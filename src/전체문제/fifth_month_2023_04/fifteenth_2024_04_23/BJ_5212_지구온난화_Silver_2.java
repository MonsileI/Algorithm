package 전체문제.fifth_month_2023_04.fifteenth_2024_04_23;
import java.util.*;
import java.io.*;
public class BJ_5212_지구온난화_Silver_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][]map = new char[N+2][M+2];
        char[][]origin = new char[N+2][M+2];
        for(int i=0;i<N+2;i++) {
            map[i][0] = '.';
            map[i][M+1] = '.';
            origin[i][0] = '.';
            origin[i][M+1] = '.';
        }
        for(int j=0;j<M+2;j++){
            map[0][j] = '.';
            map[N+1][j] = '.';
            origin[0][j] = '.';
            origin[N+1][j] = '.';
        }

        for(int i=1;i<N+1;i++) {
            String str = br.readLine();
            int idx = 0;
            for(int j=1;j<M+1;j++){
                char ch = str.charAt(idx++);
                map[i][j] = ch;
                origin[i][j] = ch;
            }
        }

        int fi = 11; int fj = 11; //왼쪽과 위 //작은값
        int si = 0; int sj = 0; //오른쪽과 아래 //큰값
        int cnt = 0;
        int [][]dir = {{-1,0},{0,1},{1,0},{0,-1}};
        for(int i=1;i<N+1;i++){
            for(int j=1;j<M+1;j++){
                if(map[i][j]=='X'){
                    cnt = 0;
                    InnerLoop:
                    for(int d=0;d<4;d++){
                        int ni = i + dir[d][0];
                        int nj = j + dir[d][1];
                        if(ni<0||nj<0||N+1<ni||M+1<nj||origin[ni][nj]=='X') continue;
                        if(origin[ni][nj]=='.') cnt++;
                        if(2<cnt) {
                            map[i][j] ='.';
                            break InnerLoop;}
                    }
                    if(cnt<3){
                        fi = Math.min(fi,i); fj = Math.min(fj,j);
                        si = Math.max(si,i); sj = Math.max(sj,j);
                    }
                }
            }
        }
        char[][]answer = new char[si-fi+1][sj-fj+1];
        int idx = 0; int jdx = 0;
        for(int i=fi;i<=si;i++){
            for(int j=fj;j<=sj;j++){
                answer[idx][jdx++] = map[i][j];
            }
            idx++;
            jdx =0;
        }
        N = answer.length;
        M = answer[0].length;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                sb.append(answer[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
