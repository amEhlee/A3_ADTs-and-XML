package utilities;

import java.lang.reflect.Array;
import java.util.EmptyStackException;

import adts.Iterator;
import adts.QueueADT;
import exceptions.EmptyQueueException;

public class MyQueue<E> implements QueueADT<E> {
	
	@SuppressWarnings("unchecked")
    private E[] arr;
    private int size;
    private final int MAXIMUM_SIZE;


    public MyQueue() {
        size = 0;
        arr = (E[]) new Object[size];
        MAXIMUM_SIZE = 0;
    }

    public MyQueue(int MAXIMUM_SIZE) {
        this.MAXIMUM_SIZE = MAXIMUM_SIZE;
    }

    public void enqueue(E toAdd) throws NullPointerException {
        if (toAdd == null) {
            throw new NullPointerException();
        }

        if (!isFull()) {
            Object[] newArr = new Object[size + 1];
            for (int i = 0; i < size; i++) {
                newArr[i] = arr[i];
            }
            newArr[size] = toAdd;
            arr = (E[]) newArr;
            size++;
        }
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
        if (size == 0) {
			return true;
		}
		return false;
	}

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int index = 0; //Current Index pointer
        	
            @Override
            public boolean hasNext() {
                return (index < size && arr[index] != null); //checks if the next is not null or the the index is less than the maximum index and returns true or false
            }

            @Override
            public E next() { //iterates iterator
                try {
                    return arr[index++]; //Moves the pointer one index forward
                } catch (Exception ex){ //catches errors when there is no index past the iteration
                    return null;
                }
            }
        };
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
        Object[] newArr = new Object[size];
        for (int i = 0; i < size; i++) {
            newArr[i] = arr[i];
        }

        return newArr;
    }

    @SuppressWarnings("unchecked")
    @Override
    public E[] toArray(E[] holder) throws NullPointerException {
        int holdSize = holder.length;
        if (holdSize < size) {
            holder = (E[]) Array.newInstance(holder.getClass().getComponentType(), size);
        }
        if (holdSize > size) {
            holder[size] = null;
        }

        try {
            if (size == 0) {
                throw new NullPointerException();
            }

            for (int i = 0; i < size; i++) {
                holder[i] = (E) arr[i];
            }
        } catch(NullPointerException ex) {
            ex.printStackTrace();
        }

        return holder;
    }

	@Override
    public boolean isFull() {
        if (MAXIMUM_SIZE == 0) { // unlimited queue
            return false;
        }
        
        if (size >= MAXIMUM_SIZE) {
            return true;
        } else {
            return false;
        }
    }

	@Override
	public int size() {
		return arr.length;
	}

}
