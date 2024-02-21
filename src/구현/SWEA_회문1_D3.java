package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA_회문1_D3 {
    static int[][]move = {{0,1},{1,0}};
    static char[]alpha;
    static char[][]map;
    static int len;
    static int ans;
    public static void main(String[] args) throws Exception {
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder();
        for(int t=1;t<11;t++){
            map = new char[8][8];
            ans = 0;
            len = Integer.parseInt(br.readLine());
            for(int i=0;i<8;i++) map[i] = br.readLine().toCharArray();
            alpha = new char[len];
            for(int i=0;i<8;i++){
                for(int j=0;j<8;j++){
                    dfs(i,j,0,0);
                    dfs(i,j,0,1);
                }
            }
            sb.append("#"+t+" "+ans+"\n");
        }
        System.out.println(sb.toString());
    }
    static void dfs(int i,int j,int depth,int d){
        alpha[depth] = map[i][j];
        if(depth==len-1){
            int L = 0; int R = len-1;
            while(L<R){
                if(alpha[L]!=alpha[R]) return;
                L++; R--;
            }
            ans++;
            return;
        }
            int ni = i + move[d][0];
            int nj = j + move[d][1];
            if(7<ni||7<nj) return;
            dfs(ni,nj,depth+1,d);
        }
    }

