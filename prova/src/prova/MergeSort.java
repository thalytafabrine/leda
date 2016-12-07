package prova;

import java.util.Arrays;

public class MergeSort<T extends Comparable<T>> {

	public void sort(T[] array, int leftIndex, int rightIndex) {
		
		if (array == null || leftIndex < 0 || leftIndex >= rightIndex || rightIndex > array.length || array.length == 1) {
			return;
		}
		
		int middle = (leftIndex+rightIndex)/2;
		sort(array, leftIndex, middle);
		sort(array, middle+1, rightIndex);
		merge(array, leftIndex, middle, rightIndex);
		
	}

	private void merge(T[] array, int leftIndex, int middle, int rightIndex) {
		T[] arrayAuxiliar = Arrays.copyOf(array, array.length);
		
		int i = leftIndex;
		int j = middle+1;
		int k = leftIndex;
		
		while(i<= middle && j <= rightIndex) {
			if(arrayAuxiliar[i].compareTo(arrayAuxiliar[j]) < 0) {
				array[k] = arrayAuxiliar[i];
				i++;
			} else {
				array[k] = arrayAuxiliar[j];
				j++;
			}
			k++;
			
		}
		
		while(i <= middle) {
			array[k] = arrayAuxiliar[i];
			k++;
			i++;
		}
		
	}
}
