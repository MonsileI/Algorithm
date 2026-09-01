package 전체문제2026.August.Seventh;

import java.util.*;
import java.io.*;
public class GR_이어붙이기_D4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<=10;i++) list.add(new ArrayList<>());
        for(int i=0;i<N;i++) {
            String num = br.readLine();
            int len = num.length();
            list.get(len).add(Integer.parseInt(num));
        }
        for(int i=0;i<=10;i++) Collections.sort(list.get(i),(o1,o2) -> -(o1-o2));
        StringBuilder sb= new StringBuilder();
        int []idxArr =new int[11];
        while(0<N){
            int[]max = new int[11];
            max[0] = -1;
            int idx = 0;
            for(int i=0;i<=10;i++){
                if(list.get(i).size() <= idxArr[i]) continue;
                int num = list.get(i).get(idxArr[i]);
                String str = String.valueOf(num);
                if((str.charAt(0) - '0') > max[0]){
                    int j;
                    idx = i;
                    for(j=0;j<i;j++){
                        max[j] = str.charAt(j) - '0';
                    }
                    max[j] = -1;
                }
                if((str.charAt(0) - '0') == max[0]){
                    String A = str + list.get(idx).get(idxArr[idx]);
                    String B = list.get(idx).get(idxArr[idx]) + str;
                    boolean flag = true;
                    for(int l =0;l<A.length();l++){
                        if(B.charAt(l) - '0' < A.charAt(l) - '0' ){
                                break;
                        }
                        if(A.charAt(l) - '0' < B.charAt(l) - '0'){
                                flag = false;
                                break;
                        }
                    }
                    if(flag) {
                        int j;
                        idx = i;
                        for(j=0;j<i;j++){
                            max[j] = str.charAt(j) - '0';
                        }
                        max[j] = -1;
                    }
                }
            }
            sb.append(list.get(idx).get(idxArr[idx]));
            idxArr[idx]++;
            N--;
        }
        String answer = sb.toString();
        if(1 < answer.length() && answer.charAt(0) == '0') answer = "-1";
        System.out.println(answer);
    }
}
