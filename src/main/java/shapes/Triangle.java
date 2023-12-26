    package shapes;

    import javafx.scene.canvas.GraphicsContext;
    import javafx.scene.paint.Color;

    public class Triangle extends  Shape{
        double base;
        double height;
        double x,y;

        public Triangle(Color color, double base, double height){
            super(color);
            this.base=base;
            this.height=height;
        }
        @Override
        public void draw(GraphicsContext gc, double x, double y, Color color, int strokeWid, Color strokeColor) {
            double[] xPoints = {x, x + base / 2, x + base};
            double[] yPoints = {y + height, y, y + height};
            if (strokeWid != 0) {
                gc.setLineWidth(strokeWid);
                gc.setStroke(strokeColor);
                gc.strokePolygon(xPoints, yPoints, 3);
            }
            gc.setFill(color);
            gc.fillPolygon(xPoints, yPoints, 3);
        }
        @Override
        public String toString(){
            return   "Треугольник";
        }
        @Override
        public void setXY(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }
