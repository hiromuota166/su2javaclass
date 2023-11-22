import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class Circle extends Shape {
  private int x;
  private int y;
  private int r;

  public Circle(int x, int y, int r) {
    this.x = x;
    this.y = y;
    this.r = r;
  }

  @Override
  public void move(int dx, int dy) {
    this.x = this.x + dx;
    this.y = this.y + dy;
  }

  @Override
  public java.awt.Shape createPath() {
    return new Ellipse2D.Double(this.x - this.r, this.y - this.r, this.r * 2, this.r * 2);
  }

  @Override
  public double area() {
    return Math.PI * this.r * this.r;
  }

  @Override
  protected void drawShape2D(Graphics2D g2, java.awt.Shape path) {
    g2.fill(path);
  }

  @Override
  public void resize(int x, int y) {
    int dx = x - this.x;
    int dy = y - this.y;
    this.r = (int) Math.sqrt(dx * dx + dy * dy);
  }

  @Override
  public String description() {
    return String.format("<Circle: center:(%d, %d) r:%d area:%.2f %s>", this.x, this.y, this.r,
        this.area(), this.additionalDescription());
  }
}
