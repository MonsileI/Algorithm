package 전체문제2026.March.Eighth;

import java.util.*;
import java.io.*;
public class BJ_19940_피자오븐_Gold_5  {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[] act = {60,10,-10,1,-1};
        while(0<TC){
            int num = Integer.parseInt(br.readLine());
            int firstNode = num/act[0];
            num %=  act[0];
            Queue<int[]> q= new ArrayDeque<>();
            q.offer(new int[]{0,firstNode,0,0,0,0});
            boolean[]visited = new boolean[61];
            visited[0] = true;
            int[]answer = new int[5];
            while(!q.isEmpty()){
                int[]c = q.poll();
                int goal = c[0];
                if(goal==num) {
                   for(int i=0;i<5;i++) {
                       answer[i] = c[i+1];
                   }
                    break;
                }
                for(int d=4;-1<d;d--){
                    int ng = goal + act[d];
                    if(-1<ng && ng<61){
                        switch (d){
                            case 0: q.offer(new int[]{ng,c[1]+1,c[2],c[3],c[4],c[5]});
                                break;
                            case 1: q.offer(new int[]{ng,c[1],c[2]+1,c[3],c[4],c[5]});
                                break;
                            case 2: q.offer(new int[]{ng,c[1],c[2],c[3]+1,c[4],c[5]});
                                break;
                            case 3: q.offer(new int[]{ng,c[1],c[2],c[3],c[4]+1,c[5]});
                                break;
                            case 4: q.offer(new int[]{ng,c[1],c[2],c[3],c[4],c[5]+1});
                                break;
                        }
                    }
                }

            }
            for(int i=0;i<5;i++){
                sb.append(answer[i]+" ");
            }
            sb.append("\n");
            TC--;
        }
        System.out.println(sb.toString());
    }
}
