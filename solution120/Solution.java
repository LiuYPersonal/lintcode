package solution120;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution { 
    public static int ladderLength(String start, String end, Set<String> dict) {
    	if(dict==null ||dict.size()==0){
    		return 0;
    	}
    	if(start==end){
    		return 1;
    	}
    	Queue<String> BFS =new LinkedList<String>();
    	Queue<Integer> Depth =new LinkedList<Integer>();
		String cur;
		char[] tmp;
		String tmp2;
		int count;
		BFS.add(start);
		Depth.add(1);
		while(!BFS.isEmpty()){
			cur=BFS.poll();
			count=Depth.poll();
			for(int i=0;i<start.length();i++){
				tmp=cur.toCharArray();
				for(char c='a';c<='z';c++){
					tmp[i]=c;
					tmp2=String.valueOf(tmp);
					if(tmp2.equals(end)){
						return count+1;
					}
					else if(dict.contains(tmp2)){
						BFS.add(tmp2);
						Depth.add(count+1);
						dict.remove(tmp2);
					}
				}
			}
		}
    	return 0;	
    }
    public static void main(String[] args){
    	String start="hit";
    	String end="cog";
    	Set<String> dict= new HashSet<String>();
    	dict.add("hot");
    	dict.add("dot");
    	dict.add("dog");
    	dict.add("lot");
    	dict.add("log");
    	System.out.println(ladderLength(start,end,dict));
    }
}
