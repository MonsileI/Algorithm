package 전체문제.seven_month_2024_06.second_2024_06_04;

import java.util.*;
import java.io.*;
public class BJ_19237_어른상어_Gold_2 {
    static class Shark implements Comparable<Shark>{
        int num; int i;int j; int d; int[][]prior;

        public Shark(int num, int i, int j,int d, int[][] prior) {
            this.num = num;
            this.i = i;
            this.j = j;
            this.d = d;
            this.prior = prior;
        }

        @Override
        public int compareTo(Shark o) {
            return num - o.num;
        }
    }
    static int[][]move = {{-1,0},{1,0},{0,-1},{0,1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][][]map = new int[N][N][2];
        List<Shark> list = new ArrayList<>();
        Queue<int[]> q=  new ArrayDeque<>();
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<N;j++){
                map[i][j][0] = Integer.parseInt(st.nextToken());
                if(map[i][j][0]!=0){
                    Shark shark = new Shark(map[i][j][0],i,j,0,new int[4][4]);
                    list.add(shark);
                    map[i][j][1] = K;
                    q.offer(new int[]{i,j,K});
                }
            }
        }

        Collections.sort(list);
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<M;i++) list.get(i).d = Integer.parseInt(st.nextToken())-1;
        for(int i=0;i<M;i++){
            for(int d=0;d<4;d++){
                st = new StringTokenizer(br.readLine()," ");
                for(int dd=0;dd<4;dd++){
                    list.get(i).prior[d][dd] = Integer.parseInt(st.nextToken())-1;
                }
            }
        }
        int t = 1;
        List<Integer> delete = new ArrayList<>();
        while(true){
            delete = new ArrayList<>();
            boolean[][]visited = new boolean[N][N];
            OuterLoop:
            for(int tc=0;tc<list.size();tc++){
                Shark shark = list.get(tc);
                int[]P = shark.prior[shark.d];
                int i = shark.i; int j = shark.j;
                //인접한 칸 중 아무 냄새 없는 칸으로 잡음
                for(int d=0;d<4;d++){
                    int ni = i + move[P[d]][0];
                    int nj = j + move[P[d]][1];
                    if(ni<0||nj<0||N-1<ni||N-1<nj) continue;
                    if(visited[ni][nj]) {
                        delete.add(tc);
                        continue OuterLoop;
                    }
                    if(map[ni][nj][0]!=0) continue;
                    visited[ni][nj] = true;
                    map[ni][nj][0] = shark.num;
                    map[ni][nj][1] = t+K;
                    shark.i = ni; shark.j = nj;
                    shark.d = P[d];
                    q.offer(new int[]{ni,nj,t+K});
                    continue OuterLoop;
                }
                //그런 칸이 없으면 자신의 냄새가 있는 칸으로 잡음
                //벽이면은 돌아서기, 남 냄새라도 돌아서기
                int ni = shark.i + move[shark.d][0];
                int nj = shark.j + move[shark.d][1];
                int d = shark.d;
                if(ni<0||nj<0||N-1<ni||N-1<nj){
                    if(d==0) d=1;
                    else if(d==1) d=0;
                    else if(d==2) d=3;
                    else d=2;
                    ni = shark.i + move[d][0];
                    nj = shark.j + move[d][1];
                }else{
                    if(map[ni][nj][0]!=shark.num){
                        if(d==0) d=1;
                        else if(d==1) d=0;
                        else if(d==2) d=3;
                        else d=2;
                        ni = shark.i + move[d][0];
                        nj = shark.j + move[d][1];
                    }
                }
                shark.i = ni; shark.j = nj; shark.d = d;
                map[shark.i][shark.j][1] = t+K;
                q.offer(new int[]{shark.i,shark.j,t+K});
            }
            for(int i : delete) list.remove(i);
            //q처리
            if(!q.isEmpty() && q.peek()[2]==t){
                while(true){
                    if(q.peek()[2]!=t) break;
                    int[]c = q.poll();
                    if(map[c[0]][c[1]][1]==t) {
                        map[c[0]][c[1]][0] = 0;
                        map[c[0]][c[1]][1] = 0;
                    }
                }
            }
            if(t>1000) break;
            if(list.size()==1) break;
            t++;
        }
        System.out.println(t==1001 ? -1 : t);

    }
}
