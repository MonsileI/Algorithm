package 전체문제2026.April.Eleventh;

import java.util.*;

public class LC_GenerateParentheses_Medium {
    static boolean[]tmp;
    static int N;
    static List<String>answer;
    public static void main(String[] args) {
        int n = 3;
        System.out.println(generateParenthesis(n));
    }
    static  List<String> generateParenthesis(int n) {
        answer= new ArrayList<>();
        N = n*2;
        tmp = new boolean[N];
        dfs(0,0,0);

        return answer;
    }
    static void dfs(int left,int right,int depth){
        if(depth==N){
            if(left==right) {
                String str = "";
                for (int i = 0; i < N; i++) {
                    if (tmp[i]) str += "(";
                    else str += ")";
                }
                answer.add(str);
            }
            return;
        }
        if(left==right){
            tmp[depth] = true;
            dfs(left+1,right,depth+1);
            tmp[depth] = false;
        }else {
            tmp[depth] = false;
            dfs(left, right + 1, depth + 1);
            tmp[depth] = true;
            dfs(left+1,right,depth+1);
        }
    }
}
