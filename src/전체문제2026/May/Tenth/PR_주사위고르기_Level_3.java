package 전체문제2026.May.Tenth;

import java.util.*;

public class PR_주사위고르기_Level_3 {
    static int N;
    static int []tmp;
    static List<Integer> mine;
    static List<Integer> other;
    static int[][]Dice;
    static int[]answer;
    static int max;
    public static void main(String[] args) {
        int[][]dice = {{1, 2, 3, 4, 5, 6}, {3, 3, 3, 3, 4, 4}, {1, 3, 3, 4, 4, 4}, {1, 1, 4, 4, 5, 5}};
        System.out.println(Arrays.toString(solution(dice)));
    }
    static  int[] solution(int[][] dice) {
        N = dice.length;
        Dice = dice;
        tmp = new int[N/2];
        answer = new int[N/2];
        comb(0,0);
        return answer;
    }
    static void calc(){

        int[]enermy = new int[N/2];
        int mIdx = 0;
        int eIdx = 0;
        for(int i=0;i<N;i++){
            if(N/2==mIdx) {
                enermy[eIdx++] = i;
                continue;
            }
            if(tmp[mIdx]!=i){
                enermy[eIdx++] = i;
            }else {
                mIdx++;
            }
        }
        mine = new ArrayList<>();
        other = new ArrayList<>();
        dfs(mine,0,0,tmp);
        dfs(other,0,0,enermy);
        Collections.sort(mine);
        Collections.sort(other);
        int mLen = mine.size();
        int oLen = other.size();
        int cnt = 0;
        for(int i=0;i<mLen;i++){
            int value = mine.get(i);
            int L = 0; int R = oLen;
            while(L<R){
                int mid = (L+R)/2;
                if(value <= other.get(mid)) R = mid;
                else L = mid+1;
            }
            cnt += L;
        }
        if(max<cnt){
            max = cnt;
            for(int i=0;i<N/2;i++) answer[i] = (tmp[i]+1);
        }
    }
    static void dfs(List<Integer> list, int depth, int sum, int[] check){
        if(depth == N/2){
            list.add(sum);
            return;
        }

        int d = check[depth];

        for(int i=0;i<6;i++){
            dfs(list, depth+1, sum + Dice[d][i], check);
        }
    }
    static void comb(int start,int depth){
        if(depth==N/2){
            calc();
            return;
        }
        for(int i=start;i<N;i++){
            tmp[depth] = i;
            comb(i+1,depth+1);
        }
    }
}
