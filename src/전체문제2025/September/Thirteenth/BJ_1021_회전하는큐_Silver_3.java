package 전체문제2025.September.Thirteenth;

import java.util.*;
import java.io.*;
public class BJ_1021_회전하는큐_Silver_3 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int TC = Integer.parseInt(st.nextToken());
        int cnt = 0;
        LinkedList<Integer>q = new LinkedList<>();
        for(int i=1;i<N+1;i++) q.offer(i);
        st = new StringTokenizer(br.readLine()," ");
        while(0<TC){
           int num = Integer.parseInt(st.nextToken());
           int targetIndex = q.indexOf(num);
           int halfIndex;

            if(q.size() % 2 == 0) {
                halfIndex = q.size() / 2 - 1;
            }
            else {
                halfIndex = q.size() / 2;
            }
            // 중간 지점 또는 중간 지점보다 원소의 위치가 앞에 있을 경우
            if(targetIndex <= halfIndex) {
                // idx 보다 앞에 있는 원소들을 모두 뒤로 보낸다. (2번 연산)
                for(int j = 0; j < targetIndex; j++) {
                    int temp = q.pollFirst();
                    q.offerLast(temp);
                    cnt++;
                }
            }
            else {	// 중간 지점보다 원소의 위치가 뒤에 있는 경우
                // idx를 포함한 뒤에 있는 원소들을 모두 앞으로 보낸다. (3번 연산)
                for(int j = 0; j < q.size() - targetIndex; j++) {
                    int temp = q.pollLast();
                    q.offerFirst(temp);
                    cnt++;
                }

            }
            q.pollFirst();	// 연산이 끝나면 맨 앞 원소를 삭제

            TC--;
        }
        System.out.println(cnt);
    }
}
