package Exceptions;
/**
 * ������������ϳ��ֱ�ǩ��ͬ������쳣
 * @author junbaba
 *
 */
public class TheSameTagRException extends Exception
{
	private Object o;
	
	public TheSameTagRException(Object o) 
	{
		this.o = o;
	}
	
	public String showwrong()
	{
		StringBuilder str = new StringBuilder();
		str.append(o.toString() + " is already in the CircularOrbit System!");
		return str.toString();
	}
}
