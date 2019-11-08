/* Copyright (c) 2007-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package P2.turtle;

import java.util.List;
import java.util.Set;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class TurtleSoup {

    /**
     * Draw a square.
     * 
     * @param turtle the turtle context
     * @param sideLength length of each side
     */
    public static void drawSquare(Turtle turtle, int sideLength) {
    	int i;
    	for(i = 0 ; i < 4 ; i++) //���������Ĵ�ѭ����ת�򼴿ɡ�
    	{
    		turtle.forward(sideLength);
    		turtle.turn(90);
    	}    	
        
    }

    /**
     * Determine inside angles of a regular polygon.
     * 
     * There is a simple formula for calculating the inside angles of a polygon;
     * you should derive it and use it here.
     * 
     * @param sides number of sides, where sides must be > 2
     * @return angle in degrees, where 0 <= angle < 360
     */
    public static double calculateRegularPolygonAngle(int sides) {
        return ((double)sides - 2) * 180 / sides; //�ɱ������εĽǹ�ʽ��
    }

    /**
     * Determine number of sides given the size of interior angles of a regular polygon.
     * 
     * There is a simple formula for this; you should derive it and use it here.
     * Make sure you *properly round* the answer before you return it (see java.lang.Math).
     * HINT: it is easier if you think about the exterior angles.
     * 
     * @param angle size of interior angles in degrees, where 0 < angle < 180
     * @return the integer number of sides
     */
    public static int calculatePolygonSidesFromAngle(double angle) {
        int m = (int)(360/(180-angle));
        double n = 360/(180-angle);
        if(n - m > 0.5)
        	return m + 1;
        else
        	return m;
    }

    /**
     * Given the number of sides, draw a regular polygon.
     * 
     * (0,0) is the lower-left corner of the polygon; use only right-hand turns to draw.
     * 
     * @param turtle the turtle context
     * @param sides number of sides of the polygon to draw
     * @param sideLength length of each side
     */
    public static void drawRegularPolygon(Turtle turtle, int sides, int sideLength) {
        int i;
        double jd = 180 - calculateRegularPolygonAngle(sides); //��Ӧת�Ƕȡ�
        for(i = 0 ; i < sides ; i++) //���ж���α�����ѭ���Ի�ͼ��
        {
        	turtle.forward(sideLength);
        	turtle.turn(jd);
        }
    }

    /**
     * Given the current direction, current location, and a target location, calculate the Bearing
     * towards the target point.
     * 
     * The return value is the angle input to turn() that would point the turtle in the direction of
     * the target point (targetX,targetY), given that the turtle is already at the point
     * (currentX,currentY) and is facing at angle currentBearing. The angle must be expressed in
     * degrees, where 0 <= angle < 360. 
     *
     * HINT: look at http://en.wikipedia.org/wiki/Atan2 and Java's math libraries
     * 
     * @param currentBearing current direction as clockwise from north
     * @param currentX current location x-coordinate
     * @param currentY current location y-coordinate
     * @param targetX target point x-coordinate
     * @param targetY target point y-coordinate
     * @return adjustment to Bearing (right turn amount) to get to target point,
     *         must be 0 <= angle < 360
     */
    public static double calculateBearingToPoint(double currentBearing, int currentX, int currentY,
                                                 int targetX, int targetY) {
    	
        int dx = currentX - targetX; //���������֮��
        int dy = currentY - targetY;//����������֮��
        double jd1 = 90 - Math.atan2((double)-dy,(double) -dx)/Math.PI*180; //����atan2���������Ƕȡ�
        double jd2;
        if(jd1 > currentBearing) //��Ϊ����������۵ó����Ľ����
           jd2 = jd1 - currentBearing;
        else if(jd1 == currentBearing)
            jd2 = 0;
        else
            jd2 = 360.0 + jd1 - currentBearing;
        return jd2;
        
    }

    /**
     * Given a sequence of points, calculate the Bearing adjustments needed to get from each point
     * to the next.
     * 
     * Assumes that the turtle starts at the first point given, facing up (i.e. 0 degrees).
     * For each subsequent point, assumes that the turtle is still facing in the direction it was
     * facing when it moved to the previous point.
     * You should use calculateBearingToPoint() to implement this function.
     * 
     * @param xCoords list of x-coordinates (must be same length as yCoords)
     * @param yCoords list of y-coordinates (must be same length as xCoords)
     * @return list of Bearing adjustments between points, of size 0 if (# of points) == 0,
     *         otherwise of size (# of points) - 1
     */
    public static List<Double> calculateBearings(List<Integer> xCoords, List<Integer> yCoords) { //�Զ�����ʽ����calculateBearingToPoint������ֵ��
        
        List<Double> bearings = new ArrayList<>();
        int i;
        double temp;
        for(i = 0 ; i < xCoords.size() - 1; i++)
        {
        	if(i == 0)
        		temp = 0;
        	else
        		temp = bearings.get(i - 1);
        	bearings.add(i,calculateBearingToPoint(temp, xCoords.get(i), yCoords.get(i), xCoords.get(i+1), yCoords.get(i+1)));
        }
        return bearings;
        
    }
    
    /**
     * Given a set of points, compute the convex hull, the smallest convex set that contains all the points 
     * in a set of input points. The gift-wrapping algorithm is one simple approach to this problem, and 
     * there are other algorithms too.
     * 
     * @param points a set of points with xCoords and yCoords. It might be empty, contain only 1 point, two points or more.
     * @return minimal subset of the input points that form the vertices of the perimeter of the convex hull
     */
    public static Set<Point> convexHull(Set<Point> points) {
        Set<Point> hull = new HashSet<Point>();
        int i = 1 , j;
        int n = points.size() + 1;
        Point[] mypoints = new Point[n];
        boolean[] vis = new boolean[n];
        for(Point p : points)
        {
        	mypoints[i] = p;
        	i++;
        }
        if(n > 1) //��������������Խ�����⡣
        {	//x���ȼ���ߣ�y���ȼ���ε������ҳ�����ߵĵ���Ϊ��ʼ�㣩
        	Point temp;
        	for(i = 1 ; i < n ; i++) 
        	{
        		for(j = i ; j < n ; j++)
        		{
        			if(mypoints[j].x() < mypoints[i].x())
        			{
        				temp = mypoints[i];
        				mypoints[i] = mypoints[j];
        				mypoints[j] = temp;
        			}
        		}
        	}
        	for(i = 1 ; i < n ; i++)
        	{
        		for(j = i ; j < n ; j++)
        		{
        			if(mypoints[j].y() < mypoints[i].y() && mypoints[j].x() == mypoints[i].x())
        			{
        				temp = mypoints[i];
        				mypoints[i] = mypoints[j];
        				mypoints[j] = temp;
        			}
        		}
        	}
            vis[1] = true;//����ʼ�����͹���㼯�С�
            hull.add(mypoints[1]);
        }
        int in = 1;
        while(true) //����������е����������������Ѱ��͹���ϵĵ㡣
        {
        	int not = -1; 
        	for (i = 1; i < n ; i++) 
        	 {
                 if (!vis[i]) 
                 {
                     not = i;
                     break;
                 }
        	 }
        	if(not == -1)
        		break;
        	for(i = 1; i < n ; i++)
        	{
        		if ((cross(mypoints[in], mypoints[i], mypoints[not]) > 0) //��������Ϊ��ʱ����ת��ϵ���ڶ��������ڵ�һ��������ࣩ
                        || (cross(mypoints[in], mypoints[i], mypoints[not]) == 0) //�������ߡ�
                        && (distance(mypoints[in], mypoints[i]) > distance(mypoints[in], mypoints[not])))//������in������Զ��
                    		not = i; //˵����i�����ԭ����not�������͹���ϵĵ�����ʣ���˽��н�����
        	}
        	if(vis[not])
        		break;
        	hull.add(mypoints[not]);
        	vis[not] = true;
        	in = not;
        }	
        return hull;
    }
    
    /**
     * Draw your personal, custom art.
     * 
     * Many interesting images can be drawn using the simple implementation of a turtle.  For this
     * function, draw something interesting; the complexity can be as little or as much as you want.
     * 
     * @param turtle the turtle context
     */
    public static void drawPersonalArt(Turtle turtle) {
        PenColor color = PenColor.RED;
        int i;
        turtle.color(color);//ת����ɫ��
        for(i = 0 ; i <= 180 ; i+=1) //����ǰ������ת�ǶȵĹ�ϵ��һ����Բ��
        {
        	turtle.forward(1);
        	turtle.turn(1);
        }
        for(i = 0 ; i <= 45; i+=1) //���˷�֮һ��Բ��
        {
        	turtle.forward(2);
        	turtle.turn(1);
        }
        for(i = 0 ; i <= 37; i+=1) //ֱ��ǰ����
        {
        	turtle.forward(3);
        }
        turtle.turn(90);
        for(i = 0 ; i <= 37; i+=1) //�������������ĶԳƲ�������󻭳�һ�����ġ�
        {
        	turtle.forward(3);
        }
        for(i = 0 ; i <= 45 ; i+=1)
        {
        	turtle.forward(2);
        	turtle.turn(1);
        }
        for(i = 0 ; i <= 180 ; i+=1)
        {
        	turtle.forward(1);
        	turtle.turn(1);
        }
        i = 3;
        for(PenColor c : PenColor.values()) //ÿ��ѭ������ɫ������Ρ�
        {
        	turtle.color(c);
        	drawRegularPolygon(turtle, i, 35);
        	i++;
        }
        turtle.forward(35);
        turtle.turn(180);
        i = 3;
        for(PenColor c : PenColor.values())
        {
        	turtle.color(c);
        	drawRegularPolygon(turtle, i, 35);
        	i++;
        }
        
}


    /**
     * Main method.
     * 
     * This is the method that runs when you run "java TurtleSoup".
     * 
     * @param args unused
     */
    public static void main(String args[]) {
        DrawableTurtle turtle = new DrawableTurtle();

        drawPersonalArt(turtle);

        // draw the window
        turtle.draw();
    }
    public static  double cross(Point c, Point a, Point b)  //��������ļ��㺯����
    {
        return (c.x() - a.x()) * (a.y() - b.y()) - (c.y() - a.y()) * (a.x() - b.x());
    }
    public static double distance(Point p1, Point p2) { //���������ĺ�����
        return (Math.hypot((p1.x() - p2.x()), (p1.y() - p2.y())));
    }
}
