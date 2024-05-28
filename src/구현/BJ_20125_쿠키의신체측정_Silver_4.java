package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class BJ_20125_쿠키의신체측정_Silver_4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[][]map = new char[N][N];
        for(int i=0;i<N;i++) map[i] = br.readLine().toCharArray();
        StringBuilder sb=  new StringBuilder();
        OuterLoop:
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(map[i][j]=='*'){
                    //머리
                    sb.append((i+2)+" "+(j+1)+"\n");
                    //왼쪽팔
                    int cnt = 0;
                    i++;
                    for(int l=j-1;-1<l;l--){
                        if(map[i][l]!='*') break;
                        cnt++;
                    }
                    sb.append(cnt+" ");
                    cnt = 0;
                    //오른팔
                    for(int l=j+1;l<N;l++){
                        if(map[i][l]!='*') break;
                        cnt++;
                    }
                    sb.append(cnt+" ");
                    cnt = 0;
                    //허리
                    int l = 0;
                    i++;
                    for(l=i;l<N;l++){
                        if(map[l][j]!='*') break;
                        cnt++;
                    }
                    sb.append(cnt+" ");
                    cnt = 0;
                    //왼다리
                    for(int k=l;k<N;k++){
                        if(map[k][j-1]!='*') break;
                        cnt++;
                    }
                    sb.append(cnt+" ");
                    cnt = 0;
                    //오른다리
                    for(int k=l;k<N;k++){
                        if(map[k][j+1]!='*') break;
                        cnt++;
                    }
                    sb.append(cnt);
                    break OuterLoop;
                }
            }
        }
        System.out.println(sb.toString());
    }
}
