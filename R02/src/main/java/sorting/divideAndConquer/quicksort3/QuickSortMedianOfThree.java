package sorting.divideAndConquer.quicksort3;

import sorting.AbstractSorting;
import util.Util;

/**
 * A classe QuickSortMedianOfThree representa uma variação do QuickSort que
 * funciona de forma ligeiramente diferente. Relembre que quando o pivô
 * escolhido divide o array aproximadamente na metade, o QuickSort tem um
 * desempenho perto do ótimo. Para aproximar a entrada do caso ótimo, diversas
 * abordagens podem ser utilizadas. Uma delas é usar a mediana de 3 para achar o
 * pivô. Essa técnica consiste no seguinte: 1. Comparar o elemento mais a
 * esquerda, o central e o mais a direita do intervalo. 2. Ordenar os elemento,
 * tal que: A[left] < A[center] < A[right]. 3. Adotar o A[center] como pivô. 4.
 * Colocar o pivô na penúltima posição A[right-1]. 5. Aplicar o particionamento
 * considerando o vetor menor, de A[left+1] até A[right-1]. 6. Aplicar o
 * algoritmo na metade a esquerda e na metade a direita do pivô.
 */
public class QuickSortMedianOfThree<T extends Comparable<T>> extends
		AbstractSorting<T> {

	public void sort(T[] array, int leftIndex, int rightIndex) {
		
		if (leftIndex >= rightIndex || array == null || leftIndex < 0 || rightIndex >= array.length) {
			return;
		}
		
		mediana(array, leftIndex, rightIndex);
		particiona(array, leftIndex, rightIndex);

	}
	
	public void particiona(T[] array, int leftIndex, int rightIndex) {
		T pivot = array[rightIndex-1];
		int i = leftIndex + 1;
		int j = rightIndex - 1;
		
		while(i <= j) {
			while(array[i].compareTo(pivot) < 0) {
				i++;
			}
			while(array[j].compareTo(pivot) > 0) {
				j--;
			}
			if (i <= j){
				Util.swap(array, i, j);
				i++;
				j--;
			}
		}
		if(i < rightIndex) {
			sort(array,i,rightIndex);
		}
		if(leftIndex < j) {
			sort(array,leftIndex,j);
		}
	}

	public void mediana(T[] array, int leftIndex, int rightIndex) {
		int center = (rightIndex+leftIndex)/2;
		
		if (array[leftIndex].compareTo(array[center]) > 0) {
			Util.swap(array, leftIndex, center);
		}

		if (array[leftIndex].compareTo(array[rightIndex]) > 0) {
			Util.swap(array, leftIndex, rightIndex);
		}

		if (array[center].compareTo(array[rightIndex]) > 0) {
			Util.swap(array, center, rightIndex);
		}
		
		Util.swap(array, center, rightIndex-1);
	}
}
