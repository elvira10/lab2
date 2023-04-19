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
        return size;
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
        remove(indexOf(item));
        return true;
    }

    @Override
    public Object remove(int index) {
        Object temporary = get(index);
        for (int i = index + 1; i < size; i++) {
            arr[i - 1] = arr[i];
        }
        size--;
        return temporary;
    }

    @Override
    public void clear() {
        this.arr = new Object[arr.length];
        this.size = 0;
    }

    @Override
    public Object get(int index) {
        checkIndex(index);
        return arr[index];
    }
    private void checkIndex(int index){
        if (index<0 || index>=size){
            throw new IndexOutOfBoundsException();
        }
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
