package com.xiong.LeetCode.StringsProblem;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/6/24 16:26
 * @description： 12. 整数转罗马数字
 * @modified By：
 * @version: $
 */
public class Leet12_intToRoman {

    public String intToRoman_greedy(int num) {
        // 把阿拉伯数字与罗马数字可能出现的所有情况和对应关系，放在两个数组中
        // 并且按照阿拉伯数字的大小降序排列，这是贪心选择思想
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        // 贪心 ，优先选大的，
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while(index < 13){
            while(num >= nums[index]){
                sb.append(romans[index]);
                num -= nums[index];
            }
            index++;
        }

        return sb.toString();

    }


    public String intToRoman1(int num){

        String[][] arr = {
            {"","I","II","III","IV","V","VI","VII","VIII","IX"},
            {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"},
            {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"},
            {"","M","MM","MMM"}};

        StringBuilder roman = new StringBuilder();

        roman.append(arr[3][num / 1000]);
        roman.append(arr[2][num / 100 % 10]);
        roman.append(arr[1][num / 10 % 10]);
        roman.append(arr[0][num % 10]);

        return roman.toString();
    }


    public String intToRoman2(int num) {

        StringBuilder sb = new StringBuilder();

        int m = 1;  // m 1 10 100 1000 ...

        while (num != 0) {

            int cur = num % 10;

            num /= 10;

            sb.append(convert(cur, m));

            m *= 10;
        }

        return sb.reverse().toString();

    }

    private String convert(int cur, int m) {

        if (cur == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();

        char preC = 'I';  // 表示 1   10  100 1000
        char curC = 'V';  // 表示 5  50 500
        char nextC = 'X'; // 表示 10  100 1000

        if (m == 10) {
            preC = 'X';
            curC = 'L';
            nextC = 'C';
        } else if (m == 100) {
            preC = 'C';
            curC = 'D';
            nextC = 'M';
        } else if (m == 1000) {
            preC = 'M';
        }


        if (cur < 4) {
            while (cur-- > 0) {
                sb.append(preC);
            }
        } else if (cur == 4) {
            sb.append(preC);
            sb.append(curC);
        } else if (cur == 9) {
            sb.append(preC);
            sb.append(nextC);
        } else {
            sb.append(curC);
            cur = cur - 5;
            while (cur-- > 0) {
                sb.append(preC);
            }
        }
        return sb.reverse().toString();

    }
}
