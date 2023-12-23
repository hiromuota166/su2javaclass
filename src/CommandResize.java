public class CommandResize implements Command {
    private CanvasPanel canvas;
    private Shape shape;
    private int originalWidth, originalHeight;
    private int newWidth, newHeight;

    public CommandResize(CanvasPanel canvas, Shape shape, int originalWidth, int originalHeight, int newWidth, int newHeight) {
        this.canvas = canvas;
        this.shape = shape;
        this.originalWidth = originalWidth;
        this.originalHeight = originalHeight;
        this.newWidth = newWidth;
        this.newHeight = newHeight;
    }

    @Override
    public void execute() {
        shape.resize(newWidth, newHeight);
        canvas.repaint();
    }

    @Override
    public void undo() {
        shape.resize(originalWidth, originalHeight);
        canvas.repaint();
    }
}
