package demo_v1.temp.sorts;

import java.util.Arrays;

/**
 * <p>
 *  冒泡排序   时间复杂度 O(n^2)
 * </p>
 *
 * @author ruixin
 * @date 2020-01-31
 */
public class BubbleSort {

    public static void main(String[] args) {

        int[] arr = {3,2,5,6,7};
        System.out.println("排序前:"+ Arrays.toString(arr));
        boolean flag = false;

        for(int i=0;i<arr.length-1;i++){

            for(int j=0;j<arr.length-i-1;j++){
                int temp;
                if(arr[j+1]<arr[j]){
                    flag = true;
                    temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
            //如果二次for(j)的时候始终没有进行交换，说明某一趟的时候数组已经是有序的了，不需要for(i)再次一趟一趟的去排序了,直接跳出即可；
            if(flag){
                break;
            }
        }
        System.out.println("排序后:"+Arrays.toString(arr));
    }
}
