/* Copyright (c) 2015-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package P1.graph;




import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;



/**
 * An implementation of Graph.
 * 
 * <p>PS2 instructions: you MUST use the provided rep.
 */
public class ConcreteEdgesGraph<L> implements Graph<L> {
    
    private final Set<L> vertices = new HashSet<>();
    private final List<Edge<L>> edges = new ArrayList<>();
    
    // Abstraction function:
    // ����vertices�е�ÿһ��Ԫ�ض�Ӧͼ�еĵ㣬��edges���б���ÿһ���߶�Ӧͼ�еıߡ�
    
    // Representation invariant:
    // vertices != null
    // edges != null
    // Edge����ʼ�����ֹ���������ڵ㼯vertices�С�
   
    
    // Safety from rep exposure:
    // Use private to prevent the parameter from exposure.
    
    // TODO constructor
    public  ConcreteEdgesGraph() 
    {
		
	}
    
    // TODO checkRep
    public void checkRep()
    {
    	assert vertices != null;
    	assert edges != null;
    }
    

    

    
    @Override public boolean add(L vertex) {
    	//�����е㼯��Ԫ�����µĵ���жԱȣ����������ͬ˵���ظ�������false.
    	for(L v : vertices) 
        {
        	if(v.equals(vertex))
        	{
        		return false;
        	}
        }
      //�粻�ظ��򽫸õ������㼯������true��
        vertices.add(vertex);
        return true;
    }
    
    @Override public int set(L source, L target, int weight) {
        Edge<L> newone = new Edge<L>(source, target, weight);
        int i , flag = 0;
      //�ж�source��target�����Ƿ��ڵ㼯�ڣ����������򷵻�-1.
        for(L v : vertices) 
        {
        	if(v.equals(source))
        		flag++;
        	if(v.equals(target))
        		flag++;
        }
        if(flag != 2)
        {
        	return -1;
        }
        //�жϸñ��Ƿ����ڱ߼��С�
        for(i = 0 ; i < edges.size() ; i++)
        {
        	Edge<L> edge = edges.get(i);
        	//���ڸñ߼��С�
        	if(edge.getsource().equals(source) && edge.gettarget().equals(target))
        	{
        		//��ȨֵΪ0˵��Ҫ�Ƴ��ñߡ�
        		if(weight == 0)
        		{
        			edges.remove(i);
        		}
        		//��Ȩֵ��Ϊ0���޸ĸ�Ȩֵ��
        		else
        		{
        			edges.set(i, newone);
        		}
        		//����ԭȨֵ��
        		return edge.getweight();
        	}
        }
        //���ڱ߼�������߼���Ӹñ߲�����0.
        edges.add(newone);
        checkRep();
        return 0;
    }
    
    
    @Override public boolean remove(L vertex) {
    	//Ѱ�ҵ㲢ɾ����ͬʱɾ�����������ıߡ��ɹ�����true,ʧ�ܷ���false��
        for(L v : vertices)
        {
        	if(v.equals(vertex))
        	{
        		vertices.remove(v);
        		for(Edge<L> edge : edges)
        		{
        			if(edge.getsource().equals(v) || edge.gettarget().equals(v))
        			{
        				edges.remove(edge);
        			}
        		}
        		checkRep();
        		return true;
        	}
        }
        checkRep();
        return false;
    }
    
    
    @Override public Set<L> vertices() {
    	//���ص㼯�����ü��ɡ�
        return vertices;
    }
    
    //������ӣ����ر߼����ã�Ϊ������ԡ�
    public List<Edge<L>> edges() 
    {
		return edges;
	}
    
    @Override public Map<L, Integer> sources(L target) {
    	//�ڱ߼���Ѱ��target�㣬������Ӧ��source�����ߵ�Ȩֵ��һ�Լ�ֵ�Լ����ֵ�Լ����С�
    	Map<L, Integer> sourcesguide = new TreeMap<L, Integer>();
    	for(Edge<L> edge : edges)
    	{
    		if(edge.gettarget().equals(target))
    		{
    			sourcesguide.put(edge.getsource(), edge.getweight());
    		}
    	}

    	return sourcesguide; 
    }
    
    @Override public Map<L, Integer> targets(L source) {
    	//�ڱ߼���Ѱ��source�㣬������Ӧ��target�����ߵ�Ȩֵ��һ�Լ�ֵ�Լ����ֵ�Լ����С�
    	Map<L, Integer> targetsguide = new TreeMap<L, Integer>();
    	for(Edge<L> edge : edges)
    	{
    		if(edge.getsource().equals(source))
    		{
    			targetsguide.put(edge.gettarget(), edge.getweight());
    		}
    	}
    	return targetsguide;
    }
    
    // TODO toString()
    //����StringBuilder��дtoString������Ϊ�˸�ֱ�۵�չʾ���ࡣ
    @Override public String toString()
    {
    	StringBuilder str = new StringBuilder();
    	str.append("Vertices: \n");
    	for(L v : vertices)
    	{
    		str.append(v + "\n");
    	}
    	str.append("Edges: \n");
    	for(Edge<L> edge : edges)
    	{
    		str.append(edge.toString() + "\n");
    	}
    	return str.toString();
    }
    
}

/**
 * TODO specification
 * Immutable.
 * This class is internal to the rep of ConcreteEdgesGraph.
 * 
 * <p>PS2 instructions: the specification and implementation of this class is
 * up to you.
 */
class Edge<L> {
    
    // TODO fields
    private final L source;
    private final L target;
    private final int weight;
    
  

    // Abstraction function:
    // weight��ʾȨֵ��source��ʾ�ߵĳ����㣬target��ʾ�ߵ�Ŀ�ĵ㣬���߱�������һ���ߡ�

    //Representation invariant:
    // weight > 0.
    // source != null
    // target != null
    
    // Safety from rep exposure:
    //   Use private to prevent the parameter from exposure.
    
    // TODO constructor
    Edge(L source , L target , int weight)
    {
    	this.source = source;
    	this.target = target;
    	this.weight = weight;
    }
    
    // TODO checkRep
    public void checkRep()
    {
    	assert weight > 0;
    	assert target != null;
    }

    
    // TODO methods:To get the private parameters.
    public  L getsource()
    {
    	return source;
    }
    
    public L gettarget()
    {
    	return target;
	}
    
    public int getweight()
    {
    	return weight;
    }
    
    // TODO toString()
    @Override public String toString() 
    {
    	return "(" + this.getsource() + "," + this.gettarget() + ") : " +  this.getweight() ;
    }
}
