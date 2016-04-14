import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import ru.kpfu.itis.univer2016.model.Group;
import ru.kpfu.itis.univer2016.model.Student;


/**
 * Created by ma on 14.04.2016.
 */
public class Main {
    private static final Session session = HibernateUtil.getSession();


    public static void main(final String[] args) throws Exception {
        /*
        Query q = session.createQuery("from Group");
        for (Object g: q.list()) {
            System.out.println(g);
        }

        Transaction t = session.beginTransaction();
        Group g = new Group();
        g.setName("09-53a");
        session.save(g);
        t.commit();
        */
        /*
        Query q = session.createQuery("from Student s where s.name = 'Khramov'");
        Student s = (Student) q.list().get(0);
        System.out.println(s.getGroup());
        */
        /*
        Query q = session.createQuery("from Group g where g.name = '11-405'");
        Group g = (Group) q.list().get(0);
        System.out.println(g.getStudents());
        */
        Criteria c = session.createCriteria(Student.class).add(
                Restrictions.like("name", "%ov")
        ).createCriteria("group", JoinType.INNER_JOIN).add(
                Restrictions.or(
                        Restrictions.eq("name", "11-402"),
                        Restrictions.eq("name", "11-405")
                )
        );
        for (Object o: c.list()){
            System.out.println(o);
        }

    }
}
