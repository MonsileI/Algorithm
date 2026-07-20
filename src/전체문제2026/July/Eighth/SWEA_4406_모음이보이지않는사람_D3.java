package 전체문제2026.July.Eighth;
import java.util.*;
import java.io.*;
public class SWEA_4406_모음이보이지않는사람_D3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=  new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        String [] arr = {"a","e","i","o","u"};
        int N = arr.length;
        for(int t=1;t<=TC;t++){
            String str = br.readLine();
            for(int i=0;i<N;i++) str = str.replaceAll(arr[i],"");
            sb.append("#"+t+" "+str+"\n");
        }
        System.out.println(sb.toString());
    }
}
