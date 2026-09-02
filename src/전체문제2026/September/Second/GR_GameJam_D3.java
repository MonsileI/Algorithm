package 전체문제2026.September.Second;

import java.util.*;
import java.io.*;
public class GR_GameJam_D3 {
    static int Gi,Gj;
    static int Pi,Pj;
    static int N;
    static int GScore, PScore;
    static int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    static int[][]numMap;
    static int[][]commandMap;

    public static void main(String[] args) throws Exception {
        input();
        Solution();
        outPut();
    }
    static void input() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Gi = Integer.parseInt(st.nextToken())-1;
        Gj = Integer.parseInt(st.nextToken())-1;
        st =new StringTokenizer(br.readLine()," ");
        Pi = Integer.parseInt(st.nextToken())-1;
        Pj = Integer.parseInt(st.nextToken())-1;
        numMap = new int[N][N];
        commandMap = new int[N][N];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<N;j++){
                String str = st.nextToken();
                numMap[i][j] = Integer.parseInt(str.substring(0,str.length()-1));
                char m = str.charAt(str.length()-1);
                int dir = 0;
                switch (m){
                    case 'U' : dir = 0;
                        break;
                    case 'R' : dir =1;
                        break;
                    case 'D' :dir = 2;
                        break;
                    case 'L' : dir = 3;
                        break;
                }
                commandMap[i][j] = dir;
            }
        }
    }

    static void Solution(){
        //구름이 calc
        GScore = calc(Gi,Gj);
        //플레이어 calc
        PScore = calc(Pi,Pj);
    }
    static int calc(int i,int j){
        boolean[][]visited=  new boolean[N][N];
        visited[i][j] = true;
        int cnt = 1;
        OuterLoop:
        while(true){

            int dir = commandMap[i][j];
            int range = numMap[i][j];

            for(int r=0;r<range;r++) {
                int ni = i + move[dir][0];
                int nj = j + move[dir][1];
                if (ni < 0) ni += N;
                else if (N - 1 < ni) ni %= N;
                if (nj < 0) nj += N;
                else if (N - 1 < nj) nj %= N;
                if (visited[ni][nj]) break OuterLoop;
                visited[ni][nj] = true;
                i = ni;
                j = nj;
                cnt++;
            }
        }
        return cnt;
    }

    static void outPut(){
        if(PScore < GScore){
            System.out.println("goorm "+GScore);
        }else if(GScore < PScore){
            System.out.println("player "+PScore);
        }else{
            System.out.println("Wrong Input");
        }

    }
}
