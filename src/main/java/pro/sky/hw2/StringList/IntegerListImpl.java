package pro.sky.hw2.StringList;

import pro.sky.hw2.StringList.exception.ElementNotFoundException;
import pro.sky.hw2.StringList.exception.InvalidIndexException;
import pro.sky.hw2.StringList.exception.ItemNullException;

import java.util.Arrays;
import java.util.Objects;

public class IntegerListImpl implements IntegerList {

    private Integer[] storage;
    private int size;

    public IntegerListImpl() {
        storage = new Integer[10];
    }

    public IntegerListImpl(int initSize) {
        storage = new Integer[initSize];
    }

    private void validateItem(Integer item) {
        if (item == null){
            throw new ItemNullException();
        }
    }

    private void growIfNeeded() {
        if (size == storage.length) {
            grow();
        }
    }

    private  void validateIndex(int index) {
        if (index < 0 || index > storage.length) {
            throw new InvalidIndexException();
        }
    }

    public Integer add(Integer item) {
        growIfNeeded();
        validateItem(item);
        storage[size++] = item;

        return item;
    }

    public Integer add(int index, Integer item) {
        growIfNeeded();
        validateItem(item);
        validateIndex(index);
        if (index == size) {
            storage[size++] = item;
            return item;
        }
        System.arraycopy(storage, index, storage, index + 1, size - index);
        storage[index] = item;
        size++;
        return item;
    }

    public Integer remove(Integer item) {
        validateItem(item);
        int index = indexOf(item);
        if (index == -1) {
            throw  new ElementNotFoundException();
        }
        if (index == size) {
            System.arraycopy(storage, index + 1, storage, index, size - index);
        }
        size--;
        return item;
    }

    public Integer remove(int index) {
        validateIndex(index);
        Integer item = storage[index];
        if (index==size) {
            System.arraycopy(storage, index+1, storage, index, size - index);
        }
        size--;
        return item;
    }

    public Integer set(int index, Integer item) {
        validateIndex(index);
        validateItem(item);
        storage[index] = item;
        return item;
    }

    public boolean contains(Integer item) {
        if (Objects.isNull(item)) {
            throw new IllegalArgumentException("null");
        }

        Integer[] arrayForSearch = toArray();
        sort(arrayForSearch);

        int min = 0;
        int max = arrayForSearch.length -1;
        while (min <= max) {
            int mid = (min + max) / 2;
            if ((item.equals(arrayForSearch[mid]))) {
                return true;
            }
            if (item < arrayForSearch[mid]) {
                max = mid - 1;
            } else  {
                min = mid + 1;
            }
        }
        return false;
    }

    public int indexOf(Integer item) {
        for (int i = 0; i < size; i++) {
            Integer a = storage[i];
            if (a.equals(item)) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(Integer item) {
        for (int i = size - 1; i >=0; i--) {
            Integer a = storage[i];
            if(a.equals(item)) {
                return i;
            }
        }
        return -1;
    }

    public Integer get(int index) {
        validateIndex(index);
        return storage[index];
    }

    public boolean equals(IntegerList otherList) {
        return Arrays.equals(this.toArray(), otherList.toArray());
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        size = 0;
    }

    public Integer[] toArray() {
        return Arrays.copyOf(storage,size);
    }

    private void sort(Integer[] arr) {
        quickSort(arr, 0, arr.length -1);
    }

    private static int partition(Integer[] arr, int begin, int end) {
        int pivot = arr[end];
        int indexA = (begin - 1);

        for (int indexB = begin; indexB < end; indexB++) {
            if (arr[indexB] <= pivot) {
                indexA++;

                swapElements(arr, indexA, indexB);
            }
        }

        swapElements(arr, indexA + 1, end);
        return indexA + 1;
    }

    private static void swapElements(Integer[] arr, int indexA, int indexB) {
        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }

    public static void quickSort(Integer[] arr, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, end);
        }
    }

    private void grow() {
        storage = Arrays.copyOf(storage, size + size / 2);
    }
}
