/**
 * Created by ma on 25.02.2016.
 */
public class Institute {
    private String name;

    public Institute(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "Institute{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
