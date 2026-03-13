package 전체문제2026.March.Eighth;

import java.util.*;
import java.io.*;
public class BJ_1963_소수경로_Gold_4 {
    static Set<Integer> prime;
    static int answer;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        prime = new HashSet<>();
        for(int i=1000;i<10000;i++){
            boolean flag = true;
            for(int j=2;j<=Math.sqrt(i);j++){
                if(i%j==0){
                    flag=  false;
                    break;
                }
            }
            if(flag) prime.add(i);
        }
        StringTokenizer st = null;
        StringBuilder sb= new StringBuilder();
        while(0<TC){
            answer = Integer.MAX_VALUE;
            st = new StringTokenizer(br.readLine()," ");
            int f = Integer.parseInt(st.nextToken());
            int s =  Integer.parseInt(st.nextToken());
            Queue<int[]> q= new ArrayDeque<>();
            boolean[]visited = new boolean[10000];
            visited[f] = true;
            q.offer(new int[]{f,0});
            while(!q.isEmpty()) {
                int[] c = q.poll();
                int num = c[0];
                int cnt = c[1];
                if(num==s){
                    answer = cnt;
                    break;
                }
                char[]origin = String.valueOf(num).toCharArray();
                char[]arr = String.valueOf(num).toCharArray();

                for(int i=0;i<4;i++){
                    for(int j=0;j<10;j++){
                        if(i==0 && j==0) continue;
                        arr[i] = (char)(j + '0');
                        int next = Integer.parseInt(new String(arr));
                        if(visited[next]){
                            arr[i] = origin[i];
                            continue;
                        }
                        if(prime.contains(next) && !visited[next]) {
                            visited[next] = true;
                            q.offer(new int[]{next,cnt+1});
                        }
                        arr[i] = origin[i];
                    }
                }
            }
            sb.append(answer==Integer.MAX_VALUE ? "Impossible" : answer);
            sb.append("\n");
            TC--;
        }
        System.out.println(sb.toString());
    }
}
