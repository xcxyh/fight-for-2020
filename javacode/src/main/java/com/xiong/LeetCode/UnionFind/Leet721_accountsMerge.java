package com.xiong.LeetCode.UnionFind;

import java.util.*;

/**
 * @author ：xiongcong
 * @date ：Created in 2021/1/18 14:36
 * @description：
 * @modified By：
 * @version: $
 */
public class Leet721_accountsMerge {

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Integer> emailToIndex = new HashMap<>();
        Map<String, String> emailToName = new HashMap<>();
        int emailCount = 0;

        for (List<String> account : accounts) {
            String name = account.get(0);
            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                if (!emailToIndex.containsKey(email)){
                    emailToIndex.put(email, emailCount++);
                    emailToName.put(email, name);
                }
            }
        }
        UF uf = new UF(emailCount);
        Map<Integer, List<String>> emailsOfroot = new HashMap<>();

        for (List<String> account : accounts) {
            for (int i = 1; i < account.size() - 1; i++) {
                String email1 = account.get(i);
                String email2 = account.get(i + 1);
                uf.merge(emailToIndex.get(email1), emailToIndex.get(email2));
            }
        }

        for (List<String> account : accounts) {
            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                int root = uf.find(emailToIndex.get(email));
                List<String> list = emailsOfroot.getOrDefault(root, new ArrayList<>());
                if (!list.contains(email)){
                    list.add(email);
                }
                emailsOfroot.put(root, list);
            }
        }

        List<List<String>> ans = new ArrayList<>();

        for(int key: emailsOfroot.keySet()){
            List<String> list = emailsOfroot.get(key);
            Collections.sort(list);
            list.add(0, emailToName.get(list.get(0)));
            ans.add(list);
        }

        return ans;


    }

    class UF {
        int[] f;
        int size;
        UF(int n) {
            size = n;
            f = new int[n];
            for (int i = 0; i < n; i++) {
                f[i] = i;
            }
        }

        void merge(int p, int q) {
            int fp = find(p);
            int fq = find(q);

            if (fp != fq) {
                f[fp] = fq;
                size--;
            }
        }

        int find(int x) {
            while (f[x] != x) {
                f[x] = f[f[x]];
                x = f[x];
            }
            return f[x];
        }

        int count() {
            return size;
        }
    }


}
