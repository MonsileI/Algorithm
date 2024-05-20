package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_20165_인내의도미노장인호석_Gold_5 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int[][]map  =new int[N][M];
        int[][]move=  {{-1,0},{0,1},{1,0},{0,-1}};
        boolean[][]falled = new boolean[N][M];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());

            }
        }
        int score = 0;
        while(0<R){
            st = new StringTokenizer(br.readLine()," ");
            int i = Integer.parseInt(st.nextToken()) -1;
            int j = Integer.parseInt(st.nextToken()) -1;
            char tmp = st.nextToken().charAt(0);
            int d = 0;
            switch (tmp){
                case 'E' : d=1;
                break;
                case 'S' : d=2;
                break;
                case 'W' : d=3;
                break;
            }
            int num = map[i][j];
            if(falled[i][j]) continue;
            falled[i][j] = true;
            score++;
            while(true) {
                num--;
                if(num<=0) break;
                i += move[d][0]; j += move[d][1];
                if(i<0||j<0||N-1<i||M-1<j) break;
                if(!falled[i][j]){
                    score++;
                    num = Math.max(num,map[i][j]);
                    falled[i][j] = true;
                }
            }
            st = new StringTokenizer(br.readLine()," ");
            i = Integer.parseInt(st.nextToken())-1;
            j = Integer.parseInt(st.nextToken())-1;
            falled[i][j] = false;
            R--;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(score+"\n");
        for(int y=0;y<N;y++){
            for(int x=0;x<M;x++){
                sb.append(falled[y][x] ? "F " : "S " );
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
