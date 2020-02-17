package Ayah2019;

public class MyMedicine {


    private String name;
    private String price;

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "MyMedicine{" +
                "name='" + name + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
