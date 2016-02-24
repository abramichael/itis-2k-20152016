/**
 * Created by ma on 24.02.2016.
 */
public class Univer {
    private String name;
    private static Univer univer = new Univer("KFU");
    private Univer(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Univer{" +
                "name='" + name + '\'' +
                '}';
    }

    public static Univer getUniver() {
        return univer;
    }

}
