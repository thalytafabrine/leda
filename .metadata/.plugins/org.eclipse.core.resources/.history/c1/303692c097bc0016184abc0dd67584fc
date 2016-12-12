package prova;

public class QuickSort<T extends Comparable<T>> {

	public void sort(T[] array, int leftIndex, int rightIndex) {
		
		if (array == null || leftIndex < 0 || leftIndex >= rightIndex || rightIndex > array.length || array.length == 1) {
			return;
		}
		
		int pos_pivot = particiona(array, leftIndex, rightIndex);
		sort(array, leftIndex, pos_pivot-1);
		sort(array, pos_pivot+1, rightIndex);
		
	}

	private int particiona(T[] array, int leftIndex, int rightIndex) {
		int i = leftIndex+1;
		int j = rightIndex;
		T pivot = array[leftIndex];
		
		while(i<=j) {
			if(array[i].compareTo(pivot) <= 0) {
				i++;
			}
			else if(array[j].compareTo(pivot) > 0) {
				j--;
			}
			else {
				T aux = array[i];
				array[i] = array[j];
				array[j] = aux;
				i++;
				j--;
			}
		}
		T aux = array[leftIndex];
		array[leftIndex] = array[j];
		array[j] = aux;
		return j;
	}
}
