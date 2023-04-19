import java.util.Arrays;

public class MyArrayList implements MyList{
    private Object[] arr; //for storing elements
    private int size; //variable to store size of an array

    MyArrayList(){
        this.arr = (Object[]) new Object[10]; // initializing the array
        this.size = 0; //set size to zero
    }

    /**
     * returns the size of an array
     * @return the size
     */
    @Override
    public int size() {
        return size; //return the size
    }

    /**
     * returns true if the elements is in the array
     * @param o the element that is going to be checked
     * @return true if it is in array, if not false
     */
    @Override
    public boolean contains(Object o) { //checking if the object contains the element
        for (int i=0; i<size; i++){
            if (arr[i].equals(o)){
                return true;
            }
        }
        return false; //return false if it does not contain
    }

    /**
     * adds the element to the end of the array
     * @param item the element that is going to be added
     */
    @Override
    public void add(Object item) {
        if (size==arr.length){
            increaseBuffer(); //checking if the array is full, if true invoke increaseBuffer
        }
        size++;
        arr[size]=item; //adding the element to the end of the array
    }

    private void increaseBuffer(){
        Object[] newArr = new Object[arr.length*2]; //new array with doubled size
        for(int i=0; i< arr.length; i++){ //copying the existing elements to the new array
            newArr[i]=arr[i];
        }
        arr = newArr; //setting the new array
    }

    /**
     * adds the element at the specified index
     * @param item the element that is going to be added
     * @param index position of the element where it is going to be added
     */
    @Override
    public void add(Object item, int index) {
        if (size() == arr.length)
            increaseBuffer(); //checking if the array is full, if true invoke increaseBuffer
        if (index > size)
            throw new IndexOutOfBoundsException(); //check if the index is in bounds
        for (int i = size; i > index; i--){
            arr[i] = arr[i - 1]; //moving the elements to make space for new ones
        }
        arr[index] = item; //inserting element at the given index
        size++; //increasing the size
    }

    /**
     * removes the first occurrence of the element from array
     * @param item the element that is going to be removed
     * @return true if it was removed, false otherwise
     */
    @Override
    public boolean remove(Object item) {
        remove(indexOf(item));
        return true;
    }

    /**
     * removes the element at the specified index
     * @param index the element that is going to be removed
     * @return the removed element
     */
    @Override
    public Object remove(int index) {
        checkIndex(index); //checking the index
        Object temporary = get(index); //finding the element and removing it
        for (int i = index + 1; i < size; i++) {
            arr[i - 1] = arr[i]; //moving the elements after removing
        }
        size--; //size decreasing
        return temporary; //returning the removed element
    }

    @Override
    public void clear() {
        this.arr = new Object[arr.length]; //creating new array with the same length
        this.size = 0; //size is zero
    }

    /**
     * get the element at the specified index
     * @param index the element that is going to be retrieved
     * @return the element
     */
    @Override
    public Object get(int index) {
        checkIndex(index); //checking the index
        return arr[index]; //returning the element
    }

    /**
     * check if the index is valid
     * @param index index that is going to be checked
     * @throws IndexOutOfBoundsException if index is out of bounds
     */
    private void checkIndex(int index){
        if (index<0 || index>=size){
            throw new IndexOutOfBoundsException(); //throw exception if the index is out of bounds
        }
    }

    /**
     * get the index of the first occurrence of the object
     * @param o object that is going to be checked
     * @return the index if it was found, if not return -1
     */
    @Override
    public int indexOf(Object o) {
            for (int i = 0; i < size; i++) {
                if (arr[i].equals(o)) //comparing each element with the object
                    return i; //if found return the index
            }
            return -1; //if not return -1
    }

    /**
     * get the index of the last occurrence of the object
     * @param o object that is going to be checked
     * @return the index of found, if not return -1
     */
    @Override
    public int lastIndexOf(Object o) {
        int index = -1; //index initializing
        for (int i=0; i<size; i++){
            if (arr[i].equals(o)){ //comparing each element with the object
                return i; //if found return index
            }
        }
        return -1; //if not found return -1
    }

    /**
     * sort the element in the array
     */
    @Override
    public void sort() {
        Arrays.sort(arr); //sort the array
    }
}