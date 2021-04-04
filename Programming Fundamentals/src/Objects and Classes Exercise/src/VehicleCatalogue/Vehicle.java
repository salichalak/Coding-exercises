package VehicleCatalogue;

public class Vehicle {
    private String type;
    private String model;
    private String color;
    private int horsePower;

    public Vehicle(String type, String model, String color, int horsePower) {
        this.setType(type);
        this.model = model;
        this.color = color;
        this.horsePower = horsePower;
    }

    public String getType() {
        return type;
    }

    private void setType(String type) {
        type = type.replace(type.charAt(0), Character.toUpperCase(type.charAt(0)));
        this.type = type;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    @Override
    public String toString() {
        return String.format("Type: %s%n" +
                        "Model: %s%n" +
                        "Color: %s%n" +
                        "Horsepower: %d", this.getType(),
                this.getModel(), this.getColor(), this.getHorsePower());
    }
}