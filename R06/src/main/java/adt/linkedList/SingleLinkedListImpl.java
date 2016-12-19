package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		if(this.head.isNIL()) {
			return true;
		}
		return false;
	}

	@Override
	public int size() {
		int count = 0;
		SingleLinkedListNode<T> no = this.head;
		
		while(!no.isNIL()) {
			no = no.next;
			count++;
		}
		return count;
	}

	@Override
	public T search(T element) {
		T out = null;
		if(element != null) {
			SingleLinkedListNode<T> no = this.head;
			while(!no.isNIL()) {
				if(no.getData().equals(element))
					return no.getData();
				no = no.next;
			}
		}
		return out;
	}

	@Override
	public void insert(T element) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented!");
	}

	@Override
	public void remove(T element) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented!");
	}

	@Override
	public T[] toArray() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented!");
	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

}
