package demo_v1.temp.sorts;

import java.util.Arrays;

/**
 * <p>
 *  选择排序  时间复杂度 O(n^2)
 *  相比较冒泡排序要好点
 *  思路：首先假设数组[0]为最小值，然后在一个无序的数组中找出其中最小值，然后将其放在前面；
 * </p>
 *
 * @author ruixin
 * @date 2020-01-31
 */
public class SelectionSort {
    public static void main(String[] args) {

        int[] arr = {3,2,5,6,7};
        System.out.println("排序前:"+ Arrays.toString(arr));
        for (int i=0;i<arr.length-1;i++){
            int minIndex = i;
            //选取最小值
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<arr[minIndex]){
                   minIndex = j;
                }
            }
            if(minIndex!=i){
                int temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
            }
        }
        System.out.println("排序后:"+Arrays.toString(arr));

    }
}
