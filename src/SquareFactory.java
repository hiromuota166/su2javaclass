public class SquareFactory extends ShapeFactory {
  @Override
  public Shape create(int x,int y) {
    return new Square(x, y,0);
  }
}