package 전체문제2026.May.Fourth;

import java.util.*;
import java.io.*;
public class SWEA_26389_여행_D3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        while(0<TC){
            String str = br.readLine();
            int N = str.length();
            int [] chArr = new int[4]; //N W S E 북 서 남 동
            for(int i=0;i<N;i++){
                char ch = str.charAt(i);
                switch (ch){
                    case 'N' : chArr[0]++;
                    break;
                    case 'W' :chArr[1]++;
                    break;
                    case 'S' : chArr[2]++;
                    break;
                    case 'E' : chArr[3]++;
                    break;
                }
            }
            boolean flag = true;
            if(chArr[0]==0){
                if(chArr[2]!=0) flag = false;
            }
            if(chArr[1]==0){
                if(chArr[3]!=0) flag = false;
            }
            if(chArr[2]==0){
                if(chArr[0]!=0) flag = false;
            }
            if(chArr[3]==0){
                if(chArr[1]!=0) flag = false;
            }
            sb.append(flag ? "Yes" : "No");
            sb.append("\n");
            TC--;
        }
        System.out.println(sb.toString());
    }
}
