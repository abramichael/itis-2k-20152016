import org.junit.Assert;
import org.junit.Assume;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Created by ma on 16.02.2016.
 */
public class Vector2DTest {
    private final double EPS = 1e-9;

    @Test
    public void defaultVectorShouldHaveZeroLength() {
        Vector2D v = new Vector2D();
        Assert.assertEquals(0, v.length(), EPS);
    }

    @Test
    public void constuctorShouldSaveFirstParamInAttributeX(){
        Vector2D v = new Vector2D(5,7);
        Assert.assertEquals(5, v.getX(), EPS);
    }

    @Test
    public void constuctorShouldSaveSecondParamInAttributeY(){
        Vector2D v = new Vector2D(5,7);
        Assert.assertEquals(7, v.getY(), EPS);
    }

    @Test
    public void vectorLengthShouldBeSQRTOfSumOfSqrsOfXY() {
        Vector2D v = new Vector2D(3,4);
        Assert.assertEquals(5, v.length(), EPS);
    }

    @Test(expected = NullPointerException.class)
    public void checkNullPointerEx(){
        Vector2D v = null;
        System.out.println(v.length());
    }

    @Ignore
    @Test(timeout = 100)
    public void checkIfFast() {
        while (true);
    }

    // if good - passed, if bad - ignored
    @Test
    public void studidTest() {
        Vector2D v = new Vector2D(2,2);
        Assume.assumeTrue(v.getX() == v.getY());
    }

}
