package prova;

public class BubbleSort<T extends Comparable<T>> {

	public void sort(T[] array, int leftIndex, int rightIndex) {
		
		if (array == null || leftIndex < 0 || leftIndex > rightIndex || rightIndex > array.length ) {
			return;
		}
		
		for(int i = leftIndex ; i <= rightIndex; i++) {
			for (int j = leftIndex; j <= rightIndex - 1; j++) {
				if(array[j].compareTo(array[j+1]) > 0 ) {
					T aux = array[j];
					array[j] = array[j+1];
					array[j+1] = aux;
				}
			}
		}
		
	}

}
