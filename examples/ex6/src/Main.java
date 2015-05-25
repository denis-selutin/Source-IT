/**
 * Created by Denis on 5/22/2015.
 */
public class Main {
    public static void main(String[] args) {
        NestedClasses ns = new NestedClasses();
        NestedClasses.NestedClass nst = ns.new NestedClass();

        NestedClasses.NestedClass2 nst2 = new NestedClasses.NestedClass2();

        //NestedClasses.NestedClass nst3 = new NestedClasses.NestedClass(); ошибка
    }
}
