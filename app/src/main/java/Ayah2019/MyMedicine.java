package Ayah2019;

public class MyMedicine {


    private String name;
    private int price;

    public String getName()
    {
        return name;

    }

    public int getPrice(){
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    @Override
    public String toString() {
        return "MyMedicine{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

}
