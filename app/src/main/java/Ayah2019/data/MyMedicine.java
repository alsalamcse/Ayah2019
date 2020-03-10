package Ayah2019.data;

public class MyMedicine {


    private String name;
    private String price;
    private String amount;
    private String title;
    private String key;
    private String owner;

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

    public String getAmount() {
        return amount;
    }


    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "MyMedicine{" +
                "name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", amount='" + amount + '\'' +
                ", title='" + title + '\'' +
                ", key='" + key + '\'' +
                ", owner='" + owner + '\'' +
                '}';
    }
}


