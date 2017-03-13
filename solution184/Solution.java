package solution184;


public class Solution {
	
    public static String largestNumber(int[] num) {
        // write your code here
    	if(num==null || num.length==0){
    		return "";
    	}
    	String res="";
    	quickSort(num,0,num.length-1);
    	if(num[0]==0){
    		return "0";
    	}
    	for(int i=0;i<num.length;i++){
    		res+=String.valueOf(num[i]);
    	}
    	return res;
    }
    public static void quickSort(int[] num, int p, int q){
    	if(p>=q){
    		return;
    	}
    	int mid,tmp;
    	int i=p,j=q;
		mid=(p+q)/2;
    	while(i<=j){
    		while(isBigger(num[i],num[mid])>0){
    			i++;
    		}
    		while(isBigger(num[j],num[mid])<0){
    			j--;
    		}
    		if(i<=j){
	    		tmp=num[i];
	    		num[i]=num[j];
	    		num[j]=tmp;
	    		i++;
	    		j--;
    		}
    	}
    	quickSort(num,p,j);
    	quickSort(num,i,q);
    }
    public static int isBigger(int A, int B){
    	String tmp1=String.valueOf(A)+String.valueOf(B);
    	String tmp2=String.valueOf(B)+String.valueOf(A);   
    	return tmp1.compareTo(tmp2);
    }
    
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	int[] num={1,40,41,50,30,9,91};
    	System.out.println(largestNumber(num));
	}
}
