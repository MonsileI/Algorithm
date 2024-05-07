    package 전체문제.sixth_month_2024_05.fourth_2024_05_04;

    import java.util.*;
    import java.io.*;
    public class BJ_2141_우체국_Gold_4 {
        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = null;
            int[][]arr = new int[N][2];
            long sum = 0;
            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine()," ");
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
                sum += arr[i][1];
            }
            Arrays.sort(arr,(o1,o2)->o1[0]-o2[0]);
            long result = 0;
            sum++;
            int ans = 0;
            for(int i=0;i<N;i++){
                result += arr[i][1];
                if((sum/2)<=result){
                    ans = arr[i][0];
                    break;
                }
            }
            System.out.println(ans);
        }
    }
