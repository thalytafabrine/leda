package prova;

public class InsertionSort<T extends Comparable<T>> {

	public void sort(T[] array,int leftIndex, int rightIndex) {
		
		if (array == null || leftIndex < 0 || leftIndex > rightIndex || rightIndex > array.length ) {
			return;
		}
		
		for (int i = leftIndex+1; i <= rightIndex; i++) {
			for (int j = i-1; j >= leftIndex && array[j].compareTo(array[j+1]) > 0; j--) {
				T aux = array[j];
				array[j] = array[j+1];
				array[j+1] = aux;
			} 
		}
	}
}
