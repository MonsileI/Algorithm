package 전체문제2026.August.Fourteenth;

import java.util.*;
import java.io.*;
public class GR_학생정보관리어플리케이션만들기_D3 {

    static class TrieNode{

        TrieNode trieNode;
        int cnt;
        Map<Character,TrieNode> childNode = new HashMap<>();

        public void insertNode(String str){
            TrieNode thisNode = this;
                for(int i=0;i<str.length();i++){
                    char ch = str.charAt(i);
                    thisNode.childNode.putIfAbsent(ch,new TrieNode());
                    thisNode = thisNode.childNode.get(ch);
                    thisNode.cnt++;
                }
        }
        public int getCnt(String str){
            TrieNode thisNode = this;
            for(int i=0;i<str.length();i++){
                char ch = str.charAt(i);
                thisNode = thisNode.childNode.get(ch);
                // 존재하지 않는 prefix
                if (thisNode == null) {
                    return 0;
                }
            }
            return thisNode.cnt;
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb=  new StringBuilder();
        TrieNode trieNode = new TrieNode();
        int Q = Integer.parseInt(br.readLine());
        for(int i=0;i<Q;i++){
            st= new StringTokenizer(br.readLine()," ");
            String act = st.nextToken();
            String alpha = st.nextToken();
            switch (act){
                case "add":
                    trieNode.insertNode(alpha);
                    break;
                case "find" :
                    sb.append(trieNode.getCnt(alpha)+"\n");
                    break;
            }
        }
        System.out.println(sb.toString());
    }
}
