package com.ddlab.rnd.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.ddlab.rnd.event.CancelEvent;

@Component
public class CancelOrderListener {

	@KafkaListener(topics = "${kafka.order.cancel.topic.name}")
	public void listenOrder(CancelEvent cancelEvent) {
		if(cancelEvent.getActionName().equalsIgnoreCase("CANCEL_ORDER")) {
			System.out.println("Your order has been cancelled. Reason: "+cancelEvent.getReason());
		}
	}
}
