import junit.framework.TestCase;
import org.junit.Assert;

public class IPPackerTest extends TestCase {

    public void testPackCorrectness() {
        long maxAddress = 0xffffffffL;
        long borderAddress = 0x7fffffff;
        Assert.assertEquals(0, IPPacker.pack("0.0.0.0"));
        Assert.assertEquals(borderAddress, IPPacker.pack("127.255.255.255"));
        Assert.assertEquals(maxAddress, IPPacker.pack("255.255.255.255"));
    }
}
