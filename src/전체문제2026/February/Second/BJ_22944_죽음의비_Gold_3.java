package 전체문제2026.February.Second;

import java.util.*;
import java.io.*;
public class BJ_22944_죽음의비_Gold_3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken()); //현재 체력
        int D = Integer.parseInt(st.nextToken()); //우산 내구도
        int si = 0; int sj = 0; int ei =0; int ej=0;
        List<int[]> umbrella = new ArrayList<>();
        for(int i=0;i<N;i++){
            String str = br.readLine();
            for(int j=0;j<N;j++){
                char ch = str.charAt(j);
                switch(ch){
                    case 'S':
                        si = i;
                        sj = j;
                    break;
                    case 'E':
                        ei = i;
                        ej = j;
                    break;
                    case 'U':
                        umbrella.add(new int[]{i,j});
                    break;
                }
            }
        }
        Queue<int[]> q= new ArrayDeque<>();
        q.offer(new int[]{si,sj,0,H,0}); //위치(i,j) , cnt , 체력, 우산 내구도
        int answer = Integer.MAX_VALUE;
        int[][] visited = new int[N][N];
        for(int i=0;i<N;i++)Arrays.fill(visited[i],-1);
        visited[si][sj] = H;
        while(!q.isEmpty()){
            int [] c = q.poll();
            int i = c[0]; int j = c[1]; int cnt = c[2]; int health = c[3]; int um = c[4];
            int range = Math.abs(i-ei)+Math.abs(j-ej); //끝 지점까지 거리
            if(answer<=cnt) continue;
            if(range<=(health+um)){
                answer = Math.min(answer, cnt+range);
            }
            for(int[] u : umbrella){
                int ni = u[0]; int nj = u[1];
                int rangeUm = Math.abs(i-ni) + Math.abs(j-nj);
                int power = um+health;
                if(power < rangeUm) continue;
                if(rangeUm<um) {
                    if(health +D <=visited[ni][nj]) continue;
                    visited[ni][nj] = health+D;
                    q.offer(new int[]{ni,nj,cnt+rangeUm,health,D}); //새로운 우산 + 체력 그대로
                }else{
                    if(health-(rangeUm-um) <= visited[ni][nj]) continue;
                    visited[ni][nj] = health-(rangeUm-um);
                    q.offer(new int[]{ni,nj,cnt+rangeUm,health-(rangeUm-um),D}); //새로운 우산 + 체력 마이너스
                }
            }
        }
        System.out.println(answer==Integer.MAX_VALUE ? -1 : answer);

    }
}
