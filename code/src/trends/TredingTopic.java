package trends;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import stream.Config;
import twitter4j.Location;
import twitter4j.RateLimitStatus;
import twitter4j.ResponseList;
import twitter4j.Trend;
import twitter4j.Trends;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

public class TredingTopic {
	public static String username = "hemraj_kumawat";
	   public static String password = "mytwitteraccount";
	private static final String CONSUMER_KEY = "BB9YRzQ42gpUmUPC8iVT6y8Hb";
	 private static final String CONSUMER_SECRET = "O56dgWaU8eKpyOycWUoVNeONr9SWN9sm7x5Od1SES6LbqNDiKo";
	 private static final String ACCESS_TOKEN = "375078108-WTQvLrtn8JHc2as54lt9D3ayktWzD9SfKk8jAYHT";
	 private static final String ACCESS_TOKEN_SECRET = "54FZUk2xtKuymij4UUds5VqaIWwG8pU0li2Fjauv89hJ4";
	 	private static Twitter twitter = null;
		// construct Twitter instance using configuration
	 static {
	 ConfigurationBuilder cb1 = new ConfigurationBuilder();
	 cb1.setDebugEnabled(true);
	 cb1.setOAuthConsumerKey(CONSUMER_KEY);
	 cb1.setOAuthConsumerSecret(CONSUMER_SECRET);
	 cb1.setOAuthAccessToken(ACCESS_TOKEN);
	 cb1.setOAuthAccessTokenSecret(ACCESS_TOKEN_SECRET);
	 
	Configuration conf1 = cb1.build();
	 
	twitter = new TwitterFactory(conf1).getInstance();
	 }
	public static void main(String[] args) throws TwitterException {
		// TODO Auto-generated method stub

		// get screen name and # of tweets
		
		 
		// get trends by woeid (Where On Earth ID)
		 int woeid = 23424848; // woeid of India
		 System.out.println("Trends of India (woeid: " + woeid + "):");
		 List trendNames = getTrendsByWoeid(woeid);
		System.out.println(trendNames.size());
		 System.out.println(trendNames);
		 }
	
		
	 private static List getTrendsByWoeid(int woeid)
			 throws TwitterException {
			 List trendNames = new ArrayList();
			 Trends trends = twitter.getPlaceTrends(woeid);
			 Trend[] trend = trends.getTrends();
			 for (Trend t : trend) {
			 trendNames.add(t.getName());
			 }
			 return trendNames;
			 }
		
	}


