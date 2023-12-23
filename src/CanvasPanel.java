import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import java.util.ArrayDeque;
import java.util.Deque;

public class CanvasPanel extends JPanel {
  private List<Shape> shapes = new ArrayList<>();
  private Color color = new Color(0, 0, 0, 64);
  private ShapeFactory factory;
  private Deque<Command> commandHistory = new ArrayDeque<>();
  private Deque<Command> undoHistory = new ArrayDeque<>();
  private CanvasState canvasStateCreate;
  private CanvasState canvasStateSelect;
  private CanvasState state;
  private List<UIObserver> observers = new ArrayList<>();

  public CanvasPanel() {
    var listener = new CanvasListener(this);
    this.addMouseMotionListener(listener);
    this.addMouseListener(listener);
    this.canvasStateCreate = new CanvasStateCreate(this);
    this.canvasStateSelect = new CanvasStateSelect(this);
  }

  public void addShape(Shape shape) {
    this.shapes.add(shape);
    this.repaint();
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.setColor(this.color);
    for (Shape shape : this.shapes) {
      shape.draw(g);
    }
  }

  public void moveShape(Shape shape, int dx, int dy) {
    shape.move(dx, dy);
    this.repaint();
  }

  public void clearShapes() {
    this.shapes.clear();
    this.repaint();
  }

  public ShapeFactory getFactory() {
    return this.factory;
  }

  public void setFactory(ShapeFactory factory) {
    this.factory = factory;
    if (factory == null) {
      this.state = this.canvasStateSelect;
    } else {
      this.state = this.canvasStateCreate;
    }
    this.state.updateCursor();
    this.notifyUIObservers();
  }

  public CanvasState getState() {
    return this.state;
  }

  public List<Shape> getShapes() {
    return this.shapes;
  }

  public void removeShape(Shape shape) {
    this.shapes.remove(shape);
    this.repaint();
  }

  public void execute(Command command) {
    command.execute();
    this.commandHistory.push(command);
    this.undoHistory.clear();
    this.notifyUIObservers();
  }

  public void undo() {
    if (!this.commandHistory.isEmpty()) {
      Command command = this.commandHistory.pop();
      command.undo();
      this.undoHistory.push(command);
      this.notifyUIObservers();
    }
  }

  public void redo() {
    if (!this.undoHistory.isEmpty()) {
      Command command = this.undoHistory.pop();
      command.execute();
      this.commandHistory.push(command);
      this.notifyUIObservers();
    }
  }

  public Shape getShapeAt(int x, int y) {
    for (int i = this.shapes.size() - 1; i >= 0; i--) {
      if (this.shapes.get(i).contains(x, y)) {
        return this.shapes.get(i);
      }
    }
    return null;
  }

  public void setColor(Color color) {
    this.color = color;
    this.notifyUIObservers();
  }

  public Color getColor() {
    return this.color;
  }

  public void addUIObserver(UIObserver observer) {
    this.observers.add(observer);
  }

  public void notifyUIObservers() {
    for (UIObserver observer : this.observers) {
      observer.stateChanged();
    }
  }

  public boolean isCommandHistoryEmpty() {
    return this.commandHistory.isEmpty();
  }

  public boolean isUndoHistoryEmpty() {
    return this.undoHistory.isEmpty();
  }
  
  public void resizeShape(Shape shape, int newWidth, int newHeight) {
    Command command = new CommandResize(this, shape, shape.getWidth(), shape.getHeight(), newWidth, newHeight);
    execute(command);
  }

}
