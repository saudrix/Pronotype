package Objects;

public interface ISelectable {
    // Attributes
    public boolean isSelected = false;
    //
    public ISelectable SetActive();
    public void Deactivate();
}
