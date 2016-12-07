package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa do Counting Sort vista em sala. Desta vez este
 * algoritmo deve satisfazer os seguitnes requisitos: - Alocar o tamanho minimo
 * possivel para o array de contadores (C) - Ser capaz de ordenar arrays
 * contendo numeros negativos
 */
public class ExtendedCountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {

		if(array == null || leftIndex >= rightIndex || leftIndex < 0 || rightIndex >= array.length) {
			return;
		}
		
		int maior = array[leftIndex];
		int menor = array[leftIndex+1];
		
		for(int i = leftIndex; i <= rightIndex; i++) {
			if (array[i] > maior) {
				maior = array[i];
			} else if (array[i] < menor) {
				menor = array[i];
			}
		}
		
		int tamanhoArray = maior - menor + 1;
		int[] countArray = new int[tamanhoArray];
		
		for(int i = leftIndex; i <= rightIndex; i++) {
			countArray[array[i] - menor]++;
		}
		
		for(int i = 1; i < tamanhoArray; i++) {
			countArray[i] += countArray[i-1];
		}
		
		int[] arrayOrdenado = new int[array.length];
		
		for(int i = leftIndex; i <= rightIndex; i++) {
			arrayOrdenado[countArray[array[i] - menor] - 1] = array[i];
			countArray[array[i] - menor]--;
		}
		
		for(int i = leftIndex; i <= rightIndex; i++) {
			array[i] = arrayOrdenado[i];
		}
		
	}

}
