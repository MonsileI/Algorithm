package 전체문제.fourth_month_2024_03.ninth_2024_03_12;

import java.util.*;

public class PR_양궁대회_Level_2 {

    static int[]apeach;
    static int[]tmp;
    static int maxDiff = 0;
    static int[]ans;
    static int[] solution(int n, int[] info) {
        apeach = info.clone();
        tmp = new int[11];
        ans = new int[11];
        dfs(n);

        return maxDiff==0 ? new int[]{-1} : ans;
    }

    static void calc(){
        int a = 0;
        int r = 0;
        for(int i=0;i<11;i++){
            if(apeach[i]==0&&tmp[i]==0) continue;
            if(tmp[i]<=apeach[i]) a += 10-i;
            else r += 10-i;
        }
        int diff = r-a;
        if(diff<0 || diff < maxDiff) return;
        if(diff==maxDiff){
            for(int i=10;-1<i;i--){
                if(tmp[i]<ans[i]) return;
                if(ans[i]<tmp[i]) break;
            }
        }
        maxDiff = diff;
        for(int i=0;i<11;i++) ans[i] = tmp[i];
    }
    static void dfs(int depth){
        if(depth==0){
            calc();
            return;
        }

        for(int i=0;i<11&&tmp[i]<=apeach[i];i++){
            tmp[i]++;
            dfs(depth-1);
            tmp[i]--;
        }
    }
    public static void main(String[] args) {
        //Test Case
        //1. int n = 5; int [] info = {2,1,1,1,0,0,0,0,0,0,0}; -> {0,2,2,0,1,0,0,0,0,0,0};
        //2. int n = 1; int [] info = {1,0,0,0,0,0,0,0,0,0,0}; -> {-1};
        //3. int n = 9; int [] info = {0,0,1,2,0,1,1,1,1,1,1}; -> {1,1,2,0,1,2,2,0,0,0,0};
        //4. int n = 10; int []info = {0,0,0,0,0,0,0,0,3,4,3}; -> {1,1,1,1,1,1,1,1,0,0,2};
        int n = 9; int [] info = {0,0,1,2,0,1,1,1,1,1,1};
        System.out.println(Arrays.toString(solution(n,info)));
    }
}
