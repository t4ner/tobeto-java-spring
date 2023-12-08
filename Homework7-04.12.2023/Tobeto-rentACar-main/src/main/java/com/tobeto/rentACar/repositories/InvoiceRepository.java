package com.tobeto.rentACar.repositories;

import com.tobeto.rentACar.entities.Invoice;
import com.tobeto.rentACar.services.dtos.responses.invoice.GetByInvoiceResponse;
import com.tobeto.rentACar.services.dtos.responses.invoice.GetInvoiceByDateResponse;
import org.springframework.cglib.core.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface InvoiceRepository extends JpaRepository<Invoice,Integer> {


    List<Invoice> findByTotalPriceGreaterThanEqual(double totalPrice);


    List<Invoice> findByInvoiceDateLessThanEqual(LocalDate date);


    @Query("SELECT new com.tobeto.rentACar.services.dtos.responses.invoice.GetInvoiceByDateResponse(" +
            "i.id, i.totalPrice, new com.tobeto.rentACar.services.dtos.responses.employee.GetByEmployee" +
            "Response(e.firstName, e.lastName, new com.tobeto.rentACar.services.dtos.responses.role.GetRole" +
            "Response(r.name))) FROM Invoice i INNER JOIN i.employee e INNER JOIN e.role r WHERE i.invoiceDate " +
            "BETWEEN :startDate AND :endDate")
    List<GetInvoiceByDateResponse> getInvoiceByDate(LocalDate startDate, LocalDate endDate);


    @Query("SELECT new com.tobeto.rentACar.services.dtos.responses.invoice.GetInvoiceByDateResponse(i.id," +
            "i.totalPrice, new com.tobeto.rentACar.services.dtos.responses.employee.GetByEmployeeResponse(" +
            "e.firstName, e.lastName, new com.tobeto.rentACar.services.dtos.responses.role.GetRoleResponse(" +
            "r.name))) FROM Invoice i INNER JOIN i.employee e INNER JOIN e.role r WHERE i.invoiceDate>:date " +
            "AND e.gender=:gender")
    List<GetInvoiceByDateResponse> getInvoiceByGenderAndDate(LocalDate date, String gender);




}
