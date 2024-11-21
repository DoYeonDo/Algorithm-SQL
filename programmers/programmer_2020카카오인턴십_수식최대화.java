import java.util.*;

class Solution {
    static int[] perm;
    static boolean[] visited;
    static List<Character> noAmbiOperList = new ArrayList<>();
    static List<Character> operList = new ArrayList<>();
    static List<Long> numList = new ArrayList<>();
    static long max;

    public long solution(String expression) {
        max = Long.MIN_VALUE;

        int prevIdx = 0;
        for (int idx = 0; idx < expression.length(); idx++) {
            char ch = expression.charAt(idx);
            if (ch == '-' || ch == '*' || ch == '+') {
                operList.add(ch);
                numList.add(Long.parseLong(expression.substring(prevIdx, idx)));
                if (!noAmbiOperList.contains(ch)) {
                    noAmbiOperList.add(ch);
                }
                prevIdx = idx + 1;
            }
        }
        numList.add(Long.parseLong(expression.substring(prevIdx)));

        perm = new int[noAmbiOperList.size()];
        visited = new boolean[noAmbiOperList.size()];
        permutation(0);

        return max;
    }

    private static void permutation(int cnt) {
        if (cnt == perm.length) {
            calc();
            return;
        }

        for (int idx = 0; idx < noAmbiOperList.size(); idx++) {
            if (!visited[idx]) {
                perm[cnt] = idx;
                visited[idx] = true;
                permutation(cnt + 1);
                visited[idx] = false;
            }
        }
    }

    private static void calc() {
        List<Character> tmpOperList = new ArrayList<>(operList);
        List<Long> tmpNumList = new ArrayList<>(numList);

        for (int idx = 0; idx < perm.length; idx++) {
            char oper = noAmbiOperList.get(perm[idx]);

            for (int cnt = 0; cnt < tmpOperList.size(); ) {
                if (tmpOperList.get(cnt) == oper) {
                    long num1 = tmpNumList.get(cnt);
                    long num2 = tmpNumList.get(cnt + 1);
                    long result = 0;

                    switch (oper) {
                        case '*': result = num1 * num2; break;
                        case '-': result = num1 - num2; break;
                        case '+': result = num1 + num2; break;
                    }

                    tmpNumList.set(cnt, result);
                    tmpNumList.remove(cnt + 1);
                    tmpOperList.remove(cnt);
                } else {
                    cnt++;
                }
            }
        }

        max = Math.max(max, Math.abs(tmpNumList.get(0)));
    }
}
