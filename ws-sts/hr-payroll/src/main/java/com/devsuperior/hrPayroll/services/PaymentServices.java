package com.devsuperior.hrPayroll.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.hrPayroll.entities.Payment;
import com.devsuperior.hrPayroll.entities.Worker;
import com.devsuperior.hrPayroll.feignclients.WorkerFeignClient;

//@Component -para registrar como uma classe do spring


@Service
public class PaymentServices {
	
	
	
	
	@Autowired
	private WorkerFeignClient workerfeignclient;
	
	
	public Payment getPayment(long workerId, int days) 
	{
		
		Worker worker=workerfeignclient.finById(workerId).getBody();
		return new Payment (worker.getName(),worker.getDailyIncome(),days);
	}
	
	
	

}
