package 전체문제2026.October.Seventh;

import java.util.*;
import java.io.*;
public class SWEA_5650_핀볼게임 {
    static int N;
    static int[][]map;
    static int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    static int[][]changeMove = {{2,3,1,0},
            {1,3,0,2},
            {3,2,0,1},
            {2,0,3,1},
            {2,3,0,1}};

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int TC = sc.nextInt();
        for(int t=1;t<=TC;t++){
            N = sc.nextInt();
            Queue<int[]> q= new ArrayDeque<>();
            List<int[][]> warmHole = new ArrayList<>();
            map = new int[N][N];
            for(int i=0;i<=10;i++) warmHole.add(new int[][]{{-1},{-1}});
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    map[i][j] = sc.nextInt();
                    if(map[i][j]==0){
                        for(int d=0;d<4;d++){
                            q.offer(new int[]{i,j,i,j,d}); //출발 위치로 돌아오거나, 블랙홀에 빠지면 ㅈㅈ
                        }
                    }
                    if(6<=map[i][j]){
                        if(warmHole.get(map[i][j])[0][0]==-1){
                            warmHole.get(map[i][j])[0] = new int[]{i,j};
                        }else{
                            warmHole.get(map[i][j])[1] = new int[]{i,j};
                        }
                    }
                }
            }
            int answer = 0;
            while(!q.isEmpty()){
                int[] c = q.poll();
                int oi =c[0]; int oj = c[1]; int i = c[2]; int j = c[3]; int d = c[4];
                int cnt = 0;
                boolean isFirst = true;
                while(true){
                    if((oi==i && oj==j) && !isFirst) break;
                    isFirst = false;
                    i += move[d][0];
                    j += move[d][1];
                    if(i<0||j<0||N-1<i||N-1<j){
                        //원복
                        i -= move[d][0];
                        j -= move[d][1];
                        cnt++;
                        d = changeMove[4][d];
                    }
                    //암것도 없음
                    if(map[i][j]==0) continue;

                    if(map[i][j]==-1) break;

                    if(map[i][j]<=5){
                        cnt++;
                        int tmpNum = map[i][j] - 1;
                        d = changeMove[tmpNum][d]; //원래 d에서 바뀜 //다음 loop에서 알아서 이동할거임
                        continue;
                    }
                    //무조건 여기 걸리지만(continue 때문에) 명시적으로 해야되니까.. 느낌 알지?
                    if(6<=map[i][j]){
                        int[][]warm = warmHole.get(map[i][j]);
                        if(i==warm[0][0] && j==warm[0][1]){
                            i = warm[1][0];
                            j = warm[1][1];
                        }else{
                            i = warm[0][0];
                            j = warm[0][1];
                        }
                    }
                }
                answer = Math.max(answer,cnt);
            }
            sb.append("#"+t+" "+answer+"\n");
        }
        System.out.println(sb.toString());
    }
}
