package shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Square extends Shape {

    double side;
    double x,y;
    public Square(Color color, double side){
        super(color);
        this.side = side;
    }


    @Override
    public void draw(GraphicsContext gc, double x, double y, Color color, int strokeWid, Color strokeColor) {
        if (strokeWid != 0) {
            gc.setLineWidth(strokeWid);
            gc.setStroke(strokeColor);
            gc.strokeRect(x, y, side, side);
        }

        gc.setFill(color);
        gc.fillRect(x, y, side, side);
    }
    @Override
    public String toString(){
        return   "Квадрат";
    }
    @Override
    public void setXY(double x, double y) {
        this.x = x;
        this.y = y;
    }
}
