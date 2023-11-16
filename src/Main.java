import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Main {

  private static final String TITLE = "2600220060-0 太田啓夢";

  private static final int FRAME_POSX = 10;
  private static final int FRAME_POSY = 10;
  private static final int CANVAS_WIDTH = 800;
  private static final int CANVAS_HEIGHT = 500;

  public static void main(String... args) {

    var frame = new JFrame();
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.setTitle(TITLE);
    frame.setLocation(FRAME_POSX, FRAME_POSY);

    var canvas = new CanvasPanel();
    canvas.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
    canvas.setBackground(new Color(255, 255, 255));

    var commandPanel = new JPanel();
    commandPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
    commandPanel.setBackground(new Color(238, 238, 238));

    var circleButton = new JButton("Circle");

    var circleFactory = new CircleFactory();
    circleButton.addActionListener(event -> canvas.setFactory(circleFactory));
    commandPanel.add(circleButton);

    var rectangleButton = new JButton("Rectangle");

    var rectangleFactory = new RectangleFactory();
    rectangleButton.addActionListener(event -> canvas.setFactory(rectangleFactory));
    commandPanel.add(rectangleButton);

    var lineButton = new JButton("Line");

    var lineFactory = new LineFactory();
    lineButton.addActionListener(event -> canvas.setFactory(lineFactory));
    commandPanel.add(lineButton);
    frame.add(commandPanel, BorderLayout.NORTH);
    frame.add(canvas, BorderLayout.CENTER);

    var diamondButton = new JButton("Diamond");

    var diamondFactory = new DiamondFactory();
    diamondButton.addActionListener(event -> canvas.setFactory(diamondFactory));
    commandPanel.add(diamondButton);

    var equilateralTriangleButton = new JButton("EquilateralTriangle");

    var equilateralTriangleFactory = new EquilateraTriangleFactory();
    equilateralTriangleButton
        .addActionListener(event -> canvas.setFactory(equilateralTriangleFactory));
    commandPanel.add(equilateralTriangleButton);

    var squareButton = new JButton("Square");

    var squareFactory = new SquareFactory();
    squareButton.addActionListener(event -> canvas.setFactory(squareFactory));
    commandPanel.add(squareButton);

    var trapezoidButton = new JButton("Trapezoid");

    var trapezoidFactory = new TrapezoidFactory();
    trapezoidButton.addActionListener(event -> canvas.setFactory(trapezoidFactory));
    commandPanel.add(trapezoidButton);

    var undoButton = new JButton("Undo");
    undoButton.addActionListener(event -> canvas.undo());
    commandPanel.add(undoButton);

    var redoButton = new JButton("Redo");
    redoButton.addActionListener(event -> canvas.redo());
    commandPanel.add(redoButton);

    var clearButton = new JButton("Clear");
    clearButton.addActionListener(event -> {
      Command command = new CommandClear(canvas);
      canvas.execute(command);
    });
    commandPanel.add(clearButton);

    var selectButton = new JButton("Select");
    selectButton.addActionListener(event -> canvas.setFactory(null));
    commandPanel.add(selectButton);

    frame.add(commandPanel, BorderLayout.NORTH);
    frame.pack();
    frame.setVisible(true);

    selectButton.doClick();
    circleButton.doClick();
  }
}
