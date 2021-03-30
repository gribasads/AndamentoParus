package com.devsuperior.hrPayroll.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.devsuperior.hrPayroll.entities.Payment;
import com.devsuperior.hrPayroll.entities.Worker;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

//@Component -para registrar como uma classe do spring


@Service
public class PaymentServices {
	
	@Value("${hr-worker.host}")
	private String workerhost;
	
	@Autowired
	private RestTemplate restTemplate; //usa esse obj para fazer uma chamada do web service do proj workers
	
	
	public Payment getPayment(long workerId, int days) 
	{
		Map<String,String> uriVariable = new HashMap<>();
		uriVariable.put("id",""+ workerhost);
		Worker worker= restTemplate.getForObject(workerhost +"/workers/{id}",Worker.class,uriVariable);
		return new Payment (worker.getName(),worker.getDailyIncome(),days);
	}
	
	
	

}
