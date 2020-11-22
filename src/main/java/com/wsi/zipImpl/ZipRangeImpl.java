/**
 * 
 */
package main.java.com.wsi.zipImpl;

import java.util.ArrayList;

import main.java.com.wsi.zip.ZipRange;

/**
 * @author RDarji
 *
 */
public class ZipRangeImpl implements ZipRange {

	private ArrayList<int[]> originalRange = new ArrayList<int[]>();

	private ArrayList<int[]> updatedRange = new ArrayList<int[]>();

	public ArrayList<int[]> getUpdatedRange() {
		return updatedRange;
	}

	public void setUpdatedRange(ArrayList<int[]> updatedRange) {
		this.updatedRange = updatedRange;
	}

	public ArrayList<int[]> getOriginalRange() {
		return originalRange;
	}

	public void setOriginalRange(ArrayList<int[]> originalRange) {
		this.originalRange = originalRange;
	}

	@Override
	public ArrayList<int[]> getZipRange(String[] inputRange) {

		for (String range : inputRange) {
			System.out.println(range);
			String[] zipRange = range.replaceAll("\\[|\\]", "").split(",");
			int[] zipNumbers = new int[zipRange.length];
			for (int i = 0; i < zipRange.length; i++) {
				zipNumbers[i] = Integer.parseInt(zipRange[i]);
			}
			originalRange.add(zipNumbers);
		}
		ArrayList<int[]> processedZipRange = getUpdatedZipRange(originalRange);
		return processedZipRange;
	}

	private ArrayList<int[]> getUpdatedZipRange(ArrayList<int[]> originalRange2) {
		for (int i = 0; i < originalRange2.size(); i++) {
			boolean check = false;
			if (i == originalRange2.size() - 1) {
				System.out.println("Checking overlap>>>.");
				check = (Math.max(originalRange2.get(i)[1],
						originalRange2.get(i - 2)[1]))
						- Math.min(originalRange2.get(i)[0],
								originalRange2.get(i - 2)[0]) < ((originalRange2
						.get(i)[1]) - (originalRange2.get(i)[0]))
						+ ((originalRange2.get(i - 2)[1]) - (originalRange2
								.get(i - 2)[0]));
				if (check) {
					int maxZip = (Math.max(originalRange2.get(i)[1],
							originalRange2.get(i - 2)[1]));
					int minZip = (Math.min(originalRange2.get(i)[0],
							originalRange2.get(i - 2)[0]));
					int zipCodes[] = new int[] { minZip, maxZip };
					updatedRange.remove(2);
					updatedRange.remove(0);
					updatedRange.add(zipCodes);
				}
			} else {
				System.out.println("Checking overlap>>>.");
				check = (Math.max(originalRange2.get(i)[1],
						originalRange2.get(i + 1)[1]))
						- Math.min(originalRange2.get(i)[0],
								originalRange2.get(i + 1)[0]) < ((originalRange2
						.get(i)[1]) - (originalRange2.get(i)[0]))
						+ ((originalRange2.get(i + 1)[1]) - (originalRange2
								.get(i + 1)[0]));
				if (check) {
					int maxZip = (Math.max(originalRange2.get(i)[1],
							originalRange2.get(i + 1)[1]));
					int minZip = (Math.min(originalRange2.get(i)[0],
							originalRange2.get(i + 1)[0]));
					int zipCodes[] = new int[] { minZip, maxZip };
					if (i == 1) {
						updatedRange.remove(i);
					}
					updatedRange.add(zipCodes);
				} else {
					if (i == 0) {
						updatedRange.add(originalRange2.get(i));
					}
					if (i != originalRange2.size() - 1) {
						updatedRange.add(originalRange2.get(i + 1));
					}

				}
			}
		}
		return updatedRange;
	}
}
