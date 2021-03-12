package demo_v1.temp.alibaba;

/**
 * <p>
 * 阿里巴巴：
 * 找到一个无序数组中找两个特定数，使其相加等于特定数字，请写代码java将它找出来，并指出时间复杂度
 * </p>
 *
 * @author ruixin
 * @date 2021/2/27
 */
public class TestDemo01 {

    public static void main(String[] args) {

        getSpectialNum(28);

    }

    public static void getSpectialNum(int n) {

        int[] numArr = {10, 25, 19, 89, 75, 56, 34, 54, 16, 9, -5};

        boolean flag = false;

        for (int i = 0; i < numArr.length; i++) {

            for (int j = 0; j < numArr.length; j++) {

                if (numArr[i] == numArr[j]) {
                    continue;
                }

                if (n == numArr[i] + numArr[j]) {
                    System.out.println("该数字为：" + numArr[i] + "," + numArr[j]);
                    flag = true;
                    break;
                }

            }

            if (flag) {
                break;
            }
        }
    }
}
