import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TweetCount {

	
	Map<String, Set<Long>> teweetData=new HashMap<>();
	 enum Frequency {
		HOUR,
		MINUTE,
		DAY
	}
	 
	 public void recordTweet(String tweetName, long time) {
		 if(null == teweetData.get(tweetName)) {
			 Set<Long> tweetTimeSet=new HashSet<>();
			 teweetData.put(tweetName, tweetTimeSet);
		 }else {
			 Set<Long> tweetTimeSet=teweetData.get(tweetName);
			 tweetTimeSet.add(time);
		 }
	 }

	 public long[] getTweetCountsPerFrequency(Frequency freq, String tweetName, long startTime, long endTime) {
	
		 List<Long> tweetCounts=new ArrayList<>();
		 // get all tweets for the given tweet name
		 Set<Long> tweetTimesSet= teweetData.get(tweetName);
		 // filter the list based on start and end time
		 for(Long time:tweetTimesSet) {
			LocalDateTime tweetTime=Instant.ofEpochMilli(time).atZone(ZoneId.systemDefault()).toLocalDateTime();
			LocalDateTime startDateTime=Instant.ofEpochMilli(startTime).atZone(ZoneId.systemDefault()).toLocalDateTime();
			LocalDateTime endDateTime=Instant.ofEpochMilli(endTime).atZone(ZoneId.systemDefault()).toLocalDateTime();
			
			if(tweetTime.isAfter(startDateTime) && tweetTime.isBefore(endDateTime)) {
				tweetCounts.add(time);
			}
		 }
		 
		 // arrange them as per frequency
		 
		 
		 return 0;
	 }
	 
	 public static void main(String[] args) {
		 TweetCount tc=new TweetCount();
		 tc.recordTweet("tweet1", 123123);
		 tc.recordTweet("tweet1", 123123);
		 tc.recordTweet("tweet1", 123123);
		 tc.recordTweet("tweet1", 123123);
		 tc.recordTweet("tweet1", 123123);
		 tc.recordTweet("tweet1", 123123);
		 
		 
	}
}
