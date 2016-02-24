import org.junit.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by ma on 15.02.2016.
 */
public class Vector2DTest {
    public final static double EPS = 1e-9;
    @Test
    public void defaultVectorShouldHaveZeroLength() {
        Vector2D v1 = new Vector2D();
        Assert.assertEquals(0, v1.length(), EPS);
    }
    @Test
    public void lengthShouldBeSQRTOfSumOfSquaresOfXY() {

        Vector2D v1 = new Vector2D(3, 4);
        Assert.assertEquals(5, v1.length(), EPS);

    }

    @Test
    public void constructorShouldSaveFirstParamInX() {
        Vector2D v1 = new Vector2D(3, 4);
        Assert.assertEquals(3, v1.getX(), EPS);
    }

    @Test
    public void constructorShouldSaveSecondParamInY() {
        Vector2D v1 = new Vector2D(3, 4);
        Assert.assertEquals(4, v1.getY(), EPS);
    }

    @Test(expected = NullPointerException.class)
    public void nullVectorCanNotHaveLength(){
        Vector2D v1 = null;
        double y = v1.length();
    }

    @Ignore
    @Test(timeout = 100)
    public void loopShouldBeQuick() {
        while (true);
    }

    @BeforeClass
    public static void beforeClass(){
        System.out.println("BEFORE CLASS");
    }
    @Before
    public void before(){
        System.out.println("BEFORE");
    }
    @After
    public void after() {
        System.out.println("AFTER");
    }
    @AfterClass
    public static void afterClass(){
        System.out.println("AFTER CLASS");
    }


    @Test
    public void sumShouldBeCorrect(){

        Vector2D v1 = new Vector2D(3, 4);

        Vector2D v2 = mock(Vector2D.class);
        when(v2.getX()).thenReturn(4.0);
        when(v2.getY()).thenReturn(3.0);

        Vector2D v3 = v1.add(v2);
        Assert.assertEquals(new Vector2D(7, 7), v3);
    }

}
