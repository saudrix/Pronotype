package Objects;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.ConsoleHandler;

import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class myScene {

    public String name;
    public boolean current;
    List<EditableObject> sceneObjects = new ArrayList<>();
    public Pane canvas;
    EditableObject currentActive;

    public void setCurrentActive(EditableObject obj){
        this.currentActive = obj;
        this.onActiveChange();
    }

    public EditableObject getCurrentActive(){return  this.currentActive;}

    public myScene(Pane javaScene){
        this.canvas = javaScene;
    }

    void onActiveChange(){
        this.Draw();
    }

    public void Draw(){
        System.out.println("drawing");
        for (EditableObject sceneObject:sceneObjects){
            sceneObject.Draw();
        }
    }

    public void Add(String id){
        switch (id){
            case "rec":
                System.out.println("Adding my rec");
                myRectangle rectangle = new myRectangle("rectangle","10","10","100","50", canvas, this);
                sceneObjects.add(rectangle);
                canvas.getChildren().add(rectangle.rect);
                Draw();
                break;
            default:
                break;
        }
    }

}
