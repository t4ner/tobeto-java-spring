package com.tobeto.homework.controllers;

import com.tobeto.homework.services.abstracts.PaymentMethodService;
import com.tobeto.homework.services.dtos.requests.paymentMethod.AddPaymentMethodRequest;
import com.tobeto.homework.services.dtos.requests.paymentMethod.UpdatePaymentMethodRequest;
import com.tobeto.homework.services.dtos.responses.paymentMethod.GetPaymentMethodListResponse;
import com.tobeto.homework.services.dtos.responses.paymentMethod.GetPaymentMethodResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/paymentmethods")
@AllArgsConstructor
public class PaymentMethodsController {
    private final PaymentMethodService paymentMethodService;


    @GetMapping
    public List<GetPaymentMethodListResponse> getAll(){
       return paymentMethodService.getAll();
    }

    @GetMapping("{id}")
    public GetPaymentMethodResponse getById(@PathVariable int id){
        return paymentMethodService.getById(id);
    }

    @PostMapping
    public void add(@RequestBody AddPaymentMethodRequest addPaymentMethodRequest){
        paymentMethodService.add(addPaymentMethodRequest);
    }

    @PutMapping
    public void update(@RequestBody UpdatePaymentMethodRequest updatePaymentMethodRequest){
        paymentMethodService.update(updatePaymentMethodRequest);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        paymentMethodService.delete(id);
    }

}
