package Less13;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Restaurant {

    private String name; // имя ресторана
    private CuisineType cuisineType; // типа кухни
    private Map<String,Order> orders = new HashMap<>(); // Ключ: ID заказа, Значение: Объект Заказа


    public Restaurant(String name, CuisineType cuisineType) {
        this.name = name;
        this.cuisineType = cuisineType;
    }


    public void addOrder(Order order){  // добавляет заказ в MAP
        orders.put(order.getOrderld(),order);
    }


    public Order getOrderById(String orderId){   // Возврат заказа ID
        Order order =  orders.get(orderId); //

        if ( order== null) {
            System.out.println("Заказ номер" + orderId + " не найден");
        }
        return order;
    }


    public List<String> getOrdersByStatus(Status status){ //Считает общую выручку ресторана (учитываются только заказы со статусом "Completed")
        List<String> filteredOrders = new ArrayList<>();
        for (Order order : orders.values()) {
            if (order.getStatus() == status) {
                filteredOrders.add(order.getOrderld()); // Добавляем ID заказа в список
            }
        }
        return filteredOrders;
    }


    public void cancelOrder(String orderId) {  // Удаляет заказ из карты заказов и отмечает его как отменённый.
        Order order = orders.remove(orderId);
       if (order != null) {
            order.setStatus(Status.CANCELED);
       }
    }


    public void updateOrderStatus(String orderId,Status newStatus){ //Меняет статус заказа по его ID
        Order order = orders.get(orderId);
        order.setStatus(newStatus);
    }

    public void costByID(String orderId){ // Этот метод принимает идентификатор заказа (orderId) и выводит общую стоимость этого заказа.
        Order order = orders.get(orderId);
        System.out.println(order.getTotalPrice());
    }

    public void costTwoByID(String orderId,String orderId2){ // Позволяет узнать сумму стоимостей двух конкретных заказов.
        Order order = orders.get(orderId);
        Order order2 = orders.get(orderId2);
        var a = order.getTotalPrice();
        var b = order2.getTotalPrice();
        // if (order != null && order2 != null) {
        //   System.out.println(order.getTotalPrice() + order2.getTotalPrice());
        System.out.println(a + b);
    }

    public double getTotalRevenue(){ // Позволяет узнать общую выручку ресторана, суммируя стоимости всех заказов.
        double summ = 0;
        for (Order order :orders.values()) {
            summ = summ + order.getTotalPrice();
        }
        return summ;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CuisineType getCuisineType() {
        return cuisineType;
    }

    public void setCuisineType(CuisineType cuisineType) {
        this.cuisineType = cuisineType;
    }

    public Map<String, Order> getOrders() {
        return orders;
    }

    public void setOrders(Map<String, Order> orders) {
        this.orders = orders;
    }
}

