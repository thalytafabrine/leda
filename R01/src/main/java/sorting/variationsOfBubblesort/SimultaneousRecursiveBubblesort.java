package sorting.variationsOfBubblesort;

import sorting.AbstractSorting;
import util.Util;

/**
 * Este algoritmo eh RECURSIVO e aplica o bubblesort na entrada empurrando os 
 * elementos grandes apra o final e trazendo os elementos menores para o início.
 * Dessa forma, ao final da primeira iteração, o menor elemento está na primeira
 * posição e o maioe elemento está na ultima. 
 * Nas proximas iterações as posicoes dos elementos das iterações anteriores
 * são excluidas do espaço de varredura do array.
 */
public class SimultaneousRecursiveBubblesort<T extends Comparable<T>> extends AbstractSorting<T> {

   public void sort(T[] array, int leftIndex, int rightIndex) {

      if (leftIndex == rightIndex - 1) {
    	  sort(array, 0, rightIndex-1);
      }
      else if (array[leftIndex].compareTo(array[leftIndex + 1]) > 0) {
    	  Util.swap(array, leftIndex, leftIndex+1);
    	  sort(array, leftIndex+1, rightIndex);
      }
      else {
    	  sort(array, leftIndex+1, rightIndex);
      }
   }
}
