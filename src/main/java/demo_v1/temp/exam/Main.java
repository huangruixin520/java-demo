package demo_v1.temp.exam;

import sun.jvmstat.perfdata.monitor.AliasFileParser;

import javax.xml.crypto.Data;
import java.util.*;

/**
 * <p>
 *
 * </p>
 *
 * @author ruixin
 * @date 2020-04-12
 */
public class Main {

    //几组数据
    private static int t_size;

    private static int data_size;

    private static List<Integer> AList = new ArrayList<>();
    private static List<Integer> BList = new ArrayList<>();

    private static List<Integer> results = new ArrayList<>();

    private static Map<Integer,Integer> nums = new HashMap<>();

    private static List<String> inputList = new ArrayList<>();

    private static boolean flag =false;

    public static void main(String[] args) {
        //数据(组)
        Scanner scanner = new Scanner(System.in);
        t_size = Integer.parseInt(scanner.next());
        getInputList(scanner);
        System.out.println("inputList:"+inputList);
        //获取数列A和数列B的数据
        getDataList(inputList);
        for (int i=0;i<AList.size();i++){
            int temp = BList.get(i) - AList.get(i);
            if(!nums.containsKey(temp)){
                nums.put(temp,1);
            }else {
                Integer count = nums.get(temp);
                nums.put(temp,count+1);
            }
        }
        System.out.println("nums:"+nums);


    }

    public static void getInputList(Scanner scanner){
        for(int i=0;i<t_size*3+1;i++){
            inputList.add(scanner.nextLine());
        }
        inputList.remove("");
    }


    public static void getDataList(List<String> list){
        String s1 = list.get(1).replace(" ", "");
        String s2 = list.get(2).replace(" ", "");
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        for (int i=0;i<chars1.length;i++){
            int temp = chars1[i];
            AList.add(temp);
        }
        for (int i=0;i<chars2.length;i++){
            int temp = chars2[i];
            BList.add(temp);
        }
    }
}
