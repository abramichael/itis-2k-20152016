/**
 * Created by ma on 25.02.2016.
 */
public class Univer {
    public Univer(String name) {
        this.name = name;

    }
    private String name;
    private static Univer univer = new Univer("KFU");
    public static Univer getUniver() {
        return univer;
    }
}
