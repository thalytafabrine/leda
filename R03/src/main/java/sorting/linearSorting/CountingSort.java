package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala. Procure
 * evitar desperdicio de memoria alocando o array de contadores com o tamanho
 * sendo o máximo inteiro presente no array a ser ordenado.
 * 
 */
public class CountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		if(array == null || leftIndex >= rightIndex || leftIndex < 0 || rightIndex >= array.length) {
			return;
		}
		
		int maior = array[leftIndex];
		
		for(int i = leftIndex; i <= rightIndex; i++) {
			if (array[i] > maior) {
				maior = array[i];
			}
		}
		
		int tamanhoArray = maior + 1;
		int[] countArray = new int[tamanhoArray];
				
		for(int i = leftIndex; i <= rightIndex; i++) {
			countArray[array[i]]++;
		}
		
		for(int i = 1; i < tamanhoArray; i++) {
			countArray[i] += countArray[i-1];
		}
		
		int[] arrayOrdenado = new int[array.length];
		
		for(int i = leftIndex; i <= rightIndex; i++) {
			arrayOrdenado[countArray[array[i]]-1] = array[i];
			countArray[array[i]]--;
		}
		
		for(int i = leftIndex; i <= rightIndex; i++) {
			array[i] = arrayOrdenado[i];
		}
		
	}

}
