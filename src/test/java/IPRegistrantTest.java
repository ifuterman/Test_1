import junit.framework.TestCase;
import org.junit.Assert;

public class IPRegistrantTest extends TestCase {
//    String[] ipArray = new String[]{
//            "255.255.255.255", "0.0.0.0", "127.255.255.255", "88.123.65.1", "88.123.65.1"
//    };
    IPRegistrant registrant = new IPRegistrant();
    public void testRegisterIp() {
        String[] ipArray = new String[]{"1.2.3.4", "4.5.6.7", "9.9.8.8"};
        for (String s : ipArray) {
            Assert.assertTrue(registrant.registerIp(s));
        }
        Assert.assertEquals(3, registrant.getUniqueIpCount());
    }
}