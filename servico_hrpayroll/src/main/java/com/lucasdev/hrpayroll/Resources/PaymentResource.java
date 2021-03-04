package com.lucasdev.hrpayroll.Resources;

import com.lucasdev.hrpayroll.entities.Payment;
import com.lucasdev.hrpayroll.services.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/payments")
public class PaymentResource {

    @Autowired
    private PaymentService paymentService;

    //caso ocorra falha chama metodo alternativo de erro.
    @HystrixCommand(fallbackMethod = "getpaymentFallBack")
    @GetMapping(value = "/{workerId}/days/{days}")
    public ResponseEntity<Payment> getPayment(@PathVariable long workerId, @PathVariable int days) {
        Payment payment = paymentService.getPayment(workerId, days);
        return ResponseEntity.ok(payment);
    }

    //metodo alternativo de erro.
    public ResponseEntity<Payment> getpaymentFallBack(long workerId, int days) {
        Payment payment = new Payment("Error", 100.0, days);
        return ResponseEntity.ok(payment);
    }
}
