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
		if (!isFull()) {
            this.top.insert(element);
        } else {
            throw new StackOverflowException();
        }
	}

	@Override
	public T pop() throws StackUnderflowException {
		if (!isEmpty()) {
            T element = this.top();
            this.top.removeLast();
            return element;
        } else {
            throw new StackUnderflowException();
        }
	}

	@Override
	public T top() {
		T element = null;
		if (!isEmpty())
			element = ((DoubleLinkedListImpl<T>) top).getHead().getData();
		return element;
	}

	@Override
	public boolean isEmpty() {
		return this.top.isEmpty();
	}

	@Override
	public boolean isFull() {
		return this.top.size() == this.size;
	}

}
