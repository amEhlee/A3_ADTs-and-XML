package utilities;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import adts.Iterator;
import adts.ListADT;

public class MyArrayList<E> implements ListADT<E> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -380906261708501589L;
	private E[] arr;

	@SuppressWarnings("unchecked")
	public MyArrayList() {
		arr = (E[]) new Object[0];
	}
	
	@Override
	public int size() {
		return arr.length;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void clear() {
		int size = arr.length;
		arr = (E[]) new Object[size];
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
		try {
			if (toAdd == null) {
				throw new NullPointerException();
			}
			
			int size = arr.length;
			if (index > size + 1 || index < 0) {
				throw new IndexOutOfBoundsException();
			}
			
			Object[] newArr = new Object[size + 1];
			if (index == size + 1) {
				add(toAdd);
			}
			else {
				for (int i = 0,j = 0; i - j < arr.length; i++) {
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

	@Override
	public boolean add(E toAdd) throws NullPointerException, IndexOutOfBoundsException {
		try {
			if (toAdd == null) {
				throw new NullPointerException();
			}
			
			int size = arr.length;
			
			
			Object[] newArr = new Object[size + 1];
			for (int i = 0; i  < arr.length; i++) {	
					newArr[i] = arr[i];
				
			}
			newArr[newArr.length - 1] = toAdd;
			arr = (E[]) newArr;
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
			int size = arr.length;
			if (index > size + 1 || index < 0) {
				throw new IndexOutOfBoundsException();
			}
			
			for (int i = 0; i  < arr.length; i++) {	
				if (i == index) {
					return arr[i];
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

			int size = arr.length;
			
			if (index > size + 1 || index < 0) {
				throw new IndexOutOfBoundsException();
			}
			
			Object[] newArr = new Object[size];
			if (index == size - 1) {
				for (int i = 0; i < arr.length - 1; i++) {
					newArr[i] = arr[i];
				}
			}
			else {
				for (int i = 0; i < arr.length; i++) {
					if (i == index) {
						newArr[i] = arr[i + 1];
						temp = arr[i];
						i++;
					}
					else {
						newArr[i] = arr[i]; 
					}
				}
			}
			arr = (E[]) newArr;
			
			

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

			int size = arr.length;
			
			Object[] newArr = new Object[size];
				for (int i = 0; i < arr.length; i++) {
					if (toRemove == arr[i]) {
						newArr[i] = arr[i + 1];
						temp = arr[i];
						i++;
					}
					else {
						newArr[i] = arr[i]; 
					}
				}
			arr = (E[]) newArr;
			
			

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
			
			int size = arr.length;
			
			Object[] newArr = new Object[size];
				for (int i = 0; i < arr.length; i++) {
					if (i == index) {
						newArr[i] = toChange;
						temp = arr[i];
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
		if (arr.length == 0) {
			return true;
		}
		else {
			return false;
		}
	}

	@SuppressWarnings("unchecked")
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
			
		} catch(NullPointerException ex) {
			ex.printStackTrace();
		}
		return contains;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E[] toArray(E[] toHold) throws NullPointerException {
		int size = toHold.length;
		if (size < arr.length) {
			size = arr.length;
		}
		E[] newArr = (E[]) new Object[size];
		try {
			if (size == 0) {
				throw new NullPointerException();
			}
			
		    for (int i = 0; i < toHold.length; i++) {
		    	newArr[i] = arr[i];
		    }
		} catch(NullPointerException ex) {
			ex.printStackTrace();
		}

		return newArr;
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
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
