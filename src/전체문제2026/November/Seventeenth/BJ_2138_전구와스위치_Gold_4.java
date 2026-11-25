package 전체문제2026.November.Seventeenth;

import java.util.*;
import java.io.*;
public class BJ_2138_전구와스위치_Gold_4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String mine = br.readLine();
        String goal = br.readLine();
        boolean[]fArr = new boolean[N];
        boolean[]sArr = new boolean[N];
        boolean[]gArr = new boolean[N];
        for(int i=0;i<N;i++){
            if(mine.charAt(i)=='1'){
                fArr[i] = true;
                sArr[i] = true;
            }
            if(goal.charAt(i)=='1'){
                gArr[i] = true;
            }
        }
        int fCnt = 0;
        int sCnt = 1;
        sArr[0] = !sArr[0];
        sArr[1] = !sArr[1];
        for(int i=0;i<N-1;i++){
            if(fArr[i]!=gArr[i]){
                fCnt++;
                fArr[i] = !fArr[i];
                fArr[i+1] = !fArr[i+1];
                if(i!=N-2){
                    fArr[i+2] = !fArr[i+2];
                }
            }
            if(sArr[i]!=gArr[i]){
                sCnt++;
                sArr[i] = !sArr[i];
                sArr[i+1] = !sArr[i+1];
                if(i!=N-2){
                    sArr[i+2] = !sArr[i+2];
                }
            }
        }
        boolean fFlag = true;
        boolean sFlag = true;
        for(int i=0;i<N;i++){
            if(fArr[i]!=gArr[i]) fFlag = false;
            if(sArr[i]!=gArr[i]) sFlag = false;
            if(!fFlag && !sFlag) break;
        }
        int INF = 987654321;
        if(!fFlag) fCnt = INF;
        if(!sFlag) sCnt = INF;
        int answer = Math.min(fCnt,sCnt);
        System.out.println(answer==INF ? -1 : answer);

    }
}
