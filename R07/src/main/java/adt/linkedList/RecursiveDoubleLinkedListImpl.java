package adt.linkedList;

public class RecursiveDoubleLinkedListImpl<T> extends RecursiveSingleLinkedListImpl<T> implements DoubleLinkedList<T> {

	protected RecursiveDoubleLinkedListImpl<T> previous;

	public RecursiveDoubleLinkedListImpl() {

	}

	public RecursiveDoubleLinkedListImpl(T data, RecursiveSingleLinkedListImpl<T> next,
			RecursiveDoubleLinkedListImpl<T> previous) {
		super(data, next);
		this.previous = previous;
	}

	@Override
	public void insert(T element) {
		if (element != null) {
			if (this.isEmpty()) {
				insertFirst(element);
			} else {
				this.next.insert(element);
			}
		}
	}

	@Override
	public void remove(T element) {
		if (!isEmpty() && element != null) {
			if (this.data.equals(element)) {
				removeFirst();
			} else {
				this.getNext().remove(element);
			}
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void insertFirst(T element) {
		if (element != null) {
			RecursiveDoubleLinkedListImpl<T> second = new RecursiveDoubleLinkedListImpl(this.getData(), this.getNext(),
					this);
			if (!isEmpty()) {
				next = new RecursiveDoubleLinkedListImpl<T>(getData(), getNext(), this);
				((RecursiveDoubleLinkedListImpl<T>) getNext()).setPrevious((RecursiveDoubleLinkedListImpl<T>) next);
				setData(element);
				setNext(next);
			} else {
				next = new RecursiveDoubleLinkedListImpl<T>();
				setData(element);
				setNext(next);
				setPrevious((RecursiveDoubleLinkedListImpl<T>) next);
			}
		}
	}

	@Override
	public void removeFirst() {
		if (!isEmpty()) {
			RecursiveDoubleLinkedListImpl<T> second = (RecursiveDoubleLinkedListImpl<T>) this.getNext();
			RecursiveDoubleLinkedListImpl<T> third = (RecursiveDoubleLinkedListImpl<T>) second.getNext();
			if (third != null) {
				third.setPrevious(this);
			}
			this.setNext(third);
			this.setData(second.getData());
		}
	}

	@Override
	public void removeLast() {
		if (!isEmpty()) {
			if (this.getNext().isEmpty()) {
				this.setNext(null);
				this.setData(null);
			} else {
				((RecursiveDoubleLinkedListImpl<T>) this.getNext()).removeLast();
			}
		}
	}

	@Override
	public RecursiveDoubleLinkedListImpl<T> getNext() {
		return (RecursiveDoubleLinkedListImpl<T>) super.getNext();
	}

	public RecursiveDoubleLinkedListImpl<T> getPrevious() {
		return previous;
	}

	public void setPrevious(RecursiveDoubleLinkedListImpl<T> previous) {
		this.previous = previous;
	}

}
