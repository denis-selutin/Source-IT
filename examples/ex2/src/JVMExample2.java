/**
 * Created by Denis on 4/27/2015.
 */
public class JVMExample2 {
    public static final int MAX_RUN = 10000;
    public static final int RECURSION_THRESHOLD = 10000;

    public static void main(String[] args) throws InterruptedException {
        long startMls = System.currentTimeMillis();
        for(int i=0; i<MAX_RUN; i++) {
            recursion(0);
        }
        System.out.println(System.currentTimeMillis() - startMls);
    }

    public static void recursion(int counter) {
        if(counter < RECURSION_THRESHOLD) {
            recursion(++counter);
        }
    }
}
