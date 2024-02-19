package 전체문제.third_month_2024_02.tenth_2024_02_19;

import java.util.*;

public class PR_단체사진찍기_Level_2 {

    static int answer;
    static char[]member = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    static String[]D;
    static boolean[]visited;
    static char[]check;
    static int N;
    static int TC;
    static int solution(int n, String[] data) {
        D = data;
        N = 8;
        TC = n;
        check = new char[N];
        visited = new boolean[N];
        dfs(0);
        return answer;
    }
    static boolean calc(){
        String str = String.valueOf(check);
        for(int i=0;i<TC;i++){

            char f = D[i].charAt(0);
            char s = D[i].charAt(2);
            char op = D[i].charAt(3);
            int range = Integer.parseInt(D[i].charAt(4)+"");
            int fidx = str.indexOf(f);
            int sidx = str.indexOf(s);
            int diff = Math.abs(fidx-sidx)-1;
            switch (op){
                case '=':
                    if(diff!=range) return false;
                    break;
                case '>':
                    if(range>=diff) return false;
                    break;
                case '<':
                    if(range<=diff) return false;
                    break;
            }
        }
        return true;
    }
    static void dfs(int depth){
        if(depth==N){
            if(calc())answer++;
            return;
        }
        for(int i=0;i<N;i++){
            if(!visited[i]){
                visited[i] = true;
                check[depth] = member[i];
                dfs(depth+1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        /*
        TEST CASE
        1.
        int n = 2;
        String[] data = {"N~F=0", "R~T>2"};
        int result = 3648;

        2.
        int n = 2;
        String[] data = {"M~C<2", "C~M>1"};
        int result = 0;

        * */
        int n = 2;
        String[] data = {"N~F=0", "R~T>2"};
        System.out.println(solution(n,data));
    }
}
