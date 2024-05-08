package 완전탐색.BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_13913_숨바꼭질4_Gold_4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int subin = Integer.parseInt(st.nextToken());
        int bro = Integer.parseInt(st.nextToken());
        Queue<int[]> q= new ArrayDeque<>();
        int[]visited = new int[100001];
        int[]p = new int[100001];
        visited[subin] = 1;
        q.offer(new int[]{subin,0});
        p[subin] = subin;
        StringBuilder sb= new StringBuilder();
        while(!q.isEmpty()){
            int[]c = q.poll();
            int pos = c[0];
            int cnt = c[1];
            if(pos==bro){
                sb.append(cnt+"\n");
                break;
            }
            int np = pos+1;
            if(np<100001 && visited[np]==0){
                visited[np] = cnt+1;
                p[np] = pos;
                q.offer(new int[]{np,cnt+1});
            }
            np = pos-1;
            if(-1<np && visited[np]==0){
                visited[np] = cnt+1;
                p[np] = pos;
                q.offer(new int[]{np,cnt+1});
            }
            np = pos*2;
            if(np<100001 && visited[np]==0){
                visited[np] = cnt+1;
                p[np] = pos;
                q.offer(new int[]{np,cnt+1});
            }
        }
        Stack<Integer> stack = new Stack<>();
        while(subin!=bro){
            stack.push(bro);
            bro = p[bro];
        }
        sb.append(subin+" ");
        while(!stack.isEmpty()) sb.append(stack.pop()+" ");
        System.out.println(sb.toString());
    }
}
