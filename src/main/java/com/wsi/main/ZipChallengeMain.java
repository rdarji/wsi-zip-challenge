/**
 * 
 */
package main.java.com.wsi.main;

import java.util.ArrayList;
import java.util.Arrays;

import main.java.com.wsi.zip.ZipRange;
import main.java.com.wsi.zipImpl.ZipRangeImpl;

/**
 * @author RDarji
 *
 */
public class ZipChallengeMain {

	/**
	 * @param args
	 */
	public static void main(String[] inputRange) {
		System.out.println("Input range>>>>");
		ZipRange zipRange = new ZipRangeImpl();
		ArrayList<int[]> outputRange = zipRange.getZipRange(inputRange);
		System.out.println("Output Range is>>>>");
		for(int[] ar:outputRange){
		System.out.println( Arrays.toString(ar));
		}
	}
}
