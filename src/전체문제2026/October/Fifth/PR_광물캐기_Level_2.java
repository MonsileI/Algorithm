package 전체문제2026.October.Fifth;

import java.util.Arrays;

public class PR_광물캐기_Level_2 {
    public static void main(String[] args) {
        int[]picks = {0,1,1};
        String[]minerals = {"diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "iron", "iron", "diamond"};
        System.out.println(solution(picks,minerals));
    }
    static int N;
    static int []tmp;
    static int[]Picks;
    static int answer;
    static int[]Minerals;
    static int minLen;
    static int[][] useTool;
    static int solution(int[] picks, String[] minerals) {
        answer = Integer.MAX_VALUE;
        N = minerals.length/5; //몇개 곡괙이 가능한지
        if(minerals.length%5!=0) N++;
        tmp = new int[N];
        Arrays.fill(tmp,-1);
        Picks = picks;
        minLen = minerals.length;
        Minerals = new int[minLen];
        useTool = new int[][]{{1,1,1},{5,1,1},{25,5,1}};
        for(int i=0;i<minLen;i++){
            if(minerals[i].equals("diamond")) Minerals[i] = 0;
            if(minerals[i].equals("iron")) Minerals[i] = 1;
            if(minerals[i].equals("stone")) Minerals[i] = 2;
        }
        dfs(0);
        return answer;
    }
    static void calc(){
        int sum = 0;
        int idx = 0;
        int plus = 0;
        for(int i=0;i<minLen;i++){
            if(5<=plus){
                plus = 0;
                idx++;
            }
            int tool = tmp[idx];
            if(tool==-1) break;
            sum += useTool[tool][Minerals[i]];
            plus++;
            if(answer<=sum) return;
        }
        answer = sum;
    }
    static void dfs(int depth){
        if(depth==N){
            calc();
            return;
        }
        boolean flag = false;
        if(Picks[0]!=0){
            flag = true;
            tmp[depth] = 0;
            Picks[0]--;
            dfs(depth+1);
            tmp[depth] = -1;
            Picks[0]++;
        }
        if(Picks[1]!=0){
            flag = true;
            tmp[depth] = 1;
            Picks[1]--;
            dfs(depth+1);
            tmp[depth] = -1;
            Picks[1]++;
        }
        if(Picks[2]!=0){
            flag = true;
            tmp[depth] = 2;
            Picks[2]--;
            dfs(depth+1);
            tmp[depth] = -1;
            Picks[2]++;
        }
        if(!flag){
            calc();
        }

    }
}
