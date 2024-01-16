package 전체문제.second_month_2024_01.eleventh_2024_01_16;
import java.util.*;
import java.io.*;
public class BJ_1105_팔_Silver_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        String a = st.nextToken();
        String b = st.nextToken();
        int aLen = a.length();
        int bLen = b.length();
        while(aLen!=bLen){
            a = '0'+a;
            aLen++;
        }
        int ans = 0;
        int idx = 0;
        while(true){
            int aNum = a.charAt(idx) - '0';
            int bNum = b.charAt(idx++) - '0';
            if(aNum<bNum) break;
            if(aNum==8 && bNum==8) ans++;
            if(idx==bLen) break;
        }
        System.out.println(ans);

    }
}
