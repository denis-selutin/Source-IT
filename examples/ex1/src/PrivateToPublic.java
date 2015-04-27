import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by Denis on 4/27/2015.
 */
public class PrivateToPublic {
    public static void main(String[] args) throws Exception {
        SomeClass someClass = new SomeClass();

        Field privateStringField = someClass.getClass().getDeclaredField("privateString");
        privateStringField.setAccessible(true);
        String fieldValue = (String) privateStringField.get(someClass);
        System.out.println("fieldValue = " + fieldValue);

        Method privateMethod = someClass.getClass().getDeclaredMethod("changePrivateString");
        privateMethod.setAccessible(true);
        privateMethod.invoke(someClass);
        fieldValue = (String) privateStringField.get(someClass);
        System.out.println("fieldValue = " + fieldValue);
    }

    static final class SomeClass {
        private String privateString;

        private void changePrivateString() {
            this.privateString = "Another private String";
        }

        public SomeClass() {
            this.privateString = "this is String";
        }
    }
}
