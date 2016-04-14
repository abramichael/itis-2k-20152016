import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.repository.CrudRepository;
import ru.kpfu.itis.univer2016.entity.Group;
import ru.kpfu.itis.univer2016.repository.GroupRepository;

/**
 * Created by ma on 14.04.2016.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext ac =
                new ClassPathXmlApplicationContext("spring-config.xml");

        GroupRepository gr = ac.getBean(GroupRepository.class);
        Group g = gr.findByName("11-401");
        System.out.println(g);
        System.out.println(g.getStudents());

    }
}
