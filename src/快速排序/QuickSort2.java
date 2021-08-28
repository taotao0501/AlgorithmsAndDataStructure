package 快速排序;
/**
 * 为快速排序添加随机化
 */

import java.util.Arrays;
import java.util.Random;

public class QuickSort2 {

    private QuickSort2(){}

    public static <E extends Comparable<E>> void sort(E[] arr){
        Random random = new Random();
        sort(arr, 0, arr.length - 1,random);
    }

    private static <E extends Comparable<E>> void sort(E[] arr, int l, int r,Random random){

        if(l >= r) return;

        int p = partition(arr, l, r,random);
        sort(arr, l, p - 1,random);
        sort(arr, p + 1, r,random);
    }

    private static <E extends Comparable<E>> int partition(E[] arr, int l, int r,Random random){
        // 生成 [l,r]之间的随机索引 r-1+1 是bound
        int p = l + random.nextInt(r-l+1);
        swap(arr,l,p);
        // arr[l+1...j] < v ; arr[j+1...i] >= v
        int j = l;
        for(int i = l + 1; i <= r; i ++)
            if(arr[i].compareTo(arr[l]) < 0){
                j ++;
                swap(arr, i, j);
            }

        swap(arr, l, j);
        return j;
    }

    private static <E> void swap(E[] arr, int i, int j){

        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args){

        int n = 1000000;

        Integer[] arr = ArrayGenerator.generateRandomArray(n,n);
        Integer[] arr2 = Arrays.copyOf(arr, arr.length);
        SortingHelper.sortTest("MergeSort", arr);
        SortingHelper.sortTest("QuickSort", arr2);

        arr = ArrayGenerator.generateOrderedArray(n);
        arr2 = Arrays.copyOf(arr, arr.length);

        SortingHelper.sortTest("MergeSort", arr);
        SortingHelper.sortTest("QuickSort2", arr2);
    }
}
