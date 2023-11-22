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
  public void move(int dx, int dy) {
    this.left += dx;
    this.top += dy;
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
  protected void drawShape2D (Graphics2D g2, java.awt.Shape path) {
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

