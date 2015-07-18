

import junit.framework.TestCase;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 */
public class TestClass1 extends TestCase {
    public static String var1;

    @BeforeClass
    public static void prepareGlobalVariables() {
        var1 = "Some text";
        System.out.println("Setup before Test");
    }

    @Test
    public void test1() {
        System.out.println("Test 1");
        System.out.println(var1);
        assert true;

    }

    @Test
    public void test2() {
        System.out.println("Test 1");
        System.out.println(var1);
        assert true;
    }

    @AfterClass
    public static void releaseGlobalVariables() {
        System.out.println("Release after Test");
    }
}
