import org.junit.*;

/**
 * Created by ma on 17.02.2016.
 */
public class Vector2DTest {
    private static final double EPS = 1e-9;
    private static Vector2D simpleVector;
    private static Vector2D notSimpleVector;

    @Test
    public void defaultVectorShouldHaveZeroLength() {
        Assert.assertEquals(0, simpleVector.length(), EPS);
    }

    @Test
    public void lengthOfVectorShouldWorkCorrect() {
        double length = Math.sqrt(
                notSimpleVector.getX() * notSimpleVector.getX() +
                notSimpleVector.getY() * notSimpleVector.getY()
        );
        Assert.assertEquals(length, notSimpleVector.length(), EPS);
    }

    @Test
    public void firstParamOfConstructorShouldBeSavedInX(){
        Vector2D v = new Vector2D(3, 4);
        Assert.assertEquals(3, v.getX(), EPS);
    }

    @Test
    public void secondParamOfConstructorShouldBeSavedInY(){
        Vector2D v = new Vector2D(3, 4);
        Assert.assertEquals(4, notSimpleVector.getY(), EPS);
    }

    @Test(expected = NullPointerException.class)
    public void checkNull(){
        Vector2D v = null;
        System.out.println(v.length());
    }

    @Ignore
    @Test(timeout = 100)
    public void checkTimeOut(){
        while(true);
    }

    @Test
    public void checkIf5(){
        Assume.assumeTrue(simpleVector.getX() == 0);
    }

    @BeforeClass
    public static void beforeClass(){
        System.out.println("BEFORE CLASS");
        simpleVector = new Vector2D();
        notSimpleVector = new Vector2D(3, 4);
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("AFTER CLASS");
    }

    @Before
    public void before(){
        System.out.println("before");
    }
    @After
    public void after() {
        System.out.println("after");
    }

}
