package map;

import net.sf.cglib.beans.BeanCopier;
import net.sf.cglib.core.Converter;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * 自定义bean工具类
 *
 * @author yusheng
 * Create-date 2019-10-19 17:34
 **/
public class BeanUtils {
    /**使用WeakHashMap缓存,entry<key,value>在内存不足||不被任何对象引用时会被自动释放掉。beanCopier创建消耗比较大，建议缓存*/
    private final static Map<String, BeanCopier> BEAN_COPIER_MAP = new WeakHashMap<>();
    /**ConverterMap*/
    private final static Map<String, Converter> CONVERTER_MAP = new WeakHashMap<>();
    /**BeanCopier的对象锁，为了安全，启动同步机制*/
    private static final Object BEAN_COPIER_LOCK = new Object();
    /**Converter的对象锁，为了安全，启动同步机制*/
    private static final Object CONVERTER_LOCK = new Object();

    private BeanUtils() {
    // 工具类不需要实例化
    }

    /**
     * 浅克隆[浅拷贝]
     * 复制对象属性，如果是引用数据类型的属性，则赋值引用地址（指针）。
     * 注意两个对象的属性名和属性类型都必须一致，而且src对象的属性，在tar对象中必须存在[否则抛出空指针异常]。
     * @param src    被复制的对象
     * @param target 被赋值的对象
     */
    public static void copy(Object src, Object target) {
        BeanCopier bc = getBeanCopier(src, target, false);
        bc.copy(src, target, null);
    }

    /**
     * 浅克隆[浅拷贝]
     * 复制对象属性，如果是引用数据类型的属性，则赋值引用地址（指针）。
     * 注意两个对象的属性名和属性类型都必须一致，而且src对象的属性，在tar对象中必须存在[否则抛出空指针异常]。
     *
     * @param src       被复制的对象
     * @param target    被赋值的对象
     * @param converter 自定义转换器
     */
    public static void copy(Object src, Object target, Converter converter) {
        BeanCopier bc = getBeanCopier(src, target, true);
        bc.copy(src, target, converter);
    }

    /**
     * 浅克隆[浅拷贝]
     * 复制对象属性，只复制fields中指定的属性，每个属性用逗号分隔
     *
     * @param src    被复制的对象
     * @param target 被赋值的对象
     * @param fields 指定的属性字符串，用逗号隔开，如 "id,name,phone"
     */
    public static void copySpecifiedFields(Object src, Object target, final String fields) {
        //获取一个BeanCopier
        BeanCopier bc = getBeanCopier(src, target, true);
        //复制指定属性
        bc.copy(src, target, newConverter(src, target, fields, true));
    }

    /**
     * 浅克隆[浅拷贝]
     * 复制对象属性，排除指定属性
     *
     * @param src    被复制的对象
     * @param target 被赋值的对象
     * @param fields 排除属性
     */
    public static void copyExcludeFields(Object src, Object target, final String fields) {
        BeanCopier bc = getBeanCopier(src, target, true);
        bc.copy(src, target, newConverter(src, target, fields, false));
    }

    /**
     * 深拷贝
     * 通过序列化和反序列化实现
     *
     * @param src 源对象[待复制对象],要求实现序列化接口，其属性若有引用对象也要实现序列化接口
     * @param <T> 泛型
     * @return 新对象
     */
    @SuppressWarnings("unchecked")
    public static <T> T deepCopy(T src) {
        if (src instanceof Serializable) {
            ByteArrayOutputStream baos = null;
            ObjectOutputStream oos = null;

            ByteArrayInputStream bais = null;
            ObjectInputStream ois = null;

            Object o = null;
            //如果子类没有继承该接口，这一步会报错
            try {
                baos = new ByteArrayOutputStream();
                oos = new ObjectOutputStream(baos);
                oos.writeObject(src);
                bais = new ByteArrayInputStream(baos.toByteArray());
                ois = new ObjectInputStream(bais);

                o = ois.readObject();
                return (T) o;
            } catch (Exception e) {
                // 对象的属性中包含未序列化的对象。
                System.out.println(e.getMessage());
                System.out.println(src.getClass().getName() + "的属性中包含未序列化的对象!!!");
                return null;
            } finally {
                try {
                    if (baos != null) {
                        baos.close();
                    }
                    if (oos != null) {
                        oos.close();
                    }
                    if (bais != null) {
                        bais.close();
                    }
                    if (ois != null) {
                        ois.close();
                    }
                } catch (Exception e2) {
                    //这里报错不需要处理
                }
            }
        }
        // 源对象没有实现序列化接口
        System.out.println(src.getClass().getName() + "没有实现序列化接口");
        return null;
    }

    /**
     * 深拷贝
     *
     * @param src         被复制的对象
     * @param targetClass 被赋值的对象的全类名
     * @param <T>         指定返回值的类型，和targetClass一样
     * @return targetClass的对象(复制了src的属性)
     */
    @SuppressWarnings("unchecked")
    public static <T> T deepCopy(Object src, Class<T> targetClass) {
        T targetObject = null;
        try {
            // 通过无参构造，实例化一个新的对象
            targetObject = targetClass.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (src instanceof Serializable && targetObject instanceof Serializable) {
            ByteArrayOutputStream baos = null;
            ObjectOutputStream oos = null;

            ByteArrayInputStream bais = null;
            ObjectInputStream ois = null;

            try {
                //生成一个字节输出流，用于在内存中暂存序列化的对象 srcObject
                baos = new ByteArrayOutputStream();
                //生成一个对象输出流，用于把序列化的对象 srcObject，输出到字节输出流中
                oos = new ObjectOutputStream(baos);
                //输出 srcObject
                oos.writeObject(src);

                //分配内存，写入原始对象，生成新对象
                bais = new ByteArrayInputStream(baos.toByteArray());
                //生成一个对象输入流
                ois = new ObjectInputStream(bais);

                Object o = ois.readObject();
                //调用objectInputStream生成新对象,然后把属性赋给target
                copy(o, targetObject);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            } finally {
                try {
                    if (baos != null) {
                        baos.close();
                    }
                    if (oos != null) {
                        oos.close();
                    }
                    if (bais != null) {
                        bais.close();
                    }
                    if (ois != null) {
                        ois.close();
                    }
                } catch (Exception e2) {
                    //这里报错不需要处理
                }
            }
            return targetObject;
        } else {
            if (targetObject instanceof Serializable) {
                System.out.println(src.getClass().getName() + "未序列化，深拷贝失败");
            } else {
                if (targetObject != null) {
                    System.out.println(targetObject.getClass().getName() + "未序列化，深拷贝失败");
                }
            }
        }
        return null;
    }

    /**
     * 创建BeanCopier，并缓存
     *
     * @param src
     * @param target
     * @param useConverter
     * @return
     */
    private static BeanCopier getBeanCopier(Object src, Object target, Boolean useConverter) {
        String key = generateKey(src, target, useConverter);
        BeanCopier bc = BEAN_COPIER_MAP.get(key);
        if (null == bc) {
            synchronized (BEAN_COPIER_LOCK) {
                bc = BEAN_COPIER_MAP.get(key);
                if (null == bc) {
                    bc = BeanCopier.create(src.getClass(), target.getClass(), useConverter);
                    BEAN_COPIER_MAP.put(key, bc);
                }
            }
        }
        return bc;
    }

    /**
     * 创建属性转换器
     *
     * @param fields        需要复制或排除的属性
     * @param fieldCopyFlag 属性复制标识 true:表明fields为需要复制的属性；false:表明fields是需要排除复制的属性
     * @return Converter转换器
     */
    private static Converter newConverter(Object src, Object target,  String fields,  Boolean fieldCopyFlag) {
        //生成一个复制指定属性的converter的key
        String key = buildConverterKey(src, target, fields, fieldCopyFlag);
        //根据key去缓存中获取该converter
        Converter converter = CONVERTER_MAP.get(key);
        if (null == converter) {
            //当前线程中没有converter，获取对象锁，可能对象锁中有该converter
            synchronized (CONVERTER_LOCK) {
                //当前线程得到对象锁后，获取指定的converter
                converter = CONVERTER_MAP.get(key);
                //如果对象锁的资源中没有指定的converter
                if (converter == null) {
                    //创建一个新的Converter，放在该对象锁中
                    converter = new Converter() {
                        /**
                         * Converter
                         * Converter会对一个实体类中的所有属性进行遍历
                         * 再通过get/set方法和属性名，获取src对象的属性，赋值到target对象的
                         *
                         * @param fieldValue 当前遍历到的实体类的一个属性对应的值
                         * @param fieldType  当前遍历到的实体类的一个属性对应的数据类型
                         * @param methodName 当前遍历到的实体类的一个属性对应的methodName（src对象的getXxxx,target对象的setXxxx)
                         * @return fieldValue 把当前遍历到的src对象的一个属性的值赋值给target对象的相同属性
                         */
                        @Override
                        public Object convert(Object fieldValue, Class fieldType, Object methodName) {
                            //setXxxx，获取子字符串，获取Xxxx，得到属性名，如Name
                            String field = methodName.toString().substring(3); // 得到属性名，如Name
                            //将首字母小写
                            field = field.substring(0, 1).toLowerCase() + field.substring(1);
                            if ((fieldCopyFlag && fields.contains(field)) || (!fieldCopyFlag && !fields.contains(field))) {
                                //根据fieldCopyFlag，选择是否把当前遍历到的src对象的一个属性的值赋值给target对象的相同属性
                                return fieldValue;
                            }
                            //防止检测到没有返回值
                            return null;
                        }
                    };
                    //创建Converter成功，放进对象锁的map中（缓存）
                    CONVERTER_MAP.put(key, converter);
                }
            }
        }
        return converter;
    }

    /**
     * key生成器
     * 根据src和target，useConverter生成一个关键字key
     *
     * @param src          被复制的对象
     * @param target       被赋值的对象
     * @param useConverter 是否使用转换器
     * @return key字符串
     */
    private static String generateKey(Object src, Object target, Boolean useConverter) {
        return src.toString() + target.getClass().getName() + useConverter.toString();
    }

    /**
     * 生成一个复制指定属性的转换器的key
     *
     * @param src      被复制的对象
     * @param target   被赋值的对象
     * @param fields   指定属性
     * @param copyFlag true:复制指定属性||false：复制除指定属性外的属性
     * @return key：复制指定属性的转换器的key
     */
    private static String buildConverterKey(Object src, Object target, String fields, Boolean copyFlag) {
        //生成一个缓存用的baseKey
        String baseKey = generateKey(src, target, copyFlag);
        //拼接成一个复制指定属性的convert的key
        return baseKey + fields + copyFlag.toString();
    }

    /**
     * 对象转换成hashMap
     *
     * @param bean 待转换对象
     * @return 包含对象属性的hashMap
     */
    public static <T> Map<String, Object> beanToMap(T bean) {
        Map<String, Object> map = new HashMap<>();
        Field[] fields = bean.getClass().getDeclaredFields();
        try {
            for (Field field : fields) {
                field.setAccessible(true);
                map.put(field.getName(), field.get(bean));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    /**
     * map转换成javabean对象
     *
     * @param map       待转换的map
     * @param beanClass bean的类对象[一定要有 public 的无参构造方法]
     * @param <T>       bean的类型
     * @return bean对象
     */
    public static <T> T mapToBean(Map<String, Object> map, Class<T> beanClass) {
        try {
            T bean = beanClass.getDeclaredConstructor().newInstance();
            Field[] fields = bean.getClass().getDeclaredFields();
            for (Field field : fields) {
                int mod = field.getModifiers();
                if (Modifier.isStatic(mod) || Modifier.isFinal(mod)) {
                    // 不处理静态或者final修改的属性
                    continue;
                }
                boolean flag = field.isAccessible();
                if (!flag) {
                    field.setAccessible(true);
                }
                if (map.containsKey(field.getName())) {
                    field.set(bean, map.get(field.getName()));
                }
                if (!flag) {
                    field.setAccessible(false);
                }
            }
            return bean;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}

