import java.awt.event.MouseEvent;

/**
 * キャンバスの状態を表現するクラスの基底クラス
 */
public abstract class CanvasState {
  protected CanvasPanel canvas;

  protected CanvasState(CanvasPanel canvas) {
    this.canvas = canvas;
  }

  public abstract void mousePressed(MouseEvent me);

  public abstract void mouseDragged(MouseEvent me);

  public abstract void mouseReleased(MouseEvent me);

  public abstract void mouseMoved(MouseEvent me);

  public abstract void updateCursor();
}
