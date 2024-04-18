package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class BJ_1411_비슷한단어_Silver_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        //패턴을 알아야 될 것 같은데. ex) aaba -> 1121 aaza -> 1121
        char[]str = br.readLine().toCharArray();
        int M = str.length;
        int[]alpha = new int[26];
        int idx = 0;
        StringBuilder sb = new StringBuilder();
        String[] arr =new String[N];
        for(int i=0;i<M;i++){
            int ch = str[i]-'a';
            if(alpha[ch]==0) alpha[ch] = ++idx;
            sb.append(alpha[ch]);
        }
        arr[0] = sb.toString();

        for(int i=1;i<N;i++){
            str = br.readLine().toCharArray();
            alpha = new int[26];
            idx = 0;
            sb = new StringBuilder();
            for(int j=0;j<M;j++){
                int ch = str[j]-'a';
                if(alpha[ch]==0) alpha[ch] = ++idx;
                sb.append(alpha[ch]);
            }
            arr[i] = sb.toString();
        }
        int ans = 0;
        for(int i=0;i<N-1;i++){
            for(int j=i+1;j<N;j++){
                if(arr[i].equals(arr[j])) ans++;
            }
        }
        System.out.println(ans);
    }
}
