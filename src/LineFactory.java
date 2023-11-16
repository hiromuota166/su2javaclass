public class LineFactory extends ShapeFactory {
  @Override
  public Shape create(int x, int y) {
    return new Line(x, y, x, y);
  }
}