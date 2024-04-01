package 전체문제.fifth_month_2023_04.first_2024_04_01;

import java.util.*;
import java.io.*;
public class BJ_1700_멀티탭스케쥴링_Gold_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[]arr = new int[M];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<M;i++)arr[i] = Integer.parseInt(st.nextToken());
        int now = 0;
        int ans = 0;
        boolean[]con = new boolean[101];
        for(int i=0;i<M;i++){
            int num = arr[i];
            if(con[num]) continue;
            if(now<N){
                now++;
                con[num] = true;
            }else{
                List<Integer> list = new ArrayList<>();
                for(int j=i;j<M;j++){
                    if(!list.contains(arr[j])&&con[arr[j]]){
                        list.add(arr[j]);
                    }
                }
                if(list.size()<N){
                    for(int j=0;j<101;j++){
                        if(con[arr[j]]&&!list.contains(arr[j])){
                            con[arr[j]] = false;
                            break;
                        }
                    }
                }else{
                    con[list.get(list.size()-1)] = false;
                }
                con[num] = true;
                ans++;

            }
        }
        System.out.println(ans);
    }
}
