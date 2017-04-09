package adt.btree;

import java.util.Collections;
import java.util.LinkedList;

public class BNode<T extends Comparable<T>> {
	protected LinkedList<T> elements; // PODERIA TRABALHAR COM ARRAY TAMBEM
	protected LinkedList<BNode<T>> children; // PODERIA TRABALHAR COM ARRAY
												// TAMBEM
	protected BNode<T> parent;
	protected int order;

	public BNode(int order) {
		this.order = order;
		this.elements = new LinkedList<T>();
		this.children = new LinkedList<BNode<T>>();
	}

	@Override
	public String toString() {
		return this.elements.toString();
	}

	@Override
	public boolean equals(Object obj) {
		boolean resp = false;
		if (obj != null) {
			if (obj instanceof BNode) {
				if (this.size() == ((BNode<T>) obj).size()) {
					resp = true;
					int i = 0;
					while (i < this.size() && resp) {
						resp = resp && this.getElementAt(i).equals(((BNode<T>) obj).getElementAt(i));
						i++;
					}
				}
			}
		}
		return resp;
	}

	public boolean isEmpty() {
		return this.size() == 0;
	}

	public int size() {
		return this.elements.size();
	}

	public boolean isLeaf() {
		return this.children.size() == 0;
	}

	public boolean isFull() {
		return this.size() == order - 1;
	}

	public void addElement(T element) {
		this.elements.add(element);
		Collections.sort(elements);
	}

	public void removeElement(T element) {
		this.elements.remove(element);
	}

	public void removeElement(int position) {
		this.elements.remove(position);
	}

	public void addChild(int position, BNode<T> child) {
		this.children.add(position, child);
		child.parent = this;
	}

	public void removeChild(BNode<T> child) {
		this.children.remove(child);
	}

	public int indexOfChild(BNode<T> child) {
		return this.children.indexOf(child);
	}

	public T getElementAt(int index) {
		return this.elements.get(index);
	}

	protected void split() {
		int med = (int) Math.floor(this.size()/2.0);

		if (parent == null) {
			parent = new BNode<>(this.getMaxChildren());
			parent.getChildren().addFirst(this);
		}
		
		BNode<T> leftChildren = getLeftChildren(med);
		BNode<T> rightChildren = getRightChildren(med);
		BNode<T> parent = this.getParent();
		int index = parent.indexOfChild(this);

		parent.removeChild(this);
		parent.addChild(index, leftChildren);
		parent.addChild(index + 1, rightChildren);
		
		rightChildren.setParent(parent);
		leftChildren.setParent(parent);
		
		this.promote();
		
		if(parent.size() >= this.getMaxChildren())
			parent.split();
	}

	private BNode<T> getRightChildren(int med) {
		BNode<T> newNode = new BNode<>(this.getMaxChildren());
		for(int i = med + 1; i < this.size(); i++) {
			newNode.addElement(this.getElementAt(i));
		}
		for (int i = med + 1; i < this.children.size(); i++) {
            newNode.addChild(i - med - 1, this.children.get(i));
        }
		return newNode;
	}

	private BNode<T> getLeftChildren(int med) {
		BNode<T> newNode = new BNode<>(this.getMaxChildren());
		for(int i = 0; i < med; i++) {
			newNode.addElement(this.getElementAt(i));
		}
		for(int i = 0; i <= med; i++) {
			newNode.addChild(i, this.children.get(i));
		}
		
		return newNode;
	}

	protected void promote() {
		int med = (int) Math.floor(this.size()/2.0);
		T element = this.getElementAt(med);
		this.parent.addElement(element);
	}

	public LinkedList<T> getElements() {
		return elements;
	}

	public void setElements(LinkedList<T> elements) {
		this.elements = elements;
	}

	public LinkedList<BNode<T>> getChildren() {
		return children;
	}

	public void setChildren(LinkedList<BNode<T>> children) {
		this.children = children;
	}

	public BNode<T> copy() {
		BNode<T> result = new BNode<T>(order);
		result.parent = parent;
		for (int i = 0; i < this.elements.size(); i++) {
			result.addElement(this.elements.get(i));
		}
		for (int i = 0; i < this.children.size(); i++) {
			result.addChild(i, ((BNode<T>) this.children.get(i)).copy());
		}

		return result;
	}

	public BNode<T> getParent() {
		return parent;
	}

	public void setParent(BNode<T> parent) {
		this.parent = parent;
	}

	public int getMaxKeys() {
		return order - 1;
	}

	public int getMaxChildren() {
		return order;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

}
