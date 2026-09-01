package 전체문제2026.August.Tenth;

import java.util.*;
import java.io.*;
public class SWEA_7272_안경이없어_D3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb=  new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        String DIFF = "DIFF";
        String SAME = "SAME";
        Set<Character> set = new HashSet<>();
        char[]moum = {'A','D','O','P','Q','R'};
        for(int i=0;i<moum.length;i++) set.add(moum[i]);
        for(int t=1;t<=TC;t++){
            st =new StringTokenizer(br.readLine()," ");
            String f = st.nextToken();
            String s = st.nextToken();
            boolean flag = true;
            int N = f.length();
            if(N==s.length()) {
                for(int i=0;i<N;i++){
                    char fCh = f.charAt(i);
                    char sCh = s.charAt(i);
                    if(fCh==sCh) continue;
                    if(fCh=='B' || sCh=='B'){
                        flag=  false;
                        break;
                    }
                    if(set.contains(fCh) && set.contains(sCh)) continue;
                    if(!set.contains(fCh) && !set.contains(sCh)) continue;
                    flag = false;
                    break;
                }
            }
            else{
                flag = false;
            }
            sb.append("#"+t+" ");
            if(flag) sb.append(SAME);
            else sb.append(DIFF);
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
