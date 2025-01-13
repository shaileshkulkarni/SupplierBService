package com.garage.supplierB.order;

import lombok.Data;

@Data
public class ItemOrder {

    public enum SupplierType {
        LOCAL,
        INTERNATIONAL
    }

    public enum OrderType {
        SINGLE,
        SCHEDULED
    }

    public enum OrderStatus {
        UNPROCESSED,
        PROCESSED,
        PLACED,
        CANCELED,
        FAILED,
        SHIPPED,
        DELIVERED
    }

    private Long orderId;

    private String itemId;
    private String itemName;
    private String supplierId;
    private SupplierType supplierType;
    private OrderType orderType;
    private OrderStatus orderStatus;
    private double orderQuantity;
}
