package 快速排序;

import 归并排序法.MergeSort;
import 插入排序法.InsertionSort;

public class SortingHelper {
    private SortingHelper(){}

    public static <E extends Comparable<E>>  boolean isSorted(E[] arr){

        for(int i=1; i<arr.length; i++)
            if(arr[i-1].compareTo(arr[i]) >0)
                return false;

        return true;
    }

    public static <E extends Comparable<E>>void sortTest(String sortname, E[] arr) {
        Long startTime = System.nanoTime();
        if(sortname.equals("InsertionSort"))
            InsertionSort.sort(arr);
        else if(sortname.equals("InsertionSort2"))
            InsertionSort.sort2(arr);
        else if(sortname.equals("MergeSort"))
            MergeSort.sort(arr);
        //最终优化版
        else if(sortname.equals("MergeSort2"))
            MergeSort2.sort2(arr);
        else if(sortname.equals("QuickSort"))
            QuickSort.sort(arr);
        else if(sortname.equals("QuickSort2"))
            QuickSort2.sort(arr);
        else if(sortname.equals("QuickSort2Ways"))
            QuickSort3.sort2ways(arr);
        Long endTime = System.nanoTime();
        double time = (endTime - startTime) / 1000000000.0;
        if(!SortingHelper.isSorted(arr))
            throw new RuntimeException(sortname + "failed");
        System.out.println(String.format("%s,n = %d : %f s", sortname, arr.length, time));
    }
}
