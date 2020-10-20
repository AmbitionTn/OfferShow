import java.io.*;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author taoning
 * @create 2020/10/16
 */
public class ConvertClassLoader extends ClassLoader {
    String classPath = null;
    String fileName = null;

    public ConvertClassLoader(String classPath) {
        this.classPath = classPath;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public ConvertClassLoader(ClassLoader parent) {
        super(parent);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        URL url = this.getClass().getClassLoader().getResource(classPath + "/" + fileName);
        if (url == null) {
            return null;
        }
        File file = new File(url.getPath());
        try {
            byte[] bytes = decode(getClassBytes(file));
            return defineClass(name, bytes, 0, bytes.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return super.findClass(name);
    }

    /**
     * 获取file文件的字节数组
     *
     * @param file
     * @return
     */
    private byte[] getClassBytes(File file) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        FileChannel channel = fileInputStream.getChannel();
        ByteArrayOutputStream out = new ByteArrayOutputStream((int) file.length());
        byte[] buf = new byte[1024];
        int size;
        try {
            while (-1 != (size = fileInputStream.read(buf))) {
                out.write(buf, 0, size);
            }
            return out.toByteArray();
        } finally {
            channel.close();
            fileInputStream.close();
            out.close();
        }
    }

    /**
     * 解码
     *
     * @param bytes
     * @return
     */
    private byte[] decode(byte[] bytes) {
        byte[] res = new byte[bytes.length];
        int index = 0;
        for (byte bt : bytes) {
            res[index++] = (byte) (255 - bt);
        }
        return res;
    }

}
