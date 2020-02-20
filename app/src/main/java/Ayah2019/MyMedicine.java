package Ayah2019;

public class MyMedicine {


    private String name;
    private String price;
    private String title;
    private String Gps;

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

    public String getTitle() {
        return title;
    }

    public String getGps() {
        return Gps;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setGps(String gps) {
        Gps = gps;
    }

    @Override
    public String toString() {
        return "MyMedicine{" +
                "name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", title='" + title + '\'' +
                ", Gps='" + Gps + '\'' +
                '}';
    }
}
