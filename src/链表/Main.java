package 链表;

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for(int i=0; i<5; i++) {
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }
        System.out.println(linkedList.removeLast());
//        linkedList.add(3,666);
//        System.out.println(linkedList);
//        linkedList.remove(2);
//        System.out.println(linkedList);
    }
}
