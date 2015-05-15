/**
 * Created by Denis on 5/15/2015.
 */
public class Cycles {
    public static void main(String[] args) {
        boolean flag = true;

        while(flag) {
            System.out.println("1-st while");
            flag = false;
        }

        while(flag) {
            System.out.println("2-st while");
            flag = false;
        }

        do {
            System.out.println("1-st do while");
            flag = false;
        } while(flag);

        for(int i = 0, j = 10; i < 10 && j >=0; i++, j--) {
            System.out.println("i = " + i + " j = " + j);
        }

        float sum = 0;
        for (float x = 1; ; x++) {
            if (x > 99)
                break;
            sum += 1 / x;
        }
        System.out.println(sum);

        sum = 0;
        for (float x = 1; ; x++) {
            if (x > 99)
                break;
            if (x % 2 > 0)
                continue;
            sum += 1 / x;
        }
        System.out.println(sum);

        //Бесконечные циклы
//        for(int i = 0; i < 10; i++, i--) {
//            System.out.println("i = " + i);
//        }
//        for(;;) {
//            System.out.println("i = for ???");
//        }
//        while(true) {
//            System.out.println("i = while ???");
//        }
    }
}
