package 두포인터;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_12891_DNA비밀번호_Silver_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        //길이가 M이어야 하고,
        int[]arr = new int[20]; //A 0 C 2 G 6 T 19  || A B C D E F G H I J K L M N O P Q R S T
        int[] idx = {0,2,6,19};
        String str = br.readLine();
        StringBuilder sb= new StringBuilder();
        int len = N;
        for(int i=0;i<N;i++){
            char ch = str.charAt(i);
            if(ch!='A' && ch!='C' && ch!='G' &&ch!='T'){
                len--;
                continue;
            }
            sb.append(ch);
        }
        N = len;
        str = sb.toString();
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<4;i++) arr[idx[i]] = Integer.parseInt(st.nextToken());
        int L = 0;
        int R = 1;
        int ans = 0;
        if(N<2){
            int firIdx = str.charAt(0)-'A';
            boolean flag = true;
            for(int i=0;i<4;i++){
                if(firIdx==idx[i]){
                    if(firIdx<idx[i]) {
                        flag = false;
                        break;
                    }
                }else{
                    if(arr[idx[i]]>0) {
                        flag = false;
                        break;
                    }
                }
            }
            if(!flag) System.out.println(0);
            else System.out.println(1);
        }else if(M==1){
            boolean flag = true;
            int checkIdx  = -1;
            for(int i=0;i<4;i++){
                if(arr[idx[i]]>1){
                    flag = false;
                    checkIdx = 100;
                    break;
                }
                if(arr[idx[i]]==1){
                    if(flag){
                        checkIdx = idx[i];
                        flag = false;
                    }else{
                        checkIdx = 100;
                        flag =false;
                        break;
                    }
                }
            }
            if(checkIdx==100) System.out.println(0);
            else{
                if(checkIdx==-1) ans = N;
                else {
                    for(int i=0;i<N;i++) if(str.charAt(i)-'A'==checkIdx)ans++;
                }
                System.out.println(ans);
            }
        }
        else {
            //마이너스면 넘치는거,
            arr[str.charAt(L) - 'A']--;
            arr[str.charAt(R) - 'A']--;
            while (true) {
                if ((R - L + 1) == M) break;
                R++;
                arr[str.charAt(R) - 'A']--;
            }
            boolean flag = true;
            for (int i = 0; i < 4; i++) {
                if (arr[idx[i]] > 0) {
                    flag = false;
                    break;
                }
            }
            OuterLoop:
            while (true) {
                if (flag) {
                    ans++;
                    if (arr[str.charAt(L) - 'A'] == 0) flag = false;
                }
                arr[str.charAt(L) - 'A']++;
                R++;
                if (R == N) break;
                arr[str.charAt(R) - 'A']--;
                L++;
                boolean small = true;
                for (int i = 0; i < 4; i++) {
                    if (arr[idx[i]] > 0) {
                        small = false;
                        break;
                    }
                }
                if (small) flag = true;
            }
            System.out.println(ans);
        }
    }
}

