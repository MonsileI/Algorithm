package 전체문제.fifth_month_2023_04.eleventh_2024_04_17;

import java.util.*;
import java.io.*;
public class BJ_1063_킹_Silver_3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        String k = st.nextToken();
        String r = st.nextToken();

        int[][]move = {{1,0},{0,1},{-1,0},{0,-1},{1,1},{-1,1},{-1,-1},{1,-1}};
        String[]dir = {"T","R","B","L","RT","RB","LB","LT"};
        Map<String,Integer> map = new HashMap<>();
        for(int i=0;i<8;i++) map.put(dir[i],i);

        int[]king = new int[2]; int[] rock = new int[2];
        int ki = Integer.parseInt(k.charAt(1)+"")%9;
        int kj = k.charAt(0) - 'A'+ 1;

        int ri = Integer.parseInt(r.charAt(1)+"")%9;
        int rj = r.charAt(0) - 'A'+ 1;
        int N = Integer.parseInt(st.nextToken());
        for(int i=0;i<N;i++){
            String act = br.readLine();
            int d = map.get(act);
            int ni = ki + move[d][0];
            int nj = kj + move[d][1];
            if(ni<1||nj<1||8<ni||8<nj) continue;
            if(ni==ri && nj==rj){
                int nni = ri  + move[d][0];
                int nnj = rj +  move[d][1];
                if(nni<1||nnj<1||8<nni||8<nnj) continue;
                ri = nni; rj = nnj;
            }
            ki = ni; kj = nj;
        }
        String alpha = "ZABCDEFGH";
        System.out.println(alpha.charAt(kj)+""+ki);
        System.out.println(alpha.charAt(rj)+""+ri);

    }
}
