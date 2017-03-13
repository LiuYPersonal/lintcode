package solution121;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution {
    public static List<List<String>> findLadders(String start, String end, Set<String> dict) {
        // write your code here  
    	if(dict==null ||dict.size()==0){
    		return null;
    	}
    	List<List<String>> res= new ArrayList<List<String>>();
    	if(start==end){
    		List<String> tmp=new ArrayList<String>();
    		tmp.add(start);
    		tmp.add(end);
    		res.add(tmp);
    		return res;
    	}
    	
    	Queue<String> BFS =new LinkedList<String>();
    	Map<String, Integer> Depth= new HashMap<String, Integer>();
    	Map<String, List<String>> pre=new HashMap<String, List<String>>();
		BFS.add(start);
		pre.put(start, null);
		Depth.put(start, 1);
		
		String cur;
		char[] tmp;
		String tmp2;
		int count;
		
		while(!BFS.isEmpty()){
			cur=BFS.poll();
			count=Depth.get(cur);
			for(int i=0;i<start.length();i++){
				tmp=cur.toCharArray();
				for(char c='a';c<='z';c++){
					tmp[i]=c;
					tmp2=String.valueOf(tmp);
					if(tmp2.equals(end)){
						boolean flag=false;
						if(!Depth.containsKey(tmp2)){
							Depth.put(tmp2, count+1);
							flag=true;
						}
						else{
							if(Depth.get(tmp2)==count+1){
								flag=true;
							}
						}
						if(flag){
							List<String> path=new ArrayList<String>();
							path.add(cur);
							pre.put(tmp2, path);
							res.addAll(findPath(pre,tmp2));
						}
					}
					else if(dict.contains(tmp2)){
						if(!Depth.containsKey(tmp2)){
							BFS.add(tmp2);
							Depth.put(tmp2, count+1);
							List<String> path=new ArrayList<String>();
							path.add(cur);
							pre.put(tmp2, path);
						}
						else{
							if(Depth.get(tmp2)==count+1){
								List<String> path=pre.get(tmp2);
								path.add(cur);
								pre.put(tmp2, path);
							}
						}
					}
				}
			}
		}
    	return res;	
    }
    public static List<List<String>> findPath(Map<String, List<String>> pre, String end){
    	List<List<String>> res=new ArrayList<List<String>>();
    	List<String> pre_node=pre.get(end);
    	if(pre_node==null){
    		List<String> path=new ArrayList<String>();	
    		path.add(end);
			res.add(path);
    		return res;
    	}
    	for(int i=0;i<pre_node.size();i++){
    		List<List<String>>res2=findPath(pre,pre_node.get(i));
			int size1=res2.size();
			for(int k=0;k<size1;k++){
				List<String> pre_nodes=new ArrayList<String>(res2.get(k));
				pre_nodes.add(end);
				if(!res.contains(pre_nodes)){
					res.add(pre_nodes);
				}
			}
		}
    	return res;
    }
    public static void main(String[] args){
    	String start="hit";
    	String end="cog";
    	Set<String> dict= new HashSet<String>();
    	dict.add("hot");
    	dict.add("dot");
    	dict.add("lot");
    	dict.add("dog");
    	dict.add("log");
    	System.out.println(findLadders(start,end,dict));
    }

}
