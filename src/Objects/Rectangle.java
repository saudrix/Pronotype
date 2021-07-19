package Objects;

import Objects.Properties.IProperty;
import Objects.Properties.NumberProperty;

import java.util.ArrayList;
import java.util.List;

public class Rectangle extends EditableObject{

    NumberProperty x;
    NumberProperty y;
    NumberProperty width;
    NumberProperty height;

    List<IProperty> properties = new ArrayList<>();

    Rectangle(String name,String x, String y, String width, String height){
        super(name);
        this.x.setValue(x);
        this.y.setValue(y);
        this.width.setValue(width);
        this.height.setValue(height);

        properties.add((this.x));
        properties.add((this.y));
        properties.add((this.height));
        properties.add((this.width));
    }

    @Override
    public List<IProperty> GetProperties() {
        return properties;
    }

    @Override
    public ISelectable SetActive() {
        return null;
    }

    @Override
    public void Deactivate() {

    }
}
