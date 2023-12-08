package com.tobeto.homework.services.dtos.responses.invoice;

import com.tobeto.homework.entities.Employee;
import com.tobeto.homework.entities.PaymentMethod;
import com.tobeto.homework.entities.Rental;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetInvoiceResponse {

    private double totalPrice;
    private LocalDate invoiceDate;
    private Rental rental;
    private PaymentMethod paymentMethod;
    private Employee employee;

}
