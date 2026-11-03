package 전체문제2026.November.Second;

import java.util.Arrays;

public class PR_양궁대회_Level_2 {
    public static void main(String[] args) {
        int n = 5;
        int[]info = {2,1,1,1,0,0,0,0,0,0,0};
        System.out.println(Arrays.toString(solution(n,info)));
    }
    static int Total;
    static int[]Apeach;
    static int[]tmp;
    static int N = 11;
    static int maxDiff;
    static int[]answer;
    static int[] solution(int n, int[] info) {
        answer=  new int[N];
        maxDiff = -1;
        Total = n;
        Apeach = info;
        tmp = new int[N];
        comb(0,0);
        if(maxDiff==-1){
            answer = new int[]{-1};
        }
        return answer;
    }
    static void calc(){
        int apeach = 0;
        int ryan = 0;
        for(int i=0;i<N;i++){
            if(tmp[i]==0 && Apeach[i]==0) continue;
            if(tmp[i] <= Apeach[i]){
                apeach += (10-i);
            }else{
                ryan += (10-i);
            }
        }
        int diff = ryan - apeach;
        if(diff<=0) return;
        if(diff<maxDiff) return;
        boolean flag = false; // true면 갱신
        if(maxDiff==diff){
            for(int i=N-1;-1<i;i--){
                if(tmp[i]<answer[i]) break;
                if(answer[i] < tmp[i]) {
                    flag = true;
                    break;
                }
            }
        }else{
            flag = true;
        }
        if(!flag) return;
        maxDiff = diff;
        for (int i = 0; i < N; i++) answer[i] = tmp[i];
    }

    static void comb(int start,int depth){
        if(depth==Total){
            calc();
            return;
        }
        for(int i=start;i<N;i++){
            for(int j=1;j<=Total-depth;j++){
                tmp[i] += j;
                comb(i+1,depth+j);
                tmp[i] -= j;
            }
        }
    }
}
