//package solution501;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//class Tweet {
//	     public int id;
//	     public int user_id;
//	     public String text;
//	     public Tweet(){
//	    	 
//	     }
//	     public static Tweet create(int user_id, String tweet_text) {
//	         // This will create a new tweet object,
//	         // and auto fill id
//	    	 Tweet tweet=new Tweet();
//	    	 tweet.id=1;
//	    	 tweet.user_id=user_id;
//	    	 tweet.text=tweet_text;
//	    	 return tweet;
//	 }
//}
//public class MiniTwitter {
//    class Node {
//        int order;
//        Tweet tweet;
//        Node(int o, Tweet t){
//        	this.order=o;
//        	this.tweet=t;
//        }
//    };
//    Map<Integer,ArrayList<Integer>> followers;
//    Map<Integer,ArrayList<Tweet>> tweets;
//    int order;
//    public MiniTwitter() {
//        // initialize your data structure here.
//    	followers=new HashMap<Integer, ArrayList<Integer>>();
//    	tweets=new HashMap<Integer,ArrayList<Tweet>>();
//    	order=0;
//    }
//
//    // @param user_id an integer
//    // @param tweet a string
//    // return a tweet
//    public Tweet postTweet(int user_id, String tweet_text) {
//        //  Write your code here
//    	Tweet newtweet = Tweet.create(user_id, tweet_text);
//    	ArrayList<Tweet> tmp;
//    	if(tweets.containsKey(newtweet.user_id)){
//    		tmp=tweets.get(newtweet.user_id);
//    	}
//    	else{
//    		tmp=new ArrayList<Tweet>();
//    	}
//		tmp.add(newtweet);
//		tweets.put(newtweet.user_id, tmp);
//		order++;
//    	return newtweet;
//    }
//
//    // @param user_id an integer
//    // return a list of 10 new feeds recently
//    // and sort by timeline
//    public List<Tweet> getNewsFeed(int user_id) {
//        // Write your code here
//    	List<Tweet> res =new ArrayList<Tweet>();
//    	if(tweets.containsKey(user_id)){
//    		return tweets.get(user_id);
//    	}
//    	return res;
//    }
//        
//    // @param user_id an integer
//    // return a list of 10 new posts recently
//    // and sort by timeline
//    public List<Tweet>  getTimeline(int user_id) {
//        // Write your code here
//    }
//
//    // @param from_user_id an integer
//    // @param to_user_id an integer
//    // from user_id follows to_user_id
//    public void follow(int from_user_id, int to_user_id) {
//        // Write your code here
//    	
//    }
//
//    // @param from_user_id an integer
//    // @param to_user_id an integer
//    // from user_id unfollows to_user_id
//    public void unfollow(int from_user_id, int to_user_id) {
//        // Write your code here
//    }
//}