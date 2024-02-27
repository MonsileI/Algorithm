package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2580_스도쿠_Gold_4 {
    static int[][]map;
    static boolean flag;
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= null;
        int N = 9;
        map = new int[N][N];
        for(int i=0;i<N;i++){
           st = new StringTokenizer(br.readLine()," ");
           for(int j=0;j<N;j++){
               map[i][j] = Integer.parseInt(st.nextToken());
           }
        }
        sudoku(0,0);
    }
    static void sudoku(int row,int col){
        if(flag) return;
        if(col==9){
            sudoku(row+1,0);
            return;
        }
        if(row==9){
            for(int i=0;i<9;i++){
                for(int j=0;j<9;j++){
                    System.out.print(map[i][j]+" ");
                }
                System.out.println();
            }
            flag = true;
            return;
        }

        if(map[row][col]==0){
            for(int i=1;i<10;i++){
                if(possible(row,col,i)){
                    map[row][col] = i;
                    sudoku(row,col+1);
                }
            }
            map[row][col] = 0;
            return;
        }
        sudoku(row,col+1);
    }
    static boolean possible(int row,int col,int value){
        for(int i=0;i<9;i++){
            if(map[row][i]==value) return false;
        }
        for(int i=0;i<9;i++){
            if(map[i][col]==value) return false;
        }
        int set_row = (row / 3) * 3; // value가 속한 3x3의 행의 첫 위치
        int set_col = (col / 3) * 3; // value가 속한 3x3의 열의 첫 위치

        for (int i = set_row; i < set_row + 3; i++) {
            for (int j = set_col; j < set_col + 3; j++) {
                if (map[i][j] == value) {
                    return false;
                }
            }
        }
        return true;
    }
}
