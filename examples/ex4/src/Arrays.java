import java.util.Random;

/**
 * Created by Denis on 5/15/2015.
 */
public class Arrays {
    public static void main(String[] args) {
        int[] mas1 = {10,20,30};
        int[] mas2  = new int[3];

        mas2[0] = 10;
        mas2[1]  = 20;
        mas2[2] = 30;

        for(int i=0; i<=2; i++) {
            mas2[i] = (i+1) * 10;
        }

        Random r = new Random();
        int ary[][] = new int[3][3];
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                ary[i][j] = 20 + r.nextInt(50); //20-70
                System.out.print(ary[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
        for(int[] inner : ary) {
            for(int i=0; i<inner.length; i++) {
                System.out.print(inner[i] + " ");
            }
            System.out.println();
        }
    }
}
