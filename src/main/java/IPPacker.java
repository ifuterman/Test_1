/**
 * Fast IP packer. Packs an address from a string representation into a long.
 * For instance the "255.255.255.255" will be converted into the 0xffffffffL
 * @author Iosif Futerman
*/
public class IPPacker {
    /**Code of the '.' character*/
    private static final byte POINT = '.';
    /**Code of the '0' character*/
    private static final byte ZERO = '0';

    /**Function for packing
     * @param address - original string representation of IP
     * @return - fields of the ip pucked into the 4 octets
     */
    static public long pack(String address){
        long result = 0;
        byte[] bytes = address.getBytes();
        long subFiled = 0, shift = 3;//subField - field of IP address
        for (byte aByte : bytes) {
            if (aByte == POINT) {
                result += subFiled << (8 * (shift));//Magic number 8 is the 8 bits for shifting inside result
                subFiled = 0;
                shift--;
                continue;
            }
            /* To reduce time of conversion char to int, the meaning of char is computing as
             * the difference between current character code and code of ZERO character
             */
            subFiled = subFiled * 10 + aByte - ZERO;
        }
        return  result + subFiled;
    }
}
