package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class GR_GameJam_Level_3 {

    static class Node{
        int move; int dir;

        public Node(int move, int dir) {
            this.move = move;
            this.dir = dir;
        }
    }
    static int N;
    static Node[][]map;
    static int [][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new Node[N][N];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int gi = Integer.parseInt(st.nextToken())-1;
        int gj = Integer.parseInt(st.nextToken())-1;
        st=  new StringTokenizer(br.readLine()," ");
        int pi = Integer.parseInt(st.nextToken())-1;
        int pj = Integer.parseInt(st.nextToken())-1;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<N;j++){
                String str = st.nextToken();
                char ch = str.charAt(str.length()-1);
                int move = Integer.parseInt(str.substring(0,str.length()-1));
                switch (ch){
                    case 'U': map[i][j] = new Node(move,0);
                        break;
                    case 'R': map[i][j] = new Node(move,1);
                        break;
                    case 'D': map[i][j] = new Node(move,2);
                        break;
                    case 'L': map[i][j] = new Node(move,3);
                        break;
                }
            }
        }
        int a = calc(gi,gj);
        int b = calc(pi,pj);
        if(a>b) System.out.println("goorm "+a);
        else System.out.println("player "+b);
    }
    static int calc(int si, int sj){
        int cnt = 1;
        boolean[][]visited = new boolean[N][N];
        visited[si][sj] = true;
        OuterLoop:
        while(true){
            int d = map[si][sj].dir;
            int m = map[si][sj].move;
            for(int i=0;i<m;i++) {
                int ni = si + move[d][0];
                int nj = sj + move[d][1];
                if(ni<0) ni = N-1;
                if(nj<0) nj = N-1;
                if(ni>N-1) ni = 0;
                if(nj>N-1) nj = 0;
                if(visited[ni][nj]) break OuterLoop;
                visited[ni][nj] = true;
                cnt++;
                si = ni; sj = nj;
            }
        }
        return cnt;
    }
}
