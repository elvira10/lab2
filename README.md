# Assignment 2
# Description
Creattion of classes MyArrayList and MyLinkedList which are implementations of ArrayList and LinkedList respectively, not using java.util.ArrayList and java.util.LinkedList.
# MyArrayList
This is a generic class that implements MyList interface. Methods:
<br />
<br />add(Object item) - adds the specified element at the end of the array
<br />
<br />add(Object item, int index) - adds the specified element at the specified index in the array
<br />
<br />get(int index) - returns the element at the specified index in the array
<br />
<br />checkIndex(int index) - checks if the specified index is valid
<br />
<br />increaseBuffer() - doubles the size of an array
<br />
<br />remove(int index) - removes the element at the specified index from the array
<br />
<br />remove(T item) - removes the first occurrence of the specified item from the array
<br />
<br />size() - returns the size of an array
<br />
<br />contains(Object o) - checks if the array contains the specified object
<br />
<br />clear() - clears the array
<br />
<br />indexOf(Object o) - returns the index of the first occurrence of the specified object in the array
<br />
<br />lastIndexOf(Object o) - returns the index of the last occurrence of the specified object in the array
<br />
<br />sort() - sorts the elements in the array in ascending order
# Solution

    MyArrayList() {
        this.arr = (Object[]) new Object[10]; // initializing the array
        this.size = 0; //set size to zero
    }

    /**
     * returns the size of an array
     *
     * @return the size
     */
    @Override
    public int size() {
        return size; //return the size
    }

    /**
     * returns true if the elements is in the array
     *
     * @param o the element that is going to be checked
     * @return true if it is in array, if not false
     */
    @Override
    public boolean contains(Object o) { //checking if the object contains the element
        for (int i = 0; i < size; i++) {
            if (arr[i].equals(o)) {
                return true;
            }
        }
        return false; //return false if it does not contain
    }

    /**
     * adds the element to the end of the array
     *
     * @param item the element that is going to be added
     */
    @Override
    public void add(Object item) {
        if (size == arr.length) {
            increaseBuffer(); //checking if the array is full, if true invoke increaseBuffer
        }
        arr[size++] = item; //adding the element to the end of the array
    }

    private void increaseBuffer() {
        Object[] newArr = new Object[arr.length * 2]; //new array with doubled size
        for (int i = 0; i < arr.length; i++) { //copying the existing elements to the new array
            newArr[i] = arr[i];
        }
        arr = newArr; //setting the new array
    }

    /**
     * adds the element at the specified index
     *
     * @param item  the element that is going to be added
     * @param index position of the element where it is going to be added
     */
    @Override
    public void add(Object item, int index) {
        checkIndex(index);
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException(); //check if the index is in bounds
        if (size() == arr.length) {
            increaseBuffer(); //checking if the array is full, if true invoke increaseBuffer
        }
        for (int i = size - 1; i > index; i--) {
            arr[i] = arr[i - 1]; //moving the elements to make space for new ones
        }
        arr[index] = item; //inserting element at the given index
        size++; //increasing the size
    }

    /**
     * removes the first occurrence of the element from array
     *
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
     *
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
     *
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
     *
     * @param index index that is going to be checked
     * @throws IndexOutOfBoundsException if index is out of bounds
     */
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(); //throw exception if the index is out of bounds
        }
    }

    /**
     * get the index of the first occurrence of the object
     *
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
     *
     * @param o object that is going to be checked
     * @return the index of found, if not return -1
     */
    @Override
    public int lastIndexOf(Object o) {
        int index = -1; //index initializing
        for (int i = 0; i < size; i++) {
            if (arr[i].equals(o)) { //comparing each element with the object
                index = i; //storing i value in index variable
            }
        }
        return index;
    }

    /**
     * sort the element in the array
     */
    @Override
    public void sort() {
        for (int i = 0; i < size; i++) {
            for (int j = i; j < size; j++) {
                if ((int) arr[j] < (int) arr[i]) {
                    Object temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
# MyLinkedList
It is a class of nodes that implements MyList interface. It contains same methods as in previous list like size(), clear(), contains(), get(), remove(), sort() and so on.

# Solution
        /**
         * Node construction
         * @param element element value of the node
         * @param next the reference to the next node
         * @param previous the reference to the previous node
         */
        public Node(T element, Node next, Node previous) {
            this.element = element;
            this.next = next;
            this.previous = previous;
        }
    }

    private Node head; //first node of the linked list
    private Node tail; //last node of the linked list
    private int size; //number of nodes in the linked list

    /**
     * constructor
     * Initializes empty list
     */
    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Returns the number of elements in list
     * @return the number of elements in list
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Checking whether the linked list contains the element
     * @param o o the element that is going to be checked
     * @return true if contains, false if not
     */
    @Override
    public boolean contains(Object o) {
        Node thisN = head;
        while (thisN != null) {
            if (thisN.element == o) { //return true if the node's element is matching the specified element
                return true;
            }
            thisN = thisN.next; //next node
        }
        return false; //if not return false
    }

    /**
     * Adding element to the end of the list
     * @param item the element that is going to be added
     */
    @Override
    public void add(Object item) {
        Node newNode = new Node((T) item, null, tail); //new node
        if (tail == null) { //set new node as the head if list is empty,
            head = newNode;
        } else { //set new node as the next node otherwise
            tail.next = newNode;
        }
        tail = newNode; //updating the tail
        size++;
    }

    /**
     * Adding element at the specified index in the list
     * @param item the element that is going to be added
     * @param index the index at which to add the element
     */
    @Override
    public void add(Object item, int index) {
        checkIndex(index); //checking if the index is valid
        Node newNode = new Node((T) item, null, null); //new node
        if (index == size) { //add new node at the end if the index is the size of the list
            if (tail == null) { //set the new node as head and tail if the list is empty
                head = newNode;
                tail = newNode;
            } else { // set the new node as next node of current tail and update reference
                tail.next = newNode;
                newNode.previous = tail;
                tail = newNode;
            }
        }
        size++;
    }

    /**
     * check if the index is valid
     *
     * @param index index that is going to be checked
     * @throws IndexOutOfBoundsException if index is out of bounds
     */
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(); //throw exception if the index is out of bounds
        }
    }

    /**
     * Removing the first occurrence of the specified element from the list
     * @param item element that is going to be removed
     * @return true if removed, false if not
     */
    @Override
    public boolean remove(Object item) {
        Node current = head;
        Node previous = null;
        boolean check = false; //indicator that shows if the element was removed or not
        while (current != null) {
            if (current.element.equals(item)) { //set flag to be true, if the current node's element matches the item to be removed
                check = true;
                break;
            }
            previous = current;
            current = current.next;
        }
        if (check) { //if element is found
            if (previous == null) { //update the head to the next node, if the element that is going to be removed is head
                head = current.next;
            } else {
                previous.next = current.next; //update the reference
            }
            if (current == tail) { //ppdate the tail to the previous, if the element that is going to be removed is the tail
                tail = previous;
            }
            size--;
        }
        return check; //return boolean
    }

    /**
     * Removing an element at the specified index in the list
     * @param index element that is going to be removed
     * @return the removed element
     */
    @Override
    public Object remove(int index) {
        checkIndex(index); //checking if the index is valid
        Node current = head;
        Node previous = null;
        for (int i = 0; i < index; i++) {
            previous = current; //move the previous reference to the current node
            current = current.next; //next node
        }
        if (previous == null) { //remove the head node if previous is null
            head = current.next;
        } else { //update the next reference of the previous node if not null
            previous.next = current.next;
        }
        if (current == tail) { //update the tail to the previous, if the current is tail
            tail = previous;
        }
        size--; //elements are being removed
        return current.element; //return removed element
    }
