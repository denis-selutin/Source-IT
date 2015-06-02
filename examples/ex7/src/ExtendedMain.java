import javax.security.auth.login.AccountLockedException;
import javax.security.auth.login.AccountNotFoundException;
import javax.security.auth.login.LoginException;

/**
 * Created by denis.selutin on 6/2/2015.
 */
public class ExtendedMain {

    public static class Base {
        public void method() throws LoginException {

        }
    }

    public static class Child_1 extends Base {
        public void method() {

        }
    }

    public static class Child_2 extends Base {
        public void method() throws AccountLockedException, AccountNotFoundException { //throws Exception

        }
    }

    public static class ChildOfChild_2 extends Child_2 {
        public void method() throws AccountLockedExceptionMy { //throws Exception

        }
    }

    public static class AccountLockedExceptionMy extends AccountLockedException {}
}
