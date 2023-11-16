public class DiamondFactory extends ShapeFactory {
  @Override
  public Shape create(int x, int y) {
    return new Diamond (x, y, x, y);
  }
}