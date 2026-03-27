package 전체문제2026.March.Sixteenth;

import java.util.*;
import java.io.*;
public class BJ_9017_크로스컨트리_Silver_3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        while(0<TC){
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine()," ");
            int[]arr= new int[N];
            int[]teams = new int[201];
            int[][]teamScores = new int[201][6];
            for(int i=0;i<N;i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                teams[arr[i]]++;
            }
            int score = 1;
            Set<Integer> set = new HashSet<>();
            for(int i=0;i<N;i++){
                if(teams[arr[i]]<6) continue;
                set.add(arr[i]);
                for(int j=0;j<6;j++){
                    if(teamScores[arr[i]][j]==0){
                        teamScores[arr[i]][j] = score;
                        break;
                    }
                }
                score++;
            }
            int sum = Integer.MAX_VALUE;
            int answer = 0;
            for(int node : set){
                Arrays.sort(teamScores[node]);
                int tmpSum = 0;
                for(int i=0;i<4;i++){
                    tmpSum += teamScores[node][i];
                }
                if(tmpSum<sum){
                    sum = tmpSum;
                    answer = node;
                }else if(tmpSum==sum){
                    for(int j=4;j<6;j++){
                        if(teamScores[node][j] < teamScores[answer][j]){
                            sum = tmpSum;
                            answer = node;
                            break;
                        }else if(teamScores[answer][j]<teamScores[node][j]){
                            break;
                        }
                    }
                }
            }
            sb.append(answer+"\n");
            TC--;
        }
        System.out.println(sb.toString());
    }
}
