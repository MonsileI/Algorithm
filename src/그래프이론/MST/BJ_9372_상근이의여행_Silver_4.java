package 그래프이론.MST;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_9372_상근이의여행_Silver_4 {

    static int N;
    static List<List<Integer>> list;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb= new StringBuilder();
        StringTokenizer st = null;
        for(int t=0;t<TC;t++){
            st =new StringTokenizer(br.readLine()," ");
            N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            sb.append(N-1+"\n");
            for(int i=0;i<M;i++) br.readLine();
        }
        System.out.println(sb.toString());

    }
}
