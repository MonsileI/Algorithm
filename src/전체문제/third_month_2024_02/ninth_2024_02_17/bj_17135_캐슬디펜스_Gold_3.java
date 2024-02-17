package 전체문제.third_month_2024_02.ninth_2024_02_17;
import java.util.*;
import java.io.*;
public class bj_17135_캐슬디펜스_Gold_3 {
    static int N,M,R;
    static int [] tmp;
    static int ans = 0;
    static int [][] map;
    static int sum;
    static List<int[]> list;
    public static void main(String[] args) throws Exception {
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        list = new ArrayList<>();
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==1) {
                    sum++;
                    list.add(new int[]{i,j});
                }
            }
        }
        tmp = new int[3];
        comb(0,0);
        System.out.println(ans);
    }
    static void calc(){
        int cnt = 0; //무조건 3명만 배치. //처음에 잡아먹고, 적들이 다가옴
        boolean[]visited = new boolean[sum]; //적
        int enermy = sum;
        int[][]copyList = new int[sum][2];
        for(int i =0; i<sum;i++) {
            copyList[i][0] = list.get(i)[0];
            copyList[i][1] = list.get(i)[1];
        }
        while(true){
            if(enermy==0) break;
            int[]idx = new int[3];
            for(int i=0;i<3;i++)idx[i] = -1;
            for(int i=0;i<3;i++) {
                int min = 987654321;
                int minJ = 987654321;
                for (int j=0;j<sum;j++) {
                    if(visited[j]) continue;
                    if (copyList[j][0]>N-1){
                        enermy--;
                        visited[j] = true;
                        continue;
                    }
                    int range = (N-copyList[j][0]) + Math.abs(copyList[j][1]-tmp[i]);
                    if(range<=R){
                        if(min>=range){
                            if(min==range){
                                if(copyList[j][1]<minJ){
                                    minJ =copyList[j][1];
                                    idx[i] = j;
                                }
                            }else{
                                min = range;
                                minJ = copyList[j][1];
                                idx[i] = j;
                            }
                        }
                    }
                    if(i==2) copyList[j][0]++;
                }
            }
            for(int i=0;i<3;i++){
                if(idx[i]!=-1 && !visited[idx[i]]){
                    cnt++;
                    enermy--;
                    visited[idx[i]] = true;
                }
            }
        }
        ans = Math.max(ans,cnt);

    }
    static void comb(int depth,int start){
        if(depth==3){
            calc();
            return;
        }
        for(int i=start;i<M;i++){
            tmp[depth] = i;
            comb(depth+1,i+1);
        }
    }
}
