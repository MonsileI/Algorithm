package 전체문제2025.November.Eleventh;

import java.util.*;
import java.io.*;
public class BJ_2310_어드벤처게임_Gold_4 {

    static class Node {
        char condition;
        int cnt;


        public Node(char condition, int cnt) {
            this.condition = condition;
            this.cnt = cnt;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        String Yes = "Yes";
        String No = "No";

        while(true){
            int N = Integer.parseInt(br.readLine());
            if(N==0) break;
            int[]visited= new int[N+1];
            Node[] rooms = new Node[N+1];
            List<List<Integer>> list = new ArrayList<>();
            for(int i=0;i<N+1;i++) list.add(new ArrayList<>());
            for(int i=1;i<N+1;i++){
                st = new StringTokenizer(br.readLine()," ");
                char ch = st.nextToken().charAt(0);
                int cnt = Integer.parseInt(st.nextToken());
                rooms[i] = new Node(ch,cnt);
                while(true){
                    int next = Integer.parseInt(st.nextToken());
                    if(next==0) break;
                    list.get(i).add(next);
                }
            }
            int initCnt = 0;
            switch (rooms[1].condition){
                case 'T':
                    if(0 < rooms[1].cnt){
                        initCnt = -1;
                    }
                    break;
                case 'L':
                    initCnt += rooms[1].cnt;
                    break;
            }
            if(initCnt==-1){
                 sb.append(No+"\n");
                 continue;
            }
            Queue<int[]> q=  new ArrayDeque<>();
            q.offer(new int[]{1,initCnt});
            Arrays.fill(visited,Integer.MAX_VALUE);
            visited[1] = initCnt;
            boolean flag = false;
            while(!q.isEmpty()){
                int []cur = q.poll();
                int num = cur[0]; int cnt = cur[1];
                if(num==N){
                    flag = true;
                    break;
                }
                for(Integer next : list.get(num)){
                    //L 일때 충전
                    if(rooms[next].condition=='L'){
                        cnt = Math.max(cnt,rooms[next].cnt);
                    }
                    //T 일때 통행료 부과
                    if(rooms[next].condition=='T') {
                        // 돈 없으면 못감
                        if(cnt < rooms[next].cnt) {
                            continue;
                        }
                        cnt -= rooms[next].cnt;
                    }
                    if(visited[next] > cnt){
                        visited[next] = cnt;
                        q.offer(new int[]{next,cnt});
                    }
                }
            }
            sb.append(flag ? Yes : No);
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
