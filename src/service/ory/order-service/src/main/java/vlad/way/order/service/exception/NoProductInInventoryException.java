package vlad.way.order.service.exception;

import vlad.way.order.service.entity.OrderItem;

import java.util.List;
import java.util.Set;

public class NoProductInInventoryException extends RuntimeException {
    public NoProductInInventoryException(String message, Set<OrderItem> isProductInInventory,
                                         Set<OrderItem> orderItems) {
        super(message);
        Set<OrderItem> inInventory = isProductInInventory;
        Set<OrderItem> inOrder = orderItems;
        if(inInventory.size() > inOrder.size()){
            inInventory = orderItems;
            inOrder = isProductInInventory;
        }
        List<OrderItem> res = inOrder.stream()
                .filter(inInventory::contains).toList();

        System.out.println(res);
        //TODO сделать хендлер


    }
}
