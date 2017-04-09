package adt.skipList;

public class SkipListImpl<T> implements SkipList<T> {

	protected SkipListNode<T> root;
	protected SkipListNode<T> NIL;

	protected int maxHeight;
	protected int height;

	protected double PROBABILITY = 0.5;
	protected boolean USE_MAX_HEIGHT_AS_HEIGHT;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public SkipListImpl(int maxHeight) {
		if (USE_MAX_HEIGHT_AS_HEIGHT) {
			this.height = maxHeight;
		} else {
			this.height = 1;
		}

		this.maxHeight = maxHeight;
		root = new SkipListNode(Integer.MIN_VALUE, maxHeight, null);
		NIL = new SkipListNode(Integer.MAX_VALUE, maxHeight, null);
		connectRootToNil();
	}

	/**
	 * Faz a ligacao inicial entre os apontadores forward do ROOT e o NIL Caso
	 * esteja-se usando o level do ROOT igual ao maxLevel esse metodo deve
	 * conectar todos os forward. Senao o ROOT eh inicializado com level=1 e o
	 * metodo deve conectar apenas o forward[0].
	 */
	private void connectRootToNil() {
		for (int i = 0; i < maxHeight; i++) {
			root.forward[i] = NIL;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void insert(int key, T newValue, int height) {
		if (this.USE_MAX_HEIGHT_AS_HEIGHT)
			height = this.maxHeight;

		if (this.height < height) {
			int current = this.height;

			while (current < height) {

				this.root.forward[current] = this.NIL;
				current++;
			}
			this.height = height;
		}

		SkipListNode<T> node = this.root;
		SkipListNode<T>[] stuffToUpdate = new SkipListNode[this.height];

		for (int i = this.height - 1; i >= 0; i--) {

			while (node.forward[i] != null && node.forward[i].key < key) {

				node = node.forward[i];
			}

			stuffToUpdate[i] = node;
		}

		node = node.forward[0];

		if (key != node.key) {

			node = new SkipListNode<T>(key, height, newValue);

			int index = 0;

			while (index < height) {

				node.forward[index] = stuffToUpdate[index].forward[index];

				stuffToUpdate[index].forward[index] = node;

				index++;
			}

		}

		else {
			node.value = newValue;
		}
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void remove(int key) {
		SkipListNode[] array = new SkipListNode[this.maxHeight];

		SkipListNode<T> aux = this.root;

		for (int i = maxHeight - 1; i >= 0; i--) {
			if (aux.forward[i] != this.NIL) {
				while (aux.forward[i].value != null && aux.forward[i].key < key)
					aux = aux.forward[i];
			}
			array[i] = aux;
		}
		aux = aux.getForward()[0];

		if (aux.key == key) {

			for (int i = 0; i < maxHeight; i++) {
				if (array[i].getForward()[i] != aux) {
					break;
				}
				array[i].getForward()[i] = aux.getForward()[i];
			}
		}
	}

	@Override
	public int height() {
		SkipListNode<T>[] forward = root.getForward();
		int h = forward.length - 1;
		if (USE_MAX_HEIGHT_AS_HEIGHT) {
			h = maxHeight;
		} else {
			for (; h >= 0 && isRootOrNil(forward[h]); h--)
				;
			h += 1;
		}
		return h;
	}

	private boolean isRootOrNil(SkipListNode<T> aux) {
		return aux.getKey() == Integer.MAX_VALUE || aux.getKey() == Integer.MAX_VALUE;
	}

	@Override
	public SkipListNode<T> search(int key) {
		SkipListNode<T> aux = this.root;

		for (int i = maxHeight - 1; i >= 0; i--) {
			while (aux.getForward(i) != null && aux.getForward(i).getKey() < key) {
				aux = aux.getForward(i);
			}
		}

		SkipListNode<T> out = aux.getForward(0);

		if (out.getKey() != key) {
			out = null;
		}

		return out;
	}

	@Override
	public int size() {
		int size = 0;
		SkipListNode<T> aux = this.root.getForward(0);
		while (aux != NIL) {
			size++;
			aux = aux.getForward(0);
		}

		return size;
	}

	@SuppressWarnings("unchecked")
	@Override
	public SkipListNode<T>[] toArray() {
		SkipListNode<T>[] array = new SkipListNode[size() + 2];
		SkipListNode<T> aux = this.root;

		int index = 0;
		while (aux != null) {
			array[index++] = aux;
			aux = aux.getForward(0);
		}
		return array;
	}

}
