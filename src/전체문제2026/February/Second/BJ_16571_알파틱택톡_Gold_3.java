package 전체문제2026.February.Second;

import java.util.*;
import java.io.*;
public class BJ_16571_알파틱택톡_Gold_3 {
    static int [][]map;
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = 3;
        map = new int[N][N];
        int firCnt = 0;
        int secCnt = 0;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==1) firCnt++;
                if(map[i][j]==2) secCnt++;
            }
        }
        int answer = -1;
        if(secCnt<firCnt){
            //2번 차례
            answer = dfs(2);
        }else{
            //1번 차례(항상 선공)
            answer = dfs(1);
        }
        if(answer==1) System.out.println('W');
        if(answer==-1) System.out.println('L');
        if(answer==0) System.out.println("D");
    }
    static int dfs(int node){
        int best = -1;
        boolean hasEmpty = false;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(map[i][j]==0){
                    hasEmpty = true;
                    map[i][j] = node;
                    if(checkEndGame(node)){
                        map[i][j] = 0;
                        return 1;
                    }
                    int result = dfs(node==1 ? 2 : 1);
                    map[i][j] = 0;

                    // 상대가 지면 나는 이김
                    if(result == -1) return 1;

                    // 무승부 가능성 저장
                    if(result == 0) best = 0;
                }
            }
        }
        if(!hasEmpty) return 0; //무승부
        return best; //모든 경우가 위에서 다 정해져서 여기까지 오는 경우는 없습니다.
    }
    static  boolean checkEndGame(int node){

        //체크 로직
        //가로
        for(int j=0;j<N;j++){
            int cnt = 0;
            for(int i=0;i<N;i++){
                if(map[i][j]==node) cnt++;
            }
            if(cnt==3) return true;
        }
        //세로
        for(int i=0;i<N;i++){
            int cnt = 0;
            for(int j=0;j<N;j++){
                if(map[i][j]==node)cnt++;
            }
            if(cnt==3) return true;
        }
        //대각선
        if(map[0][0]==node && map[0][0]==map[1][1] && map[1][1]==map[2][2]) return true;
        if(map[2][0]==node && map[2][0] == map[1][1] && map[1][1] == map[0][2]) return true;
        return false;
    }
}
