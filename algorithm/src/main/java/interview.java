import java.util.ArrayList;
import java.util.List;

/**
 * @author hp.he
 * @date 2021/1/8 10:07
 */
public class interview {
    // f(n)=f(n-1)+f(n-2),n>2,f(0)=0;f(1)=f(2)=1，请编写一个非递归函数实现，要求时间复杂度和空间复杂度最低


    public static void main(String[] args) {

       /* int num = 8;

        int ret = fabc(num);

        System.out.println(ret);*/


        int[] num = new int[]{1,2,2,2,2};

        List<Integer> retArr = binarySearch(num, 2);

        for (int ind : retArr) {
            System.out.println(ind);
        }

    }


    public static int fabc(int n) {

        int lessOne = 1;
        int lessTwo = 1;
        int totalSum = 0;

        for (int ind = 3; ind <= n; ++ind) {
            totalSum = lessOne + lessTwo;

            lessTwo = lessOne;
            lessOne = totalSum;
        }

        return totalSum;
    }


    public static List<Integer> binarySearch(int[] num, int target) {
        int start = -1;
        int end = num.length;

        while (start +1 < end) {
            int mid = start + (end - start) / 2;
            if (num[mid] >= target) {
                end = mid;
            } else {
                start = mid;
            }
        }

        List<Integer> indArr = new ArrayList<>(num.length);

        // 开始找多个相同元素下标
        for (int ind = start+1 ; ind < num.length; ++ind) {
            if (num[ind] == target) {
                indArr.add(ind);
                continue;
            }
            break;
        }

        return indArr;
    }

}
