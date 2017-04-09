package adt.btree;

public class BTreeImpl<T extends Comparable<T>> implements BTree<T> {

	protected BNode<T> root;
	protected int order;

	public BTreeImpl(int order) {
		this.order = order;
		this.root = new BNode<T>(order);
	}

	@Override
	public BNode<T> getRoot() {
		return this.root;
	}

	@Override
	public boolean isEmpty() {
		return this.root.isEmpty();
	}

	@Override
	public int height() {
		return height(this.root);
	}

	private int height(BNode<T> node) {
		if(node.isLeaf())
			return 0;
		return 1 + this.height(node.getChildren().getFirst());
	}

	@Override
	public BNode<T>[] depthLeftOrder() {
		BNode<T>[] array = new BNode[this.countNodes(this.root)];
		this.depthLeftOrder(array, 0, this.root);
		
		return array;
	}
	
	private int depthLeftOrder(BNode<T>[] array, int index, BNode<T> node) {
		if(!node.isEmpty()) {
			array[index] = node;
			index++;
			
			for(int i = 0; i < node.getChildren().size(); i++) {
				index = this.depthLeftOrder(array, index, node.getChildren().get(i));
			}
		}
		return index;
	}
	

	private int countNodes(BNode<T> node) {
		if(node.isEmpty())
			return 0;
		int nodes = 1;
		for(int i = 0; i < node.getChildren().size(); i++) {
			nodes += this.countNodes(node.getChildren().get(i));
		}
		return nodes;
	}

	@Override
	public int size() {
		return this.size(this.root);
	}
	
	private int size(BNode<T> node) {
		if(node.isEmpty())
			return 0;
		int size = node.size();
		
		for(int i = 0; i < node.getChildren().size(); i++) {
			size += this.size(node.getChildren().get(i));
		}
		return size;
	}

	@Override
	public BNodePosition<T> search(T element) {
		if (element == null)
			return new BNodePosition<T>();
		return search(this.root, element);
	}

	private BNodePosition<T> search(BNode<T> node, T element) {
		int index = 0;
		
		while (index < node.getElements().size() && element.compareTo(node.getElementAt(index)) > 0) {
			index++;
		}
		
		if (index < node.getElements().size() && element.compareTo(node.getElementAt(index)) == 0) {
			return new BNodePosition<T>(node, index);
		}
		if (node.isLeaf()) {
			return new BNodePosition<T>();
		}
		BNodePosition<T> nodeFound = this.search(node.getChildren().get(index), element);
		
		return nodeFound;
	}

	@Override
	public void insert(T element) {
		if (element == null)
			return;
		this.insert(this.root, element);
	}

	private void insert(BNode<T> node, T element) {
		int index = 0;
		
		while(index < node.getElements().size() && element.compareTo(node.getElementAt(index)) > 0) {
			index++;
		}
		
		if(node.isLeaf()) {
			node.addElement(element);
			node.addChild(index, new BNode<T>(this.order));
			
			if (node.getMaxKeys() < node.size()) {
				node.split();
				while(node.parent != null) {
					node = node.parent;
				}
				this.root = node;
			}
			return;
		}
		this.insert(node.getChildren().get(index), element);
	}

	private void split(BNode<T> node) {
		node.split();
	}

	private void promote(BNode<T> node) {
		node.promote();
	}

	// NAO PRECISA IMPLEMENTAR OS METODOS ABAIXO
	@Override
	public BNode<T> maximum(BNode<T> node) {
		// NAO PRECISA IMPLEMENTAR
		throw new UnsupportedOperationException("Not Implemented yet!");
	}

	@Override
	public BNode<T> minimum(BNode<T> node) {
		// NAO PRECISA IMPLEMENTAR
		throw new UnsupportedOperationException("Not Implemented yet!");
	}

	@Override
	public void remove(T element) {
		// NAO PRECISA IMPLEMENTAR
		throw new UnsupportedOperationException("Not Implemented yet!");
	}

}
