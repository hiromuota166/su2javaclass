public class CircleFactory extends ShapeFactory {
  @Override
  public Shape create(int x, int y) {
    return new Circle(x, y,0);
  }
}