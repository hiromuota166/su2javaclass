import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class Rectangle extends Shape {
  private int left;
  private int top;
  private int width;
  private int height;

  public Rectangle(int left, int top, int width, int height) {
    this.left = left;
    this.top = top;
    this.width = width;
    this.height = height;
  }

  @Override
  public java.awt.Shape createPath() {
    return new Rectangle2D.Double(this.left, this.top, this.width, this.height);
  }

  @Override
  public double area() {
    return Math.abs(this.width * this.height);
  }

  @Override
  public void resize(int x, int y) {
    this.width = x - this.left;
    this.height = y - this.top;
  }

  @Override
  public String description() {
    return String.format("<Rectangle: left:%d top:%d width:%d height:%d area:%.2f>", this.left,
        this.top, this.width, this.height, this.area());
  }

  @Override
  public void draw(Graphics g) {
    var path = this.createPath();
    Graphics2D g2 = (Graphics2D) g;
    g2.fill(path);
  }
}
