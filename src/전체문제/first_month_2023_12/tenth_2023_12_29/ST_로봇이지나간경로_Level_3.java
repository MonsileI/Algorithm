package 전체문제.first_month_2023_12.tenth_2023_12_29;
import java.util.*;
import java.io.*;
public class ST_로봇이지나간경로_Level_3 {
    static int N,M;
    static char[][]map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine()," ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        boolean[][]visited = new boolean[N][M];
        int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
        char[] dirShape = {'^','>','v','<'};
        int sum = 0;
        //input
        for(int i=0;i<N;i++){
            String str =br.readLine();
            for(int j=0;j<M;j++){
                map[i][j] = str.charAt(j);
                if(map[i][j]=='#')sum++;
            }
        }
        //출발지 선정 , 한 개인 경우, 두 개인 경우
        int si =0;int sj=0;
        OuterLoop:
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j]=='.') continue;
                int tmp = 0;
                for(int d=0;d<4;d++){
                    int ni = i + move[d][0]; int nj= j + move[d][1];
                    if(!rangeCheck(ni,nj))continue;
                    if(map[ni][nj]=='#')tmp++;
                }
                if(tmp==1){
                    si = i; sj = j;
                    break OuterLoop;
                }else if(tmp==2){
                    si = i; sj = j;
                }
            }
        }
        visited[si][sj] = true;
        sum--;
        StringBuilder sb = new StringBuilder();
        sb.append((si+1)+" "+(sj+1)+"\n");
        int dir = 0;
        for(int d=0;d<4;d++){
            int ni = si + move[d][0]; int nj = sj+move[d][1];
            if(!rangeCheck(ni,nj)) continue;
            if(map[ni][nj]=='#') {
                dir = d;
                break;
            }
        }
        sb.append(dirShape[dir]+"\n");

        while(-1<sum){
            for(int d=0;d<4;d++){
                //더해서 짝수면, 반대 방향이라 안됨
                if(d!=dir && (d+dir)%2==0)continue;

                int ni = si + move[d][0]; int nj = sj + move[d][1];
                if(!rangeCheck(ni,nj)||map[ni][nj]=='.') continue;
                if(visited[ni][nj]) continue;
                int nni = ni + move[d][0]; int nnj= nj + move[d][1];
                if(!rangeCheck(nni,nnj)||map[nni][nnj]=='.') continue;
                if(visited[nni][nnj]) continue;
                visited[ni][nj] = true; visited[nni][nnj] = true;
                if(d!=dir){
                    if(dir==0&&d==3)sb.append('L');
                    else if(dir==3&&d==0)sb.append('R');
                    else{
                        if(dir<d) sb.append('R');
                        else sb.append('L');
                    }
                    dir = d;
                }
                sb.append('A');
                si = nni; sj = nnj;
                break;
            }
            sum -= 2;
        }
        System.out.println(sb.toString());
    }
    static boolean rangeCheck(int i,int j){
        if(i<0||j<0||N-1<i||M-1<j)return false;
        return true;
    }
}
