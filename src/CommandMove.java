public class CommandMove implements Command {
  private CanvasPanel canvas;
  private Shape shape;
  private int dx;
  private int dy;

  public CommandMove(CanvasPanel canvas, Shape shape, int dx, int dy) {
    this.canvas = canvas;
    this.shape = shape;
    this.dx = dx;
    this.dy = dy;
  }

  @Override
  public void execute() {
    this.canvas.moveShape(this.shape, this.dx, this.dy);
  }

  @Override
  public void undo() {
    this.canvas.moveShape(this.shape, -this.dx, -this.dy);
  }
}
