package demo_v1.temp.exam;

import java.util.*;

/**
 * <p>
 *   算法题-数组变换
 * </p>
 *
 * @author ruixin
 * @date 2020-04-08
 */
public class CalDemo {

    public static void main(String[] args) {
        ArrayChange ac = new ArrayChange();
//        ac.arrayChange01();
//        ac.arrayChange02();



    }

    static class ArrayChange{
        public void arrayChange01(){
            //int[] arr = {3, 5, 7, 1, 9};
            int[] arr = {11, 13, 15,17,19};
            int d=2;

            //1、判断无解情况
            Set<Integer> sets = new HashSet<>();
            for (int i=0;i<arr.length;i++) {
                sets.add(arr[i] % d);
            }
            if(sets.size()>1){
                System.out.println("该数组无解-1");
                return;
            }
            //2、有解情况输出最小操作次数
            Map map = new HashMap<>();
            for(int i=0;i<arr.length;i++){
                for(int j=0;j<arr.length;j++){
                    if(arr[i]==arr[j]){
                        if(map.containsKey(arr[i])){
                            int var = (int) map.get(arr[i]);
                            map.put(arr[i],var+0);
                        }else {
                            map.put(arr[i],0);
                        }
                    }else {
                        if(map.containsKey(arr[i])){
                            int var = (int) map.get(arr[i]);
                            map.put(arr[i],var+(Math.abs(arr[i]-arr[j]))/d);
                        }else {
                            map.put(arr[i],(Math.abs(arr[i]-arr[j]))/d);
                        }
                    }
                }
            }

            Collection values = map.values();
            System.out.println("01-该数组的最小操作次数: "+Collections.min(values));
            System.out.println("01-map:"+map);
        }


        public void arrayChange02(){
            //int[] arr = {3, 5, 7, 1, 9};
            int[] arr = {11, 13, 15,17,19};
            int d=2;

            //1、判断无解情况
            Set<Integer> sets = new HashSet<>();
            for (int i=0;i<arr.length;i++) {
                sets.add(arr[i] % d);
            }
            if(sets.size()>1){
                System.out.println("该数组无解-1");
                return;
            }
            //2、有解情况输出最小操作次数
            int mid_index = 0;
            int num = 0;
            Arrays.sort(arr);
            mid_index = (arr.length / 2);
            for(int i=0;i<arr.length;i++){
                if(arr[mid_index]==arr[i]){
                    continue;
                }
                num=num+(Math.abs(arr[i]-arr[mid_index])/d);
            }
            System.out.println("02-最优值为"+arr[mid_index]+", 该数组的最小操作次数: "+num);
        }
    }


}
