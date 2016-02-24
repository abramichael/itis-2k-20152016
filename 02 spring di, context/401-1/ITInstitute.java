import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by ma on 24.02.2016.
 */
public class ITInstitute implements Institute{

    private Univer univer;

    private String name;
    public ITInstitute(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "Institute{" +
                "name='" + name + '\'' +
                '}';
    }
}
