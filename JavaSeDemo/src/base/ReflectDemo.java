package base;

import org.junit.Test;
import pojo.ReflectDTO;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;

/**
 * @author: yusheng
 * @create-time 2019-11-06 09:53
 **/
public class ReflectDemo {


    @Test
    public void test1() throws ClassNotFoundException, IllegalArgumentException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        // 用于测试的对象
        ReflectDTO reflect = new ReflectDTO();
        reflect.setProp1("Hello");
        reflect.setProp2(100);

        // 获取Class对象方式1，最常用；根据全类名获取类对象
        Class clazz = Class.forName("pojo.ReflectDTO");

        // 获取Class对象方式2；根据对象获取类对象
        Object testObject = new Object();
        Class clazz2 = testObject.getClass();

        // 获取Class对象方式3，最少用
        Class clazz3 = ReflectDTO.class;

        // 通过类对象，获取全类名（xxx.xxx.xxx.pojo.Person）
        String clazzName = clazz.getName();
        // 获取类名，不含包名
        String clazzSimpleName = clazz.getSimpleName();
        System.out.println("全类名：" + clazzName + "\t类名：" + clazzSimpleName);

        // 获取类修饰符
        int mod = clazz.getModifiers();
        // 判断类修饰符
        System.out.println("Modifier.isPublic:" + Modifier.isPublic(mod));
        System.out.println("Modifier.isProtected:" + Modifier.isProtected(mod));

        // 获取包对象
        Package p = clazz.getPackage();
        System.out.println("包对象：" + p + "\t 包名：" + p.getName());

        // 获取父类
        Class superClass = clazz.getSuperclass();
        System.out.println("父类的类对象：" + superClass);

        // 获取实现接口
        Class[] interfaces = clazz.getInterfaces();
        System.out.println("实现的接口的数量:" + interfaces.length);

        // 构造方法
        Constructor[] cons = clazz.getConstructors();
        System.out.println("构造方法的数量:" + cons.length);

        // 获取所有方法
        Method[] allMethod = clazz.getMethods();
        System.out.println("该类的方法数量:" + allMethod.length);
        for (Method method : allMethod) {
            // 具体方法
            System.out.println("allMethod.detailMethod:" + method);
            // 简略方法名
            System.out.println("allMethod.simpleMethod:" + method.getName());
        }

        // 获取指定方法
        Method specifiedGetMethod = clazz.getMethod("getProp1", null);
        System.out.println("specifiedGetMethod:" + specifiedGetMethod);

        //调用方法,等价于 Object methodResultValue =reflect.getProp1(null);
        Object methodResultValue = specifiedGetMethod.invoke(reflect, null);
        System.out.println("specifiedGetMethod.invoke:" + methodResultValue);

        // 获取指定方法
        Method specifiedSetMethod = clazz.getMethod("setProp3", Double.class);
        System.out.println("specifiedSetMethod:" + specifiedSetMethod);

        // 调用setter方法，该方法没有返回值，所以methodValue3为null；此处注意参数2.0 ，不能用null
        Object methodResultValue3 = specifiedSetMethod.invoke(reflect, 2.0);
        System.out.println("specifiedSetMethod.methodResultValue:" + methodResultValue3);

        // 获取变量(字段，属性）
        Field[] fields = clazz.getDeclaredFields();
        System.out.println("DeclaredFields.length:" + fields.length);
        for (Field field : fields) {
            field.setAccessible(true);
            field.set(reflect, null);
            System.out.println("field.getAnnotations:" + field.getAnnotations().length + "\tfield.getNames:" + field.getName() + "\tfield.get:" + field.get(reflect));//获取实例属性名和值

        }

        // 获取类注解
        Annotation[] annos = clazz.getAnnotations();
        System.out.println("getAnnotations:" + annos.length);


    }
}
