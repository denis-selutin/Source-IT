import java.io.*;
import java.util.*;

/**
 * Created by denis.selutin on 6/16/2015.
 */
public class RWExample {
    public static void read(String filename) throws IOException {
        System.out.print(readFile(filename));
    }

    public static String readFile(String filename) throws IOException {
        // создание символьного потока для чтения
        BufferedReader in = new BufferedReader(new FileReader(filename));
        String s;
        StringBuilder sb = new StringBuilder();
        // чтение открытого файла построчно:
        while ((s = in.readLine()) != null)
            sb.append(s + "\n");
        in.close();
        return sb.toString();
    }


    public static void readFile() throws IOException {
        StringReader in = new StringReader(readFile("D:\\projects\\Source-IT\\examples\\ex9\\src\\RWExample.java"));
        int symbol;
        while ((symbol = in.read()) != -1)
            System.out.print((char) symbol);

    }

    public static void dosFile() throws IOException {
        DataOutputStream out = new DataOutputStream(
                new BufferedOutputStream(new FileOutputStream("Data.txt")));
        out.writeDouble(Math.PI);
        out.writeUTF("Это число pi");
        out.writeDouble(Math.sqrt(Math.PI));
        out.writeUTF("А это квадратный корень из него");
        out.close();

        DataInputStream in = new DataInputStream(
                new BufferedInputStream(new FileInputStream("Data.txt")));
        System.out.println(in.readDouble());
        // Только метод readUTF() нормально читает
        // строки в кодировке UTF для Java:
        System.out.println(in.readUTF());
        System.out.println(in.readDouble());
        System.out.println(in.readUTF());

    }

    public static void main(String[] args) throws IOException {
        read("D:\\projects\\Source-IT\\examples\\ex9\\src\\FileExample.java");
        readFile();
        dosFile();
    }

}
