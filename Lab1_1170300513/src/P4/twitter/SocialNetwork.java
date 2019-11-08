/* Copyright (c) 2007-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package P4.twitter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;

/**
 * SocialNetwork provides methods that operate on a social network.
 * 
 * A social network is represented by a Map<String, Set<String>> where map[A] is
 * the set of people that person A follows on Twitter, and all people are
 * represented by their Twitter usernames. Users can't follow themselves. If A
 * doesn't follow anybody, then map[A] may be the empty set, or A may not even exist
 * as a key in the map; this is true even if A is followed by other people in the network.
 * Twitter usernames are not case sensitive, so "ernie" is the same as "ERNie".
 * A username should appear at most once as a key in the map or in any given
 * map[A] set.
 * 
 * DO NOT change the method signatures and specifications of these methods, but
 * you should implement their method bodies, and you may add new public or
 * private methods or classes if you like.
 */
public class SocialNetwork {

    /**
     * Guess who might follow whom, from evidence found in tweets.
     * 
     * @param tweets
     *            a list of tweets providing the evidence, not modified by this
     *            method.
     * @return a social network (as defined above) in which Ernie follows Bert
     *         if and only if there is evidence for it in the given list of
     *         tweets.
     *         One kind of evidence that Ernie follows Bert is if Ernie
     *         @-mentions Bert in a tweet. This must be implemented. Other kinds
     *         of evidence may be used at the implementor's discretion.
     *         All the Twitter usernames in the returned social network must be
     *         either authors or @-mentions in the list of tweets.
     */
    public static Map<String, Set<String>> guessFollowsGraph(List<Tweet> tweets) //Ҫ�󷵻�һ����׷���ߡ���׷�������ɵļ��ϡ��ļ�ֵ�Լ��ϣ��ж�׷������ͨ����@�˱�����ȷ����

    {
    	Map<String, Set<String>> socialnetwork = new TreeMap<>();
    	Filter filter = new Filter();//��Ҫ�õ�ǰ������ʱ�õ��������ࡣ
    	Extract extract = new Extract();
    	int i , j ,  k ,n = tweets.size();
    	List<String> username = new ArrayList<>();
    	for(i = 0 ; i < n ; i++)//�ȴ�tweets�е�usernameȡ������tweets�ġ�׷���ߡ���
    	{
    		if(!extract.isthesame(username, tweets.get(i).getAuthor()))
    		{
    			username.add(tweets.get(i).getAuthor());
    		}
    	}
    	for(i = 0 ; i < username.size() ; i++)
    	{	
    		List<Tweet> thisguy =  filter.writtenBy(tweets, username.get(i));//ȡ��ÿ����׷���ߡ���д��tweets��ѭ��һ��һ����������
    		Set<String> hisidol = extract.getMentionedUsers(thisguy);//��ȡ����Щtweets��@���������ɼ��ϣ���׷���ߡ�׷����ˣ���
    		socialnetwork.put(username.get(i), hisidol);//��Ӹü�ֵ�ԡ�
    	}
			

    
    	return socialnetwork;
    }

    /**
     * Find the people in a social network who have the greatest influence, in
     * the sense that they have the most followers.
     * 
     * @param followsGraph
     *            a social network (as defined above)
     * @return a list of all distinct Twitter usernames in followsGraph, in
     *         descending order of follower count.
     */
    public static List<String> influencers(Map<String, Set<String>> followsGraph) {//����ǰ��ļ�ֵ�Լ��ϼ���Ӱ�������а񣨱�׷�����Խ��Ӱ����Խ��
    	List<String> influence = new ArrayList<>();
    	List<people> rank = new ArrayList<>();
    	List<String> temp = new ArrayList<>();
       	Filter filter = new Filter();
    	Extract extract = new Extract();
    	int i , j;
    	for(String key : followsGraph.keySet() )
    	{
    		for(String idol : followsGraph.get(key))
    		{
    			if(!extract.isthesame(temp, idol))
    			{
    				temp.add(idol); //ȡ��map�����е�Set��������������������а��У�ע�������Ƿ��ظ�����isthesame������飩������û����һ���ȶ����ӡ�
    				people p = new people();
    				p.name = idol;
    				p.hot++;
    				rank.add(p);
    			}
    			else //��������������а��У�����Ӧ��������Ӱ������
    			{
    				int m = getindex(temp, idol);
    				people change = new people();
    				change = rank.get(m);
    				change.hot++;
    				rank.set(m, change);
    						
    			}
    		}
    	}
    	for(i = 0 ; i < rank.size() ; i++) //�����а�Ӱ������С��������
    	{
    		for(j = i ; j < rank.size() ; j++)
    		{
    			people up = new people();
    			if(rank.get(j).hot > rank.get(i).hot)
    			{
    				up = rank.get(j);
    				rank.set(j, rank.get(i));
    				rank.set(i, up);
    			}
    		}
    	}
    	for(i = 0 ; i < rank.size() ; i++)
    	{
    		influence.add(rank.get(i).name);
    	}
    	return influence;
    }
    public static List<String> gethashset(List<Tweet> tweets) //����������ȡ��tweets�����������С�#����ǩ�����乹���б���ԭ����ȡ@���ƣ�
    {
        List<String> mentionedusers = new ArrayList<>();
        int n = tweets.size();
        Extract extract = new Extract();
        List<String> temp = new ArrayList<>();
        int i , j;
        for(i = 0 ; i < n ; i++)
        {
        	String[] strarray = tweets.get(i).getText().split("#");
        	
        	for(j = 1 ; j < strarray.length ; j++)
        	{
        		String str1 = strarray[j].split(" ")[0];
        		if( !(extract.isthesame(temp, str1)))
        		{
        			
        			temp.add(str1);
        			mentionedusers.add("#"+str1);
        		}
        	}	
        }
        return mentionedusers;
    }
    public static boolean  isthesame(Set<String> mentionedusers , String m) //����������ȷ��ĳ�������Ƿ���һ���������ֵļ����
    {
		int j , flag = 0;
		for(String k : mentionedusers)
		{
			
			if(m.length() == k.length())
			{
				for(j = 0 ; j < m.length() ; j++)
				{
					if(!( (m.charAt(j) == k.charAt(j)) || (m.charAt(j) == k.charAt(j)-32) || (m.charAt(j) == k.charAt(j)+32) ))
						break;
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

    public static int getindex(List<String> mentionedusers , String m) //�����������ҵ��б��ж�Ӧ���ֵ��±ꡣ
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
    		if(flag == 1)
    		{
    			return i;
    		}
    	}
    	return -1;
    }
    public static Map<String, Set<String>> myguessFollowsGraph(List<Tweet> tweets)
    {
    	Map<String, Set<String>> socialnetwork = new TreeMap<>();
    	Filter filter = new Filter();//��Ҫ�õ�ǰ������ʱ�õ��������ࡣ
    	Extract extract = new Extract();
    	int i , j ,  k ,n = tweets.size();
    	List<String> username = new ArrayList<>();
    	for(i = 0 ; i < n ; i++)//�ȴ�tweets�е�usernameȡ������tweets�ġ�׷���ߡ���
    	{
    		if(!extract.isthesame(username, tweets.get(i).getAuthor()))
    		{
    			username.add(tweets.get(i).getAuthor());
    		}
    	}
    	for(i = 0 ; i < username.size() ; i++)
    	{	
    		List<Tweet> thisguy =  filter.writtenBy(tweets, username.get(i));//ȡ��ÿ����׷���ߡ���д��tweets��ѭ��һ��һ����������
    		Set<String> hisidol = extract.getMentionedUsers(thisguy);//��ȡ����Щtweets��@���������ɼ��ϣ���׷���ߡ�׷����ˣ���
    		socialnetwork.put(username.get(i), hisidol);//��Ӹü�ֵ�ԡ�
    	}
			
    	List<String> hashset = gethashset(tweets);//ȡ�����б�ǩ��
    	for(i = 0 ; i < hashset.size() ; i++)//ѭ�����ÿ����ǩ��
    	{
    		
    		List<String> hashsetcase = new ArrayList<>();
    		hashsetcase.add(0, hashset.get(i));
    		List<Tweet> interests = filter.containing(tweets, hashsetcase);//ȡ������tweets�а����ñ�ǩ��tweets��
    		for(j = 0 ; j < interests.size() ; j++)//��ע�ñ�ǩ��ĳ����Ӧ����׷���ע�ñ�ǩ�����������ˡ�
    		{
    			Set<String> lovers = socialnetwork.get(interests.get(j).getAuthor());
    			for(k = 0 ; k < interests.size() ; k++)
    			{
    				if((k != j) && !(isthesame(lovers, interests.get(k).getAuthor())))
    				{
    					lovers.add(interests.get(k).getAuthor());
    				}
    				
    			}
    			socialnetwork.put(interests.get(j).getAuthor(), lovers);
    		}
    		
    	}
    
    	return socialnetwork;
    }
}

class people //���츨����people����¼��Ӧ�����Լ���Ӱ����hot��
{
	public String name;
	public  int  hot = 0;
}