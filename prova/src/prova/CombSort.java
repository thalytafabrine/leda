package prova;

public class CombSort<T extends Comparable<T>> {

	public void sort(T[] array, int leftIndex, int rightIndex) {
		
		if (array == null || leftIndex < 0 || leftIndex > rightIndex || rightIndex > array.length ) {
			return;
		}
		
		int gap = (int) (rightIndex-leftIndex);
		boolean swapped = true;
		
		while(gap > 1 || swapped) {
			gap = (int) (gap/1.3);
			
			int i = 0;
			swapped = false;
			
			while(i + gap <= rightIndex) {
				if(array[i].compareTo(array[i+gap]) > 0) {
					T aux = array[i];
					array[i] = array[i+gap];
					array[i+gap] = aux;
					swapped = true;
				}
				i++;
			}
			
		}
		
	}

}
