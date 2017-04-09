package adt.splaytree;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;
import adt.bt.Util;

public class SplayTreeImpl<T extends Comparable<T>> extends BSTImpl<T>
		implements SplayTree<T> {

	private void splay(BSTNode<T> node) {
		if (node == null) return;
		
		if (node.getParent() == null) {
			this.root = node;
			return;
		}
		else if (node.getParent().getParent() == null) {
			if(this.isLeftChild(node)) {
				BSTNode<T> aux = (BSTNode<T>) node.getParent();
				aux.setLeft(node.getRight());
				node.getRight().setParent(aux);
				node.setRight(aux);
				node.setParent(aux.getParent());
				aux.setParent(node);
			}
			else {
				BSTNode<T> aux = (BSTNode<T>) node.getParent();
				aux.setRight(node.getLeft());
				node.getLeft().setParent(aux);
				node.setLeft(aux);
				node.setParent(aux.getParent());
				aux.setParent(node);
			}
			
		}
		else {
			if (this.isLeftChild(node) && this.isLeftChild((BSTNode<T>) node.getParent())) {
				Util.rightRotation((BSTNode<T>) node.getParent().getParent());
				Util.rightRotation((BSTNode<T>) node.getParent());
			}
			else if (!this.isLeftChild(node) && !this.isLeftChild((BSTNode<T>) node.getParent())) {
				Util.leftRotation((BSTNode<T>) node.getParent().getParent());
				Util.leftRotation((BSTNode<T>) node.getParent());
			}
			else {
				if(this.isLeftChild(node)) {
					Util.rightRotation((BSTNode<T>) node.getParent());
					Util.leftRotation((BSTNode<T>) node.getParent());
				} else {
					Util.leftRotation((BSTNode<T>) node.getParent());
					Util.rightRotation((BSTNode<T>) node.getParent());
				}
			}
		} this.splay(node);
			
	}
	
	@Override
	public void insert(T element) {
		if (element == null) return;
		BSTNode<T> node = super.insert(root, element, (BSTNode<T>) root.getParent());
		this.splay(node);
		
	}
	
	@Override
	public void remove(T element) {
		if (element == null) return;
		BSTNode<T> nodeSplay = new BSTNode<T>();
		
		BSTNode<T> node = super.search(element);
		
		if (!node.isEmpty()) {
			if(!node.getData().equals(element)) nodeSplay = node;
			else nodeSplay = (BSTNode<T>) node.getParent();
			
			if(element != null && node.getData().equals(element))
				super.remove(node);
		}
		this.splay(nodeSplay);
		
	}
	
	@Override
	public BSTNode<T> search(T element) {
		if(element == null || this.root.isEmpty())
			return new BSTNode<T>();
			
		BSTNode<T> node = super.search(element);
		if (!node.isEmpty())
			this.splay(node);
		else
			this.splay((BSTNode<T>) node.getParent());
		return node;
	}
	
	private boolean isLeftChild(BSTNode<T> node) {
		if (node.getParent().getLeft() != null)
			return node.getParent().getLeft().equals(node);
		return false;
	}
}
