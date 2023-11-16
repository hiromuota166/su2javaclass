public class EquilateraTriangleFactory extends ShapeFactory {
  @Override
  public Shape create(int x, int y) {
    return new EquilateralTriangle(x, y, 0);
  }
}