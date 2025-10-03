package 전체문제2025.September.Second;

import java.util.*;
import java.io.*;
public class BJ_20920_영단어암기는괴로워_Silver_3 {

    static class Word implements Comparable<Word>{
        String str;
        int len;
        int cnt;

        public Word( String str,int len, int cnt) {
            this.str = str;
            this.len = len;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Word o) {
            return cnt == o.cnt ? len == o.len ? str.compareTo(o.str) : -(len - o.len) : -(cnt - o.cnt);
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<String,Word> map = new HashMap<>();

        for(int i=0;i<N;i++){
            String str = br.readLine();
            if(str.length()<M) continue;
            if(map.get(str) == null){
                map.put(str,new Word(str,str.length(),1));
            }else{
                Word word = map.get(str);
                word.cnt++;
                map.put(str,word);
            }
        }
        List<Word> list = new ArrayList<>();
        for(String key : map.keySet()){
            list.add(map.get(key));
        }
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for(Word word : list){
            sb.append(word.str+"\n");
        }
        System.out.println(sb.toString());



    }
}

