package 전체문제2026.May.Fourth;

import java.util.*;
import java.io.*;
public class SWEA_22979_문자열옮기기_D3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb=  new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        while(0<TC){
            String str = br.readLine();
            int len = str.length();
            int N = Integer.parseInt(br.readLine());
            int[]arr = new int[N];
            st = new StringTokenizer(br.readLine()," ");
            for(int i=0;i<N;i++)arr[i] = Integer.parseInt(st.nextToken());
            Deque<Character> q = new ArrayDeque<>();
            for(int i=0;i<len;i++) q.offer(str.charAt(i));
            for(int t=0;t<N;t++){
                int act = arr[t];
                if(act==0) continue;
                act = act % len;
                if(0<act){
                    for(int i=0;i<act;i++){
                        char ch = q.pollFirst();
                        q.offerLast(ch);
                    }
                }else{
                    act *= -1;
                    for(int i=0;i<act;i++){
                        char ch = q.pollLast();
                        q.offerFirst(ch);
                    }
                }
            }
            while(!q.isEmpty()){
                sb.append(q.poll());
            }
            sb.append("\n");
            TC--;
        }
        System.out.println(sb.toString());
    }
}
