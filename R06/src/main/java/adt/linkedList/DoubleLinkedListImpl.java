package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;
	private DoubleLinkedListNode<T> nilNode = new DoubleLinkedListNode<T>();

	public DoubleLinkedListImpl() {
		super();
		this.head = this.last = new DoubleLinkedListNode<T>();
	}

	@Override
	public void insertFirst(T element) {
		if (element != null) {
			DoubleLinkedListNode<T> head = (DoubleLinkedListNode<T>) this.getHead();
			DoubleLinkedListNode<T> newNode = new DoubleLinkedListNode<T>(element, head, nilNode);

			head.setPrevious(newNode);
			this.setHead(newNode);

			if (this.getLast().isNIL()) {
				this.setLast(newNode);
			} else if (this.getLast().getPrevious() == null) {
				this.getLast().setPrevious(newNode);
			}

		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void removeFirst() {
		if (!this.getHead().isNIL()) {
            if (this.getHead().getNext() != null) {
                this.setHead(this.getHead().getNext());
                ((DoubleLinkedListNode)this.getHead()).setPrevious(null);
            } else {
                this.setHead(new DoubleLinkedListNode<T>());
            }
        }
	}

	@Override
	public void removeLast() {
		if (!isEmpty()) {

			if (size() == 1) {
				super.head = this.last = (DoubleLinkedListNode<T>) super.head.getNext();
				
			} else {
				this.last.getPrevious().setNext(nilNode);
				this.last = this.last.getPrevious();
			}

		}
	}
	
	@Override
	public void insert(T element) {
		if (element != null) {
			
			DoubleLinkedListNode<T> elem = new DoubleLinkedListNode<T>(element, nilNode, last);

			if (isEmpty()) {
				super.head = last = elem;
			} else {
				last.next = elem;
				last = elem;
			}
		}
	}

	@Override
	public void remove(T element) {
		if (!isEmpty() && element != null) {
			SingleLinkedListNode<T> aux =  getHead();
			while (!aux.isNIL() && !aux.getData().equals(element)) {
				aux = aux.getNext();
			}
			if (!aux.isNIL() && aux.getData().equals(element)) {
				DoubleLinkedListNode<T> newNext = (DoubleLinkedListNode<T>) aux.getNext().getNext();
				aux.setData(aux.getNext().getData());
				aux.setNext(newNext);
				if (newNext != null)
					newNext.setPrevious((DoubleLinkedListNode<T>) aux);
			}
		}
	}

	public DoubleLinkedListNode<T> getLast() {
		return last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}

}
