import java.util.Random;

/**
 * Created by Denis on 5/15/2015.
 */
public class Switch {
    public static void main(String[] args) {
        Random r = new Random();
        int i = r.nextInt(10);
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4: System.out.println("<5"); break;
            default: System.out.println(">5"); break;
        }

        if(i > 0 && i <= 4) {
            System.out.println("if <5");
        } else {
            System.out.println("if >5");
        }
    }
}
