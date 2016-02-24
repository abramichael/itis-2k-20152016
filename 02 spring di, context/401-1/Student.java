import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * Created by ma on 24.02.2016.
 */
public class Student {
    private String name;
    private static int n = 0;


    private Institute institute;
    private List<Lesson> lessons;

    public void setSchedule(Map<String, Lesson> schedule) {
        this.schedule = schedule;
    }

    public void printSchedule(){
        System.out.println("Cho tam u " + name + "?");
        for (String key: schedule.keySet()) {
            System.out.println(key + ": " + schedule.get(key));
        }
    }

    private Map<String, Lesson> schedule;

    public Student(String name, Institute institute) {
        this.name = name;
        this.institute = institute;
        this.n++;
    }

    public void goToLessons(){
        for (Lesson lesson : lessons) {
            System.out.println(name + " is on " + lesson.getName());
        }
    }

    public void wakeUp() {
        System.out.println(name + " is already not sleeping.");
    }

    public void goToSleep() {
        System.out.println(name + ": Хррррр-Пщщщщщщ!");
    }

    public static int getN(){
        return n;
    }

    public Student() {
        this("", null);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", institute=" + institute +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setInstitute(Institute institute) {
        this.institute = institute;
    }


    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }
}
