package project;

public class Services {
	private String serviceName;
    private int quantity;
    private double price;

    public Services (String serviceName, int quantity, double price) {
        this.serviceName = serviceName;
        this.quantity = quantity;
        this.price = price;
    }

    public String getServiceName() {
        return serviceName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }


    public void removeQuantity() {
        this.quantity--;
    }
    
    public String printList() {
        return "Service Name = " + serviceName + ", Quantity = " + quantity + ", Price = " + price + " NIS";
    }

    @Override
    public String toString() {
        return "Service Name = " + serviceName + ", Price = " + price + " NIS";
    }

}
