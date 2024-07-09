package 전체문제.eigth_month_2024_07.fifth_2024_07_09;
import java.util.*;
import java.io.*;
public class BJ_10825_국영수_Silver_4 {
    static class Subject implements Comparable<Subject>{
        String title;
        int kor; int eng; int math;

        public Subject(String title, int kor, int eng, int math) {
            this.title = title;
            this.kor = kor;
            this.eng = eng;
            this.math = math;
        }

        @Override
        public int compareTo(Subject o) {
            return kor==o.kor ? eng == o.eng ? math == o.math ? title.compareTo(o.title) : -(math-o.math) : eng - o.eng : -(kor - o.kor);
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Subject[]subjects = new Subject[N];
        StringTokenizer st = null;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            subjects[i] = new Subject(st.nextToken(),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(subjects);
        StringBuilder sb= new StringBuilder();
        for(int i=0;i<N;i++)sb.append(subjects[i].title+"\n");
        System.out.println(sb.toString());
    }
}
