package adt.queue;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.DoubleLinkedListImpl;
import adt.linkedList.SingleLinkedListImpl;

public class QueueDoubleLinkedListImpl<T> implements Queue<T> {

	protected DoubleLinkedList<T> list;
	protected int size;

	public QueueDoubleLinkedListImpl(int size) {
		if (size < 0)
			size = 0;
		this.size = size;
		this.list = new DoubleLinkedListImpl<T>();
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if (isFull()) {
			throw new QueueOverflowException();
		}
		if (element != null) {
			list.insert(element);
			size--;
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if (!isEmpty()) {
            T element = ((DoubleLinkedListImpl<T>) list).getHead().getData();
            size++;
            this.list.removeFirst();
            return element;
        } else {
            throw new QueueUnderflowException();
        }
	}

	@Override
	public T head() {
		return ((DoubleLinkedListImpl<T>) list).getHead().getData();
	}

	@Override
	public boolean isEmpty() {
		return this.list.isEmpty();
	}

	@Override
	public boolean isFull() {
		return this.size == 0;
	}

}
