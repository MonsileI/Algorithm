package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14503_로봇청소기_Gold_5 {
    static int N,M;
    static int[][]map;
    static int ci,cj,cd;
    static int cnt;
    static int[][]dir = {{-1,0},{0,1},{1,0},{0,-1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=  new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        st= new StringTokenizer(br.readLine()," ");
        ci = Integer.parseInt(st.nextToken());
        cj = Integer.parseInt(st.nextToken());
        cd = Integer.parseInt(st.nextToken());
        for(int i=0;i<N;i++){
            st= new StringTokenizer(br.readLine()," ");
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        while(true){
            first();
            if(!second()){
                if(!third()) break;
            }
        }
        System.out.println(cnt);
    }
    static boolean third(){
        int ni = ci - dir[cd][0];
        int nj = cj - dir[cd][1];
        if(map[ni][nj]==1) return false;
        ci = ni; cj = nj;
        return true;
    }
    static boolean second(){

        for(int d=0;d<4;d++){
            int ni = ci + dir[d][0];
            int nj = cj + dir[d][1];
            if(map[ni][nj]==0){
                //반시계 방향으로 회전
                cd = ( cd+3 )%4;
                int tmpI = ci + dir[cd][0];
                int tmpJ = cj + dir[cd][1];
                if(map[tmpI][tmpJ]==0){
                    ci = tmpI; cj = tmpJ;
                }
                return true;
            }
        }
        return false ;
    }
    static void first(){
        if(map[ci][cj]==0){
            map[ci][cj]=2;
            cnt++;
        }
    }
}
