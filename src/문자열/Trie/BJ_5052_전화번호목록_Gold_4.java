package 문자열.Trie;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BJ_5052_전화번호목록_Gold_4 {

    static class TrieNode{

        public TrieNode() {}

        Map<Character,TrieNode> childNode = new HashMap<>();

        public void insertNode(String str){
            TrieNode trieNode = this;
            for(int i=0;i<str.length();i++){
                char ch = str.charAt(i);
                trieNode.childNode.putIfAbsent(ch,new TrieNode());
                trieNode = trieNode.childNode.get(ch);
            }
        }
        public boolean isContains(String str){
            TrieNode trieNode = this;
            for(int i=0;i<str.length();i++){
                char ch = str.charAt(i);
                TrieNode thisNode = trieNode.childNode.get(ch);
                if(thisNode.childNode.isEmpty()) return false;
                trieNode = thisNode;
            }

            return true;
        }
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t=0;t<TC;t++){
        TrieNode trieNode = new TrieNode();
        List<String >list = new ArrayList<>();
            int N = Integer.parseInt(br.readLine());
            for(int i=0;i<N;i++){
                String str = br.readLine();
                list.add(str);
                trieNode.insertNode(str);
            }
            boolean flag = true;
            for(String str : list){
                if(trieNode.isContains(str)) {
                    flag= false;
                    break;
                }
            }
            sb.append(flag ? "YES\n" : "NO\n");
        }
        System.out.println(sb.toString());
    }
}
