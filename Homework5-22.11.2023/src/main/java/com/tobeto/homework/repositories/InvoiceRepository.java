package com.tobeto.homework.repositories;

import com.tobeto.homework.entities.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {}
