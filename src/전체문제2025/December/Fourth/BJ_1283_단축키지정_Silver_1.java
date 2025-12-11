package 전체문제2025.December.Fourth;

import java.util.*;
import java.io.*;
public class BJ_1283_단축키지정_Silver_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        Map<Character,Integer> map = new HashMap<>();
        for(int tc=0;tc<N;tc++){
            String[]tmp = br.readLine().split(" ");
            int idx = -1;
            for(int i=0;i<tmp.length;i++){
                String str = tmp[i].toUpperCase();
                char ch = str.charAt(0);
                if(!map.containsKey(ch)){
                    map.put(ch,1);
                    idx = i;
                    break;
                }
            }
            if(idx != -1){
                for(int i=0;i<tmp.length;i++){
                    if(idx==i){
                        sb.append("[");
                        sb.append(tmp[i].charAt(0));
                        sb.append("]");
                        sb.append(tmp[i].substring(1,tmp[i].length()));
                    }else{
                        sb.append(tmp[i]);
                    }
                    if(i!=tmp.length-1) sb.append(" ");
                }
            }else{
                boolean flag = false;
                for(int i=0;i<tmp.length;i++){
                    String str = tmp[i].toUpperCase();
                    if(flag){
                        sb.append(tmp[i]);
                        if(i!=tmp.length-1) sb.append(" ");
                        continue;
                    }
                    for(int j=0;j<str.length();j++){
                        char ch = str.charAt(j);
                        if(flag) {
                            sb.append(tmp[i].charAt(j));
                            continue;
                        }
                        if(!map.containsKey(ch)){
                            map.put(ch,1);
                            sb.append("[");
                            sb.append(tmp[i].charAt(j));
                            sb.append("]");
                            flag = true;
                        }else{
                            sb.append(tmp[i].charAt(j));
                        }
                    }
                    if(i!=tmp.length-1) sb.append(" ");
                }
            }
            if(tc!=N-1) sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
