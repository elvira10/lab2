public class MyLinkedList<T> implements MyList{
    private class Node{
        private T element;
        private Node next;
        private Node previous;
        public Node(T element, Node next, Node previous) {
            this.element = element;
            this.next = next;
            this.previous = previous;
        }
    }
    private Node head;
    private Node tail;
    private int size;
    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
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
        Node newNode = new Node((T) item, null, tail);
        if (tail==null){
            head=newNode;
        }
        else {
            tail.next=newNode;
        }
        tail=newNode;
        size++;
    }

    @Override
    public void add(Object item, int index) {
        checkIndex(index);
        Node newNode = new Node((T) item, null, null);
        if (index == size) {
            if (tail == null) {
                head = newNode;
                tail = newNode;
            }
            else {
                tail.next = newNode;
                newNode.previous = tail;
                tail = newNode;
            }
        }
        size++;
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
    @Override
    public boolean remove(Object item) {
        Node current = head;
        Node previous = null;
        boolean check = false;
        while (current != null) {
            if (current.element.equals(item)) {
                check = true;
                break;
            }
            previous = current;
            current = current.next;
        }
        if (check) {
            if (previous == null) {
                head = current.next;
            } else {
                previous.next = current.next;
            }
            if (current == tail) {
                tail = previous;
            }
            size--;
        }
        return check;
    }

    @Override
    public Object remove(int index) {
            checkIndex(index);
            Node current = head;
            Node previous = null;
            for (int i = 0; i < index; i++) {
                previous = current;
                current = current.next;
            }
            if (previous == null) {
                head = current.next;
            } else {
                previous.next = current.next;
            }
            if (current == tail) {
                tail = previous;
            }
            size--;
            return current.element;
        }

    @Override
    public void clear() {

    }

    @Override
    public Object get(int index) {
        checkIndex(index);
        Node thisN;
        if (index < size / 2) {
             thisN = head;
            for (int i = 0; i < index; i++) {
                thisN = thisN.next;
            }
        }
        else {
            thisN = tail;
            for (int i = size - 1; i > index; i--) {
                thisN = thisN.previous;
            }
        }
        return thisN.element;
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
