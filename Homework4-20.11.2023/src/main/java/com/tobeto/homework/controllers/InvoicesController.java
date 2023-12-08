package com.tobeto.homework.controllers;

import com.tobeto.homework.entities.Invoice;
import com.tobeto.homework.repositories.InvoiceRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/invoices")
public class InvoicesController {
    private final InvoiceRepository invoiceRepository;
    public InvoicesController(InvoiceRepository invoiceRepository){
        this.invoiceRepository = invoiceRepository;
    }
    @GetMapping
    public List<Invoice> getAll(){
        return invoiceRepository.findAll();
    }

    @GetMapping("{id}")
    public Invoice getById(@PathVariable int id){
        //Optionel<T> =>ilgili filtreden bir veri dönmeyebilir.
        return invoiceRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody Invoice invoice){
        invoiceRepository.save(invoice);
    }

    @PutMapping
    public void update(@RequestBody Invoice invoice){
        Invoice invoiceToUpdate = invoiceRepository.findById(invoice.getId()).orElseThrow();
        invoiceToUpdate.setInvoiceDate(invoice.getInvoiceDate());
        invoiceRepository.save(invoiceToUpdate);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        invoiceRepository.deleteById(id);
    }
}
