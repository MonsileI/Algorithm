package 순열_조합_부분집합.부분집합;

import java.util.Arrays;

public class PR_양궁대회_Level_2 {


    static int apeach[],tmp[];
    static int[]answer;
    static int max;
    static int[] solution(int n, int[] info) {

        apeach = info;
        answer = new int[11];
        tmp = new int[11];
        comb(n);
        return max==0 ? new int[]{-1} : answer;
    }

    static void calc(){
        int a = 0; int r = 0;
        for(int i=0;i<11;i++){
            if(apeach[i]==0&&tmp[i]==0) continue;
            if(apeach[i]<tmp[i]) r += (10-i);
            else a += (10-i);
        }

        int diff = r-a;
        if(max<diff){
            max = diff;
            for(int i=0;i<11;i++)answer[i] = tmp[i];
        }else if(max==diff){
            for(int i=10;-1<i;i--) {
                if(answer[i]>tmp[i]) return;
                if(tmp[i]>answer[i]){
                    for(int j=0;j<11;j++)answer[j] = tmp[j];
                    return;
                }
            }
        }
    }

    static void comb(int depth){

        if(depth==0){
            calc();
            return;
        }


        for(int i=0;i<11&&tmp[i]<=apeach[i];i++){
            tmp[i]++;
            comb(depth-1);
            tmp[i]--;
        }
    }



    public static void main(String[] args) {

        //Test Case
        //1. int n = 5; int [] info = {2,1,1,1,0,0,0,0,0,0,0}; -> {0,2,2,0,1,0,0,0,0,0,0};
        //2. int n = 1; int [] info = {1,0,0,0,0,0,0,0,0,0,0}; -> {-1};
        //3. int n = 9; int [] info = {0,0,1,2,0,1,1,1,1,1,1}; -> {1,1,2,0,1,2,2,0,0,0,0};
        //4. int n = 10; int []info = {0,0,0,0,0,0,0,0,3,4,3}; -> {1,1,1,1,1,1,1,1,0,0,2};
        int n = 5; int [] info = {2,1,1,1,0,0,0,0,0,0,0};
        System.out.println(Arrays.toString(solution(n,info)));
    }
}
