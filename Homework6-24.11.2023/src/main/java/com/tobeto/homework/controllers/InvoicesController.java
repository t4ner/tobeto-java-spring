package com.tobeto.homework.controllers;

import com.tobeto.homework.services.abstracts.InvoiceService;
import com.tobeto.homework.services.dtos.requests.invoice.AddInvoiceRequest;
import com.tobeto.homework.services.dtos.requests.invoice.UpdateInvoiceRequest;
import com.tobeto.homework.services.dtos.responses.invoice.GetInvoiceListResponse;
import com.tobeto.homework.services.dtos.responses.invoice.GetInvoiceResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/invoices")
@AllArgsConstructor
public class InvoicesController {
    private final InvoiceService invoiceService;

    @GetMapping
    public List<GetInvoiceListResponse> getAll(){
        return invoiceService.getAll();
    }

    @GetMapping("{id}")
    public GetInvoiceResponse getById(@PathVariable int id){
        return invoiceService.getById(id);
    }

    @PostMapping
    public void add(@RequestBody AddInvoiceRequest addInvoiceRequest){
        invoiceService.add(addInvoiceRequest);
    }

    @PutMapping
    public void update(@RequestBody UpdateInvoiceRequest updateInvoiceRequest){
        invoiceService.update(updateInvoiceRequest);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        invoiceService.delete(id);
    }
}
