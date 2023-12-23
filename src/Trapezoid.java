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
  public void move(int dx, int dy) {
    this.topBase += dx;
    this.bottomBase += dx;
    this.height += dy;
  }

  @Override
  public int getX() {
      return 0; // 台形の左端は原点
  }

  @Override
  public int getY() {
      return 0; // 台形の上端も原点
  }

  @Override
  public int getWidth() {
      return Math.max(topBase, bottomBase); // 幅は上底と下底の長い方
  }

  @Override
  public int getHeight() {
      return this.height; // 高さ
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
  protected void drawShape2D (Graphics2D g2, java.awt.Shape path) {
  g2.fill(path);
  }

  @Override
  public void resize(int x, int y) {
    this.bottomBase = x;
    this.height = y;
  }
}
