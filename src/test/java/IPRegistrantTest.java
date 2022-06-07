import junit.framework.TestCase;
import org.junit.Assert;

public class IPRegistrantTest extends TestCase {
    String[] ipArray = new String[]{
            "255.255.255.255", "0.0.0.0", "127.255.255.255", "88.123.65.1", "88.123.65.1"
    };
    IPRegistrant registrant = new IPRegistrant();

    public void testRegisterIp() {
        for(int i = 0; i < 4; i++){
            Assert.assertTrue(registrant.registerIp(ipArray[i]));
        }
        Assert.assertFalse(registrant.registerIp(ipArray[4]));
        Assert.assertEquals(4, registrant.getUniqueIpCount());
    }
}