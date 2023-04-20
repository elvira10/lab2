public class Main {
    public static void main(String[] args) {
        MyArrayList arrayList = new MyArrayList();
        arrayList.add(45);
        arrayList.add(8);
        arrayList.add(973);
        arrayList.add(89);
        arrayList.add(6);
        arrayList.add(3);
        arrayList.add(404);
        arrayList.add(8);
        arrayList.add(26);
        System.out.println(arrayList.get(7));
        System.out.println(arrayList.size());
        System.out.println(arrayList.contains(500));
        System.out.println(arrayList.lastIndexOf(8));
        System.out.println(arrayList.indexOf(973));
        System.out.println(arrayList.remove(7));
        //arrayList.sort();

        MyLinkedList linkedList = new MyLinkedList();
        linkedList.add(54);
        linkedList.add(876);
        linkedList.add(5);
        linkedList.add(36);
    }
}