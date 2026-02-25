package 전체문제2026.February.Fourteenth;

import java.util.*;
import java.io.*;
public class BJ_2503_숫자야구_Silver_3 {
    static int[][]number;
    static int[][]sAndB;
    static int answer;
    static int[]tmp;
    static boolean[]visited;
    static int Q;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Q = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        number = new int[Q][3];
        sAndB = new int[Q][2];
        for(int i=0;i<Q;i++){
            st =new StringTokenizer(br.readLine()," ");
            String num = st.nextToken();
            number[i][0] = Integer.parseInt(num.charAt(0)+"");
            number[i][1] = Integer.parseInt(num.charAt(1)+"");
            number[i][2] = Integer.parseInt(num.charAt(2)+"");
            sAndB[i][0] = Integer.parseInt(st.nextToken());
            sAndB[i][1] = Integer.parseInt(st.nextToken());
        }
        tmp = new int[3];
        visited = new boolean[10];
        perm(0);
        System.out.println(answer);
    }
    static boolean calc(){
        boolean flag = true;
        for(int i=0;i<Q;i++){
            int strikeCnt = 0;
            int ballCnt = 0;
            for(int j=0;j<3;j++){
                for(int l=0;l<3;l++){
                    if(tmp[j] == number[i][l]){
                        if(j == l) strikeCnt++;
                        else ballCnt++;
                    }
                }
            }
            if(strikeCnt != sAndB[i][0] || ballCnt != sAndB[i][1]) return false;
        }
        return flag;
    }
    static void perm(int depth){
        if(depth==3){
            if(calc())answer++;
            return;
        }

        for(int i=1;i<10;i++){
            if(!visited[i]) {
                visited[i] = true;
                tmp[depth] = i;
                perm(depth + 1);
                visited[i] = false;
            }
        }
    }
}
