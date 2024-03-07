package ru.gb.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.gb.model.Payment;
import ru.gb.proxy.PaymentProxy;

@RestController
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentProxy paymentProxy;
    @PostMapping("/payment")
    public Payment createPayment(@RequestBody Payment payment){
        String requestId = "1";
        return paymentProxy.createPayment(requestId,payment);
    }

}
