package 전체문제.second_month_2024_01.eleventh_2024_01_16;
import java.util.*;
import java.io.*;
public class BJ_1141_접두사_Silver_1 {

    static class TrieNode{

        public TrieNode(){};

        boolean terminal;

        Map<Character,TrieNode> childNode = new HashMap<>();

        public void insertNode(String str){
            TrieNode trieNode = this;
            for(int i=0;i<str.length();i++){
                char ch = str.charAt(i);
                trieNode.childNode.putIfAbsent(ch, new TrieNode());
                trieNode = trieNode.childNode.get(ch);
                if(i==str.length()-1){
                    trieNode.terminal = true;
                    return;
                }
            }
        }
        public boolean isContains(String str){
            TrieNode trieNode = this;
            for(int i=0;i<str.length();i++){
                char ch = str.charAt(i);
                TrieNode nowNode = trieNode.childNode.get(ch);
                if(nowNode.childNode.isEmpty()) return false;
                trieNode = nowNode;
            }

            if(trieNode.childNode.isEmpty()){
                if(trieNode.terminal) return false;
            }
            return true;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();
        TrieNode trieNode = new TrieNode();
        int ans = 0;
        for(int i=0;i<N;i++){
            String str =br.readLine();
            trieNode.insertNode(str);
            if(list.contains(str)) ans--;
            list.add(str);
        }
        for(String str : list) if(!trieNode.isContains(str)) ans++;
        System.out.println(ans);
    }
}
