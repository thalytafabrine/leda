package adt.linkedList;

public class RecursiveSingleLinkedListImpl<T> implements LinkedList<T> {

	protected T data;
	protected RecursiveSingleLinkedListImpl<T> next;

	public RecursiveSingleLinkedListImpl() {

	}

	public RecursiveSingleLinkedListImpl(T data,
			RecursiveSingleLinkedListImpl<T> next) {
		this.data = data;
		this.next = next;
	}

	@Override
	public boolean isEmpty() {
		return data == null;
	}

	@Override
	public int size() {
		if(this.isEmpty()) {
			return 0;
		}
		return 1 + next.size();
	}

	@Override
	public T search(T element) {
		if(this.isEmpty()) {
			return null;
		} if(this.data == element) {
			return this.data;
		} else {
			return next.search(element);
		}
	}

	@Override
	public void insert(T element) {
		if(this.isEmpty()) {
			this.data = element;
			this.next = new RecursiveSingleLinkedListImpl<>();
		}
		else {
			next.insert(element);
		}
	}

	@Override
	public void remove(T element) {
		if(this.isEmpty()) {
			return;
		} if(this.data == element) {
			this.data = this.next.data;
			this.next = this.next.next;
		} else {
			this.next.remove(element);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public T[] toArray() {
		T[] out = (T[]) new Object[this.size()];
		toArray(out, this);
		return out;
	}
	
	public void toArray(T[] array, RecursiveSingleLinkedListImpl<T> no){
		if(!no.isEmpty()) {
			int i = 0;
			boolean add = false;
			while(i < array.length && add == false) {
				if(array[i] == null) {
					array[i] = no.data;
					add = true;
				} else {
					i++;
				}
			}
			toArray(array, no.next);
		}
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public RecursiveSingleLinkedListImpl<T> getNext() {
		return next;
	}

	public void setNext(RecursiveSingleLinkedListImpl<T> next) {
		this.next = next;
	}

}
