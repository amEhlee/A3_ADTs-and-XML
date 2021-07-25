package utilities;

import java.util.EmptyStackException;

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
			
			E[] temp = (E[]) new Object[arr.length + 1];
			temp[temp.length - 1] = toAdd;
			arr = temp;
		} catch (NullPointerException ex) {
			ex.printStackTrace();
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public E dequeue() throws EmptyQueueException {
		E dequeued = null;
		try {
			if (arr.length <= 0) {
				throw new EmptyQueueException();
			}

			E[] temp = (E[]) new Object[arr.length - 1];
			for (int i = 1; i < temp.length; i++) {
				temp[i] = arr[i];
			}
			dequeued = arr[0];
			arr = temp;
		} catch (EmptyQueueException ex) {
			ex.printStackTrace();
		}
		return dequeued;
	}

	@Override
	public E peek() throws EmptyQueueException {
		E value = null;
		try {
			if (arr.length <= 0) {
				throw new EmptyStackException();
			}

			value = arr[0];

		} catch (EmptyStackException ex) {
			ex.printStackTrace();
		}
		return value;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void dequeueAll() {
		E[] temp = (E[]) new Object[1];
		arr = temp;
	}

	@Override
	public boolean isEmpty() {
		if (arr.length == 0) {
			return true;
		}
		return false;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(QueueADT<E> that) {
		boolean exact = false;
		E[] temp = (E[]) that.toArray();
		if (that.size() == arr.length) {
			for (int i = 0; i < arr.length; i++) {
				if (temp[i] == arr[i]) {
					exact = true;
				}
				else {
					exact = false;
					break;
				}
			}
		}
		
		return exact;
	}

	@Override
	public Object[] toArray() {
		int size = arr.length;
		Object[] newArr = new Object[size];		
		for (int i = 0; i < arr.length; i++) {
		    newArr[i] = arr[i];
		}

		return newArr;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E[] toArray(E[] holder) throws NullPointerException {
		int size = holder.length;
		
		if (size < arr.length) {
			size = arr.length;
		}
		
		E[] newArr = (E[]) new Object[size];
		try {
			if (size == 0) {
				throw new NullPointerException();
			}
			
		    for (int i = 0; i < holder.length; i++) {
		    	newArr[i] = arr[i];
		    }
		} catch(NullPointerException ex) {
			ex.printStackTrace();
		}

		return newArr;
	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		return arr.length;
	}

}
