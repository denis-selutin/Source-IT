/**
 * Created by Denis on 5/22/2015.
 */
public class NestedClasses {
    private String val = "Val";

    class NestedClass { //может жить только при наличии экземпляра внешнего класса
        public void print() {
            System.out.println(NestedClasses.this.val);
        }
    }

    static class NestedClass2 {//может жить отдельно от NestedClasses
        public void print() {
            //System.out.println(NestedClasses.this.val); - ошибка
        }
    }
}
