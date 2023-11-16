public class CommandClear implements Command {
  private CanvasPanel canvas;
  private Shape[] shapeArray; // 配列に現在の図形のリストをコピーしておく．

  public CommandClear(CanvasPanel canvas) {
    this.canvas = canvas;
    this.shapeArray = new Shape[this.canvas.getShapes().size()];
    this.canvas.getShapes().toArray(this.shapeArray);
  }

  @Override
  public void execute() {
    this.canvas.clearShapes();
  }

  @Override
  public void undo() {
    for (Shape shape : this.shapeArray) {
      this.canvas.addShape(shape);
    }
  }
}
