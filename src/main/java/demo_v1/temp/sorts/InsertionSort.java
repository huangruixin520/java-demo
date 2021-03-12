package demo_v1.temp.sorts;

import java.util.Arrays;

/**
 * <p>
 *  插入排序  难度比较大
 * </p>
 *
 * @author ruixin
 * @date 2020-08-21
 */
public class InsertionSort {
    public static void main(String[] args) {

        int[] arr = {4,3,2,12,9,8};
        System.out.println("排序前:"+ Arrays.toString(arr));
        for (int i=1;i<arr.length;i++){
            int indx_value = arr[i];
            int j=i-1;
            for(;j>=0;j--){
                if(indx_value<=arr[j]){
                    arr[j+1]=arr[j];   //数据移动
                }else {
                    break;
                }
            }
            arr[j+1]= indx_value;  //插入数据
        }
        System.out.println("排序后:"+Arrays.toString(arr));

    }
}
