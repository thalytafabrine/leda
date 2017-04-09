package adt.avltree;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;
import adt.bt.Util;

/**
 * 
 * Performs consistency validations within a AVL Tree instance
 * 
 * @author Claudio Campelo
 *
 * @param <T>
 */
public class AVLTreeImpl<T extends Comparable<T>> extends BSTImpl<T> implements AVLTree<T> {

	@Override
	public void remove(T element) {
		if (element == null) {
			return;
		}
		
		BSTNode<T> node = search(element);
		node = super.remove(node);
		this.rebalanceUp((BSTNode<T>) node.getParent());
	}


	// AUXILIARY
	protected int calculateBalance(BSTNode<T> node) {
		if (node == null || node.isEmpty())
			return 0;
		BSTNode<T> nodeLeft = (BSTNode<T>) node.getLeft();
		BSTNode<T> nodeRight = (BSTNode<T>) node.getRight();
		return this.height(nodeRight, -1) - this.height(nodeLeft, -1);
	}

	// AUXILIARY
	protected void rebalance(BSTNode<T> node) {
		int balance = this.calculateBalance(node);

		if (balance < -1) {
			if (this.calculateBalance((BSTNode<T>) node.getLeft()) > 0)
				leftRotation((BSTNode<T>) node.getLeft());
			rightRotation(node);
		} else if (balance > 1) {
			if (this.calculateBalance((BSTNode<T>) node.getRight()) < 0)
				rightRotation((BSTNode<T>) node.getRight());
			leftRotation(node);
		}
	}

	// AUXILIARY
	protected void rebalanceUp(BSTNode<T> node) {
		if (node != null) {
			this.rebalance(node);
			this.rebalanceUp((BSTNode<T>) node.getParent());
		}
	}

	@Override
	public void insert(T element) {
		super.insert(element);
		BSTNode<T> node = this.search(element);
		this.rebalanceUp(node);
	}

	protected void leftRotation(BSTNode<T> node) {
		BSTNode<T> newNode = Util.leftRotation(node);
		if (newNode.getParent() == null)
			root = newNode;
	}

	protected void rightRotation(BSTNode<T> node) {
		BSTNode<T> newNode = Util.rightRotation(node);
		if (newNode.getParent() == null)
			root = newNode;
	}
}
