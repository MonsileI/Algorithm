package 그래프이론.플로이드와샬;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_21278_호석이두마리치킨_Gold_5 {

    static int N;
    static int[][]map;
    static int[]tmp;
    static int answer = 987654321;
    static int answerArr[] = new int[2];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=  new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        map = new int[N+1][N+1];
        for(int i=1;i<N+1;i++) Arrays.fill(map[i],987654321);
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int a=  Integer.parseInt(st.nextToken());
            int b=  Integer.parseInt(st.nextToken());
            map[a][b] = map[b][a] = 1;
        }
        for(int l=1;l<N+1;l++){
            for(int i=1;i<N+1;i++){
                for(int j=1;j<N+1;j++){
                    if(i==j){
                        map[i][j] = 0;
                        continue;
                    }
                    map[i][j] = Math.min(map[i][j],map[i][l]+map[l][j]);
                }
            }
        }
        tmp = new int[2];
        comb(1,0);
        System.out.println(answerArr[0]+" "+answerArr[1]+" "+answer);
    }
    static void calc(){
        int sum  = 0;
        for(int i=1;i<N+1;i++){
            sum += Math.min(map[tmp[0]][i],map[tmp[1]][i])*2;
            if(sum>=answer) return;
        }
        answer = sum;
        answerArr[0] = tmp[0]; answerArr[1] = tmp[1];
    }
    static void comb(int start,int depth){
        if(depth==2){
            calc();
            return;
        }
        for(int i=start;i<N+1;i++){
            tmp[depth] = i;
            comb(i+1,depth+1);
        }
    }
}
