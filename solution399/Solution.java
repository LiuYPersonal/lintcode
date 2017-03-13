package solution399;
class NBCompare {
	     public int cmp(String a, String b){
	    	 for(int i=0;i<a.length();i++){
	    		 if(a.charAt(i)-b.charAt(i)<32){
	    			 return 1;
	    		 }
	    		 else if (a.charAt(i)-b.charAt(i)>32){
	    			 return -1;
	    		 }
	    	 }
	    	 return 0;
	     }
}
public class Solution {
	
    public void sortNutsAndBolts(String[] nuts, String[] bolts, NBCompare compare) {
        // write your code here
    	if(nuts.length==0 || nuts.length!=bolts.length){
    		return;
    	}
    	qSort(nuts,bolts,compare,0,nuts.length-1);
    }
    public void qSort(String[] nuts, String[] bolts, NBCompare compare, int p, int q){
    	if(p>=q){
    		return;
    	}
    	int part_index=partition(nuts,bolts[p],compare,p,q);
    	partition(bolts, nuts[part_index],compare,p,q);
    	qSort(nuts,bolts,compare,p,part_index-1);
    	qSort(nuts,bolts,compare,part_index+1,q);
    	
    }
    public int partition(String[] str, String pivot, NBCompare compare, int p, int q){
    	//对齐pivot
    	String tmp;
    	for(int i=p;i<=q;i++){
    		if(compare.cmp(str[i], pivot)==0 || compare.cmp(pivot,str[i])==0){
    			tmp=str[i];
    			str[i]=str[p];
    			str[p]=tmp;
    			break;
    		}
    	}
    	int left=p,right=q;
    	while(left<=right){
    		while(compare.cmp(str[left],pivot)==1 || compare.cmp(pivot,str[left])==1){
    			left++;
    		}
    		while(compare.cmp(str[right], pivot)==-1 || compare.cmp(pivot,str[right])==1){
    			right--;
    		}
    		if(left<right){
    			tmp=str[left];
    			str[left]=str[right];
    			str[right]=tmp;
    			left++;
    			right--;
    		}
    	}
    	if(str[left]==pivot){
    		return left;
    	}
		return right;
    }
}
