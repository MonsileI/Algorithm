package 전체문제2026.July.August.Seventeenth;

import java.util.*;
import java.io.*;
public class GR_이어붙이기_D4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<=10;i++) list.add(new ArrayList<>());
        for(int i=0;i<N;i++){
            String num = br.readLine();
            list.get(num.length()).add(Integer.parseInt(num));
        }
        for(int i=0;i<=10;i++) {
            Collections.sort(list.get(i),(o1,o2) -> -(o1-o2));
        }
        int[]idxArr = new int[11];
        StringBuilder sb= new StringBuilder();
        while(0<N){
            int max = -1;
            int idx = 0;
            int divide = 1;
            for(int i=1;i<=10;i++){
                if(list.get(i).size()<=idxArr[i]) continue;
                if(max < ((list.get(i).get(idxArr[i])))/divide){
                    max = list.get(i).get(idxArr[i])/divide;
                    idx = i;
                }
                divide *= 10;
            }
            N--;
            sb.append(list.get(idx).get(idxArr[idx]));
            idxArr[idx]++;
        }
        String answer = sb.toString();
        if(answer.charAt(0)=='0' && answer.length()!=1) System.out.println(-1);
        else System.out.println(sb.toString());
    }
}
