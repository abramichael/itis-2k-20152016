import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.AbstractCollection;

/**
 * Created by ma on 25.02.2016.
 */
public class Main {
    public static void main(String[] args) {
        /*
        Institute i1 = new Institute("ITIS");
        Institute i2 = new Institute("Sportfak");
        Student s1 = new Student("Igor", i1);
        Student s2 = new Student("Manya", i2);
        */
        System.out.println(Student.getN());
        ApplicationContext ac =
                new ClassPathXmlApplicationContext("spring-config.xml");
        System.out.println(Student.getN());
        Student s1 = (Student) ac.getBean("igor");
        System.out.println(Student.getN());
        Student s2 = (Student) ac.getBean("manya");
        System.out.println(Student.getN());
        Student s3 = (Student) ac.getBean("manya");
        System.out.println(Student.getN());
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s2 == s3);
        s1.goToLessons();


    }
}
