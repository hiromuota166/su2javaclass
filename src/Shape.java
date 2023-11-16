import java.awt.Graphics;
public abstract class Shape {
  private static final double INTERSECTION_THRESHOLD = 2.0;
  public static final double MINIMUM_SHAPE_AREA = 0;

  public abstract void move(int dx, int dy);
  public abstract double area();
  public abstract String description();
  public abstract void draw(Graphics g);
  public abstract void resize(int x, int y);
  public abstract java.awt.Shape createPath();
  public boolean contains(int x, int y) {
    var path = this.createPath();
    return path.intersects(x - INTERSECTION_THRESHOLD / 2.0,
    y - INTERSECTION_THRESHOLD / 2.0,
    INTERSECTION_THRESHOLD, INTERSECTION_THRESHOLD);
  }
}
