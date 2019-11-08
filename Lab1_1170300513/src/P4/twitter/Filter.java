/* Copyright (c) 2007-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package P4.twitter;

import java.util.ArrayList;
import java.util.List;

/**
 * Filter consists of methods that filter a list of tweets for those matching a
 * condition.
 * 
 * DO NOT change the method signatures and specifications of these methods, but
 * you should implement their method bodies, and you may add new public or
 * private methods or classes if you like.
 */
public class Filter {

    /**
     * Find tweets written by a particular user.
     * 
     * @param tweets
     *            a list of tweets with distinct ids, not modified by this method.
     * @param username
     *            Twitter username, required to be a valid Twitter username as
     *            defined by Tweet.getAuthor()'s spec.
     * @return all and only the tweets in the list whose author is username,
     *         in the same order as in the input list.
     */
    public static List<Tweet> writtenBy(List<Tweet> tweets, String username) {//Ѱ������tweets��ĳ������д��tweets�б�
       List<Tweet> message = new ArrayList<>();
       int i , j , n = tweets.size();
       for(i = 0 ; i < n ; i++)
       {
    	   String cmp = tweets.get(i).getAuthor();
    	   if(username.length() == cmp.length())
    	   {
    		   for(j = 0 ; j < cmp.length() ; j++) //�����ַ������ַ����бȽϡ�
    		   {
    			   if(!((username.charAt(j) == cmp.charAt(j)) ||  //��Դ�Сд�����ж���ӵıȽ�������
    					   (username.charAt(j) == cmp.charAt(j)+32) || 
    					   (username.charAt(j) == cmp.charAt(j)-32)))
    				   break;
    			   else if(j == cmp.length() - 1)
    			   {
    				   message.add(tweets.get(i));
    			   }
    		   }
    	   }
       }       
       return message;
    }

    /**
     * Find tweets that were sent during a particular timespan.
     * 
     * @param tweets
     *            a list of tweets with distinct ids, not modified by this method.
     * @param timespan
     *            timespan
     * @return all and only the tweets in the list that were sent during the timespan,
     *         in the same order as in the input list.
     */
    public static List<Tweet> inTimespan(List<Tweet> tweets, Timespan timespan) {//�ж�tweet��ʱ���Ƿ���ָ��ʱ����ڣ��������ӵ�Ӧ���ص��б��С�
    	List<Tweet> message = new ArrayList<>();
    	int i , n = tweets.size();
    	for(i = 0 ; i < n ; i++)
    	{
    		long time = tweets.get(i).getTimestamp().getEpochSecond();
    		if((time <= timespan.getEnd().getEpochSecond()) && 
    				(time >= timespan.getStart().getEpochSecond()))//�ж����Ƿ��ڸ�ʱ����ڡ�
    		{
    			message.add(tweets.get(i));
    		}
    	}
    	return message;
    }

    /**
     * Find tweets that contain certain words.
     * 
     * @param tweets
     *            a list of tweets with distinct ids, not modified by this method.
     * @param words
     *            a list of words to search for in the tweets. 
     *            A word is a nonempty sequence of nonspace characters.
     * @return all and only the tweets in the list such that the tweet text (when 
     *         represented as a sequence of nonempty words bounded by space characters 
     *         and the ends of the string) includes *at least one* of the words 
     *         found in the words list. Word comparison is not case-sensitive,
     *         so "Obama" is the same as "obama".  The returned tweets are in the
     *         same order as in the input list.
     */
    public static List<Tweet> containing(List<Tweet> tweets, List<String> words) {//������tweets��Ѱ��text�ﺬwords������ĵ��ʵ�tweets���ϡ�
    	List<Tweet> message = new ArrayList<>();
    	int i , j , r , l , n = tweets.size() , flag = 0;
    	for(i = 0 ; i < n ; i++)
    	{
    		String[] txt = tweets.get(i).getText().split(" ");//����Ҫ��text�и�ɵ������ʵ��ַ������ϡ�
    		int size = txt.length;
    		for(j = 0 ; j < size ; j++) //����ѭ���Խ��е�����ĸ������ĸ�ıȽϡ�
    		{
    			String k = txt[j];
    			for(r = 0 ; r < words.size(); r++)
    			{
    				String m = words.get(r);
    				if(m.length() == k.length())
    				{
    					for(l = 0 ; l < m.length() ; l++)
    					{
    						if(!( (m.charAt(l) == k.charAt(l)) || //��Դ�Сд�����ж���ӵıȽ�������
    								(m.charAt(l) == k.charAt(l)-32) || 
    								(m.charAt(l) == k.charAt(l)+32) ))
    							break;
    						else if(l == m.length() - 1)
    							flag = 1;
    					}
    				}
    			}
    		}
    		if(flag == 1)
    			message.add(tweets.get(i));
    		flag = 0;
    	}
    	
    	
    	return message;
    }

}
