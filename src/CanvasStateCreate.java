import java.awt.Cursor;
import java.awt.event.MouseEvent;

/**
 * 図形作成モード
 */
public class CanvasStateCreate extends CanvasState {
  private Shape shape;

  public CanvasStateCreate(CanvasPanel canvas) {
    super(canvas);
  }

  @Override
  public void mouseMoved(MouseEvent me) {}

  @Override
  public void mousePressed(MouseEvent me) {
    ShapeFactory factory = this.canvas.getFactory();
    int x = me.getX();
    int y = me.getY();
    this.shape = factory.create(x, y);
    this.shape.setColor(this.canvas.getColor());
    this.canvas.addShape(this.shape);
    this.canvas.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
  }

  @Override
  public void mouseDragged(MouseEvent me) {
    int x = me.getX();
    int y = me.getY();
    this.canvas.resizeShape(this.shape, x, y);
  }

  @Override
  public void mouseReleased(MouseEvent me) {
    this.canvas.removeShape(this.shape);
    // 図形の大きさが一定以下になった場合は，図形の作成を取り消す．
    if (this.shape.area() < Shape.MINIMUM_SHAPE_AREA) {
      // デバッグ用にメッセージを出力する．
      System.out.printf("%s is too small and not added.¥n", this.shape.description());
    } else {
      Command command = new CommandAdd(this.canvas, this.shape);
      this.canvas.execute(command);
    }
    this.shape = null;
    // カーソルの形を戻す．
    this.updateCursor();
    // 図形選択モードに移行しないのであれば，以下の行をコメントアウトする．
    this.canvas.setFactory(null);
  }

  @Override
  public void updateCursor() {
    this.canvas.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
  }
}
