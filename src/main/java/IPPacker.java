/**
 * Fast IP packer. Packs an address from a string representation into a long.
 * For instance the "255.255.255.255" will be converted into the 0xffffffffL
 * @author Iosif Futerman
*/
public class IPPacker {
    /**Code of the '.' character*/
    static final byte POINT = '.';
    /**Code of the '0' character*/
    static final byte ZERO = '0';

    /**Function for packing
     * @param address - original string representation of IP
     * @return - fields of the ip pucked into the 4 octets
     */
    static public long pack(String address){
        long res = 0;
        byte[] bytes = address.getBytes();
        long sub = 0, shift = 3;
        for (byte aByte : bytes) {
            if (aByte == POINT) {
                res += sub << (8 * (shift));
                sub = 0;
                shift--;
                continue;
            }
            sub = sub * 10 + aByte - ZERO;
        }
        return  res + sub;
    }
}
