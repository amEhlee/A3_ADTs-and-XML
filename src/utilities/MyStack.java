package utilities;

import java.util.EmptyStackException;

import adts.Iterator;
import adts.StackADT;

public class MyStack<E> implements StackADT<E> {

	@SuppressWarnings("unchecked")
	E[] arr = (E[]) new Object[0];

	@SuppressWarnings("unchecked")
	@Override
	public void push(E toAdd) throws NullPointerException {
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
	public E pop() throws EmptyStackException {
		E popped = null;
		try {
			if (arr.length <= 0) {
				throw new EmptyStackException();
			}

			E[] temp = (E[]) new Object[arr.length - 1];
			for (int i = 0; i < temp.length; i++) {
				temp[i] = arr[i];
			}
			popped = arr[arr.length - 1];
			arr = temp;
		} catch (EmptyStackException ex) {
			ex.printStackTrace();
		}
		return popped;
	}

	@Override
	public E peek() throws EmptyStackException {
		E value = null;
		try {
			if (arr.length <= 0) {
				throw new EmptyStackException();
			}

			value = arr[arr.length - 1];

		} catch (EmptyStackException ex) {
			ex.printStackTrace();
		}
		return value;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void clear() {
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
	public Object[] toArray() {
		int size = arr.length;
		Object[] newArr = new Object[size];		
		for (int i = 0; i < arr.length; i++) {
		    newArr[i] = arr[i];
		}

		return newArr;
	}

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
	public boolean contains(E toFind) throws NullPointerException {
		boolean contains = false;
		try {
			if (toFind == null) {
				throw new NullPointerException();
			}
			for (int i = 0; i < arr.length; i++) {
				if (toFind == arr[i]) {
					contains = true;
				}
			}

		} catch (NullPointerException ex) {
			ex.printStackTrace();
		}
		return contains;
	}

	@Override
	public int search(E toFind) {
		int distance = 1;
		try {
			if (toFind == null) {
				throw new NullPointerException();
			}
			for (int i = 0; i < arr.length; i++) {
				if (toFind == arr[i]) {
					distance = i + 1;
				}
			}

		} catch (NullPointerException ex) {
			ex.printStackTrace();
		}
		return distance;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(StackADT<E> that) {
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
	public int size() {
		return arr.length;
	}

}
