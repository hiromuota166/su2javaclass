public class RectangleFactory extends ShapeFactory {
  @Override
  public Shape create(int x, int y) {
    return new Rectangle(x, y, 0,0);
  }
}