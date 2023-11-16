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
    public java.awt.Shape createPath() {
        return new Rectangle2D.Double(this.left, this.top, this.width, this.width);
    }
    @Override
    public double area() {
        return this.width * this.width;
    }

    @Override
    public String description() {
        return String.format(
            "<Square: left:%d top:%d width:%d area:%.2f>",
            this.left, this.top, this.width, this.area());
    }

    @Override
    public void draw(Graphics g) {
      var path = this.createPath();
      Graphics2D g2 = (Graphics2D) g;
      g2.fill(path);
    }

    @Override
    public void resize(int x, int y) {
        this.width = x - this.left;
    }
}
