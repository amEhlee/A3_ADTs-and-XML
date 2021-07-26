package utilities;

import java.lang.reflect.Array;
import java.util.NoSuchElementException;

import adts.Iterator;
import adts.ListADT;

public class MyArrayList<E> implements ListADT<E> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -380906261708501589L;
	private E[] arr;
	private int size;
	
	@SuppressWarnings("unchecked")
	public MyArrayList() {
		size = 0;
		arr = (E[]) new Object[size];
	}
	
	@Override
	public int size() {
		return arr.length;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void clear() {
		size = 0;
		arr = (E[]) new Object[0];
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
		try {
			if (toAdd == null) {
				throw new NullPointerException();
			}
			
			if (index > size + 1 || index < 0) {
				throw new IndexOutOfBoundsException();
			}
			
			Object[] newArr = new Object[size + 1];
			if (index == size + 1) {
				add(toAdd);
			}
			else {
				for (int i = 0,j = 0; i - j < size; i++) {
					if (i == index) {
						newArr[i] = toAdd;
						j++;
					}
					else {
						newArr[i] = arr[i - j];
					}
				}
			}
			arr = (E[]) newArr;
			size = arr.length;
			return true;
		} catch(NullPointerException ex) {
			ex.printStackTrace();
			return false;
		}
		catch(IndexOutOfBoundsException ex) {
			ex.printStackTrace();
			return false;
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean add(E toAdd) throws NullPointerException, IndexOutOfBoundsException {
		try {
			if (toAdd == null) {
				throw new NullPointerException();
			}
			
						
			Object[] newArr = new Object[size + 1];
			for (int i = 0; i  < size; i++) {	
					newArr[i] = arr[i];
				
			}
			newArr[newArr.length - 1] = toAdd;
			arr = (E[]) newArr;
			size = arr.length;
			return true;
		} catch(NullPointerException ex) {
			ex.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {
		try {
			if (toAdd == null) {
				throw new NullPointerException();
			}
			
			Object[] arr = toAdd.toArray();
			
			//TODO
			

			return true;
		} catch(NullPointerException ex) {
			ex.printStackTrace();
			return false;
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public E get(int index) throws IndexOutOfBoundsException {
		try {
			if (index > size + 1 || index < 0) {
				throw new IndexOutOfBoundsException();
			}
			
			for (int i = 0; i  < size; i++) {	
				if (i == index) {
					return (E) arr[i];
				}
			
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		
		}
		
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E remove(int index) throws IndexOutOfBoundsException {
		E temp = null;
		try {

			
			if (index > size + 1 || index < 0) {
				throw new IndexOutOfBoundsException();
			}
			
			Object[] newArr = new Object[size - 1];
			if (index == size - 1) {
				for (int i = 0; i < size - 1; i++) {
					newArr[i] = arr[i];
				}
			}
			else {
				for (int i = 0; i < size; i++) {
					if (i == index) {
						newArr[i] = arr[i + 1];
						temp = (E) arr[i];
						i++;
					}
					else {
						newArr[i] = arr[i]; 
					}
				}
			}
			arr = (E[]) newArr;
			size = arr.length;
			
			

		} catch(IndexOutOfBoundsException ex) {
			ex.printStackTrace();
		}
		return temp;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E remove(E toRemove) throws NullPointerException {
		E temp = null;
		try {

			
			Object[] newArr = new Object[size - 1];
				for (int i = 0; i < size; i++) {
					if (toRemove == arr[i]) {
						if (i == size - 1) {
							temp = (E) arr[i];
						}
						else {
							newArr[i] = arr[i + 1];
							temp = (E) arr[i];
							i++;
						}
					}
					else {
						newArr[i] = arr[i]; 
					}
				}
			arr = (E[]) newArr;
			size = arr.length;
			
			

		} catch(IndexOutOfBoundsException ex) {
			ex.printStackTrace();
		}
		return temp;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public E set(int index, E toChange) throws NullPointerException {
		E temp = null;
		try {
			
			
			Object[] newArr = new Object[size];
				for (int i = 0; i < size; i++) {
					if (i == index) {
						newArr[i] = toChange;
						temp = (E) arr[i];
						i++;
					}
					else {
						newArr[i] = arr[i]; 
					}
				 }
			arr = (E[]) newArr;
			
			
		} catch(NullPointerException ex) {
			ex.printStackTrace();
		}
		return temp;
	}

	@Override
	public boolean isEmpty() {
		if (size == 0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean contains(E toFind) throws NullPointerException {
		boolean contains = false;
		try {
			if (toFind == null) {
				throw new NullPointerException();
			}
			
				for (int i = 0; i < size; i++) {
					if (toFind == arr[i]) {
						contains = true;
					}
				 }
			
		} catch(NullPointerException ex) {
			ex.printStackTrace();
		}
		return contains;
	}


	@SuppressWarnings("unchecked")
	@Override
	public E[] toArray(E[] toHold) throws NullPointerException {
		int holdSize = toHold.length;	
		if (holdSize < size) {
			toHold = (E[]) Array.newInstance(toHold.getClass().getComponentType(), size);
		}
		if (holdSize > size) {
			toHold[size] = null;
		}
		
		try {
			if (size == 0) {
				throw new NullPointerException();
			}
			
		    for (int i = 0; i < size; i++) {
		    	toHold[i] = (E) arr[i];
		    }
		} catch(NullPointerException ex) {
			ex.printStackTrace();
		}

		return toHold;
	}


	@Override
	public Object[] toArray() {
		int size = arr.length;
		Object[] newArr = new Object[size];		
		for (int i = 0; i < size; i++) {
			newArr[i] = arr[i];
		}

		return newArr;
	}

	@Override
	public Iterator<E> iterator() {
		return new Iterator<E>() {

			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public E next() throws NoSuchElementException {
				// TODO Auto-generated method stub
				return null;
			}
		};
	}

}
