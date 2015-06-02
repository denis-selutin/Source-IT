/**
 * Created by denis.selutin on 6/2/2015.
 */
public class Main {
    public static void main(String[] args) throws MyException {
        throwException();
        throwRuntimeException();
        throwThrowable();
    }

    public static void throwThrowable() {
        throw new MyRuntimeException();
    }

    public static void throwException() throws MyException {
        throw new MyException();
    }

    public static void throwRuntimeException() {
        throw new MyRuntimeException();
    }
}
