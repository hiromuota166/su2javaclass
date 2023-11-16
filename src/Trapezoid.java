import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Path2D;

class Trapezoid extends Shape {
  private int topBase;
  private int bottomBase;
  private int height;

  public Trapezoid(int topBase, int bottomBase, int height) {
    this.topBase = topBase;
    this.bottomBase = bottomBase;
    this.height = height;
  }
  @Override
  public java.awt.Shape createPath() {
    Path2D path = new Path2D.Double();
    path.moveTo(0, 0);
    path.lineTo(topBase, 0);
    path.lineTo(bottomBase, height);
    path.lineTo(0, height);
    path.closePath();
    return path;
  }
  @Override
  public double area() {
    return (this.topBase + this.bottomBase) * this.height / 2.0;
  }

  @Override
  public String description() {
    return String.format("<Trapezoid: topBase:%d bottomBase:%d height:%d area:%.2f>", this.topBase,
        this.bottomBase, this.height, this.area());
  }

  @Override
  public void draw(Graphics g) {
    Graphics2D g2 = (Graphics2D) g;
    var path = this.createPath();
    g2.fill(path);
  }

  @Override
  public void resize(int x, int y) {
    this.bottomBase = x;
    this.height = y;
  }
}
