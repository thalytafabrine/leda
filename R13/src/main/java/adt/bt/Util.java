package adt.bt;

import adt.bst.BSTNode;

public class Util {


	/**
	 * A rotacao a esquerda em node deve subir e retornar seu filho a direita
	 * @param node
	 * @return
	 */
	public static <T extends Comparable<T>> BSTNode<T> leftRotation(BSTNode<T> node) {
		if(node.isEmpty())
			return null;
		
		BSTNode pivot = (BSTNode) node.getRight();
		pivot.parent = node.parent;
		node.parent = pivot;
		node.right = pivot.getLeft();
		pivot.left = node;
		
		return pivot;
	}

	/**
	 * A rotacao a direita em node deve subir e retornar seu filho a esquerda
	 * @param node
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static <T extends Comparable<T>> BSTNode<T> rightRotation(BSTNode<T> node) {
		if(node.isEmpty())
			return null;
		
		BSTNode pivot = (BSTNode) node.getLeft();
		pivot.parent = node.parent;
		node.parent = pivot;
		node.left = pivot.getRight();
		pivot.right = node;
		
		return pivot;
	}

	public static <T extends Comparable<T>> T[] makeArrayOfComparable(int size) {
		@SuppressWarnings("unchecked")
		T[] array = (T[]) new Comparable[size];
		return array;
	}
}
