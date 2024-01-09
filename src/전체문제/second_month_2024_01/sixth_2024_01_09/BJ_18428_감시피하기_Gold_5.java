package 전체문제.second_month_2024_01.sixth_2024_01_09;
import java.util.*;
import java.io.*;
public class BJ_18428_감시피하기_Gold_5 {
    static int N;
    static char[][]map;
    static List<int[]> wallList;
    static List<int[]> tList;
    static int[]tmp;
    static int size;
    static boolean flag;
    static int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        wallList = new ArrayList<>();
        tList = new ArrayList<>();
        StringTokenizer st = null;

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<N;j++){
                map[i][j] = st.nextToken().charAt(0);
                if(map[i][j]=='T') tList.add(new int[]{i,j});
                if(map[i][j]=='X') wallList.add(new int[]{i,j});
            }
        }
        size = wallList.size();
        tmp = new int[3];
        comb(0,0);
        System.out.println(flag ? "YES" : "NO");
    }

    static void calc(){
        char[][]copyMap = new char[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                copyMap[i][j] = map[i][j];
            }
        }
        for(int i=0;i<3;i++){
            int[]c = wallList.get(tmp[i]);
            copyMap[c[0]][c[1]] = 'O';
        }
        int tSize = tList.size();

        for(int t=0;t<tSize;t++){
            int[]c = tList.get(t);
            int i = c[0]; int j = c[1];
            for(int d=0;d<4;d++){
                int tmpI = i; int tmpJ = j;
                InnerLoop:
                while(true){
                    int ni = tmpI + move[d][0];
                    int nj = tmpJ + move[d][1];
                    if(ni<0||nj<0||N-1<ni||N-1<nj) break;
                    if(copyMap[ni][nj]=='O'||copyMap[ni][nj]=='T') break InnerLoop;
                    if(copyMap[ni][nj]=='S') return;
                    tmpI = ni; tmpJ = nj;
                }
            }
        }
        flag = true;
    }

    static void comb(int depth,int start){
        if(flag) return;
        if(depth==3){
            calc();
            return;
        }

        for(int i=start;i<size;i++){
            tmp[depth] = i;
            comb(depth+1,i+1);
        }
    }
}
