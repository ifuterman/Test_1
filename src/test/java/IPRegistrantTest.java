import junit.framework.TestCase;
import org.junit.Assert;

public class IPRegistrantTest extends TestCase {
    public void testUniqueIpSimple() {
        IPRegistrant registrant = new IPRegistrant();
        String[] ipArray = new String[]{"1.2.3.4", "4.5.6.7", "9.9.8.8"};
        for (String s : ipArray) {
            Assert.assertTrue(registrant.registerIp(s));
        }
        Assert.assertEquals(3, registrant.getUniqueIpCount());
    }
    public void testUniqueIpNotUniqueIP() {
        IPRegistrant registrant = new IPRegistrant();
        String[] ipArray = new String[]{"1.2.3.4", "4.5.6.7","1.2.3.4", "9.9.8.8","192.16.8.1"};
        for(int i = 0; i < ipArray.length; i++){
            if(i == 2){
                Assert.assertFalse(registrant.registerIp(ipArray[i]));
            }
            else {
                Assert.assertTrue(registrant.registerIp(ipArray[i]));
            }
        }
        Assert.assertEquals(4, registrant.getUniqueIpCount());
    }
    public void testUniqueIpBorderValues() {
        IPRegistrant registrant = new IPRegistrant();
        String[] ipArray = new String[]{"0.0.0.0", "1.2.3.4", "4.5.6.7","1.2.3.4", "127.255.255.255","192.16.8.1", "255.255.255.255"};
        for(int i = 0; i < ipArray.length; i++){
            if(i == 3){
                Assert.assertFalse(registrant.registerIp(ipArray[i]));
            }
            else {
                Assert.assertTrue(registrant.registerIp(ipArray[i]));
            }
        }
        Assert.assertEquals(6, registrant.getUniqueIpCount());
    }

}