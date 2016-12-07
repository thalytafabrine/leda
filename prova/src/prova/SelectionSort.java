package prova;

public class SelectionSort<T extends Comparable<T>> {

	public void sort(T[] array, int leftIndex, int rightIndex) {
		
		if (array == null || leftIndex < 0 || leftIndex > rightIndex || rightIndex > array.length ) {
			return;
		}
		
		for (int i = leftIndex; i <= rightIndex; i++) {
			int indiceMenor = i;
			for (int j = i+1; j <= rightIndex; j++) {
				if(array[j].compareTo(array[indiceMenor]) < 0) {
					indiceMenor = j;
				}
			}
			T aux = array[i];
			array[i] = array[indiceMenor];
			array[indiceMenor] = aux;
			
		}
	}
}
