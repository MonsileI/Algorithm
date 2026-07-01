package 전체문제2026.June.Sixteenth;

import java.util.*;
import java.io.*;
public class SWEA_1289_원재의메모리복구하기_D3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for(int t=1;t<=TC;t++){
            char[]memory = br.readLine().toCharArray();
            int N = memory.length;
            int answer = 0;
            boolean isZero = true; //0인 상태
            for(int i=0;i<N;i++){
                if(memory[i]=='1'){
                   if(isZero) {
                       isZero = false;
                       answer++;
                   }
                }else{
                    if(!isZero){
                        isZero = true;
                        answer++;
                    }
                }
            }
            sb.append("#"+t+" "+answer+"\n");
        }
        System.out.println(sb.toString());
    }
}