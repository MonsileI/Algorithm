package 전체문제.fifth_month_2023_04.eleventh_2024_04_17;

import java.util.*;
import java.io.*;
public class BJ_1343_폴리오미노_Silver_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        int N = arr.length;
        int cnt = 0;
        boolean flag = true;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++){
            char ch = arr[i];
            if(ch=='.') {
                if(cnt!=0) {
                    if (cnt % 2 != 0) {
                        flag = false;
                        break;
                    } else {
                        while (cnt!=0) {
                            if (cnt == 2) {
                                sb.append("BB");
                                break;
                            }
                            sb.append("AAAA");
                            cnt -= 4;
                        }
                    }
                    cnt = 0;
                }
                sb.append(".");
            }else  cnt++;
        }
        if(!flag) System.out.println(-1);
        else{
            if(cnt%2!=0){
                flag = false;
            }else{
                while(cnt!=0){
                    if(cnt==2) {
                        sb.append("BB");
                        break;
                    }
                    sb.append("AAAA");
                    cnt -= 4;
                }
            }
            if(!flag) System.out.println(-1);
            else System.out.println(sb.toString());
        }

    }
}
