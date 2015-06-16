import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by denis.selutin on 6/16/2015.
 */
public class UsingRandomAccessFile {
    static String fileName = "raFileTest.dat";

    static void display() throws IOException {    // этот метод
        //выводит на консоль содержимое файла
        RandomAccessFile raFile = new RandomAccessFile(fileName, "r");
        for (int i = 0; i < 7; i++)
            System.out.println("Value " + i + ": " + raFile.readDouble());
        System.out.println(raFile.readUTF());
        raFile.close();
    }

    public static void main(String[] args)
            throws IOException {
        RandomAccessFile raFile = new RandomAccessFile(fileName, "rw");
        for (int i = 0; i < 7; i++)
            raFile.writeDouble(i * 1.414);
        raFile.writeUTF("Конец файла");
        raFile.close();
        display();
        raFile = new RandomAccessFile(fileName, "rw");
        raFile.seek(5 * 8);
        raFile.writeDouble(47.0001);
        raFile.close();
        display();
    }
}
