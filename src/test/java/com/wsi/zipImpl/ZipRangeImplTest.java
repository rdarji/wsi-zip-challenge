/**
 * 
 */
package test.java.com.wsi.zipImpl;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import main.java.com.wsi.zip.ZipRange;
import main.java.com.wsi.zipImpl.ZipRangeImpl;

import org.junit.Test;

/**
 * @author RDarji
 *
 */
public class ZipRangeImplTest {
	@Test
	public void testGetZipRange() {
		ZipRange zipRange = new ZipRangeImpl();
		ArrayList<int[]> outputRange = null;
		String[] inputRange = new String[]{"[92833,92833],[95099,95199],[96100,96200]"};
		try {
			System.out.println("Calling getZipRange method>>>>");
			outputRange = zipRange.getZipRange(inputRange);
			assertNotNull(outputRange);
		} catch (Exception e) {
		}
		
	}
}
