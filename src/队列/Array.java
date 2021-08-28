package 队列;

/**
 * 二次封装自己的类，成为动态数组，提供增、删、改、查等功能
 */
public class Array<E> {
    private E[] data;
    private int size;

    //构造函数，传入数组的容量capacity构造Array
    public Array(int capacity){
        data = (E[]) new Object[capacity];
        size = 0;//没有元素的时候 size指向索引0
    }

    // 无参构造，默认数组容量capacity=10
    public Array(){
        this(10);
    }

    public int getSize(){
        return size;
    }

    public int getCapacity(){
        return data.length;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    // 数组尾部添加一个元素
    public void addLast(E e){
        add(e, size);
    }
    // 添加的复杂度总体而言是 O(n)级别
    // 数组头部添加一个元素
    public void addFirst(E e){
        add(e,0);
    }



    //在第index位置插入一个新元素e
    public void add(E e, int index){

        if(index < 0 || index > size)
            throw new IllegalArgumentException("Inser failed, Require index >= 0 and index <= size");

        if(size == data.length)
            resize(2 * data.length);

        for(int i=size-1; i>=index; i--)
            data[i+1] = data[i];
        data[index] = e;
        size++;
    }

    //获取index索引位置的元素
    public E get(int index){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed. Index is illegal");
        return data[index];
    }

    public E getLast(){
        return get(size-1);
    }

    public E getFirst(){
        return get(0);
    }

    //设置index索引位置的元素
    public void set(int index, E e){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Set failed. Index is illegal");
        data[index] = e;
    }

    // 查找数组种是否有元素 e
    public boolean contain(E e ){
        for(int i=0; i< size; i++) {
            if(data[i].equals(e)) //对象的比较 使用equals() 比较内存地址
                return true;
        }
        return false;
    }

    // 查找数组中元素e所在的索引，如果不存在元素e,则返回-1
    public int find(E e) {
        for(int i=0; i<size; i++) {
            if(data[i].equals(e))
                return i;
        }
        return -1;
    }

    // 从数组种删除index的位置的元素，返回删除的元素
    public E remove(int index){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Remove failed. Index is illegal");
        E ret= data[index];
        for(int i=index+1; i<size; i++)
            data[i-1] = data[i];
        size --;
        //data[size] = null; // loitering objects != memory leak
        return ret;
//        if(size == data.length/4 && data.length /2 != 0)
//            resize(data.length/2);  有点问题不知道为什么？
    }

    // 删除第一个元素，并返回删除的元素
    public E removeFirst() {
        return remove(0);
    }

    // 删除最后一个元素，并返回删除的元素
    public E removeLast() {
        return remove(size-1);
    }

    // 从数组种删除元素e
    public void removeElement(E e){
        int index = find(e);
        if(index != -1)
            remove(index);
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size=%d, capacity = %d\n", size, data.length));
        res.append("[");
        for(int i=0; i<size; i++){
            res.append(data[i]);
            if(i != size-1)
                res.append(", ");
        }
        res.append("]");
        return res.toString();
    }

    private void resize(int newCapacity){
        E[] newData = (E[])new Object[newCapacity];
        for(int i =0; i<data.length;i++)
            newData[i] = data[i];
        data = newData;
    }

}



