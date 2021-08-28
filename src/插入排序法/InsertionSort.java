package 插入排序法;

import java.util.Arrays;

public class InsertionSort {
    private InsertionSort(){}

    public static <E extends Comparable<E>>void sort(E[] arr) {
        for(int i=0; i< arr.length; i++) {
            // BETA1
            //for(int j=i; j-1>=0; j--) {
            //if(arr[j].compareTo(arr[j-1]) <0)
            //    swap(arr, j, j-1);
            //else break;
            for (int j=i; j-1>=0 && arr[j].compareTo(arr[j-1]) < 0 ; j--) {
                swap(arr, j,j-1);
            }
        }
    }

    public static <E> void swap(E[] arr, int i, int j) {
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static <E extends Comparable<E>> void sort2(E[] arr) {
        for(int i=0; i<arr.length; i++) {
            //将arr[i]插入到合适位置
            E t= arr[i];
            int j;
            for(j=i; j-1>=0 && t.compareTo(arr[j-1]) < 0; j--) {
                arr[j] = arr[j-1];
            }
            arr[j] = t;
        }
    }

    public static void main(String[] args) {
//         Integer[] test1 = {6,1,2,5,4,3,7};
//         InsertionSort.sort(test1);
//         for(Integer t:test1)
//             System.out.println(t + " ");

         int[] dataSize = {10000, 100000};
         for(int n:dataSize){
             Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
             Integer[] arr2 = Arrays.copyOf(arr, arr.length);

             SortingHelper.sortTest("InsertionSort", arr);
             SortingHelper.sortTest("InsertionSort2", arr2);
         }

    }
}
