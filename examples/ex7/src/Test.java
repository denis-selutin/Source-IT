/**
 * Created by denis.selutin on 6/2/2015.
 */
class Test {
    public static void main(String args[]) {
        Test test = getNullTest(0);
        test.print("Something");
    }

    private static Test getNullTest(int whatever) {
        if(true) {
            return null;
        } else {
            return new Test();
        }
    }

    public void print(String str) {
        System.out.println(str);
    }
}

