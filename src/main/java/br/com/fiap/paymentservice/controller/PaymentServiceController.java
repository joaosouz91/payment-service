package br.com.fiap.paymentservice.controller;

import java.net.URI;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.fiap.paymentservice.Payment;
import br.com.fiap.paymentservice.PaymentFactory;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/payment-service")
public class PaymentServiceController {
	
    @GetMapping("/{idPayment}")
    public ResponseEntity getPaymentById(@PathVariable(value="idPayment", required=true) int idPayment) {
        Payment payment = PaymentFactory.findPaymentById(idPayment);
        if(payment != null) {
            return new ResponseEntity<>(payment, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody Payment payment) {
    	
    	if(PaymentFactory.create(payment) >0) {
    		URI location = ServletUriComponentsBuilder
       			 .fromCurrentRequest()
       			 .path("/{idPayment}")
       			 .buildAndExpand(payment.getIdPayment()).toUri();
    		return ResponseEntity.created(location).build();
    	}
    	return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    	
    }
    
    @PutMapping
    public ResponseEntity<String> update(@RequestBody Payment payment) {
    	
    	payment = PaymentFactory.update(payment);
    	
    	if(payment != null) {
    		URI location = ServletUriComponentsBuilder
       			 .fromCurrentRequest()
       			 .path("/{idPayment}")
       			 .buildAndExpand(payment.getIdPayment()).toUri();
    		return ResponseEntity.created(location).build();
    	}
    	return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    	
    }
    
    @DeleteMapping("{idPayment}")
    public ResponseEntity<String> delete(@PathVariable(value="idPayment", required=true) int idPayment) {
    	
    	if(PaymentFactory.delete(idPayment)) {
    		return new ResponseEntity<>(HttpStatus.ACCEPTED);
    	}
    	return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }    
    
}
