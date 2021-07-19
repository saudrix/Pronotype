package Objects.Properties;

public class TextProperty implements IProperty{

    String name = "";
    boolean isEditable = true;
    private String value = "";

    TextProperty(String name, String value){
        this.name = name;
        this.value = value;
    }

    @Override
    public Object getValue() {
        return value;
    }

    @Override
    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean IsEditable() {
        return isEditable;
    }
}
