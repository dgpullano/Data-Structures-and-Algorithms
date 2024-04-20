package myLibrary.DataStructures.SearchSort;
import java.util.Arrays;

/**
 * Implementation of an interpolation search on integer data.
 * @author Dillon Pullano
 *
 */
public class Interpolation {
	
	// Apply interpolation search (Assumes sorted array so line was added to sort in App)
	public int interpolationSearchIterative(int[] array, int key)
	{
		
		// Sort array first
		Arrays.sort(array);
		
		//Initialize intermediate parameters:
		int low = 0;
		int high = array.length - 1;
		int pos;
		
		while(low <= high && key >= array[low] && key <= array[high]) {

			// For case where search match is on first element:
			if(low == high) {
				if(array[low] == key) {
					return low;
				}
				return -1;
			}
			
			// Get new interpolated index for expected location of match:
			pos = low + ((key - array[low]) * (high - low)) / (array[high] - array[low]);
			
			// When there is match on first try:
			if(key == array[pos]) {
				return pos;
			}
			
			// When key is likely to be lower than mid:
			else if(key < array[pos]) {
				high = pos - 1;
			}
			
			// When key is likely to be higher than mid:
			else {
				low = pos + 1;
			}
		}
		return -1;
	}
}