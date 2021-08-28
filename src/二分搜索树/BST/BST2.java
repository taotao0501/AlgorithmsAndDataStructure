package 二分搜索树.BST;
//重写改写
import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;

import java.util.Queue;
import java.util.Stack;
public class BST2<E extends Comparable<E>> {

    private class Node {
        public E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BST2(){
        root = null;
        size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 1.添加
     * @param e
     */
    //向二分搜索树中添加新的元素e
    public void add(E e){
        root = add(root, e);
    }

    // 向以node为根的二分搜索树中插入元素e，递归算法
    // 返回插入新节点后二分搜索树的根
    private Node add(Node node, E e){
        if(node == null){
            size ++;
            return new Node(e);
        }
        if(e.compareTo(node.e) < 0)
            node.left = add(node.left, e);
        else if(e.compareTo(node.e) > 0)
            node.right = add(node.right, e);

        return node;
    }

    /**
     * 2.查询
     */
    public boolean contains(E e){
        return contains(root,e);
    }

    private boolean contains(Node node, E e){
        if(node == null)
            return false;
        if(e.compareTo(node.e) == 0)
            return true;
        else if(e.compareTo(node.e) <0)
            return contains(node.left,e);
        else
            return contains(node.right,e);
    }

    //遍历的 迭代方法参考 https://leetcode-cn.com/problems/binary-tree-preorder-traversal/solution/leetcodesuan-fa-xiu-lian-dong-hua-yan-shi-xbian-2/
    /**
     * 3.遍历
     * 3.1 前序遍历
     */
    public void preOrder(){
        preOrder(root);
    }
    // 前序遍历以node为根的二分搜索树, 递归算法
    private void preOrder(Node node){
        if(node ==null)
            return;
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }
    /**
     * 3.1.2 前序遍历的非递归写法
     * 用栈来记录先后顺序，右孩子先入栈
     */
    public void preOrderNR(){
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            //先访问该节点的值
            Node cur = stack.pop();
            System.out.println(cur.e);

            if(cur.right != null)
                stack.push(cur.right);
            if(cur.left !=null)
                stack.push(cur.left);
        }
    }

    /**
     * 3.2 中序遍历
     * @return
     */
    public void inOrder(){
        inOrder(root);
    }
    // 前序遍历以node为根的二分搜索树, 递归算法
    private void inOrder(Node node){
        if(node ==null)
            return;
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }
    /**
     * 3.2.1 中序遍历的非递归写法 head == root
     */
    public void inOrderNR(Node head){
        if(head == null)
            return;
        Node cur = head;
        Stack<Node> stack = new Stack<>();
        while(!stack.isEmpty() || cur!= null) {
            while(cur!=null){
                stack.push(cur);
                cur = cur.left;
            }
            Node node = stack.pop();
            System.out.println(node.e + " ");
            if(node.right !=null){
                cur = node.right;
            }
        }
    }

    /**
     * 3.3 后续遍历
     * @return
     */
    // 二分搜索树的后序遍历
    public void postOrder(){
        postOrder(root);
    }

    // 后序遍历以node为根的二分搜索树, 递归算法
    private void postOrder(Node node){
        if(node == null)
            return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    // 后序遍历以node为根的二分搜索树, 非递归算法
    public void postOrderNR(Node head){
        if(head == null)
            return;
        Stack<Node> stack1= new Stack<>();
        Stack<Node> stack2= new Stack<>();
        stack1.push(head);
        while(!stack1.isEmpty()){
            Node node = stack1.pop();
            stack2.push(node);
            if(node.left!=null){
                stack1.push(node.left);
            }
            if(node.right !=null){
                stack1.push(node.right);
            }
        }
        while(!stack2.isEmpty()) {
            System.out.println(stack2.pop().e + " ");
        }
    }



    /**
     * 层序遍历  需要队列
     * @return
     */
    public void levelOrder(){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node cur = q.remove();
            System.out.println(cur.e);
            if(cur.left!=null){
                q.add(cur.left);
            }
            if(cur.right != null){
                q.add(cur.right);
            }
        }
    }

    /**
     * 删除 Max Min值
     * @return
     */
    // 寻找二分搜索树的最小元素
    public E minimum(){
        if(size==0)
            throw new IllegalArgumentException("BST is empty");
        return minimum(root).e;
    }

    //返回以Node为根的二分搜索树的最小值所在的节点
    private Node minimum(Node node) {
        if(node.left == null)
            return node;
        return minimum(node.left);
    }

    // 寻找二分搜索树的最大元素
    public E maximum(){
        if(size == 0)
            throw new IllegalArgumentException("BST is empty");
        return maximum(root).e;
    }

    // 返回以node为根的二分搜索树的最大值所在的节点
    private Node maximum(Node node) {
        if(node.right ==null)
            return node;
        return maximum(node.right);
    }

    // 从二分搜索树中删除最小值所在节点, 返回最小值
    public E removeMin(){
        E ret = minimum();
        root = removeMin(root);
        return ret;
    }

    // 删除掉以node为根的二分搜索树中的最小节点
    // 返回删除节点后新的二分搜索树的根
    private Node removeMin(Node node){
        if(node.left == null){
            Node rightNode = node.right;
            node.right = null;
            size --;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    // 从二分搜索树中删除最小值所在节点, 返回最小值
    public E removeMax(){
        E ret = minimum();
        root = removeMin(root);
        return ret;
    }

    // 删除掉以node为根的二分搜索树中的最小节点
    // 返回删除节点后新的二分搜索树的根
    private Node removeMax(Node node){
        if(node.right == null){
            Node leftNode = node.left;
            node.left = null;
            size --;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }

    // 从二分搜索树中删除元素为e的节点
    public void remove(E e){
        root = remove(root,e);
    }

    private Node remove(Node node, E e){
        if(node == null)
            return null;
        if(e.compareTo(node.e) < 0){
            node.left = remove(node.left,e);
            return node;
        }
        else if(e.compareTo(e) > 0){
            node.right = remove(node.right, e);
            return node;
        }
        else if(e.compareTo(node.e) > 0 ){
            node.right = remove(node.right, e);
            return node;
        }
        else { // e.compareTo(node.e) == 0
            // 待删除节点左子树为空的情况
            if(node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size --;
                return rightNode;
            }

            // 待删除节点右子树为空的情况
            if(node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size --;
                return leftNode;
            }
            // 待删除节点左右子树均不为空的情况
            // 找到比待删除节点大的最小节点, 即待删除节点右子树的最小节点
            // 用这个节点顶替待删除节点的位置
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            size ++;
            successor.left = node.left;

            node.left = node.right = null; //脱离关系
            size --;
            return successor;
        }
    }









    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    // 生成以node为根节点，深度为depth的描述二叉树的字符串
    private void generateBSTString(Node node, int depth, StringBuilder res){

        if(node == null){
            res.append(generateDepthString(depth) + "null\n");
            return;
        }

        res.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }

    private String generateDepthString(int depth){
        StringBuilder res = new StringBuilder();
        for(int i = 0 ; i < depth ; i ++)
            res.append("--");
        return res.toString();
    }
}

