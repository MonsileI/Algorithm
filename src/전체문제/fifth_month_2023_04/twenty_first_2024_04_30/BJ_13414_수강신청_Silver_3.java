package 전체문제.fifth_month_2023_04.twenty_first_2024_04_30;
import java.util.*;
import java.io.*;
public class BJ_13414_수강신청_Silver_3 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        LinkedHashSet<String> set = new LinkedHashSet<>();

        for(int i=0;i<M;i++){
            String str = br.readLine();
            if(set.contains(str)) set.remove(str);
            set.add(str);
        }
        StringBuilder sb=  new StringBuilder();
        for(String str : set){
            sb.append(str+"\n");
            N--;
            if(N==0) break;
        }
        System.out.println(sb.toString());
    }
}
