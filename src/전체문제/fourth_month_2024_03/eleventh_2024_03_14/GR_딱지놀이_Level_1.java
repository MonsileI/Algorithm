package 전체문제.fourth_month_2024_03.eleventh_2024_03_14;
import java.util.*;
import java.io.*;
public class GR_딱지놀이_Level_1 {
    static int[]aArr;
    static int[]bArr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N= Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        StringBuilder sb=  new StringBuilder();
        for(int t=0;t<N;t++){
            st = new StringTokenizer(br.readLine()," ");
            int aN = Integer.parseInt(st.nextToken());
            aArr = new int[5];
            for(int i=0;i<aN;i++){
                int num = Integer.parseInt(st.nextToken());
                aArr[num]++;
            }
            st = new StringTokenizer(br.readLine()," ");
            int bN = Integer.parseInt(st.nextToken());
            bArr = new int[5];
            for(int i=0;i<bN;i++) {
                int num = Integer.parseInt(st.nextToken());
                bArr[num]++;
            }
            boolean flag = false;
            for(int i=4;-1<i;i--){
                if(aArr[i]>bArr[i]) {
                    sb.append("A\n");
                    flag = true;
                    break;

                }
                if(aArr[i]<bArr[i]){
                    sb.append("B\n");
                    flag = true;
                    break;
                }
            }
            if(!flag) sb.append("D\n");
        }
        System.out.println(sb.toString());
    }
}
