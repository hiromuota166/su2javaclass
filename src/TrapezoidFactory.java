public class TrapezoidFactory extends ShapeFactory{
  @Override
  public Shape create(int x, int y) {
    return new Trapezoid(x, y, 0);
  }
}
