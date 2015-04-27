/**
 * Created by Denis on 4/27/2015.
 */
public class MethodParameters {
    public static void main(String[] args) {
        MethodParameters methodParameters = new MethodParameters();
        int j = 20;
        String s = "Something";
        StringBuilder sb = new StringBuilder("Josh");

        System.out.println("before method: " + j + " " + s + " " + sb.toString());
        methodParameters.changeData(j,s, sb);
        System.out.println("after method: " + j + " " + s + " " + sb.toString());
    }

    public void changeData(int i, String str, StringBuilder sb) {
        i = 10;
        str = "Hello!!!";
        sb.insert(0, "Hello, ");
    }
}
