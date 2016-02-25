import java.util.List;

/**
 * Created by ma on 25.02.2016.
 */
public class Student {
    private String name;
    private static int n = 0;
    private Institute institute;
    private List<Lesson> lessons;

    public void goToLessons() {
        for (Lesson lesson : lessons) {
            System.out.println(name + " goes to lesson " + lesson);
        }
    }

    public static int getN() {
        return n;
    }

    public Student() {
        this(null, null);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", institute=" + institute +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Institute getInstitute() {
        return institute;
    }

    public void setInstitute(Institute institute) {
        this.institute = institute;
    }

    public Student(String name, Institute institute) {
        this.name = name;
        this.institute = institute;
        n++;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }
}
