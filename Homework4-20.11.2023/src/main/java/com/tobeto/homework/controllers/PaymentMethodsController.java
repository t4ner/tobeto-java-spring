package com.tobeto.homework.controllers;

import com.tobeto.homework.entities.PaymentMethod;
import com.tobeto.homework.repositories.PaymentMethodRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/paymentmethods")
public class PaymentMethodsController {
    private final PaymentMethodRepository paymentMethodRepository;
    public PaymentMethodsController(PaymentMethodRepository paymentMethodRepository){
        this.paymentMethodRepository = paymentMethodRepository;
    }

    @GetMapping
    public List<PaymentMethod> getAll(){
        return paymentMethodRepository.findAll();
    }

    @GetMapping("{id}")
    public PaymentMethod getById(@PathVariable int id){
        return paymentMethodRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody PaymentMethod paymentMethod){
         paymentMethodRepository.save(paymentMethod);
    }

    @PutMapping
    public void update(@RequestBody PaymentMethod paymentMethod){
        PaymentMethod paymentMethodToUpdate = paymentMethodRepository.findById(paymentMethod.getId()).orElseThrow();
        paymentMethodToUpdate.setName(paymentMethod.getName());
        paymentMethodRepository.save(paymentMethodToUpdate);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        paymentMethodRepository.deleteById(id);
    }
}
