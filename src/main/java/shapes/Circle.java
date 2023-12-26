package shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Circle extends Shape {
    private double radius;
    private double x, y;

    public Circle(Color color, double radius) {
        super(color);
        this.radius = radius;
    }

    @Override
    public void draw(GraphicsContext gc, double x, double y, Color color, int strokeWidth, Color strokeColor) {
        if (strokeWidth != 0) {
            gc.setLineWidth(strokeWidth);
            gc.setStroke(strokeColor);
            gc.strokeOval(x, y, radius * 2, radius * 2);
        }

        gc.setFill(color);
        gc.fillOval(x, y, radius * 2, radius * 2);
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Круг";
    }

    @Override
    public void setXY(double x, double y) {
        this.x = x;
        this.y = y;
    }
}
