package com.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.entity.Gpay;
import com.repository.GpayRepository;

@Service
public class GpayService {

	@Autowired
	GpayRepository gpayRepository;
	
	@Autowired
	RestTemplate restTemplate;
	
	public String createGpayAccount(Gpay gpay) {
		String emailid = gpay.getEmailid();
		Optional<Gpay> result = gpayRepository.findById(emailid);
		if(result.isPresent()) {
			return "Emailid already exists";
		}else {
//			int accno = restTemplate.getForObject("http://localhost:9090/account/findaccnumber/"+emailid, Integer.class);
//			int accno = restTemplate.getForObject("http://IP_ADDRESS/account/findaccnumber/"+emailid, Integer.class);
			int accno = restTemplate.getForObject("http://ACCOUNT-MICRO-SERVICE/account/findaccnumber/"+emailid, Integer.class);

			if(accno==-1) {
				gpay.setAccno(accno);
				gpayRepository.save(gpay);
				return "Gpay account created without linking your bank account";
			}else {
				gpay.setAccno(accno);
				gpayRepository.save(gpay);
				return "Gpay account created with link your bank account";
			}
		}	
	}
	
	public String findBalance(String emailid) {
		Optional<Gpay> result = gpayRepository.findById(emailid);
		if(result.isPresent()) {
			Gpay gpay = result.get();
			if(gpay.getAccno()==-1) {
				return "Gpay account present but not link with UPI ID ";
			}else {
//			return restTemplate.getForObject("http://localhost:9090/account/findbalance/"+gpay.getAccno(), String.class);	
			return restTemplate.getForObject("http://ACCOUNT-MICRO-SERVICE/account/findbalance/"+gpay.getAccno(), String.class); // with load balanced features 	
			}
		}else {
			return "Gpay account not present";
		}
	}
}