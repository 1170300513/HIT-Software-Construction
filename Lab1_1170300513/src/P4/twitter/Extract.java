/* Copyright (c) 2007-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package P4.twitter;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * Extract consists of methods that extract information from a list of tweets.
 * 
 * DO NOT change the method signatures and specifications of these methods, but
 * you should implement their method bodies, and you may add new public or
 * private methods or classes if you like.
 */
public class Extract {

    /**
     * Get the time period spanned by tweets.
     * 
     * @param tweets
     *            list of tweets with distinct ids, not modified by this method.
     * @return a minimum-length time interval that contains the timestamp of
     *         every tweet in the list.
     */
    public static Timespan getTimespan(List<Tweet> tweets) { //��tweets��ʱ�������ȡ��һ�������һ����ʱ�䴴��timepan�෵�ؼ��ɡ�
    	
    	int i , j , n = tweets.size();
        for(i = 0 ; i < n ; i++)
        {
        	for(j = i ; j < n ; j++)
        	{
        		if(tweets.get(j).getTimestamp().getEpochSecond() < tweets.get(i).getTimestamp().getEpochSecond())
        		{
        			Tweet temp = tweets.get(j);
        			tweets.set(j, tweets.get(i));
        			tweets.set(i, temp);
        		}
        	}
        }

        Timespan timespan = new Timespan(tweets.get(0).getTimestamp(),tweets.get(n-1).getTimestamp());
        return timespan;
    }

    /**
     * Get usernames mentioned in a list of tweets.
     * 
     * @param tweets
     *            list of tweets with distinct ids, not modified by this method.
     * @return the set of usernames who are mentioned in the text of the tweets.
     *         A username-mention is "@" followed by a Twitter username (as
     *         defined by Tweet.getAuthor()'s spec).
     *         The username-mention cannot be immediately preceded or followed by any
     *         character valid in a Twitter username.
     *         For this reason, an email address like bitdiddle@mit.edu does NOT 
     *         contain a mention of the username mit.
     *         Twitter usernames are case-insensitive, and the returned set may
     *         include a username at most once.
     */
    public static Set<String> getMentionedUsers(List<Tweet> tweets) 
    {
        Set<String> mentionedusers = new HashSet<>();
        int n = tweets.size();
        List<String> temp = new ArrayList<>();
        int i , j;
        for(i = 0 ; i < n ; i++)
        {
        	String[] strarray = tweets.get(i).getText().split("@");//�ȶ�text��@�����и�������ַ�������ĵڶ�����ʼ����@����ַ�����
        	
        	for(j = 1 ; j < strarray.length ; j++)
        	{
        		String str1 = strarray[j].split(" |:")[0];//�ٶ�@����ַ������ո�򣺽����и�Ӷ�ȡ��@��ĵ��ʡ�
        		if(islegal(str1) && !(isthesame(temp, str1)))//�жϸõ����Ƿ�Ϸ������û��������Ҳ��ڼ����У�����Ǿ���ӵ������С�
        		{
        			temp.add(str1);
        			mentionedusers.add(str1);
        		}
        	}	
        }
        return mentionedusers;
    }
    public static boolean  isthesame(List<String> mentionedusers , String m) //�ж���ͬ�ַ����Ƿ��Ѿ��ڼ������ˡ�
    {
		int n = mentionedusers.size();
		int i , j , flag = 0;
		for(i = 0 ; i < n ; i++)
		{
			String k = mentionedusers.get(i);
			if(m.length() == k.length())
			{
				for(j = 0 ; j < m.length() ; j++)
				{
					if(!( (m.charAt(j) == k.charAt(j)) || (m.charAt(j) == k.charAt(j)-32) || (m.charAt(j) == k.charAt(j)+32) ))
						break;//�����ַ���ĸ�д�Сд�Ĺ�ϵ��ʵ�ִ�Сд�����е���ͬ�ַ����жϡ�
					else if(j == m.length() - 1)
						flag = 1;
				}
			}
		}
		if(flag == 1)
			return true;
		else
			return false;
    }
    public static boolean islegal(String m) //�ж��ַ����Ƿ����tweet���û�����Ҫ��
    {
    	int i;
    	for(i = 0 ; i < m.length() ; i++)
    	{
    		char ch = m.charAt(i);
    		if((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch == '-') || (ch == '_')|| (ch >= '0' && ch <= '9'))
    			continue; //ÿ���ַ���Ϊa-z��A-Z��-��_�����ַ��źϷ���
    		else 
    			return false;
    	}
    	return true;
    }
}
