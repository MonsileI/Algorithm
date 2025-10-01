package 전체문제2025.August.Sixth;

import java.util.*;
import java.io.*;
public class BJ_5052_전화번호목록_Gold_4 {


    static class TrieNode{
        public TrieNode(){};

        boolean flag;

        Map<Character,TrieNode> childNode = new HashMap<>();

        public void insertNode(String str){
            TrieNode trieNode = this;
            for(int i=0;i<str.length();i++){
                char ch = str.charAt(i);
                trieNode.childNode.putIfAbsent(ch,new TrieNode());
                trieNode = trieNode.childNode.get(ch);
                if(i == str.length()-1){
                    trieNode.flag = true;
                }
            }
        }
        public boolean isContains(String str){
            TrieNode trieNode = this;
            for(int i=0;i<str.length();i++){
                char ch = str.charAt(i);
                TrieNode thisNode = trieNode.childNode.get(ch);
                trieNode = thisNode;
            }
            if(trieNode.flag){
                if(trieNode.childNode.isEmpty()){
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for(int t=0;t<TC;t++){
            int N = Integer.parseInt(br.readLine());
            List<String> list = new ArrayList<>();
            TrieNode trieNode = new TrieNode();
            for(int i=0;i<N;i++){
                String str = br.readLine();
                list.add(str);
                trieNode.insertNode(str);
            }
            boolean flag = false;
            for(String str : list){
                if(trieNode.isContains(str)){
                    flag = true;
                    break;
                }
            }
            sb.append(flag ? "NO" : "YES");
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

}
