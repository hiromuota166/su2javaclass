import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

class Square extends Shape {
  private int left;
  private int top;
  private int width;

  public Square(int left, int top, int width) {
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
    return new Rectangle2D.Double(this.left, this.top, this.width, this.width);
  }

  @Override
  public double area() {
    return this.width * this.width;
  }

  @Override
  public String description() {
    return String.format("<Square: left:%d top:%d width:%d area:%.2f>", this.left, this.top,
        this.width, this.area());
  }

  @Override
  protected void drawShape2D (Graphics2D g2, java.awt.Shape path) {
  g2.fill(path);
  }

  @Override
  public void resize(int x, int y) {
    this.width = x - this.left;
  }
}
