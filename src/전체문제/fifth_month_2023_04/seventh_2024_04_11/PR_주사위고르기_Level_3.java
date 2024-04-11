package 전체문제.fifth_month_2023_04.seventh_2024_04_11;

import java.util.*;

public class PR_주사위고르기_Level_3 {
    static int N;
    static int[][]D;
    static int[]tmp;
    static List<Integer> listA;
    static List<Integer> listB;
    static int[]answer;
    static int ansCnt;
    static int[] solution(int[][] dice) {
        answer = new int[dice.length/2];
        D = dice;
        N = dice.length;
        tmp = new int[dice.length/2];
        comb(0,0);
        return answer;
    }
    static void calc(){
        int[]other = new int[N/2];
        int idx = 0; int idxSec = 0;
        for(int i=0;i<N;i++){
            if(idx>N/2-1||tmp[idx]!=i) {
                other[idxSec++] = i;
                continue;
            }
            idx++;
        }
        //모든 A의 조합과 B의 조합
        listA = new ArrayList<>();
        listB = new ArrayList<>();
        dfs(listA,tmp,0,0);
        dfs(listB,other,0,0);
        Collections.sort(listB);
        int sum  = 0;
        for(int num : listA){
            int L = 0; int R = listB.size();
            while(L<R){
                int mid = (L+R)/2;
                if(listB.get(mid)<num) L = mid+1;
                else R = mid;
            }
            sum += L;
        }
        if(ansCnt<sum){
            ansCnt = sum;
            for(int i=0;i<N/2;i++) answer[i]  = tmp[i]+1;
        }
    }
    static void dfs(List<Integer> list,int[]mine,int sum,int depth){
        if(depth==N/2){
            list.add(sum);
            return;
        }
        for(int i=0;i<6;i++){
            dfs(list,mine,sum+D[mine[depth]][i],depth+1);
        }

    }
    static void comb(int depth,int start){

        if(depth==N/2){
            calc();
            return;
        }

        for(int i=start;i<N;i++){
            tmp[depth] = i;
            comb(depth+1,i+1);
        }
    }
    public static void main(String[] args) {
           /*
        TEST CASE
        1.
        int[][]dice = {{1, 2, 3, 4, 5, 6},{3, 3, 3, 3, 4, 4},{1, 3, 3, 4, 4, 4},{1, 1, 4, 4, 5, 5}};
        int []result = {1,4}

        2.
        int[][]dice = {{1, 2, 3, 4, 5, 6},{2, 2, 4, 4, 6, 6}};
        int []result = {2}

        3.
        int[][]dice = {{40, 41, 42, 43, 44, 45},{43, 43, 42, 42, 41, 41},{1, 1, 80, 80, 80, 80},{70, 70, 1, 1, 70, 70}};
        int []result = {1,3}
        * */
        int[][]dice = {{40, 41, 42, 43, 44, 45},{43, 43, 42, 42, 41, 41},{1, 1, 80, 80, 80, 80},{70, 70, 1, 1, 70, 70}};
        System.out.println(Arrays.toString(solution(dice)));
    }
}
