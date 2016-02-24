/**
 * Created by ma on 24.02.2016.
 */
public class ProfInstitute implements Institute{
    private String name;
    public ProfInstitute(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "Institute{" +
                "name='" + name + '\'' +
                '}';
    }
}
