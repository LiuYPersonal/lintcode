package solution58;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.HashMap;
class Pair{
	int x,y,ind_x,ind_y;;
	public Pair(int x, int y, int ind_x, int ind_y){
		this.x=x;
		this.y=y;
		this.ind_x=ind_x;
		this.ind_y=ind_y;
	}
}

public class Solution {
	

    public static ArrayList<ArrayList<Integer>> fourSum(int[] numbers, int target) {
    	
    	ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
    	
		if(numbers==null || numbers.length<3){
			return res;
		}
		Arrays.sort(numbers);
		HashMap<Integer,ArrayList<Pair>>map=new HashMap<Integer,ArrayList<Pair>>();
		Pair tmp;
		ArrayList<Pair> pairList;
		for(int i=0;i<numbers.length;i++){
			for(int j=i+1;j<numbers.length;j++){
				tmp= new Pair(numbers[i],numbers[j],i,j);
				if(!map.containsKey(numbers[i]+numbers[j])){
					pairList=new ArrayList<Pair>();
					pairList.add(tmp);
					map.put(numbers[i]+numbers[j], pairList);
				}
				else{
					pairList=map.get(numbers[i]+numbers[j]);
					pairList.add(tmp);
					map.put(numbers[i]+numbers[j], pairList);
				}
			}
		}
		ArrayList<Integer> tmp_res;
		int tmp_target=0;
		for(int i=0;i<numbers.length;i++){
			for(int j=i+1;j<numbers.length;j++){
				tmp_target=target-numbers[i]-numbers[j];
				if(map.containsKey(tmp_target)){
					pairList=map.get(tmp_target);
					for(int k=0;k<pairList.size();k++){
						tmp=pairList.get(k);
						if(tmp.ind_x>j && tmp.ind_y>j){
							tmp_res=new ArrayList<Integer>();
							tmp_res.add(tmp.x);
							tmp_res.add(tmp.y);
							tmp_res.add(0,numbers[j]);
							tmp_res.add(0,numbers[i]);
							if(!res.contains(tmp_res)){
								res.add(tmp_res);
							}
						}
					}
				}
			}
		}
    return res;
	}
    
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	int[] nums={1, 0, -1, 0, -2, 2};
    	System.out.println(fourSum(nums, 0));
	}

}
