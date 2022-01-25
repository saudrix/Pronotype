package Objects;

import Objects.Properties.IProperty;
import Objects.Properties.NumberProperty;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class myRectangle extends EditableObject {

    NumberProperty x = new NumberProperty("xPosition",0);
    NumberProperty y = new NumberProperty("yPosition", 0);
    NumberProperty width = new NumberProperty("width", 0);
    NumberProperty height = new NumberProperty("height",0);

    List<IProperty> properties = new ArrayList<>();
    Rectangle rect;
    boolean isActive = false;
    Pane parent;
    myScene sceneParent;

    double orgSceneX, orgSceneY;
    double orgTranslateX, orgTranslateY;

    myRectangle(String name,String x, String y, String width, String height, Pane pane,myScene parentActiveRef){
        super(name);
        this.x.setValue(x);
        this.y.setValue(y);
        this.width.setValue(width);
        this.height.setValue(height);

        properties.add((this.x));
        properties.add((this.y));
        properties.add((this.height));
        properties.add((this.width));

        this.parent = pane;
        this.sceneParent = parentActiveRef;

        this.rect = new Rectangle((int)(double)this.x.getValue(), (int)(double)this.y.getValue(), (int)(double)this.width.getValue(), (int)(double)this.height.getValue());
        this.rect.setFill(Color.RED);
        this.rect.setOnMousePressed(mouseEvent -> {this.handleClickDown(mouseEvent);});
        this.rect.setOnMouseReleased(mouseEvent -> {this.handleClickUp(mouseEvent);});
        //rect.setOnDragDetected(this::startDrag); // même résultat differentes écritures
        this.rect.setOnMouseDragged(mouseEvent -> {this.startDrag(mouseEvent);});
        this.rect.setOnDragDropped(this::stopDrag);
    }

    void handleClickDown(MouseEvent mouseEvent){
        System.out.println("mouse down event");
        orgSceneX = mouseEvent.getSceneX();
        orgSceneY = mouseEvent.getSceneY();
        orgTranslateX = ((Rectangle)(mouseEvent.getSource())).getTranslateX();
        orgTranslateY = ((Rectangle) (mouseEvent.getSource())).getTranslateY();

        if(!isActive){
            this.SetActive();
            this.sceneParent.setCurrentActive(this);
        }
    }

    void handleClickUp(MouseEvent mouseEvent){
        this.x.setValue(Double.toString(this.rect.getX()));
        this.y.setValue(Double.toString(this.rect.getY()));
    }

    void startDrag(MouseEvent mouseEvent){
        double offsetX = mouseEvent.getSceneX() - orgSceneX;
        double offsetY = mouseEvent.getSceneY() - orgSceneY;
        double newTranslateX = orgTranslateX + offsetX;
        double newTranslateY = orgTranslateY + offsetY;

        ((Rectangle) (mouseEvent.getSource())).setTranslateX(newTranslateX);  //transform the object
        ((Rectangle) (mouseEvent.getSource())).setTranslateY(newTranslateY);
    };

    private void stopDrag(DragEvent dragEvent) {
        System.out.println("drag stopped");
    }

    @Override
    public void Draw(){
        //parent.getChildren().add(rect);
        if (this.isActive){
            this.rect.setStroke(Color.BLACK);
        }
        else{
            this.rect.setStroke(null);
        }
    }

    @Override
    public List<IProperty> GetProperties() {
        return properties;
    }

    @Override
    public ISelectable SetActive() {
        this.isActive = true;
        return this;
    }

    @Override
    public void Deactivate() {
        this.isActive = false;
    }
}
