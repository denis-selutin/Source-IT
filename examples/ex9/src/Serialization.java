import java.io.*;

/**
 * Created by denis.selutin on 6/16/2015.
 */
public class Serialization {
    public static String fileName = "file.txt";

    public static void main( String[ ] args )
            throws IOException, ClassNotFoundException {
        ObjectOne o1 = new ObjectOne("name 1", "key1");
        System.out.println(o1);
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(new File(fileName)));
        os.writeObject(o1);
        //os.writeObject(new ObjectTwo("name 2", "key2")); //java.io.NotSerializableException
        os.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(fileName)));
        ObjectOne o1FromFile = (ObjectOne)ois.readObject();
        System.out.println(o1FromFile);

        os = new ObjectOutputStream(new FileOutputStream(new File(fileName)));
        ObjectTwo o2 = new ObjectTwo("name 2","key2");
        o2.writeExternal(os);
        os.close();
        System.out.println(o2);

        ois = new ObjectInputStream(new FileInputStream(new File(fileName)));
        ObjectTwo o2FromFile = new ObjectTwo();
        o2FromFile.readExternal(ois);
        System.out.println(o2FromFile);
    }

    public static final class ObjectOne implements Serializable {
        private final String name;
        private transient final String key;
        public ObjectOne(String name, String key) {
            this.name = name;
            this.key = key;
        }
        public String getName() {return name;}
        public String getKey() {return key;}
        public String toString() {return " " + this.name + " : " + this.key;}
    }

    public static final class ObjectTwo implements Externalizable{
        private String name;
        private transient String key;
        public ObjectTwo(){}
        public ObjectTwo(String name, String key) {
            this.name = name;
            this.key = key;
        }
        public String getName() {return name;}
        public String getKey() {return key;}
        public String toString() {return " " + this.name + " : " + this.key;}
        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeUTF(this.name);
        }
        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            this.name = in.readUTF();
        }
    }


}
