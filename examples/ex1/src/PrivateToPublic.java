import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by Denis on 4/27/2015.
 */
public class PrivateToPublic {
    public static void main(String[] args) throws Exception {
        SomeClass someClass = new SomeClass();

        //get private field via reflection
        Field privateStringField = someClass.getClass().getDeclaredField("privateString");
        //make it accessible - so, we can get it's value in future
        privateStringField.setAccessible(true);
        //get field value
        String fieldValue = (String) privateStringField.get(someClass);
        //print it
        System.out.println("fieldValue = " + fieldValue);

        //get private method via reflection
        Method privateMethod = someClass.getClass().getDeclaredMethod("changePrivateString");
        //make it accessible - so, we can invoke it
        privateMethod.setAccessible(true);
        //invoke method
        privateMethod.invoke(someClass);
        //get field value to make sure that method changed its value
        fieldValue = (String) privateStringField.get(someClass);
        //print it
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
