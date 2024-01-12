package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_5527_전구장식_Gold_4 {
    public static void main(String[] args) throws Exception{
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int[]arr = new int[N];
        arr[0] = Integer.parseInt(st.nextToken());
        int cnt = 1;
        List<Integer> list = new ArrayList<>();
        for(int i=1;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            if(arr[i]!=arr[i-1]) cnt++;
            else{
                list.add(cnt);
                cnt = 1;
            }
        }
        list.add(cnt);
        int size = list.size();
        int ans = 0;
        for(int i=0;i<size;i++){
            int sum = list.get(i);
            if(size<=i+1) {
                ans = Math.max(ans,sum);
                break;
            }
            else if(size<=i+2){
                sum +=list.get(i+1);
                ans = Math.max(ans,sum);
                break;
            }else{
                sum += list.get(i+1) + list.get(i+2);
                ans = Math.max(ans,sum);
            }
        }
        System.out.println(ans);
    }
}
