package Objects;

import Objects.Properties.IProperty;
import Objects.Properties.NumberProperty;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class myRectangle extends EditableObject{

    NumberProperty x = new NumberProperty("xPosition",0);
    NumberProperty y = new NumberProperty("yPosition", 0);
    NumberProperty width = new NumberProperty("width", 0);
    NumberProperty height = new NumberProperty("height",0);

    List<IProperty> properties = new ArrayList<>();
    Rectangle rect;
    boolean isActive = false;
    Pane parent;
    myScene sceneParent;

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

        rect = new Rectangle((int)(double)this.x.getValue(), (int)(double)this.y.getValue(), (int)(double)this.width.getValue(), (int)(double)this.height.getValue());
        rect.setFill(Color.RED);
        rect.setOnMouseClicked(mouseEvent -> {this.handleClick(mouseEvent);});
    }

    void handleClick(MouseEvent mouseEvent){
        System.out.println(mouseEvent);
        EditableObject obj = this.sceneParent.getCurrentActive();
        if(obj != null )obj.Deactivate();

        this.sceneParent.setCurrentActive((EditableObject) this.SetActive());
        this.SetActive();
    }

    @Override
    public void Draw(){
        System.out.println(this.x.getValue());
        System.out.println(this.y.getValue());
        System.out.println(this.width.getValue());
        System.out.println(this.height.getValue());
        //parent.getChildren().add(rect);
        if (this.isActive){
            this.rect.setStroke(Color.BLACK);
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
