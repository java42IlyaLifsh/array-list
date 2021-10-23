package telran.util;
//HW_5 Ilya_L after corrections 23.10.21   
 
import java.util.Arrays;

public class ArrayList<T> implements List<T> {
	private static final int DEFAULT_CAPACITY = 16;
	private T[] array;
	private int size = 0; 
	@SuppressWarnings("unchecked")
	public ArrayList(int capacity) {
		array = (T[]) new Object[capacity];
	}
	public ArrayList() {
		this(DEFAULT_CAPACITY);
	}
	@Override
	public void add(T element) {
		if (size == array.length) {
			//size is capacity
			allocate();
		}
		array[size++] = element;
		
		
	}

	private void allocate() {
		array = Arrays.copyOf(array, array.length * 2);
		
	}
	@Override
	public boolean add(int index, T element) {
		if (index>size || index<0) {
		return false;
	}
		if (size ==array.length) {
			allocate();
		}
		System.arraycopy(array, index, array, index+1, size-index);
		size=size+1;
		array[index]=element;
		return true;
		}
	

	@Override
	public int size() {
		
		return size;
	}

	@Override
	public T get(int index) {
		
		return isValidIndex(index) ? array[index] : null;
	}

	private boolean isValidIndex(int index) {
		
		return index >= 0 && index < size;
	}
	@Override
	public T remove(int index) {
		if (!isValidIndex(index)) {
			return null;
		}
		T resValue = array[index];
		System.arraycopy(array, index+1, array, index, size-index-1);
		size = size-1;
		return resValue;
	}

}
