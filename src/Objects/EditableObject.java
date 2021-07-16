package Objects;

public abstract class EditableObject implements ISelectable{

    boolean isSelected;

    @Override
    public ISelectable SetActive() {


        return this;
    }

    @Override
    public void Deactivate(){

    }
}
