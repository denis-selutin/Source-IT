/**
 * Created by Denis on 5/22/2015.
 */
public enum EnumEx {
    V1("Some string", 10), V2("Other name", 15);

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    private String name;
    private int value;

    private EnumEx(String name, int value) {
        this.name = name;
        this.value = value;
    }
}
