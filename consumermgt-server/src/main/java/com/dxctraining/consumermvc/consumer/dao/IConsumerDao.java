package com.dxctraining.consumermvc.consumer.dao;

import java.util.List;

import com.dxctraining.consumermvc.consumer.entities.Consumer;

public interface IConsumerDao {
	
	 Consumer findConsumerById(int id);
	 Consumer add(Consumer consumer);
	Consumer remove(int id);
	List<Consumer> allConsumers();

}
