package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class BJ_1331_나이트투어_SIlver_4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean flag = true;
        String fir = br.readLine();
        int i = fir.charAt(1)-'1'; int j = fir.charAt(0)-'A';
        int si = i; int sj = j;
        boolean[][]visited = new boolean[6][6];
        visited[i][j] = true;
        for(int t=1;t<36;t++){
            String str = br.readLine();
            int ni = str.charAt(1)-'1';
            int nj = str.charAt(0)-'A';

            //방문
            if(visited[ni][nj]){
                flag=  false;
                break;
            }
            int di = Math.abs(i-ni);
            int dj = Math.abs(j-nj);
            //맨해튼거리
            if((di+dj)!=3){
                flag = false;
                break;
            }
            if(di>2 ||dj>2){
                flag = false;
                break;
            }
            visited[ni][nj] = true;
            i = ni;
            j = nj;
        }
        if(flag){
            int di = Math.abs(si-i);
            int dj = Math.abs(sj-j);
            if((di+dj)!=3 || (di>2 || dj>2)) System.out.println("Invalid");
            else System.out.println("Valid");
        }else System.out.println("Invalid");
    }
}
