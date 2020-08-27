package com.dxctraining.consumermvc.consumer.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxctraining.consumermvc.consumer.dao.IConsumerDao;
import com.dxctraining.consumermvc.consumer.entities.*;

@Transactional
@Service
public class ConsumerServiceImpl implements IConsumerService {

	@Autowired
	private IConsumerDao dao;

	@Override
	public Consumer findConsumerById(int id) {
		Consumer consumer = dao.findConsumerById(id);
		return consumer;

	}
	@Override
	public Consumer add(Consumer consumer) {
	consumer=dao.add(consumer);
		return consumer;
	}
	
	@Override
	public Consumer remove(int id) {
		Consumer consumer=dao.remove(id);
		return consumer;
	}


	@Override
	public List<Consumer> allConsumers() {
		List<Consumer> all=dao.allConsumers();
		return all;
	}
}
