package Less13;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Less13 {
    public static void main(String[] args) {

// Создаем ресторан
        Restaurant restaurant = new Restaurant("Burger Heaven", CuisineType.RUSSIAN);

// Создаем меню
        Map<String, Double> menuItems = new HashMap<>();
        menuItems.put("Burger", 15.99);
        menuItems.put("Fries", 5.99);
        menuItems.put("Chicken Wrap", 12.50);
        menuItems.put("Soda", 2.50);
        menuItems.put("Pizza", 20.00);
        menuItems.put("Salad", 8.00);
        Menu menu = new Menu(menuItems);

// Создаем заказы
        Order order1 = new Order("O001", List.of("Burger", "Fries"),menu);
        Order order2 = new Order("O002", List.of("Chicken Wrap", "Soda"),menu);
        Order order3 = new Order("O003", List.of("Pizza", "Salad"),menu);

// Добавляем заказы в ресторан
        restaurant.addOrder(order1);
        restaurant.addOrder(order2);
        restaurant.addOrder(order3);

// Печатаеминформацию о заказе по ID
        System.out.println("Получаем заказ по ID (O002):");
        System.out.println(restaurant.getOrderById("O002"));

//// Добавляем блюдо в заказ O003
        System.out.println("\nДобавляем блюдо в заказ O003:");
        order3.addItem("Garlic Bread");
        System.out.println(order3);

//// Удаляем блюдо из заказа O003
        System.out.println("\nУдаляем блюдо из заказа O003:");
        order3.removeItem("Salad");
        System.out.println(order3);

// Обновляем статус заказов
        System.out.println("\nОбновляем статусы заказов:");
        restaurant.updateOrderStatus("O001", Status.COMPLETED);
        restaurant.updateOrderStatus("O003", Status.IN_PROGRESS);

// Отменяем заказ O002
        System.out.println("\nОтменяем заказ O002:");
        restaurant.cancelOrder("O002");

// Печатаем заказы со статусом 'Pending'
        System.out.println("\nЗаказы со статусом 'Pending':");
        restaurant.getOrdersByStatus(Status.PENDING).forEach(System.out::println);

// Печатаем заказы со статусом 'In Progress'
        System.out.println("\nЗаказы со статусом 'In Progress':");
        restaurant.getOrdersByStatus(Status.IN_PROGRESS).forEach(System.out::println);

// Печатаем общую выручку ресторана
        System.out.println("\nОбщая выручка ресторана:");
        System.out.println("$" + restaurant.getTotalRevenue());

// Проверяем, выполнен ли заказ O001
        System.out.println("\nСтатус заказа O001 (выполнен ли?): " + order1.isCompleted());


        restaurant.cancelOrder("eg23123");
    }
}




