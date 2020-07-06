package file;

import java.io.*;

/**
 * 文件操作工具类
 *
 * @author: yusheng
 * @create-date: 2020-03-14 21:33
 **/
public class FileTool {
    /**
     * 读取文件
     *
     * @param path 文件路径
     * @return
     */
    public static String readFile(String path) {
        StringBuffer sb = new StringBuffer();
        //1.创建文件的字节流
        InputStream fis = null;
        try {
            //InputStream为抽象类，不能实例化
            fis = new FileInputStream(path);
            //二进制数组
            byte[] bytes = new byte[1024];
            int data = 0;
            while ((data = fis.read(bytes)) != -1) {
                //(data=fis.read(bytes))==-1表示读到最后了

                //二进制数组转换成字符串,后面加,0,data是防止1024出现0000000
                String str = new String(bytes, 0, data);
                sb.append(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //2.关闭字节流
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

    /**
     * 写入文件
     *
     * @param path
     * @param content
     * @param flag    是否覆盖已存在文件
     * @return 是否成功写入
     */
    public static boolean writeFile(String path, String content, boolean flag) {
        boolean result = false;
        //1.创建文件的字节流
        OutputStream fos = null;
        try {
            //2.创建文件输出流对象,flag表示是否覆盖,flag=true表示在末尾添加，flag=false表示覆盖
            fos = new FileOutputStream(path, flag);
            //字符串String--->byte[]
            byte[] words = content.getBytes();
            //写入
            fos.write(words, 0, words.length);
            result = true;
        } catch (Exception ignored) {
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 文件复制
     *
     * @param fromPath
     * @param toPath
     * @return
     */
    public static boolean copyFile(String fromPath, String toPath) {
        boolean result = false;
        // 文件的复制:先读取要复制的文件，再写入新文件
        //1.读取文件
        InputStream fis = null;
        //2.写入文件
        OutputStream fos = null;
        try {
            //3.读取
            fis = new FileInputStream(fromPath);
            //4.写入
            fos = new FileOutputStream(toPath);
            //5.边读边写
            StringBuffer content = new StringBuffer();
            //读二进制数组
            byte[] bytes = new byte[1024];
            int data = 0;
            while ((data = fis.read(bytes)) != -1) {
                //(data=fis.read(bytes))==-1表示读到最后了
                //二进制数组转换成字符串。后面加,0,data是防止1024出现0000000
                String str = new String(bytes, 0, data);
                content.append(str);
            }
            //【写】字符串String--->byte[]
            byte[] words = content.toString().getBytes();
            //写入
            fos.write(words, 0, words.length);
            result = true;
        } catch (Exception ignored) {
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }


    /**
     * 获取文件后缀名
     *
     * @param path
     * @return
     */
    public static String getFileExt(String path) {
        return path.substring(path.lastIndexOf("."));
    }

    /**
     * 删除文件夹及其下面的子文件夹
     *
     * @param path
     */
    public static boolean deleteFolder(String path) {
        File file = new File(path);
        if (file.exists()) {
            if (file.isFile()) {
                file.delete();
                return true;
            } else {
                File[] files = file.listFiles();
                assert files != null;
                for (File subFile : files) {
                    //得到子文件或文件夹的绝对路径
                    String root = subFile.getAbsolutePath();
                    deleteFolder(root);
                }
                file.delete();
                return true;
            }
        } else {
            return false;
        }
    }

    /**
     * 复制文件
     *
     * @param src
     * @param dst
     * @throws Exception
     */
    public static void copy(File src, File dst) throws Exception {
        int BUFFER_SIZE = 4096;
        InputStream in = null;
        OutputStream out = null;
        try {
            in = new BufferedInputStream(new FileInputStream(src), BUFFER_SIZE);
            out = new BufferedOutputStream(new FileOutputStream(dst), BUFFER_SIZE);
            byte[] buffer = new byte[BUFFER_SIZE];
            int len = 0;
            while ((len = in.read(buffer)) > 0) {
                out.write(buffer, 0, len);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (null != in) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                in = null;
            }
            if (null != out) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                out = null;
            }
        }
    }

    /**
     * @param src
     * @param dst
     * @param append
     * @throws Exception
     * @复制文件，支持把源文件内容追加到目标文件末尾
     */
    public static void copy(File src, File dst, boolean append) throws Exception {
        int BUFFER_SIZE = 4096;
        InputStream in = null;
        OutputStream out = null;
        try {
            in = new BufferedInputStream(new FileInputStream(src), BUFFER_SIZE);
            out = new BufferedOutputStream(new FileOutputStream(dst, append), BUFFER_SIZE);
            byte[] buffer = new byte[BUFFER_SIZE];
            int len = 0;
            while ((len = in.read(buffer)) > 0) {
                out.write(buffer, 0, len);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (null != in) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                in = null;
            }
            if (null != out) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                out = null;
            }
        }
    }
}