package 전체문제2026.November.First;
import java.util.*;
import java.io.*;
public class SWEA_1873_상호의배틀필드_D3 {
    static int N,M;
    static char[][]map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb= new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        int[][]move=  {{-1,0},{0,1},{1,0},{0,-1}};
        for(int t=1;t<=TC;t++){
            st= new StringTokenizer(br.readLine()," ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            map = new char[N][M];
            int ci = 0; int cj = 0; int d= 0;
            for(int i=0;i<N;i++){
                String str = br.readLine();
                for(int j=0;j<M;j++){
                    map[i][j] = str.charAt(j);
                    if(map[i][j]!='.' && map[i][j]!='*' && map[i][j]!='#' && map[i][j]!='-'){
                        ci = i ; cj  = j;
                        char tmp = '*';
                        switch (map[i][j]){
                            case '^' : tmp = 'U';
                            break;
                            case '>' : tmp = 'R';
                            break;
                            case 'v' : tmp = 'D';
                            break;
                            case '<' : tmp = 'L';
                            break;
                        }
                        d = changeTurn(tmp);
                        map[i][j] = '.';
                    }
                }
            }
            int Q = Integer.parseInt(br.readLine());
            String Query = br.readLine();
            for(int i=0;i<Q;i++){
                char ch = Query.charAt(i);
                if(ch=='S'){
                    int ni = ci;
                    int nj = cj;
                    while(true){
                        ni += move[d][0];
                        nj += move[d][1];
                        if(!checkRange(ni,nj)) break;
                        if(map[ni][nj]=='*'){
                            map[ni][nj] = '.';
                            break;
                        }
                        if(map[ni][nj]=='#'){
                            break;
                        }
                    }
                }else{
                    d = changeTurn(ch);
                    int ni = ci + move[d][0];
                    int nj = cj + move[d][1];
                    if(!checkRange(ni,nj)) continue;
                    if(map[ni][nj]=='.') {
                        ci = ni;
                        cj = nj;
                    }
                }
            }
            sb.append("#"+t+" ");
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    if(i==ci && j==cj){
                        switch (d){
                            case 0: sb.append("^");
                            break;
                            case 1 : sb.append(">");
                            break;
                            case 2 : sb.append("v");
                            break;
                            case 3 : sb.append("<");
                            break;
                        }
                        continue;
                    }
                    sb.append(map[i][j]);
                }
                sb.append("\n");
            }

        }
        System.out.println(sb.toString());
    }
    static boolean checkRange(int i, int j){
        if(i<0||j<0||N-1<i||M-1<j) return false;
        return true;
    }
    static int changeTurn(char ch ){
        int d= -1;
        switch (ch){
            case 'U': d = 0;
                break;
            case 'R' : d= 1;
                break;
            case 'D' : d= 2;
                break;
            case 'L' : d= 3;
                break;
        }
        return d;
    }
}
