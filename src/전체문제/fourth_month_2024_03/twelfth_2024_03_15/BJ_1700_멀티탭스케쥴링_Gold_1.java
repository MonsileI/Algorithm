package 전체문제.fourth_month_2024_03.twelfth_2024_03_15;
import java.util.*;
import java.io.*;
public class BJ_1700_멀티탭스케쥴링_Gold_1 {
    public static void main(String[] args) throws Exception{
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine()," ");
        int[]arr = new int[K];
        for(int i=0;i<K;i++)arr[i] = Integer.parseInt(st.nextToken());
        boolean[]check = new boolean[101];
        int now = 0;
        int ans = 0;
        for(int i=0;i<K;i++){
            int kon = arr[i];
            if(check[kon]) continue;

            if(now<N){
                now++;
                check[kon] = true;
                continue;
            }

            List<Integer> list = new ArrayList<>();
            for(int j=i;j<K;j++){
                if(check[arr[j]] && !list.contains(arr[j])){
                    list.add(arr[j]);
                }
            }
            if(list.size()<N){
                for(int j=0;j<101;j++){
                    if(check[arr[j]]&&!list.contains(arr[j])){
                        check[arr[j]] = false;
                        break;
                    }
                }
            }else{
                check[list.get(list.size()-1)] = false;
            }
            ans++;
            check[kon] = true;
        }
        System.out.println(ans);
    }
}
