package utilities;

import adts.Iterator;
import adts.ListADT;

public class MyDLL<E> implements ListADT<E> {

	private Node head;
	private Node tail;

	@Override
	public int size() {
		int count = 0;
		if(head == null) {
			return count;
		} else {
			count ++;
			Node temp = head;

			// continue until we reach tail / end 
			while(temp.getNext() != tail) {
				count ++;
				temp = temp.getNext();
			}
		}

		return count;
	}

	@Override
	public void clear() {
		Node temp = new Node();

		// iterate through and delete from head 
		while(head != null) {
			temp = head;
			head = head.getNext();
			temp = null;
		}
	}

	@Override
	public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
		Node newNode = new Node(toAdd);
		Node tempPrev = null;

		if(index == size() - 1) {
			return add(toAdd);
		} else {
			Node current = head;
			for (int i = 0; i < index; i++) {
				tempPrev = current;
				current = current.getNext();
			}

			newNode.setNext(current.getNext());
			newNode.setPrevious(tempPrev);
			current.setNext(newNode);

			return true;
		}

	}

	@Override
	public boolean add(E toAdd) throws NullPointerException, IndexOutOfBoundsException {
		Node newNode = new Node(toAdd);
		if(!isEmpty()) {
			Node temp = head;

			// iterate to the tail 
			while(temp.getNext() != tail) {
				temp = temp.getNext();
			}

			// after reaching end 
			temp.setNext(newNode);
			tail = newNode.getNext();
			return true;
		}
		else {
			head = newNode;
			tail = head.getNext();
			return true;
		}

	}

	@Override
	public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {
		// TODO Auto-generated method stub
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E get(int index) throws IndexOutOfBoundsException {
		if(!isEmpty()) {
			Node current = head;

			if(index > size() - 1) {
				throw new IndexOutOfBoundsException();
			} else {
				for (int i = 0; i < index; i++) {
					current = current.getNext();
				}
			}

			return (E) current.getData();
		}
		else {
			return null;
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public E remove(int index) throws IndexOutOfBoundsException {

		E removed = null;

		if(index >= size() || index < 0)
			throw new IndexOutOfBoundsException();

		if(index == 0) {
			removed = (E) head.getData();
			head = head.getNext();
		}
		else {
			Node current = head;
			Node tempPrev = null;
			// navigate to node
			for (int i = 0; i < index; i++) {
				tempPrev = current;
				current = current.getNext();

			}

			// unlink node
			removed = (E) current.getData();
			tempPrev.setNext(current.getNext());
			current.getNext().setPrevious(tempPrev);
		}

		return removed;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E remove(E toRemove) throws NullPointerException {
		Node current = head;
		Node tempPrev = current;
		E removed = null;

		// if node is head 
		if(head.getData() == toRemove) {
			removed = (E) head.getData();
			head = head.getNext();
		}

		// if target is tail 
		if(get(size() - 1) == toRemove) {
			removed = (E) tail.getData();
			tail = tail.getPrevious();
		}

		for (int i = 0; i < size(); i++) {
			if (current.getData() == toRemove) {
				removed = (E) current.getData();
				current.getNext().setPrevious(tempPrev);
				tempPrev.setNext(current.getNext());
			}
			else {
				tempPrev = current;
				current = current.getNext();
			}
		}

		return removed;
	}

	@Override
	public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		return (size() == 0);
	}

	@Override
	public boolean contains(E toFind) throws NullPointerException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E[] toArray(E[] toHold) throws NullPointerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}