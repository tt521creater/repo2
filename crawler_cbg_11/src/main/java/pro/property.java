package pro;

public class property {
    private String name;
    private double price;   //直接考虑单价不在考虑价格了！
    private String type;   //存贮元气丹的种类

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
        this.type = "";
    }

    public property(String name, double price, String type) {
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public property() {
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        if ( type.length() == 0 ||type.contains("#0") || type.contains("#r")){
            return "property{" +
                    "name='" + name + '\'' +
                    ", price=" + price +
                    '}';
        }
        return "property{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", type='" + type + '\'' +
                '}';
    }
}
