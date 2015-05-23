import com.example.inheritance.ex4.AccessIdentifiers2;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by Denis on 5/20/2015.
 */
public class ClassExample {
    public static void main(String[] args) {
        AccessIdentifiers2 ac = new AccessIdentifiers2();
        System.out.println(ac.getClass().getName());
        System.out.println(Arrays.stream(ac.getClass().getDeclaredFields())
                .map(Field::getName)
                .collect(Collectors.joining(" || ")));;
        System.out.println(Arrays.stream(ac.getClass().getDeclaredMethods())
                .map(Method::getName)
                .collect(Collectors.joining(" || ")));
        System.out.println(Arrays.stream(ac.getClass().getDeclaredMethods())
                .map(Method::getReturnType)
                .map(Class::getName)
                .collect(Collectors.joining(" || ")));
        System.out.println(Arrays.stream(ac.getClass().getInterfaces())
                .map(Class::getName)
                .collect(Collectors.joining(" || ")));

        System.out.println(ac.getClass().getDeclaredFields().length);
        System.out.println(ac.getClass().getDeclaredMethods().length);
    }

}
