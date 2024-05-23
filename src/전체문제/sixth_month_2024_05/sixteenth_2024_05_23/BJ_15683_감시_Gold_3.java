package 전체문제.sixth_month_2024_05.sixteenth_2024_05_23;

import java.util.*;
import java.io.*;
public class BJ_15683_감시_Gold_3 {
    static class Node{
        int i; int j; int v;

        public Node(int i, int j, int v) {
            this.i = i;
            this.j = j;
            this.v = v;
        }
    }
    static int N,M;
    static int[][]map;
    static List<Node> list;
    static int [][] move = {{-1,0},{0,1},{1,0},{0,-1}};
    static int [] tmp;
    static int size;
    static int total;
    static int sum;
    static boolean [][] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        list = new ArrayList<>();
        int[]nums = new int[6];
        int wall = 0;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]!=0&&map[i][j]!=6) {
                    list.add(new Node(i,j,map[i][j]));
                    nums[map[i][j]]++;
                }
                if(map[i][j]==6) wall++;
            }
        }
        //134의 조합을 1234 별로 해야됨
        //2는 조합 두개, 5는 조합 없음
        size = list.size();
        tmp = new int[size];
        comb(0,0);
        System.out.println((N*M)-size-total-wall);
    }
    static void comb(int depth,int start){
        if(depth==size){
            calc();
            return;
        }
        for(int i=start;i<size;i++){
            if(list.get(i).v==5){
                tmp[depth] = 0;
                comb(depth+1,i+1);
            }
            else if(list.get(i).v==2) {
                tmp[depth] = 0;
                comb(depth+1,i+1);
                tmp[depth] = 1;
                comb(depth+1,i+1);
            }else{
                for(int j=0;j<4;j++){
                    tmp[depth] = j;
                    comb(depth+1,i+1);
                }
            }
        }

    }
    static void spreadOp(int i,int j,int d){
        int ti = i; int tj= j;
        while(true) {
            int ni = ti + move[d][0];
            int nj = tj + move[d][1];
            if (!isPossible(ni, nj)) break;
            if (!visited[ni][nj]&&map[ni][nj]==0) {
                visited[ni][nj] = true;
                sum++;
            }
            ti = ni; tj = nj;
        }
    }
    static void calc(){
        sum  =0;
        visited = new boolean[N][M];
        for(int t=0;t<size;t++){
            Node node = list.get(t);
            int i = node.i; int j = node.j; int v = node.v;
           if(v==1){
                int d = tmp[t];
                spreadOp(i,j,d);

            }else if(v==2){
                if(tmp[t]==0){
                    for(int d=0;d<4;d+=2){
                        spreadOp(i,j,d);
                    }
                }else{
                    for(int d=1;d<4;d+=2){
                        spreadOp(i,j,d);
                    }
                }
            }
            else if(v==3){
                if(tmp[t]==0){
                    for(int d=0;d<2;d++){
                        spreadOp(i,j,d);
                    }
                }else if(tmp[t]==1){
                    for(int d=1;d<3;d++){
                        spreadOp(i,j,d);
                    }
                }else if(tmp[t]==2){
                    for(int d=2;d<4;d++){
                        spreadOp(i,j,d);
                    }
                }else{
                    spreadOp(i,j,3);
                    spreadOp(i,j,0);
                }
            }else if(v==4){
                if(tmp[t]==0){
                    for(int d=0;d<3;d++){
                        spreadOp(i,j,d);
                    }
                }else if(tmp[t]==1){
                    for(int d=1;d<4;d++){
                        spreadOp(i,j,d);
                    }
                }else if(tmp[t]==2){
                    for(int d=2;d<4;d++){
                        spreadOp(i,j,d);
                    }
                    spreadOp(i,j,0);
                }else{
                    spreadOp(i,j,3);
                    for(int d=0;d<2;d++){
                        spreadOp(i,j,d);
                    }
                }
            }else{
               for(int d=0;d<4;d++){
                   spreadOp(i,j,d);
               }
            }
        }
        total = Math.max(total,sum);
    }
    static boolean isPossible(int i,int j){
        if(i<0||j<0||N-1<i||M-1<j) return false;
        if(map[i][j]==6) return false;
        return true;
    }
}
