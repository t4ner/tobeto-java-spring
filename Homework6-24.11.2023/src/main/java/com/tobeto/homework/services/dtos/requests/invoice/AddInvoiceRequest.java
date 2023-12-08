package com.tobeto.homework.services.dtos.requests.invoice;

import com.tobeto.homework.entities.Employee;
import com.tobeto.homework.entities.PaymentMethod;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddInvoiceRequest {

    private double totalPrice;
    private LocalDate invoiceDate;
    private PaymentMethod paymentMethod;
    private Employee employee;

}