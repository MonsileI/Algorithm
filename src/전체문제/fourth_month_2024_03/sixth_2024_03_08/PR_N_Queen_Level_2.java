package 전체문제.fourth_month_2024_03.sixth_2024_03_08;
import java.util.*;
public class PR_N_Queen_Level_2 {

    static int arr[];
    static int N;
    static int answer;
    static int solution(int n) {
        arr = new int[n];
        N = n;
        dfs(0);
        return answer;
    }
    static void dfs(int depth){
        if(depth==N){
            answer++;
            return;
        }
        for(int i=0;i<N;i++){
            arr[depth] = i;
            if(check(depth)){
                dfs(depth+1);
            }
            arr[depth] = 0;
        }
    }

    static boolean check(int col){
        for(int i=0;i<col;i++){
            if(arr[col]==arr[i]) return false;
            if(Math.abs(col-i) == Math.abs(arr[col]-arr[i])) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        /*
        TEST CASE
        int n = 4;

        int result = 2;
        * */
        int n =4;
        System.out.println(solution(n));
    }
}
