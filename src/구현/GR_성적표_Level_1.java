package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GR_성적표_Level_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        double[][]arr = new double[M+1][2];
        for(int i=0;i<N;i++){
            st= new StringTokenizer(br.readLine()," ");
            int num = Integer.parseInt(st.nextToken());
            int score = Integer.parseInt(st.nextToken());
            arr[num][0]++;
            arr[num][1] += score;
        }
        double max = 0;
        int answer = 0;
        for(int i=1;i<M+1;i++){
            if(arr[i][0]==0) continue;
            if(max<(arr[i][1]/arr[i][0])){
                max = (arr[i][1]/arr[i][0]);
                answer = i;
            }
        }
        System.out.println(answer);
    }
}
