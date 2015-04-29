/**
 * Created by Denis on 4/27/2015.
 */
public class JVMExample {
    public static void main(String[] args) {
        long rs = 0 ;
        for(int i0 = 0; i0 < 10000000; i0++) {
            rs = 1;
            for(int i = 1; i < 10; i++) {
                rs *= i;
            }
        }
        Printer.print(rs);
    }

    public static class Printer {
        static {
            System.out.println("Initialized");
        }
        public static void print(Object o){
            System.out.println(o);
        }
    }
}
/**
 Результат выполнение показывает что сперва компилятор выполняет какойто код и даже делает оптимизаци. Подгружает Printer
 только непосрелственно перед его использованием.

 Расшифровка вывода
 1) колонка - время
 2) колонка - уникальный идентификатор запуска и параметры метода
 3) имя оптимизируемого метода
 */