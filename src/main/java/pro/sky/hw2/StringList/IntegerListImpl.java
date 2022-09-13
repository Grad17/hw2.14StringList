package pro.sky.hw2.StringList;

import pro.sky.hw2.StringList.exception.ElementNotFoundException;
import pro.sky.hw2.StringList.exception.InvalidIndexException;
import pro.sky.hw2.StringList.exception.ItemNullException;
import pro.sky.hw2.StringList.exception.StringsIsFullException;

import java.util.Arrays;
import java.util.Objects;

public class IntegerListImpl implements IntegerList {

    private int size;
    private final Integer[] Integers;

    public IntegerListImpl(int arraySize) {
        Integers = new Integer[arraySize];
    }

    public IntegerListImpl() {
        Integers = new Integer[2];
    }

    private void validateItem(Integer item) {
        if (item == null){
            throw new ItemNullException();
        }
    }

    private void validateSize() {
        if (size == Integers.length) {
            throw new StringsIsFullException();
        }
    }

    private  void validateIndex(int index) {
        if (index < 0 || index > Integers.length) {
            throw new InvalidIndexException();
        }
    }

    public Integer add(Integer item) {
        validateSize();
        validateItem(item);
        Integers[size++] = item;

        return item;
    }

    public Integer add(int index, Integer item) {
        validateSize();
        validateItem(item);
        validateIndex(index);
        if (index == size) {
            Integers[size++] = item;
            return item;
        }
        System.arraycopy(Integers, index, Integers, index + 1, size - index);
        Integers[index] = item;
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
            System.arraycopy(Integers, index + 1, Integers, index, size - index);
        }
        size--;
        return item;
    }

    public Integer remove(int index) {
        validateIndex(index);
        Integer item = Integers[index];
        if (index==size) {
            System.arraycopy(Integers, index+1, Integers, index, size - index);
        }
        size--;
        return item;
    }

    public Integer set(int index, Integer item) {
        validateIndex(index);
        validateItem(item);
        Integers[index] = item;
        return item;
    }

    public boolean contains(Integer item) {
        if (Objects.isNull(item)) {
            throw new IllegalArgumentException("null");
        }

        Integer[] arrayForSearch = toArray();
        sortInsertion(arrayForSearch);

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
            Integer a = Integers[i];
            if (a.equals(item)) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(Integer item) {
        for (int i = size - 1; i >=0; i--) {
            Integer a = Integers[i];
            if(a.equals(item)) {
                return i;
            }
        }
        return -1;
    }

    public Integer get(int index) {
        validateIndex(index);
        return Integers[index];
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
        return Arrays.copyOf(Integers,size);
    }

    private void sortInsertion(Integer[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }
}
