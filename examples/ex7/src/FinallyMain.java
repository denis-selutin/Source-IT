/**
 * Created by denis.selutin on 6/2/2015.
 */
public class FinallyMain {
    public static void main(String[] args) {
        System.out.println(doSmth());
    }

    public static int doSmth() {
        try {
            throw new Exception("Something wrong....");
        } catch(Exception ex) {
            return 2;
        }
        finally {
            return 3;
        }
    }
}

