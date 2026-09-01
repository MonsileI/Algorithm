package 전체문제2026.August.Eighteenth;
import java.util.*;
import java.io.*;
public class GR_증식하는수들2_D3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Set<Integer> set = new HashSet<>();
        int answer = 0;
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++){
            int num = Integer.parseInt(st.nextToken());
            while(num<=K){
                if(!set.contains(num)){
                    set.add(num);
                    answer++;
                }
                num *= 2;
                num++;

            }
        }
        System.out.println(set.size());
    }
}
