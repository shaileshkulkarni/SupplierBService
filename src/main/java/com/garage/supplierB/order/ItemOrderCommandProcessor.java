package com.garage.supplierB.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ItemOrderCommandProcessor {

    @Autowired
    private OrderService orderService;

    public void processItemOrderCommand(ItemOrderCommand itemOrderCommand){
        ItemOrder itemOrder = getItemOrder(itemOrderCommand);
        orderService.sendOrderToSupplier(itemOrder);

        // TODO: Update the status of the ItemOrder with Order Service indicating order is placed
    }

    private ItemOrder getItemOrder(ItemOrderCommand itemOrderCommand){
        ItemOrder itemOrder = new ItemOrder();
        itemOrder.setItemId(itemOrder.getItemId());
        itemOrder.setItemName(itemOrder.getItemName());
        itemOrder.setOrderQuantity(itemOrder.getOrderQuantity());
        itemOrder.setSupplierId(itemOrder.getSupplierId());

        if(itemOrder.getSupplierType()== ItemOrder.SupplierType.LOCAL){
            itemOrder.setSupplierType(ItemOrder.SupplierType.LOCAL);
            itemOrder.setOrderType(ItemOrder.OrderType.SINGLE);
        }

        if(itemOrder.getSupplierType()== ItemOrder.SupplierType.INTERNATIONAL){
            itemOrder.setSupplierType(ItemOrder.SupplierType.INTERNATIONAL);
            itemOrder.setOrderType(ItemOrder.OrderType.SCHEDULED);
        }

        itemOrder.setOrderStatus(ItemOrder.OrderStatus.UNPROCESSED);

        return itemOrder;
    }
}
