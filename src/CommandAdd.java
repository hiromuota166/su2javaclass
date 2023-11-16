public class CommandAdd implements Command {
  private CanvasPanel canvas;
  private Shape shape;

  public CommandAdd(CanvasPanel canvas, Shape shape) {
    this.canvas = canvas;
    this.shape = shape;
  }

  @Override
  public void execute() {
    this.canvas.addShape(this.shape);
  }

  @Override
  public void undo() {
    this.canvas.removeShape(this.shape);
  }
}