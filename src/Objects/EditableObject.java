package Objects;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public abstract class EditableObject implements ISelectable, IEditable{
    String name;

    EditableObject(String name){}

    public abstract void Draw();
}
