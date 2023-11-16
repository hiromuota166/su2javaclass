import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;

class Diamond extends Shape {
  private int left;
  private int top;
  private int width;
  private int height;

  public Diamond(int left, int top, int width, int height) {
    this.left = left;
    this.top = top;
    this.width = width;
    this.height = height;
  }
  @Override
  public java.awt.Shape createPath() {
    int[] xPoints = {left + width / 2, left + width, left + width / 2, left};
    int[] yPoints = {top, top + height / 2, top + height, top + height / 2};
    return new Polygon(xPoints, yPoints, 4);
  }

  @Override
  public void resize(int x, int y) {
    this.width = x - this.left;
    this.height = y - this.top;
  }

  @Override
  public double area() {
    return this.width * this.height / 2.0;
  }

  @Override
  public String description() {
    return String.format("<Diamond: left:%d top:%d width:%d height:%d area:%.2f>", this.left,
        this.top, this.width, this.height, this.area());
  }

  @Override
  public void draw(Graphics g) {
    var path = this.createPath();
    
    Graphics2D g2 = (Graphics2D) g;
    g2.fill(path);
  }
}
