package Less13;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Order {
    private String orderId; // ID заказа
    private List<String> items; // список блюд из заказа
    private double totalPrice; // вся стоимость
    private Status status; // статус заказа
    private Menu menu;

    public Order(String orderId, List<String> items, Menu menu) {
        this.orderId = orderId;
        this.items = new ArrayList<>(items);
        this.menu = menu;
        this.status = Status.PENDING;
        calculateTotalPrice(); // Вызываем метод внутри конструктора
    }

    private void calculateTotalPrice() { // позволяющий узнать сумму конкретного заказа
        totalPrice = 0;
        Map<String, Double> menuItems = menu.getNameAndPrice();
        for (String itemName : items) {
            Double price = menuItems.get(itemName);
            if (price != null) {
                totalPrice += price;
            }
        }
    }

    public void addItem(String item) { // Позволяет добавить блюдо в заказ и автоматически обновляет общую стоимость заказа.
        items.add(item);
        if (menu.getNameAndPrice().get(item) != null) {
            totalPrice = totalPrice + menu.getNameAndPrice().get(item); // totalPrice = totalPrice + price; // summ = summ + new price
        }
    }


    public void removeItem(String item) { // Позволяет удалить блюдо из заказа и автоматически обновляет общую стоимость заказа.
//        items.remove(item);
//        totalPrice = totalPrice - price; // summ = summ - new price
       if (items.remove(item)) {
             totalPrice = totalPrice - menu.getNameAndPrice().get(item);// totalPrice -= menu.getNameAndPrice().get(item)
       }
    }

    public boolean isCompleted() { // метод проверяет статус заказа (true \ false)
        if (status == Status.COMPLETED) {
            return true;
        }
        return false;
    }


    public String getOrderld() {
        return orderId;
    }

    public void setOrderld(String orderld) {
        this.orderId = orderld;
    }

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Номер заказа: " + orderId  +
                ", Блюдо: " + items +
                ", Стоимость:" + totalPrice +
                " Статус: " + status;
    }
}

