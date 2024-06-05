package 전체문제.seven_month_2024_06.third_2024_06_05;

import java.util.*;
import java.io.*;
public class BJ_17144_미세먼지안녕_Gold_4 {
    static int N,M;
    static int[][]map;
    static int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    static int fi,si;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==-1){
                    fi = i-1;
                    si = i;
                }
            }
        }
        while(0<T){

            spread();
            clean();
            T--;
        }
        int ans = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(0<map[i][j]) ans += map[i][j];
            }
        }
        System.out.println(ans);
    }
    static void clean(){

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
        //위 공기청정기
        //오른쪽
        int f = map[fi][M-1];
        for(int j=M-1;1<j;j--) map[fi][j] = map[fi][j-1];
        map[fi][1] = 0;

        //위
        int s = map[0][M-1];
        for(int i=0;i<fi-1;i++) map[i][M-1] = map[i+1][M-1];
        map[fi-1][M-1] = f;
        //왼쪽
        int t = map[0][0];
        for(int j=0;j<M-1;j++) map[0][j] = map[0][j+1];
        map[0][M-2] = s;
        //아래
        for(int i=fi-1;0<i;i--) map[i][0] = map[i-1][0];
        map[fi-1][0] = t;



        //아래 공기청정기
        //오른쪽
        f = map[si][M-1];
        for(int j=M-1;1<j;j--) map[si][j] = map[si][j-1];
        map[si][1] = 0;
        //아래
        s = map[N-1][M-1];
        for(int i=N-1;si<i;i--) map[i][M-1] = map[i-1][M-1];
        map[si+1][M-1] = f;
        //왼쪽
        t = map[N-1][0];
        for(int j=0;j<M-1;j++) map[N-1][j] = map[N-1][j+1];
        map[N-1][M-2] = s;
        //위
        for(int i=si+1;i<N-1;i++) map[i][0] = map[i+1][0];
        map[N-2][0] = t;


        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();

    }
    static void spread(){
        List<int[]> list = new ArrayList<>();
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j]<4) continue;
                int cnt = 0;
                int value = map[i][j]/5;
                for(int d=0;d<4;d++){
                    int ni = i + move[d][0];
                    int nj = j + move[d][1];
                    if(ni<0||nj<0||N-1<ni||M-1<nj||map[ni][nj]==-1) continue;
                    cnt++;
                    list.add(new int[]{ni,nj,value});
                }
                map[i][j] -= value*cnt;
            }
        }
        for(int t=0;t<list.size();t++){
            int[]c = list.get(t);
            map[c[0]][c[1]] += c[2];
        }

    }
}
