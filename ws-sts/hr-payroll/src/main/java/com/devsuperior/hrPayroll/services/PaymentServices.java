package com.devsuperior.hrPayroll.services;

import org.springframework.stereotype.Service;

import com.devsuperior.hrPayroll.entities.Payment;

//@Component -para registrar como uma classe do spring


@Service
public class PaymentServices {
	public Payment getPayment(long workerId, int days) 
	{
		return new Payment ("BOB",200.0,days);
	}
	
	
	

}
