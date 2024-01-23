package 전체문제.second_month_2024_01.fifteen_2024_01_23;
import java.util.*;
import java.io.*;
public class BJ_15666_N과M12_Silver_2 {
    static int N,M;
    static int[]arr;
    static StringBuilder sb;
    static Set<String>set;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=  new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        sb = new StringBuilder();
        set = new HashSet<>();
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        perm(0,"",0);
        System.out.println(sb.toString());
    }
    static void perm(int depth, String now,int start){

        if(depth==M){
            now = now.substring(1,now.length());
            if(!set.contains(now)){
                set.add(now);
                sb.append(now+"\n");
            }
            return;
        }

        for(int i=start;i<N;i++){
            String newOne = now + " " + arr[i];
            perm(depth+1,newOne,i);
        }
    }
}
