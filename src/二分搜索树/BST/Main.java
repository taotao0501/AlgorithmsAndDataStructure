package 二分搜索树.BST;

public class Main {
    public static void main(String[] args) {
        BST2<Integer> bst = new BST2<>();
        int[] nums = {5,3,6,8,4,2};


        for(int num: nums)
            bst.add(num);

        /////////////////
        //      5      //
        //    /   \    //
        //   3    6    //
        //  / \    \   //
        // 2  4     8  //
        /////////////////

        bst.preOrder();
        System.out.println();
        //System.out.println(bst);
        bst.preOrderNR();

        System.out.println();
        bst.levelOrder();

//        bst.inOrder();
//        System.out.println();
//        //System.out.println(bst);
//
//        bst.postOrder();
//        System.out.println();
    }


}
