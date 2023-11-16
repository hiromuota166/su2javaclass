import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;

class EquilateralTriangle extends Shape {
  private int left;
  private int top;
  private int width;

  public EquilateralTriangle(int left, int top, int width) {
    this.left = left;
    this.top = top;
    this.width = width;
  }
  @Override
  public java.awt.Shape createPath() {
    int halfWidth = width / 2;
    int height = (int) (Math.sqrt(3) * halfWidth);
    int[] xPoints = {left, left + width, left + halfWidth};
    int[] yPoints = {top + height, top + height, top};
    return new Polygon(xPoints, yPoints, 3);
  }
  @Override
  public double area() {
    return this.width * this.width * Math.sqrt(3) / 4.0;
  }

  @Override
  public void draw(Graphics g) {

    int halfWidth = width / 2;
    int height = (int) (Math.sqrt(3) * halfWidth);
    int[] xPoints = {left, left + width, left + halfWidth};
    int[] yPoints = {top + height, top + height, top};
    var path = this.createPath();
    Graphics2D g2 = (Graphics2D) g;
    g2.draw(new Polygon(xPoints, yPoints, 3));
    g2.fill(path);
  }

  @Override
  public String description() {
    return String.format("<EquilateralTriangle: left:%d top:%d width:%d area:%.2f>", this.left,
        this.top, this.width, this.area());
  }

  @Override
  public void resize(int x, int y) {
    this.width = x - this.left;
  }
}
