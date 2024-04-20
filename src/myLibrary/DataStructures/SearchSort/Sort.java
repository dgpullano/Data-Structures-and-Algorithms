package myLibrary.DataStructures.SearchSort;

/**
 * Implementation of selection sort on integer data.
 * @author Dillon Pullano
 *
 */
public class Sort {
	
	// Apply one of the sorting algorithms (Selection Sort - Ascending)
	public void X_Sort(int[] a)
	{
		for(int i = 0; i < a.length-2; i++) {
			
			// Find the minimum element:
			int min = i;
			
			for(int j = i + 1; j < a.length; j++) {
				
				if(a[j] < a[min]) {
					min = j;
				}
			}
			
			// Swap items in list:
			int temp = a[min];
			a[min] = a[i];
			a[i] = temp;
		}
	}
}