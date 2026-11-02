package 전체문제2026.November.First;

import java.util.Arrays;

public class PR_파일명정렬_Level_2 {
    static class Node implements Comparable<Node>{
        int idx;
        String head;
        int number;
        String tail;

        public Node(int idx, String head, int number, String tail) {
            this.idx = idx;
            this.head = head;
            this.number = number;
            this.tail = tail;
        }

        @Override
        public int compareTo(Node o) {
            return head.equals(o.head) ? number == o.number ? idx - o.idx : number- o.number : head.compareTo(o.head);
        }
    }
    public static void main(String[] args) {
        String[]files = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
        System.out.println(Arrays.toString(solution(files)));
    }
    static String[] solution(String[] files) {
        int N = files.length;
        Node[] nodeArr = new Node[N];
        for(int i=0;i<N;i++){
            String str = files[i];
            String h = "";
            int j = 0;
            for(j=0;j<str.length();j++){
                char ch = str.charAt(j);
                if('0'<=ch && ch<='9'){
                    break;
                }
                h += ch;
            }
            int len = str.length();
            String num = "";
            while(j<len){
                char ch = str.charAt(j);
                if(ch < '0' || '9' < ch){
                    break;
                }
                num += ch;
                j++;
            }
            Node node = new Node(i,h.toLowerCase(),Integer.parseInt(num),str.substring(j));
            nodeArr[i] = node;
        }
        Arrays.sort(nodeArr);
        String[]answer = new String[N];
        for(int i=0;i<N;i++){
            answer[i] = files[nodeArr[i].idx];
        }
        return answer;
    }
}
