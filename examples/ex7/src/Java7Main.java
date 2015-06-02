import javax.security.auth.login.AccountException;
import javax.security.auth.login.AccountExpiredException;
import javax.security.auth.login.AccountLockedException;
import javax.security.auth.login.LoginException;
import java.io.IOException;

/**
 * Created by denis.selutin on 6/2/2015.
 */
public class Java7Main {

    public static void method() throws IOException, AccountException {

    }

    public static void main(String[] args) {
        try {
            method();
        } catch (IOException | AccountLockedException | AccountExpiredException ex) { //?????? | LoginException
            ex.printStackTrace();

        } catch (LoginException ex) {

        } catch (Exception ex) {

        }
    }
}
