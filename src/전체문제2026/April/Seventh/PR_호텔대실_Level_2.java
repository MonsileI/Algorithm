package 전체문제2026.April.Seventh;

import java.util.Arrays;
import java.util.PriorityQueue;

public class PR_호텔대실_Level_2 {
    public static void main(String[] args) {
        String[][]book_time = {{"1:0","3:0"},{"2:0","2:6"},{"2:0","2:7"},{"4:0","5:0"}};
        System.out.println(solution(book_time));
    }
    static int solution(String[][] book_time) {
        int answer = 0;
        int N = book_time.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[][]timeLine = new int[N][2];
        for(int i=0;i<N;i++){
            int start = changeTimeToInt(book_time[i][0]);
            int end = changeTimeToInt(book_time[i][1]);
            timeLine[i][0] = start;
            timeLine[i][1] = end;
        }
        Arrays.sort(timeLine,(o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
        pq.offer(timeLine[0][1]+10);
        for(int i=1;i<N;i++){
            int endTime = pq.poll();
            if(timeLine[i][0]<endTime){
                pq.offer(endTime);
            }
            pq.offer(timeLine[i][1]+10);
        }
        answer = pq.size();
        return answer;
    }
    static int changeTimeToInt(String time){
        String[]tmp = time.split(":");
        int toTime = (Integer.parseInt(tmp[0])*60) + Integer.parseInt(tmp[1]);
        return toTime;
    }

}
