package 전체문제2026.June.Eighth;

import java.util.Arrays;
import java.util.PriorityQueue;

public class PR_호텔대실_Level_2 {
    public static void main(String[] args) {
        String[][]book_time = {{"15:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"}, {"14:10", "19:20"}, {"18:20", "21:20"}};
        System.out.println(solution(book_time));
    }
    static int solution(String[][] book_time) {
        int N = book_time.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[][]arr = new int[N][2];
        for(int i=0;i<N;i++){
            int start = change(book_time[i][0]);
            int end = change(book_time[i][1]);
            arr[i][0] = start;
            arr[i][1] = end;
        }
        Arrays.sort(arr,(o1,o2) -> o1[0]==o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
        pq.offer(arr[0][1]+10);
        for(int i=1;i<N;i++){
            int endTime = pq.poll();
            if(arr[i][0] < endTime){
                pq.offer(endTime);
            }
            pq.offer(arr[i][1]+10);
        }
        int answer = pq.size();
        return answer;
    }
    static int change(String time){
        String[]tmp = time.split(":");
        int minute = Integer.parseInt(tmp[1]);
        int hour = Integer.parseInt(tmp[0]) * 60;
        return hour+minute;
    }
}
