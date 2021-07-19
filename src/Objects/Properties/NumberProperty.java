package Objects.Properties;

public class NumberProperty implements IProperty{

    String name = "";
    boolean isEditable = true;
    private double value = 0;

    NumberProperty(String name, double value){
        this.name = name;
        this.value = value;
    }

    @Override
    public Object getValue() {
        return value;
    }

    @Override
    public void setValue(String value) {
        try {
            double doubleValue = Double.parseDouble(value);
            this.value = doubleValue;
        }
        catch (NumberFormatException e)
        {
            System.out.println("Type Error in setting numeric IProperty");
        }
    }

    @Override
    public boolean IsEditable() {
        return isEditable;
    }
}
