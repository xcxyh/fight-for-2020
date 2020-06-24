package com.xiong.LeetCode.StringsProblem;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/6/24 16:26
 * @description： 12. 整数转罗马数字
 * @modified By：
 * @version: $
 */
public class Leet12_intToRoman {

    public String intToRoman(int num) {

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
