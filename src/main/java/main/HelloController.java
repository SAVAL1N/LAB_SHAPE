package main;

import shapes.Shape;
import shapes.ShapeFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    public ListView<String> listview;
    public Canvas canvas;
    public ColorPicker colorPicker;
    public ObservableList<String> content;
    public ComboBox<Integer> widhtStroke;
    public Label figure;
    GraphicsContext gc;

    @FXML
    private TextField textX;

    @FXML
    private TextField textY;

    @FXML
    private TextField textZ;
    @FXML
    private ColorPicker strokeColor;

    private ShapeFactory shapeFactory;

    @FXML
    public void drawShape(MouseEvent mouseEvent) {
        int index = listview.getSelectionModel().getSelectedIndex();
        Shape shape = shapeFactory.createShape(index);

        int x;
        int y;
        Color defaultColor = Color.RED;
        int defaultStrokeWidth = 1;
        Color defaultStrokeColor = Color.BLACK;


        try {
            x = textX.getText().isEmpty() ? 20: Integer.parseInt(textX.getText());
            y = textY.getText().isEmpty() ? 20 : Integer.parseInt(textY.getText());
        } catch (NumberFormatException e) {
            x = 20;
            y = 20;
        }

        Color shapeColor = colorPicker.getValue() != null ? colorPicker.getValue() : defaultColor;

        int strokeWidth;
        if (!textZ.getText().isEmpty()) {
            strokeWidth = Integer.parseInt(textZ.getText());
        } else if (widhtStroke.getValue() != null) {
            strokeWidth = widhtStroke.getValue();
        } else {
            strokeWidth = defaultStrokeWidth;
        }


        shape.setColor(shapeColor);
        shape.draw(gc, x, y, shapeColor, strokeWidth, strokeColor.getValue());
        figure.setText("Фигура: " + shape);
    }

    @Override
    public void initialize(URL location, ResourceBundle resource) {
        shapeFactory = new ShapeFactory();

        gc = canvas.getGraphicsContext2D();
        content = FXCollections.observableArrayList("Квадрат", "Треугольник", "Прямоугольник", "Круг");
        ObservableList<Integer> strokeOptions = FXCollections.observableArrayList(0, 1, 2, 3, 4, 5, 6, 7, 8);
        widhtStroke.setItems(strokeOptions);
        listview.setItems(content);
    }


    @FXML
    private void onClear() {
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }
}
