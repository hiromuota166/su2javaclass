import java.awt.Cursor;
import java.awt.Point;
import java.awt.event.MouseEvent;

/**
 * 図形選択モード
 */
public class CanvasStateSelect extends CanvasState {
  // 選択されている図形
  private Shape shape;
  // 移動を開始した位置
  private int startX;
  private int startY;
  // 移動中の位置
  private int lastX;
  private int lastY;

  public CanvasStateSelect(CanvasPanel canvas) {
    super(canvas);
  }

  @Override
  public void mouseMoved(MouseEvent me) {
    this.updateCursor();
  }

  @Override
  public void mousePressed(MouseEvent me) {
    int x = me.getX();
    int y = me.getY();
    this.shape = this.canvas.getShapeAt(x, y);
    if (this.shape != null) {
      this.startX = x;
      this.startY = y;
      this.lastX = x;
      this.lastY = y;
      // 図形の移動中であることを示すためにカーソルの形を変える．
      this.canvas.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
    }
  }

  @Override
  public void mouseReleased(MouseEvent me) {
    if (this.shape != null) {
      if (this.lastX != this.startX || this.lastY != this.startY) {
        this.canvas.moveShape(this.shape, this.startX - this.lastX, this.startY - this.lastY);
        Command command = new CommandMove(this.canvas, this.shape, this.lastX - this.startX,
            this.lastY - this.startY);
        this.canvas.execute(command);
      }
      this.shape = null;
    }
    // カーソルの形を図形選択モードのデフォルトに戻す．
    this.updateCursor();
  }

  @Override
  public void updateCursor() {
    Shape shape = null;
    Point point = this.canvas.getMousePosition();
    if (point != null) {
      int x = (int) point.getX();
      int y = (int) point.getY();
      shape = this.canvas.getShapeAt(x, y);
    }
    if (shape != null) {
      this.canvas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    } else {
      this.canvas.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }
  }

  // CanvasStateSelect.java
  @Override
  public void mouseDragged(MouseEvent me) {
      if (this.shape != null) {
          int newWidth = me.getX() - shape.getX();
          int newHeight = me.getY() - shape.getY();
          canvas.resizeShape(shape, newWidth, newHeight);
      }
  }
}