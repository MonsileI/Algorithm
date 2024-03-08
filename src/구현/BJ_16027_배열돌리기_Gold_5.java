package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class BJ_16027_배열돌리기_Gold_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int[][]map = new int[N][M];
        int[][]answer = new int[N][M];
        for(int i=0;i<N;i++){
            st= new StringTokenizer(br.readLine()," ");
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int depth = 0;
        int min = Math.min(N,M);
        int minus = 0;

        while(true){
            int size = ((N-minus)*2)+((M-minus)*2)-4;
            int[]tmp = new int[size];
            int idx = 0;
            //위
            for(int j=depth;j<M-depth;j++){
                tmp[idx++] = map[depth][j];
            }
            //오
            for(int i=depth+1;i<N-depth;i++){
                tmp[idx++] = map[i][M-depth-1];
            }
            //아래
            for(int j=M-depth-2;depth-1<j;j--){
                tmp[idx++] = map[N-depth-1][j];
            }
            //왼
            for(int i=N-depth-2;depth<i;i--){
                tmp[idx++] = map[i][depth];
            }
            int turn = (R%size);
            for(int t=0;t<turn;t++){
                int tNum = tmp[0];
                for(int i=0;i<size-1;i++){
                    tmp[i] = tmp[i+1];
                }
                tmp[size-1] = tNum;
            }
            //위
            idx = 0;
            for(int j=depth;j<M-depth;j++){
                answer[depth][j] = tmp[idx++];
            }
            //오
            for(int i=depth+1;i<N-depth;i++){
                answer[i][M-depth-1] = tmp[idx++];
            }
            //아래
            for(int j=M-depth-2;depth-1<j;j--){
                answer[N-depth-1][j] = tmp[idx++];
            }
            //왼
            for(int i=N-depth-2;depth<i;i--){
                answer[i][depth] = tmp[idx++];
            }

            depth++;
            minus += 2;
            if(min<=minus) break;
        }
        StringBuilder sb= new StringBuilder();
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                sb.append(answer[i][j]+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
