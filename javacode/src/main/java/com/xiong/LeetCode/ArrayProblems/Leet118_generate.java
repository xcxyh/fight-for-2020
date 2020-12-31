package com.xiong.LeetCode.ArrayProblems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/12/6 15:26
 * @description： 118. 杨辉三角
 * @modified By：
 * @version: $
 */
public class Leet118_generate {


    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();

        if (numRows == 0){
            return ans;
        }
        List<Integer> first = new ArrayList<>();
        first.add(1);
        ans.add(first);

        for ( int i = 1; i < numRows; i++){

            List<Integer> preline = ans.get(i - 1);

            List<Integer> curline = new ArrayList<>();

            for (int j = 0; j < i + 1; j++){
                int left = j - 1 >= 0 ? preline.get(j - 1) : 0;
                int right =  j < i ? preline.get(j) : 0;

                curline.add(left + right);
            }
            ans.add(curline);
        }

        return ans;

    }
}
