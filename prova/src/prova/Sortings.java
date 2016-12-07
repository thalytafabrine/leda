package prova;

import java.util.Arrays;

public class Sortings {
	
//	
//	public class CombSort<T extends Comparable<T>> {
//
//		public void sort(T[] array, int leftIndex, int rightIndex) {
//			
//			if (array == null || leftIndex < 0 || leftIndex > rightIndex || rightIndex > array.length ) {
//				return;
//			}
//			
//			int gap = (int) (rightIndex-leftIndex);
//			boolean swapped = true;
//			
//			while(gap > 1 || swapped) {
//				gap = (int) (gap/1.3);
//				
//				int i = 0;
//				swapped = false;
//				
//				while(i + gap <= rightIndex) {
//					if(array[i].compareTo(array[i+gap]) > 0) {
//						T aux = array[i];
//						array[i] = array[i+gap];
//						array[i+gap] = aux;
//						swapped = true;
//					}
//					i++;
//				}
//				
//			}
//			
//		}
//
////	}
//	
//	public class CountingSort<T extends Comparable<T>> {
//
//		public void sort(Integer[] array, int leftIndex, int rightIndex) {
//			if(array == null || leftIndex >= rightIndex || leftIndex < 0 || rightIndex >= array.length) {
//				return;
//			}
//			
//			int maior = array[leftIndex];
//			
//			for(int i = leftIndex; i <= rightIndex; i++) {
//				if (array[i] > maior) {
//					maior = array[i];
//				}
//			}
//			
//			int tamanhoArray = maior + 1;
//			int[] countArray = new int[tamanhoArray];
//					
//			for(int i = leftIndex; i <= rightIndex; i++) {
//				countArray[array[i]]++;
//			}
//			
//			for(int i = 1; i < tamanhoArray; i++) {
//				countArray[i] += countArray[i-1];
//			}
//			
//			int[] arrayOrdenado = new int[array.length];
//			
//			for(int i = leftIndex; i <= rightIndex; i++) {
//				arrayOrdenado[countArray[array[i]]-1] = array[i];
//				countArray[array[i]]--;
//			}
//			
//			for(int i = leftIndex; i <= rightIndex; i++) {
//				array[i] = arrayOrdenado[i];
//			}
//			
//		}
//
//	}
//	
	
//	public class InsertionSort<T extends Comparable<T>> {
//
//		public void sort(T[] array,int leftIndex, int rightIndex) {
//			
//			if (array == null || leftIndex < 0 || leftIndex > rightIndex || rightIndex > array.length ) {
//				return;
//			}
//			
//			for (int i = leftIndex+1; i <= rightIndex; i++) {
//				for (int j = i-1; j >= leftIndex && array[j].compareTo(array[j+1]) > 0; j--) {
//					T aux = array[j];
//					array[j] = array[j+1];
//					array[j+1] = aux;
//				} 
//			}
//		}
//	}
	
//	public class MergeSort<T extends Comparable<T>> {
//
//		public void sort(T[] array, int leftIndex, int rightIndex) {
//			
//			if (array == null || leftIndex < 0 || leftIndex >= rightIndex || rightIndex > array.length || array.length == 1) {
//				return;
//			}
//			
//			int middle = (leftIndex+rightIndex)/2;
//			sort(array, leftIndex, middle);
//			sort(array, middle+1, rightIndex);
//			merge(array, leftIndex, middle, rightIndex);
//			
//		}
//
//		private void merge(T[] array, int leftIndex, int middle, int rightIndex) {
//			T[] arrayAuxiliar = Arrays.copyOf(array, array.length);
//			
//			int i = leftIndex;
//			int j = middle+1;
//			int k = leftIndex;
//			
//			while(i<= middle && j <= rightIndex) {
//				if(arrayAuxiliar[i].compareTo(arrayAuxiliar[j]) < 0) {
//					array[k] = arrayAuxiliar[i];
//					i++;
//				} else {
//					array[k] = arrayAuxiliar[j];
//					j++;
//				}
//				k++;
//				
//			}
//			
//			while(i <= middle) {
//				array[k] = arrayAuxiliar[i];
//				k++;
//				i++;
//			}
//			
//		}

//	public class QuickSort<T extends Comparable<T>> {
//
//		public void sort(T[] array, int leftIndex, int rightIndex) {
//			
//			if (array == null || leftIndex < 0 || leftIndex >= rightIndex || rightIndex > array.length || array.length == 1) {
//				return;
//			}
//			
//			int pos_pivot = particiona(array, leftIndex, rightIndex);
//			sort(array, leftIndex, pos_pivot-1);
//			sort(array, pos_pivot+1, rightIndex);
//			
//		}
//
//		private int particiona(T[] array, int leftIndex, int rightIndex) {
//			int i = leftIndex+1;
//			int j = rightIndex;
//			T pivot = array[leftIndex];
//			
//			while(i<=j) {
//				if(array[i].compareTo(pivot) <= 0) {
//					i++;
//				}
//				else if(array[j].compareTo(pivot) > 0) {
//					j--;
//				}
//				else {
//					T aux = array[i];
//					array[i] = array[j];
//					array[j] = aux;
//					i++;
//					j--;
//				}
//			}
//			T aux = array[leftIndex];
//			array[leftIndex] = array[j];
//			array[j] = aux;
//			return j;
//			
//			
//			
//			//Mediana de 3
////			while(i <= j) {
////				while(array[i].compareTo(pivot) < 0) {
////					i++;
////				}
////				while(array[j].compareTo(pivot) > 0) {
////					j--;
////				}
////				if (i <= j){
////					Util.swap(array, i, j);
////					i++;
////					j--;
////				}
////			}
////			if(i < rightIndex) {
////				sort(array,i,rightIndex);
////			}
////			if(leftIndex < j) {
////				sort(array,leftIndex,j);
////			}
//		}
//		
//		// Mediana de 3
////		public void mediana(T[] array, int leftIndex, int rightIndex) {
////			int center = (rightIndex+leftIndex)/2;
////			
////			if (array[leftIndex].compareTo(array[center]) > 0) {
////				Util.swap(array, leftIndex, center);
////			}
//	//
////			if (array[leftIndex].compareTo(array[rightIndex]) > 0) {
////				Util.swap(array, leftIndex, rightIndex);
////			}
//	//
////			if (array[center].compareTo(array[rightIndex]) > 0) {
////				Util.swap(array, center, rightIndex);
////			}
////			
////			Util.swap(array, center, rightIndex-1);
////		}
//	}
	
//	public class SelectionSort<T extends Comparable<T>> {
//
//		public void sort(T[] array, int leftIndex, int rightIndex) {
//			
//			if (array == null || leftIndex < 0 || leftIndex > rightIndex || rightIndex > array.length ) {
//				return;
//			}
//			
//			for (int i = leftIndex; i <= rightIndex; i++) {
//				int indiceMenor = i;
//				for (int j = i+1; j <= rightIndex; j++) {
//					if(array[j].compareTo(array[indiceMenor]) < 0) {
//						indiceMenor = j;
//					}
//				}
//				T aux = array[i];
//				array[i] = array[indiceMenor];
//				array[indiceMenor] = aux;
//				
//			}
//		}


}
