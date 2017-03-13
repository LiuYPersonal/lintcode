package solution74;
public class Solutions {

    public int findFirstBadVersion(int n) {
        // write your code here
    	if(n<1){
    		return 0;
    	}
    	if(n==1){
    		return 1;
    	}
    	int p=1;
    	int q=n;
    	int center;
    	while(p+1<q){
    		center=p+(q-p)/2;
//    		if(SVNRepo.isBadVersion(center)){
//    			q=center;
//    		}
//    		else{
//    			p=center;
//    		}
    	}
    	return q;
    }
}
