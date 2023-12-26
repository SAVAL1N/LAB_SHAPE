package shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

class Rectangle extends Shape{
     double lenght;
     double width;
    double x,y;
     public Rectangle(Color color, double lenght, double width){
        super(color);
        this.lenght = lenght;
        this.width = width;
     }


    public void draw(GraphicsContext gc, double x, double y, Color color, int strokeWid, Color strokeColor) {
        if (strokeWid != 0) {
            gc.setLineWidth(strokeWid);
            gc.setStroke(strokeColor);
            gc.strokeRect(x, y, lenght, width);
        }

        gc.setFill(color);
        gc.fillRect(x, y, lenght, width);
    }

    @Override
    public String toString(){
         return   "Прямоугольник";
     }

    @Override
    public Rectangle clone() {
        return (Rectangle) super.clone();
    }
    @Override
    public void setXY(double x, double y) {
        this.x = x;
        this.y = y;
    }

}
