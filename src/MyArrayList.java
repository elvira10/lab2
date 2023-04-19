import java.util.Arrays;

public class MyArrayList implements MyList{
    private Object[] arr;
    private int size;
    MyArrayList(){
        this.arr = (Object[]) new Object[10];
        this.size = 0;
    }
    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public void add(Object item) {
        if (size==arr.length){
            increaseBuffer();
        }
        size++;
        arr[size]=item;
    }
    private void increaseBuffer(){
        Object[] newArr = new Object[arr.length*2];
        for(int i=0; i< arr.length; i++){
            newArr[i]=arr[i];
        }
        arr = newArr;
    }

    @Override
    public void add(Object item, int index) {
        if (size() == arr.length)
            increaseBuffer();
        if (index > size)
            throw new IndexOutOfBoundsException();
        for (int i = size; i > index; i--){
            arr[i] = arr[i - 1];
        }
        arr[index] = item;
        size++;
    }

    @Override
    public boolean remove(Object item) {
        return false;
    }

    @Override
    public Object remove(int index) {
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public Object get(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public void sort() {

    }
}
