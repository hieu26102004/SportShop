package models;

public class Product {
    private int id;
    private String name;
    private String image;
    private String description;
    private int price;
    private int quantity;

    public Product(int id, String name, String image, String description, int price) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.description = description;
        this.price = price;
        this.quantity = 1; // Mặc định số lượng là 1 khi thêm sản phẩm vào giỏ hàng
    }

    // Getters và Setters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
