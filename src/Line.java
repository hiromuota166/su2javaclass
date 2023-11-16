import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

public class Line extends Shape {
  private int x1;
  private int y1;
  private int x2;
  private int y2;

  public Line(int x1, int y1, int x2, int y2) {
    this.x1 = x1;
    this.y1 = y1;
    this.x2 = x2;
    this.y2 = y2;
  }

  @Override
  public java.awt.Shape createPath() {
  return new Line2D.Double(this.x1, this.y1, this.x2, this.y2);
  }

  @Override
  public void resize(int x, int y) {
    this.x2 = x;
    this.y2 = y;
  }

  @Override
  public double area() {
    int dx = this.x2 - this.x1;
    int dy = this.y2 - this.y1;
    return Math.sqrt(dx * dx + dy * dy);
  }

  @Override
  public String description() {
    return String.format("<Line: start:(%d, %d) end:(%d, %d) area:%.2f>", this.x1, this.y1, this.x2,
        this.y2, this.area());
  }

  @Override
  public void draw(Graphics g) {
    var path = this.createPath();
    Graphics2D g2 = (Graphics2D) g;
    g2.draw(path);
  }
}
