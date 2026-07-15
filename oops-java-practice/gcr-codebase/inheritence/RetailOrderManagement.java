import java.time.LocalDate;

public class RetailOrderManagement {
    public static void main(String[] args) {
        Order order = new Order("ORD-1001", LocalDate.of(2026, 6, 25));
        ShippedOrder shippedOrder = new ShippedOrder("ORD-1002", LocalDate.of(2026, 6, 24), "TRACK12345");
        DeliveredOrder deliveredOrder = new DeliveredOrder("ORD-1003", LocalDate.of(2026, 6, 22), "TRACK67890", LocalDate.of(2026, 6, 24));

        System.out.println(order.getOrderStatus());
        System.out.println(shippedOrder.getOrderStatus());
        System.out.println(deliveredOrder.getOrderStatus());
    }
}

class Order {
    private String orderId;
    private LocalDate orderDate;

    public Order(String orderId, LocalDate orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }

    public String getOrderId() {
        return orderId;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public String getOrderStatus() {
        return "Order " + orderId + " placed on " + orderDate + " - Status: Pending";
    }
}

class ShippedOrder extends Order {
    private String trackingNumber;

    public ShippedOrder(String orderId, LocalDate orderDate, String trackingNumber) {
        super(orderId, orderDate);
        this.trackingNumber = trackingNumber;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    @Override
    public String getOrderStatus() {
        return "Order " + getOrderId() + " shipped with tracking " + trackingNumber + " - Status: Shipped";
    }
}

class DeliveredOrder extends ShippedOrder {
    private LocalDate deliveryDate;

    public DeliveredOrder(String orderId, LocalDate orderDate, String trackingNumber, LocalDate deliveryDate) {
        super(orderId, orderDate, trackingNumber);
        this.deliveryDate = deliveryDate;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    @Override
    public String getOrderStatus() {
        return "Order " + getOrderId() + " delivered on " + deliveryDate + " - Status: Delivered";
    }
}
