package one.media.model;

public class Product {
    private String uid, name, timestamp;
    private long price;

    public Product(String uid, String name, String timestamp, long price) {
        this.uid = uid;
        this.name = name;
        this.timestamp = timestamp;
        this.price = price;
    }

    public Product() {
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }
}
