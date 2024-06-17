package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_8911_거북이_Silver_3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[][]move=  {{-1,0},{0,1},{1,0},{0,-1}};
        for(int t=0;t<TC;t++){
            String str = br.readLine();
            int d = 0;
            int N = str.length();
            //가장 작은 x와 가장 큰 x
            int lx = 0; int rx=0; int ly=0; int ry = 0;
            int i = 0; int j =0;
            for(int o=0;o<N;o++){
                char ch = str.charAt(o);
                if(ch=='F'){
                     i += move[d][0]; j += move[d][1];
                }else if(ch=='B'){
                    i -= move[d][0]; j-= move[d][1];

                }else if(ch=='L') d = (d+3) % 4;
                else d = (d+1) % 4;

                lx = Math.min(lx,j);
                rx = Math.max(rx,j);
                ly = Math.min(ly,i);
                ry = Math.max(ry,i);
            }
            sb.append((rx-lx) * (ry-ly)+"\n");
        }
        System.out.println(sb.toString());
    }
}
