/**
 * Created by Denis on 4/27/2015.
 */
public class JVMExample {
    public static void main(String[] args) {
        long rs = 0 ;
        for(int i0 = 0; i0 < 10000000; i0++) {
            rs = 1;
            for(int i = 1; i < 10; i++) {
                rs *= i;
                //System.out.println(rs);
            }
            //System.out.println("----------");
        }
        Printer.print(rs);
    }

    public static class Printer {
        static{
            System.out.println("Initialized");
        }
        public static void print(Object o){
            System.out.println(o);
        }
    }
}
/**
 First column
 The first column '260' is the timestamp.

 Second column
 The second column is the compilation_id and method_attributes.
 When a HotSpot compilation is triggered, every compilation unit gets a compilation id.
 The number in the second column is the compilation id. JIT compilation, and OSR compilation have two different sequences for the compilation id.
 So 1% and 1 are different compilation units. The %  refers to the fact that this is an OSR compilation.
 An OSR compilation was triggered because the code was looping over a large loop, and the VM determined that this code is hot.
 So an OSR compilation was triggered, which would enable the VM to do an On Stack Replacement and move over to the optimized code, once it is ready.

 Third column
 The third column is the method name.

 Fourth column
 The fourth column is again different when OSR compilation happens and when it does not.
 Let's look at the common parts first. The end of the fourth column (59 bytes), refers to the size of the compilation unit in bytecode (not the size of the compiled code).
 The @ 19 part in OSR compilation refers to the osr_bci.
 */