package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by e.kutsenko on 22.09.2016.
 */
public class PointTest {

    @Test
  public void testArea() {

    Point a = new Point(2, 2);

    Point b = new Point(1, 2);
    assert a.distance(b) == 1.0;

  }
    @Test
  public void testArea1() {

    Point a = new Point(2, 2);

    Point b = new Point(1, 2);
    Assert.assertEquals(a.distance(b), 1.0);
  }
}
