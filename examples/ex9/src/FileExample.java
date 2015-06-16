import java.io.File;
import java.io.IOException;

/**
 * Created by denis.selutin on 6/16/2015.
 */
public class FileExample {
    public static void main(String[] args) throws IOException {
        File file = new File("D:\\projects\\Source-IT\\examples\\ex9\\src\\FileExample.java");
        System.out.println(file.exists());//существование файла
        System.out.println(file.isDirectory());//является папкой
        System.out.println(file.isHidden());//скрытый ли файл
        System.out.println(file.getName());//имя файла
        System.out.println(file.getPath());//путь файла

        file = new File("D:\\projects\\Source-IT\\examples\\ex9\\src", "FileExample.java");
        System.out.println(file.exists());//существование файла
        System.out.println(file.isDirectory());//является папкой
        System.out.println(file.isHidden());//скрытый ли файл
        System.out.println(file.getName());//имя файла
        System.out.println(file.getPath());//путь файла


        file = new File(new File("D:\\projects\\Source-IT\\examples\\ex9\\src"), "FileExample.java");
        System.out.println(file.exists());//существование файла
        System.out.println(file.isDirectory());//является папкой
        System.out.println(file.isHidden());//скрытый ли файл
        System.out.println(file.getName());//имя файла
        System.out.println(file.getPath());//путь файла

        listf("D:\\projects\\Source-IT\\examples");
    }

    public static void listf(String directoryName) throws IOException {
        File directory = new File(directoryName);
        // получаем все файлы внутри папки
        File[] fList = directory.listFiles();
        for (File file : fList) {
            if (file.isFile()) {
                System.out.println("----" + file.getName());
            } else if (file.isDirectory()) {
                System.out.println(file.getPath());
                listf(file.getAbsolutePath());
            }
        }
    }
}
