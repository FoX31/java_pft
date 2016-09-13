package ru.stqa.pft.sandbox;

import com.sun.org.apache.bcel.internal.generic.RETURN;

/**
 * Created by e.kutsenko on 13.09.2016.
 */
public class Point{
  public int x;
  public int y;

  public static double distance(Point p1, Point p2){
    return Math.sqrt((p1.x - p2.x)^2 + (p1.y - p2.y)^2 );
  }
  public  Point(int x,int y) {
    this.x = x;
    this.y = y;
  }
}


