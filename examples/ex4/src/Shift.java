/**
 * Полезная ссылка http://javapd.blogspot.com/2008/05/24-7.html
 */
public class Shift {
    public static void main(String[] args) {
        int a = 11; //11 = 0000 1011;
        int a1 = -11; //-11 = 1111 0101 (0000 1010; 0000 1011)
        System.out.println(a << 1);
        System.out.println(a << 3);
        System.out.println(1 >> 2);

        System.out.println("MAX = " + Integer.MAX_VALUE);
        System.out.println("Shift a >>> 1 << 1 = " + ((a >>> 1) << 1));
        System.out.println("Shift a >> 1 = " + (a >> 1));
        System.out.println("Shift a1 >> 1 = " + (a1 >> 1));
        System.out.println("Shift a1 >>> 1 = " + (a1 >>> 1));
        System.out.println("Shift a1 >> 1 + 1 = " + ((a1 >> 1) + 1));
        System.out.println("Div = " + a1 / 2);
        System.out.println("Shift a >>> 3 = " + (a >>> 3));
        System.out.println("Shift a1 >>> 2 = " + (a1 >>> 2));
        System.out.println("Shift a1 >>> 2 + 1 = " + ((a1 >>> 2)  + 1));
        System.out.println("Shift -1 >>> 2 = " + ((-1 >>> 2)));
        System.out.println("Div = " + Integer.MAX_VALUE / 2);
        {
            System.out.println("Shift a1 >>> 3 = " + (a1 >>> 3));
            System.out.println("Shift -1 >>> 3 = " + (-1 >>> 3));
        }
        System.out.println("Div = " + Integer.MAX_VALUE / 4);

        short i = 0b0101110101101111;
        short i1 = 0b0101;
        short i2 = 0b1101;
        short i3 = 0b0110;
        short i4 = 0b1111;
        System.out.println(i);
        System.out.println(i1);
        System.out.println(i2);
        System.out.println(i3);
        System.out.println(i4);
        System.out.println("result");
    }
}
