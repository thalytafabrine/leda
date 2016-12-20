package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		return (this.getHead().isNIL());
	}

	@Override
	public int size() {
		int size = 0;

		if (!isEmpty()) {
			SingleLinkedListNode<T> aux = this.getHead();

			while (!aux.isNIL()) {
				size++;
				aux = aux.getNext();
			}
		}

		return size;
	}

	@Override
	public T search(T element) {
		T result = null;
		if (!isEmpty() && element != null) {
			SingleLinkedListNode<T> aux = this.head;
			while (!aux.isNIL() && !aux.getData().equals(element)) {
				aux = aux.getNext();
			}
			if (!aux.isNIL() && aux.getData().equals(element)) {
				result = aux.getData();
			}
		}
		return result;
	}

	@Override
	public void insert(T element) {
		if (element != null) {
			SingleLinkedListNode<T> aux = this.head;
			while (!aux.isNIL())
				aux = aux.getNext();
			aux.setData(element);
			aux.setNext(new SingleLinkedListNode<T>());
		}
	}

	@Override
	public void remove(T element) {

		if (element != null && !isEmpty()) {
			if (this.head.getData().equals(element)) {
				head = head.getNext();
			} else {
				SingleLinkedListNode<T> previous = new SingleLinkedListNode<T>();
				SingleLinkedListNode<T> aux = this.getHead();

				while (!aux.isNIL() && !aux.getData().equals(element)) {
					previous = aux;
					aux = aux.getNext();
				}
				if (!aux.isNIL()) {
					previous.setNext(aux.getNext());
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public T[] toArray() {
		int size = this.size();
		int index = 0;

		T[] array = (T[]) new Object[size];
		SingleLinkedListNode<T> aux = this.getHead();

		while (!aux.isNIL()) {
			array[index] = aux.getData();
			aux = aux.getNext();
			index++;
		}

		return array;
	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

}
