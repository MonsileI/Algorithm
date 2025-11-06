package 전체문제2025.November.First;

import java.util.*;
import java.io.*;
public class BJ_7682_틱택톡_Gold_5 {
    static char[][]board;
    static Map<String,Integer> map;
    static boolean[][]visited;
    static int cnt;
    public static void main(String[] args) throws Exception {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        board = new char[3][3];
        map = new HashMap<>();
        visited= new boolean[3][3];
        for(int i=0;i<3;i++) Arrays.fill(board[i],'.');
        dfs(1,0);
        StringBuilder sb=  new StringBuilder();
        while(true){
            String str = br.readLine();
            if(str.equals("end")) break;
            if(map.containsKey(str)) sb.append("valid");
            else sb.append("invalid");
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    static void dfs(int turn,int depth){
        if(depth==9) {
            String str = "";
            for(int y=0;y<3;y++){
                for(int x=0;x<3;x++){
                    str += board[y][x];
                }
            }
            map.put(str,0);
            return;
        }


        for(int i=0;i<3;i++){
            if(board[i][0] != '.'){
                if(board[i][1] == board[i][0] && board[i][1] == board[i][2]){
                   String str = "";
                   for(int y=0;y<3;y++){
                       for(int x=0;x<3;x++){
                           str += board[y][x];
                       }
                   }
                    map.put(str,0);
                    return;
                }
            }
        }
        for(int j=0;j<3;j++){
            if(board[0][j] != '.'){
                if(board[1][j] == board[0][j] && board[1][j] == board[2][j]){
                    String str = "";
                    for(int y=0;y<3;y++){
                        for(int x=0;x<3;x++){
                            str += board[y][x];
                        }
                    }
                    map.put(str,0);
                    return;
                }
            }
        }
        if(board[0][0]!='.'){
            if(board[0][0] == board[1][1] && board[1][1] == board[2][2]){
                String str = "";
                for(int y=0;y<3;y++){
                    for(int x=0;x<3;x++){
                        str += board[y][x];
                    }
                }
                map.put(str,0);
                return;
            }
        }
        if(board[0][2]!='.'){
            if(board[0][2] == board[1][1] && board[1][1] == board[2][0]){
                String str = "";
                for(int y=0;y<3;y++){
                    for(int x=0;x<3;x++){
                        str += board[y][x];
                    }
                }
                map.put(str,0);
                return;
            }
        }
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(!visited[i][j]) {
                    visited[i][j] = true;
                    if (turn == 1) {
                        board[i][j] = 'X';
                        dfs(2,depth+1);
                        board[i][j] = '.';
                    } else {
                        board[i][j] = 'O';
                        dfs(1,depth+1);
                        board[i][j] = '.';
                    }
                    visited[i][j] = false;
                }
            }
        }
    }
}
