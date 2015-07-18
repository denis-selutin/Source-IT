package main;

import java.lang.reflect.Method;

/**
 *
 */
public class TestClass {

    public static void main(String[] args) {
        Object o = new MyClass();
        Object o2 = "2323";
        assert false;

        printAnnotationIfPresent(o);
        printAnnotationIfPresent(o2);
    }

    public static final void printAnnotationIfPresent(Object obj) {
        Class clazz = obj.getClass();
        if (clazz.isAnnotationPresent(MyAnnotation.class)) {
            printAnnotationData((MyAnnotation) clazz.getAnnotation(MyAnnotation.class));
        }
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(MyAnnotation.class)) {
                printAnnotationData(method.getAnnotation(MyAnnotation.class));
            }
        }
    }

    private static void printAnnotationData(MyAnnotation myAnnotation) {
        System.out.println("enumValue : " + myAnnotation.enumValue());
        System.out.println("name : " + myAnnotation.name());
        System.out.println("Tags : ");

        int tagLength = myAnnotation.tags().length;
        for (String tag : myAnnotation.tags()) {
            if (tagLength > 1) {
                System.out.print(tag + ", ");
            } else {
                System.out.print(tag);
            }
            tagLength--;
        }
    }

    @MyAnnotation(enumValue = MyAnnotation.MyEnum.VALUE_3, name = "class annotation", tags = "no tags")
    public static class MyClass {

        @MyAnnotation
        private String id;


        @MyAnnotation
        public void method() {

        }
    }
}
