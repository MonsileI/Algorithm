package 전체문제2026.January.Third;

import java.util.*;
import java.io.*;
public class BJ_14226_이모티콘_Gold_4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<int[]> q= new ArrayDeque<>();
        //대쉬보드 , 화면 , 초
        q.offer(new int[]{0,1,0});
        int[][]dist = new int[1200][1200]; //해당하는 개수, 화면에 달하는 초 수
        int answer = 0;
        for(int i=0;i<1200;i++) Arrays.fill(dist[i],987654321);
        while(!q.isEmpty()){
            int[]c = q.poll();
            int board = c[0]; int window = c[1]; int second = c[2];
            if(window==N){
                answer = second;
                break;
            }
            // 대쉬보드 복사
            if(dist[window][window] > second+1){
                dist[window][window] = second+1;
                q.offer(new int[]{window,window,second+1});
            }
            // 화면에 붙여넣기
            if(window+board < 1200) {
                if (dist[board][window + board] > second + 1) {
                    dist[board][window+board] = second+1;
                    q.offer(new int[]{board, window + board, second + 1});
                }
            }
            //하나 지우기
            if(0<window) {
                if (dist[board][window - 1] > second + 1) {
                    dist[board][window - 1] = second + 1;
                    q.offer(new int[]{board, window - 1, second + 1});
                }
            }
        }
        System.out.println(answer);
    }
}
