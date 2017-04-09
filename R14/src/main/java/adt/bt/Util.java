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
		
		BSTNode<T> pivot = (BSTNode<T>) node.getRight();
		pivot.setParent(node.getParent());
		
		BSTNode<T> pivotParent = (BSTNode<T>) pivot.getParent();
		if (pivotParent != null) {
			if (pivotParent.getLeft().equals(node)) {
				pivotParent.setLeft(pivot);
			} else {
				pivotParent.setRight(pivot);
			}
		}
		
		node.setRight(pivot.getLeft());
		pivot.getLeft().setParent(node);
		pivot.setLeft(node);
		node.setParent(pivot);
		
		return pivot;
	}

	/**
	 * A rotacao a direita em node deve subir e retornar seu filho a esquerda
	 * @param node
	 * @return
	 */
	public static <T extends Comparable<T>> BSTNode<T> rightRotation(BSTNode<T> node) {
		if(node.isEmpty())
			return null;
		
		BSTNode pivot = (BSTNode) node.getLeft();
		pivot.setParent(node.getParent());

		BSTNode<T> parentPivot = (BSTNode<T>) pivot.getParent();
		if (parentPivot != null) {
			if (parentPivot.getLeft().equals(node)) {
				parentPivot.setLeft(pivot);
			} else {
				parentPivot.setRight(pivot);
			}
		}
		
		node.setLeft(pivot.getRight());
		pivot.getRight().setParent(node);
		pivot.setRight(node);
		node.setParent(pivot);
		
		return pivot;
	}

}
