package Ayah2019.data;

public class MyMedicine {


    private String name;
    private String price;
    private String amount;
//    private String title;
//    private String Gps;

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getAmount() {
        return amount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    //    public String getTitle() {
//        return title;
//    }
//
//    public String getGps() {
//        return Gps;
//    }

//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public void setGps(String gps) {
//        Gps = gps;
//    }


    @Override
    public String toString() {
        return "MyMedicine{" +
                "name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", amount='" + amount + '\'' +
                '}';
    }
}

