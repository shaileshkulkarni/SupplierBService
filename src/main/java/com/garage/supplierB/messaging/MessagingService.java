package com.garage.supplierB.messaging;


import com.garage.supplierB.order.ItemOrderCommand;
import com.garage.supplierB.order.ItemOrderCommandProcessor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
@Slf4j
public class MessagingService {

    @Autowired
    private ItemOrderCommandProcessor itemOrderCommandProcessor;

    @KafkaListener(topics = "orderTopic", groupId = "orderGroup")
    public void listenItemInventoryTopic(ItemOrderCommand itemOrderCommand) {
        log.info("Received Message : " + itemOrderCommand);
        itemOrderCommandProcessor.processItemOrderCommand(itemOrderCommand);
    }
}
