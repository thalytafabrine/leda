package adt.queue;

public class QueueImpl<T> implements Queue<T> {

	private T[] array;
	private int tail;
	private int head;

	@SuppressWarnings("unchecked")
	public QueueImpl(int size) {
		array = (T[]) new Object[size];
		tail = -1;
		head = -1;
	}

	@Override
	public T head() {
		if (this.isEmpty()) {
            return null;
		}
        return this.array[head];
	}

	@Override
	public boolean isEmpty() {
		return tail == -1;
	}

	@Override
	public boolean isFull() {
		return tail == array.length - 1;
	}

	private void shiftLeft() {
		for(int i = 0; i < array.length-1; i++) {
			array[i] = array[i+1];
		}
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if (isFull()) {
			throw new QueueOverflowException();
		}
        if (isEmpty()) {
        	this.head = 0;
            this.tail = 0;
            this.array[0] = element;
        } else {
            tail = (tail + 1) % array.length;
            this.array[tail] = element;
        }
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if (this.isEmpty()) {
            throw new QueueUnderflowException();
		}
		T elementoRemovido = this.array[0];
		this.array[0] = null;
		this.shiftLeft();
		tail--;
		return elementoRemovido;
	}

}
