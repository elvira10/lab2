public class MyLinkedList<T> implements MyList {
    private class Node {
        private T element;
        private Node next;
        private Node previous;

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

    /**
     * Clears all elements in list
     */
    @Override
    public void clear() {
        size = 0;
        head = null;
        tail = null;
    }

    /**
     * Retrieving an element at the specified index in the list
     * @param index element that is going to be retrieved
     * @return the element at the specified index
     */
    @Override
    public Object get(int index) {
        checkIndex(index); //checking if the index is valid
        Node thisN; //node reference
        if (index < size / 2) { //first half of the list
            thisN = head; //start from the head
            for (int i = 0; i < index; i++) { //iteration till we get to the specified index
                thisN = thisN.next;
            }
        } else { //second half of the list
            thisN = tail; //start from the tail
            for (int i = size - 1; i > index; i--) { //iteration backwards till we get to the specified index
                thisN = thisN.previous;
            }
        }
        return thisN.element; //return the element at the specified index
    }

    /**
     * Returning index of the first occurrence of the specified element in the list
     * @param o the element that is going to be searched
     * @return index of the first occurrence of searched element, return -1 if not found
     */
    @Override
    public int indexOf(Object o) {
        int index = 0;
        Node current = head;
        while (current != null) { //iteration in the list
            if (current.element.equals(o)) { // return the index if current element is equal to the specified
                return index;
            }
            current = current.next; //nex node
            index++; //next index
        }
        return -1; //if not found
    }

    /**
     * Returning index of the last occurrence of the specified element in the list
     * @param o the element that is going to be searched
     * @return index of the last occurrence of searched element, return -1 if not found
     */
    @Override
    public int lastIndexOf(Object o) {
        Node current = head;
        int index = -1; //initializing index as -1
        int currentIndex = 0;
        while (current != null) { //iteration in the list
            if (current.element.equals(o)) { // update to the current, if current element is equal to the specified
                index = currentIndex;
            }
            currentIndex++; //next index
            current = current.next; //next node
        }
        return index;
    }

    /**
     * Sorts the elements in the linked list in ascending order
     */
    @Override
    public void sort() {
        Node current = head;
        while (current != null) { //iteration in the list
            Node min = current; //initializing current node as min
            Node inner = current.next; //compartment with next
            while (inner != null) { //iteration of remaining
                if (((Comparable<T>) inner.element).compareTo(min.element) < 0) { // update the min node to be the inner node if inner node element is smaller than min node
                    min = inner;
                }
                inner = inner.next; //move to the next node
            }
            if (min != current) { // If the min node is not the current node, swap the elements
                T temp = current.element;
                current.element = min.element;
                min.element = temp;
            }
            current = current.next; // move to the next node in the list
        }
    }

    @Override
    public int sublist(int index, int size) {
        return 0;
    }

    @Override
    public void sublist(){
        return;
    }
}
