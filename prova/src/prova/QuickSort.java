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
		
		
		
		//Mediana de 3
//		while(i <= j) {
//			while(array[i].compareTo(pivot) < 0) {
//				i++;
//			}
//			while(array[j].compareTo(pivot) > 0) {
//				j--;
//			}
//			if (i <= j){
//				Util.swap(array, i, j);
//				i++;
//				j--;
//			}
//		}
//		if(i < rightIndex) {
//			sort(array,i,rightIndex);
//		}
//		if(leftIndex < j) {
//			sort(array,leftIndex,j);
//		}
	}
	
	// Mediana de 3
//	public void mediana(T[] array, int leftIndex, int rightIndex) {
//		int center = (rightIndex+leftIndex)/2;
//		
//		if (array[leftIndex].compareTo(array[center]) > 0) {
//			Util.swap(array, leftIndex, center);
//		}
//
//		if (array[leftIndex].compareTo(array[rightIndex]) > 0) {
//			Util.swap(array, leftIndex, rightIndex);
//		}
//
//		if (array[center].compareTo(array[rightIndex]) > 0) {
//			Util.swap(array, center, rightIndex);
//		}
//		
//		Util.swap(array, center, rightIndex-1);
//	}
}
