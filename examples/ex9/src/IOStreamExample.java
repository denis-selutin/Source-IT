import com.sun.xml.internal.messaging.saaj.packaging.mime.util.BASE64EncoderStream;

import java.io.*;

/**
 * Created by denis.selutin on 6/16/2015.
 */
public class IOStreamExample {
    public static void main(String[] args) throws IOException {
        baisExample();
        fisExample();
        doisExample();
        psExample();
    }

    public static void baisExample() throws IOException {
        System.out.println("-------------ByteArrayInputStream------------");
        String someString = "This is some string that will be saved as byte array";
        InputStream is = new ByteArrayInputStream(someString.getBytes());
        byte[] temp = new byte[10];
        is.read(temp);
        System.out.println(new String(temp));
        System.out.println("---------------------------------------------");
    }

    public static void fisExample() throws IOException {
        System.out.println("---------------FileInputStream---------------");
        InputStream is = new FileInputStream("D:\\projects\\Source-IT\\examples\\ex9\\src\\FileExample.java");
        byte[] temp = new byte[500];
        is.read(temp);
        System.out.println(new String(temp));
        System.out.println("---------------------------------------------");
    }

    public static void doisExample() throws IOException {
        System.out.println("---------------DataInputStream---------------");
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(out);
        //записуем
        dos.writeDouble(5.63);
        dos.writeChar('\t');
        dos.writeInt(5698);
        dos.writeChar('\t');
        dos.writeChars("test");
        dos.writeChar('\n');
        dos.writeUTF("test");
        dos.writeChar('\n');
        dos.close();

        //читаем
        DataInputStream dis = new DataInputStream(new ByteArrayInputStream(out.toByteArray()));
        try {
            Double aDouble = dis.readDouble();
            dis.readChar();
            Integer anInt = dis.readInt();
            dis.readChar();
            String aChars = dis.readLine();
            String aString = dis.readUTF();
            System.out.println(aDouble + "  " + anInt + " " + aChars + " " + aString);
        } catch (EOFException e) {
            e.printStackTrace();
        }
        dis.close();
        System.out.println(out.toString());
        System.out.println("---------------------------------------------");
    }

    public static void psExample() {
        PrintStream ps = new PrintStream(System.out);
        //PrintStream ps = new PrintStream(new BASE64EncoderStream(System.out));

        //печатаем 15 и переводим каретку на новую строку
        ps.println(15);
        //печатаем строку
        ps.println("New Line");
        ps.println(new SomeClass());

        //сохранение результатов
        ps.flush();
        ps.close();
    }

    private static class SomeClass {
        private String string = "String";
    }
}
