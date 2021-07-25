package utilities;

import adts.Iterator;
import adts.QueueADT;
import exceptions.EmptyQueueException;

public class MyQueue<E> implements QueueADT<E> {
	
	@SuppressWarnings("unchecked")
	E[] arr = (E[]) new Object[0];

	public void enqueue(E toAdd) throws NullPointerException {
		try {
			if (toAdd == null) {
				throw new NullPointerException();
			}
			
			
		} catch (NullPointerException ex) {
			ex.printStackTrace();
		}
		
	}

	@Override
	public E dequeue() throws EmptyQueueException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E peek() throws EmptyQueueException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void dequeueAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean equals(QueueADT<E> that) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E[] toArray(E[] holder) throws NullPointerException {
		try {
			if (holder == null) {
				throw new NullPointerException();
			}
			
		} catch (NullPointerException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

}
