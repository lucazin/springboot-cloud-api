package com.lucasdev.hrpayroll.services;

import com.lucasdev.hrpayroll.entities.Payment;
import com.lucasdev.hrpayroll.entities.Worker;
import com.lucasdev.hrpayroll.feignclients.WorkerFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private WorkerFeignClient workerFeignClient;

    public Payment getPayment(Long workerId, int days) {
        Worker worker = workerFeignClient.findById(workerId).getBody();
        assert worker != null;
        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }
}
