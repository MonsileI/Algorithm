
package 전체문제2026.October.Sixth;

public class PR_혼자서하는틱택톡_Level_2 {
    static char[][] map;

    static int solution(String[] board) {
        map = new char[3][3];

        int cntO = 0;
        int cntX = 0;

        for (int i = 0; i < 3; i++) {
            map[i] = board[i].toCharArray();

            for (int j = 0; j < 3; j++) {
                if (map[i][j] == 'O') cntO++;
                if (map[i][j] == 'X') cntX++;
            }
        }

        // 1. 돌 개수 검사
        if (cntO < cntX || cntO > cntX + 1) {
            return 0;
        }

        // 2. 승리 여부 검사
        boolean oWin = isDone('O');
        boolean xWin = isDone('X');

        // 3. 둘 다 승리할 수 없음
        if (oWin && xWin) return 0;

        // 4. O가 승리했다면 O가 마지막 차례
        if (oWin && cntO != cntX + 1) return 0;

        // 5. X가 승리했다면 X가 마지막 차례
        if (xWin && cntO != cntX) return 0;

        return 1;
    }

    static boolean isDone(char ch) {
        // 가로 검사
        for (int i = 0; i < 3; i++) {
            if (map[i][0] == ch &&
                    map[i][1] == ch &&
                    map[i][2] == ch) {
                return true;
            }
        }

        // 세로 검사
        for (int j = 0; j < 3; j++) {
            if (map[0][j] == ch &&
                    map[1][j] == ch &&
                    map[2][j] == ch) {
                return true;
            }
        }

        // 대각선 검사
        if (map[0][0] == ch &&
                map[1][1] == ch &&
                map[2][2] == ch) {
            return true;
        }

        if (map[0][2] == ch &&
                map[1][1] == ch &&
                map[2][0] == ch) {
            return true;
        }

        return false;
    }
}