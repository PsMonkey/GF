package dontCare.gf.gwt.client.util;

/**
 * 將一個 int 當成 32 個 boolean flag 來用時，所需要的 utility。
 */
public class BitFlag {
	public static boolean extractBit(int value, int mask) {
		return (value & mask) == mask;
	}
	
	public static int assignBit(int value, int mask, boolean flag) {
		if (flag) {
			return value | mask;
		} else {
			return value & (~mask);
		}
	}
}
