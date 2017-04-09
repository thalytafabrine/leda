package adt.stack;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.DoubleLinkedListImpl;

public class StackDoubleLinkedListImpl<T> implements Stack<T> {

	protected DoubleLinkedList<T> top;
	protected int size;

	public StackDoubleLinkedListImpl(int size) {
		if (size < 0)
			size = 0;
		this.size = size;
		this.top = new DoubleLinkedListImpl<T>();
	}

	@Override
	public void push(T element) throws StackOverflowException {
		if (!isFull() && element != null) {
            this.top.insert(element);
            size--;
        } else {
            throw new StackOverflowException();
        }
	}

	@Override
	public T pop() throws StackUnderflowException {
		if (!isEmpty()) {
            T element = ((DoubleLinkedListImpl<T>) top).getLast().getData();
            this.top.removeLast();
            size++;
            return element;
        } else {
            throw new StackUnderflowException();
        }
	}

	@Override
	public T top() {
		return ((DoubleLinkedListImpl<T>) top).getLast().getData();
	}

	@Override
	public boolean isEmpty() {
		return this.top.isEmpty();
	}

	@Override
	public boolean isFull() {
		return this.size == 0;
	}

}
