/**
 * Created by Denis on 4/27/2015.
 */
public class NumberExample {
    public static void main(String[] args) {
        int octal = 010;
        int binary = 0b010101;
        int hex = 0xab2;
        int octal2 = 011245;
        int binary2 = 0b01010111101;
        int hex2 = 0xd45;

        System.out.println("octal=" + octal);
        System.out.println("binary=" + binary);
        System.out.println("hex=" + hex);
        System.out.println("octal2=" + octal2);
        System.out.println("binary2=" + binary2);
        System.out.println("hex2=" + hex2);

        System.out.println("--------------");

        System.out.println("octal + octal2=" + (octal + octal2));
        System.out.println("binary + octal2=" + (binary + octal2));
        System.out.println("hex + octal2=" +(hex + octal2));
        System.out.println("--------------");

        System.out.println("octal + binary2=" + (octal + binary2));
        System.out.println("binary + binary2=" + (binary + binary2));
        System.out.println("hex + binary2=" + (hex + binary2));
        System.out.println("--------------");

        System.out.println("octal + hex2=" + (octal + hex2));
        System.out.println("binary + hex2=" + (binary + hex2));
        System.out.println("hex + hex2=" + (hex + hex2));
        System.out.println("--------------");

        Integer objectI = 5;
        int primitiveI = 5;
        Double objectD = 1.0;
        double primitiveD = 1.0;

        //System.out.println(primitiveI/0); //ошибка
        //System.out.println(objectI/0); //ошибка
        //System.out.println(5/0); //ошибка

        System.out.println((double)5/0); //Infinity

        System.out.println(1.0/0); //Infinity
        System.out.println(objectD/0);//Infinity
        System.out.println(primitiveD/0);//Infinity

        objectD = 0.0;
        primitiveD = 0.0;

        System.out.println(objectD/0);//NaN
        System.out.println(primitiveD/0);//NaN
        System.out.println(0.0/0); //NaN
    }
}
