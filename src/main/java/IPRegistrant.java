import java.util.BitSet;
/**
 * Unique registration class.
*/
public class IPRegistrant {
    /**Maximal positive integer, in the four-byte integer systems*/
    private static final int MAX_POSITIVE = 0x7fffffff;
    /**Maximal packed IP address 255.255.255.255*/
    private static final long MAX_ADDRESS = 0xffffffffL;
    /**BitSet for storing addresses higher than 127.255.255.255, except for 255.255.255.255*/
    private final BitSet high = new BitSet(MAX_POSITIVE);
    /**BitSet for storing addresses from 127.255.255.255 to 0.0.0.0*/
    private final BitSet low = new BitSet(MAX_POSITIVE);
    /**Flag of unique for 255.255.255.255*/
    private boolean highest = false;
    /**Number of unique registered IP*/
    private int uniqueIpCount;

    public int getUniqueIpCount() {
        return uniqueIpCount;
    }
    /**Function for packing
     * @param ip - IP address in string representation
     * @return - true if IP is unique, otherwise false
     */
    boolean registerIp(String ip){
        long address = IPPacker.pack(ip);
        if(address == MAX_ADDRESS){
            if(!highest){
                uniqueIpCount++;
                highest = true;
                return true;
            }
            return false;
        }
        if(address <= MAX_POSITIVE){
            if(low.get((int)address)){
                return false;
            }
            low.set((int)address);
            uniqueIpCount++;
            return true;
        }
        int highAddress = (int)(address - MAX_POSITIVE);
        if(high.get(highAddress)){
            return false;
        }
        high.set(highAddress);
        uniqueIpCount++;
        return true;
    }
}
