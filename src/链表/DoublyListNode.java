package 链表;


//这个感觉有问题，就不用做了

public class DoublyListNode<E> {

    private class Node<E> {
        E data;
        Node pre;
        Node next;

        public Node(){}
        public Node(E data, Node pre, Node next){
            this.data=data;
            this.pre=pre;
            this.next=next;
        }
        public Node(E data){
            this.data=data;
        }
        //指向null的尾节点
        public Node(E data, Node pre){
            this(data, pre,null);
        }
        //头节点
//        public Node(E data,Node next){
//            this(data,null,next);
//        }
    }

    private Node<E> head;
    private Node<E> tail;
    private int length;


    //链表初始化是一个数据为null的空
    public DoublyListNode(){
        head=null;
        tail=head;
        length=0;
    }

    public boolean isEmpty() {
        return length ==0;
    }

    public int length(){
        return length;
    }

    // 向头节点添加元素，这是没有虚拟头节点的设置
    public void addFirst(E e){
        //创建一个新节点
        Node curNode = new Node(e);
        //当 两表为空
        if(isEmpty()){
            // 将 head和 tail都指向链表第一个元素
            head=curNode;
            tail=curNode;
        }
        else {
            //前驱为空，后继指向 当前 head
            curNode.next=head;
            head=curNode;
        }
        length++;
    }

    // 向尾节点插入元素 add= addLast
    public void addLast(E e){
        Node curNode = new Node(e);
        if(isEmpty()){
            head = curNode;
            tail=curNode;
        }
        else {
            tail.next=curNode;
            curNode.pre=tail;
            tail=curNode;
        }
        length++;
    }

    public E get(int index){
        Node<E> cur = head;
        for(int i=0;i<index;i++){
            cur=cur.next;
        }
        return cur.data;

    }

    public void add(int index, E data){
        if(index <0 || index >length)
            throw new IllegalArgumentException("Add failed,Illegal index,");
        if(index ==0)
            addFirst(data);
        else if(index==length)
            addLast(data);
        else {
            Node preNode = head;
            for(int i=0;i<index-1;i++){
                preNode = preNode.next;
            }
            Node<E> curNode = new Node(data);
            curNode.next = preNode.next;
            curNode.next.pre=curNode;
            curNode.pre = preNode;
            preNode.next=curNode;
            length++;
        }
    }
    //从头部删除
    public void deleteFirst(){
        if(length ==1){
            head = null;
            tail=head;
        }
        else{
            head=head.next;
        }
        length--;
    }
    // 尾部删除
    public void deleteLast() {
        if (length == 1) {
            head = null;
            tail = head;
            length--;
        } else {

            tail.pre.next = null;
            tail = tail.pre;
            length--;
        }
    /*public void delete(int index){
            if(index==0)
                deleteFirst();
            else if (index==length-1) {
                deleteLast();
            }
            else {//删除 为了理解统一从头找那个节点
                Node<E>team=head;
                for(int i=0;i<index-1;i++)
                {
                    team=team.next;
                }
                //team 此时为要删除的前节点  a  c   插入B  a为team
                team.next.next.pre=team;//c的前驱变成a
                team.next=team.next.next;//a的后驱变成c
                length--;
            }
        }
        void set(int index, E data){
            Node<E>team=head;
            for(int i=0;i<index-1;i++)
            {
                team=team.next;
            }
            team.data=data;
        }
        @Override
        public String toString() {
            Node<E> team = head;
            String vaString = "";
            while (team != null) {
                vaString += team.data + " ";
                team = team.next;
            }
            return vaString;


        }*/
    }
}
