package demo_v1.temp.alibaba;

import java.util.*;

/**
 * <p>
 *      阿里巴巴笔试 有一个字符串它的构成是词+空格的组合，如“北京 杭州 杭州 北京”， 要求输入一个匹配模式（简单的以字符来写）.
 *      比如 aabb,来判断该字符串是否符合该模式， 举个例子：
 *
 *      pattern = “abba”, str=”北京 杭州 杭州 北京” 返回 ture
 *      pattern = “aabb”, str=”北京 杭州 杭州 北京” 返回 false
 *      pattern = “baab”, str=”北京 杭州 杭州 北京” 返回 ture
 * </p>
 *
 * @author ruixin
 * @date 2021/2/28
 */
public class TestDemo06 {

    public static void main(String[] args) {

        String pattern = "ababcd";

        String str = "杨永瑞 黄瑞馨 黄瑞馨 黄瑞馨 李四 张三";

        boolean result = matchStringRule(pattern, str);
        System.out.println(result);
    }


    public static boolean matchStringRule(String pattern,String str){

        Map<String,Integer> patternIdMap = new HashMap<>();
        List<Integer> patternIdList = new ArrayList<>();
        Map<Integer,Integer> strIdMap = new HashMap<>();
        List<Integer> strIdList = new ArrayList<>();

        char[] patterChars = pattern.toCharArray();
        String[] strChars = str.split(" ");

        Integer n=0,m=0;
        for (char patterChar : patterChars) {
            if(null==patternIdMap.get(String.valueOf(patterChar))){
                patternIdMap.put(String.valueOf(patterChar), n);
                patternIdList.add(n);
                n++;
            }else {
                Integer patternId = patternIdMap.get(String.valueOf(patterChar));
                patternIdList.add(patternId);
            }
        }

        for (String strChar : strChars) {
            if(null==strIdMap.get(strChar.hashCode())){
                strIdMap.put(strChar.hashCode(), m);
                strIdList.add(m);
                m++;
            }else {
                Integer strId = strIdMap.get(strChar.hashCode());
                strIdList.add(strId);
            }
        }

        if(patternIdList.size()!=strIdList.size()){
            return false;
        }

        System.out.println(patternIdList);
        System.out.println(strIdList);

        for (int i=0;i<patternIdList.size();i++){
            if(!patternIdList.get(i).equals(strIdList.get(i))){
                return false;
            }

        }
        return true;
    }
}
