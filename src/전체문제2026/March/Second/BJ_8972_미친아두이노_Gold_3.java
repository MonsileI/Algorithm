package 전체문제2026.March.Second;

import java.util.*;
import java.io.*;
public class BJ_8972_미친아두이노_Gold_3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int[][]move = {{},{1,-1},{1,0},{1,1},{0,-1},{0,0},{0,1},{-1,-1},{-1,0},{-1,1}};
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][]map = new char[N][M];
        Queue<int[]> q= new ArrayDeque<>();
        int si =0; int sj=0;
        for(int i=0;i<N;i++){
            String str = br.readLine();
            for(int j=0;j<M;j++){
                map[i][j] = str.charAt(j);
                if(map[i][j]=='R') q.offer(new int[]{i,j});
                if(map[i][j]=='I') {
                    si = i;
                    sj = j;
                    map[i][j] = '.';
                }
            }
        }
        String jongsu = br.readLine();
        int len = jongsu.length();
        int[]jongsuMove = new int[len];
        for(int i=0;i<len;i++) jongsuMove[i] = Integer.parseInt(jongsu.charAt(i)+"");
        int idx = 0;
        int[][]visited = null;
        OuterLoop:
        while(idx<len) {
            visited = new int[N][M];
            //종수 이동
            int ni = si + move[jongsuMove[idx]][0];
            int nj = sj + move[jongsuMove[idx]][1];
            idx++;
            //break 조건
            if(map[ni][nj]=='R') break;
            //종수 이동 갱신
            si = ni; sj = nj;
            //아두이노 이동
            int size = q.size();
            for (int t = 0; t < size; t++) {
                int []c = q.poll();
                int ci = c[0]; int cj = c[1];
                map[ci][cj] = '.';
                int gi = 0; int gj = 0;
                int diff = Integer.MAX_VALUE; //거리 차이
                for(int d=1;d<10;d++){
                    if(d==5) continue;
                    int ti = ci + move[d][0];
                    int tj = cj + move[d][1];
                    int tmpDiff = Math.abs(ti-si) + Math.abs(tj-sj);
                    if(tmpDiff<diff){
                        diff = tmpDiff;
                        gi = ti; gj = tj;
                    }
                }
                //조건 만족하면 break;
                if(gi==si && gj==sj) break OuterLoop;
                visited[gi][gj]++;
                //아두이노 위치 갱신
                q.offer(new int[]{gi,gj});
            }

            //아두이노 폭파시키기
            size = q.size();
            for(int t=0;t<size;t++){
                int[]c = q.poll();
                int i = c[0]; int j = c[1];
                //1이면, 다음 루프에서도 사용
                if(visited[i][j]==1) {
                    map[i][j] = 'R';
                    q.offer(new int[]{i,j});
                }
            }
        }
        if(idx!=len){
            System.out.println("kraj "+idx);
        }else{
            StringBuilder sb= new StringBuilder();
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    if(i==si&&j==sj){
                        sb.append("I");
                        continue;
                    }
                    sb.append(map[i][j]);
                }
                if(i==N-1) break;
                sb.append("\n");
            }
            System.out.println(sb.toString());
        }
    }
}
