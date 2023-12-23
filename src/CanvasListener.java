import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * キャンバスのマウスリスナー
 */
public class CanvasListener extends MouseAdapter {
  // 対応するキャンバス
  private CanvasPanel canvas;

  /**
   * コンストラクタ 対応するキャンバスを引数にとる．
   */
  public CanvasListener(CanvasPanel canvas) {
    this.canvas = canvas;
  }

  @Override
  public void mouseMoved(MouseEvent me) {
    this.canvas.getState().mouseMoved(me);
  }

  @Override
  public void mousePressed(MouseEvent me) {
    this.canvas.getState().mousePressed(me);
  }

  @Override
  public void mouseDragged(MouseEvent me) {
    this.canvas.getState().mouseDragged(me);
  }

  @Override
  public void mouseReleased(MouseEvent me) {
    this.canvas.getState().mouseReleased(me);
  }
}
