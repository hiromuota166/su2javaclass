import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public abstract class Shape {
  private static final double INTERSECTION_THRESHOLD = 2.0;
  public static final double MINIMUM_SHAPE_AREA = 0;
  protected Color color = Color.BLACK;

  public abstract void move(int dx, int dy);

  public abstract double area();

  public abstract String description();

  public abstract void resize(int x, int y);

  public abstract java.awt.Shape createPath();

  public boolean contains(int x, int y) {
    var path = this.createPath();
    return path.intersects(x - INTERSECTION_THRESHOLD / 2.0, y - INTERSECTION_THRESHOLD / 2.0,
        INTERSECTION_THRESHOLD, INTERSECTION_THRESHOLD);
  }

  protected abstract void drawShape2D(Graphics2D g2, java.awt.Shape path);

  public void draw(Graphics g) {
    g.setColor(this.color);
    var path = this.createPath();
    Graphics2D g2 = (Graphics2D) g;
    this.drawShape2D(g2, path);
  }

  public void setColor(Color color) {
    this.color = color;
  }

  protected String additionalDescription() {
    return String.format("color:#%02x%02x%02x%02x", this.color.getRed(), this.color.getGreen(),
        this.color.getBlue(), this.color.getAlpha());
  }
}
