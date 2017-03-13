//package solution499;
//
//import java.util.Iterator;
//import java.util.StringTokenizer;
//
//class OutputCollector<K, V> {
//	     public void collect(K key, V value);
//	         // Adds a key/value pair to the output buffer
//}
//public class WordCount {
//
//    public static class Map {
//        public void map(String key, String value, OutputCollector<String, Integer> output) {
//            // Write your code here
//            // Output the results into output buffer.
//            // Ps. output.collect(String key, int value);
//        	StringTokenizer iter = new StringTokenizer(value);
//        	while(iter.hasMoreTokens()){
//        		String s=iter.nextToken();
//        		output.collect(s,1);
//        	} 
//        }
//    }
//
//    public static class Reduce {
//        public void reduce(String key, Iterator<Integer> values,
//                           OutputCollector<String, Integer> output) {
//            // Write your code here
//            // Output the results into output buffer.
//            // Ps. output.collect(String key, int value);
//        	int sum = 0;
//        	while (values.hasNext()) {
//				sum += values.next();
//			}
//        	output.collect(key, sum);
//    }
//}
