package utilities;

import java.util.EmptyStackException;

import adts.Iterator;
import adts.QueueADT;
import exceptions.EmptyQueueException;

public class MyQueue<E> implements QueueADT<E> {
	
	@SuppressWarnings("unchecked")
    private E[] arr;
    private int size;

    public MyQueue() {
        size = 0;
        arr = (E[]) new Object[size];
    }

    public void enqueue(E toAdd) throws NullPointerException {
        if (toAdd == null) {
            throw new NullPointerException();
        }

        Object[] newArr = new Object[size + 1];
        for (int i = 0; i < size; i++) {
            newArr[i] = arr[i];
        }
        newArr[size] = toAdd;
        arr = (E[]) newArr;
        size++;
    }


	@SuppressWarnings("unchecked")
	@Override
	public E dequeue() throws EmptyQueueException {
        E dequeued;
        if (size <= 0) {
            throw new EmptyQueueException();
        }

        dequeued = arr[0];

		Object[] newArr = new Object[size - 1];
		for (int i = 1; i < size; i++) {
			newArr[i - 1] = arr[i];
		}
		arr = (E[]) newArr;
		size--;
		return dequeued;
	}

	@Override
	public E peek() throws EmptyQueueException {
        if (size <= 0) {
            throw new EmptyStackException();
        }

        return arr[0];
	}

	@SuppressWarnings("unchecked")
	@Override
	public void dequeueAll() {
        arr = (E[]) new Object[0];
        size = 0;
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
