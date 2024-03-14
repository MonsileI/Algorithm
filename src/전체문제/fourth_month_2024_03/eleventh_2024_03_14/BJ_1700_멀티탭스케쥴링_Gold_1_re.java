package 전체문제.fourth_month_2024_03.eleventh_2024_03_14;
import java.util.*;
import java.io.*;
public class BJ_1700_멀티탭스케쥴링_Gold_1_re {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[]arr =new int[K];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<K;i++)arr[i] = Integer.parseInt(st.nextToken());
        boolean[]check = new boolean[101];
        int ans = 0;
        int put = 0;
        for(int i=0;i<K;i++){
            int con = arr[i];
            if(check[con]) continue;
            if(put<N){
                put++;
                check[con] = true;
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
                    if(check[arr[j]] && !list.contains(arr[j])){
                        check[arr[j]] = false;
                        break;
                    }
                }
            }else{
                check[list.get(list.size()-1)] = false;
            }
            ans++;
            check[con] = true;
        }
        System.out.println(ans);
    }
}
