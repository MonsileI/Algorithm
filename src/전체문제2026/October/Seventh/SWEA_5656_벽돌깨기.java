package 전체문제2026.October.Seventh;

import java.util.*;
import java.io.*;
public class SWEA_5656_벽돌깨기 {
    static int N;
    static int[][]map;
    static int W,H;
    static int[]tmp;
    static int answer;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb= new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for(int t=1;t<=TC;t++){
            st=  new StringTokenizer(br.readLine()," ");
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            map = new int[H][W];
            for(int i=0;i<H;i++){
                st = new StringTokenizer(br.readLine()," ");
                for(int j=0;j<W;j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            answer = H*W;
            tmp = new int[N];
            comb(0);
            sb.append("#"+t+" "+answer+"\n");
        }
        System.out.println(sb.toString());
    }
    static void calc(){
        int[][]copyMap = new int[H][W];
        for(int i=0;i<H;i++){
            for(int j=0;j<W;j++){
                copyMap[i][j] = map[i][j];
            }
        }
        for(int t=0;t<N;t++){
            //구슬 떨어뜨리기
            Queue<int[]> q= new ArrayDeque<>();
            int y = 0;
            int x= tmp[t];
            while(y<H) {
                if(copyMap[y][x]!=0) {
                    q.offer(new int[]{y,x});
                    break;
                }
                y++;
            }
            while(!q.isEmpty()) {
                int size = q.size();
                for(int tt=0;tt<size;tt++) {
                    int[] c = q.poll();
                    int i = c[0]; //2
                    int j = c[1]; //2
                    //위쪽
                    int si = Math.max(0,i-copyMap[i][j]+1);
                    int ei = Math.min(H-1,i+copyMap[i][j]-1);
                    int sj = Math.max(0,j-copyMap[i][j]+1);
                    int ej = Math.min(W-1,j+copyMap[i][j]-1);

                    for(int ii=si; ii<=ei;ii++){
                        if(ii==i) continue;
                        if(copyMap[ii][j]!=0){
                            q.offer(new int[]{ii,j});
                        }
                    }
                    for(int jj=sj;jj<=ej;jj++) {
                        if(jj==j) continue;
                        if(copyMap[i][jj]!=0){
                            q.offer(new int[]{i,jj});
                        }
                    }
                    copyMap[i][j] = 0;
                }
            }

            //중력 적용
            for(int j=0;j<W;j++){
                for(int i=H-1;-1<i;i--){
                    if(copyMap[i][j]!=0){
                        int ti = i+1;
                        while(ti<H){
                            if(copyMap[ti][j]!=0){
                                if(ti-1!=i) {
                                    copyMap[ti - 1][j] = copyMap[i][j];
                                    copyMap[i][j] = 0;
                                }
                                break;
                            }
                            if(ti==H-1){
                                copyMap[ti][j] = copyMap[i][j];
                                copyMap[i][j] = 0;
                            }
                            ti++;
                        }
                    }
                }
            }
        }
        int cnt = 0;
        for(int i=0;i<H;i++){
            for(int j=0;j<W;j++){
                if(copyMap[i][j]!=0) cnt++;
            }
        }
        answer = Math.min(answer,cnt);
    }
    static void comb(int depth){
        if(depth==N){
            calc();
            return;
        }
        for(int i=0;i<W;i++){
            tmp[depth] = i;
            comb(depth+1);
        }

    }
}