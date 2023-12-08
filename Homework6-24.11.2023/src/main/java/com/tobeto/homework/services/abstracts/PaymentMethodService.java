package com.tobeto.homework.services.abstracts;

import com.tobeto.homework.services.dtos.requests.paymentMethod.AddPaymentMethodRequest;
import com.tobeto.homework.services.dtos.requests.paymentMethod.UpdatePaymentMethodRequest;
import com.tobeto.homework.services.dtos.responses.paymentMethod.GetPaymentMethodListResponse;
import com.tobeto.homework.services.dtos.responses.paymentMethod.GetPaymentMethodResponse;

import java.util.List;

public interface PaymentMethodService {
    List<GetPaymentMethodListResponse> getAll();
    GetPaymentMethodResponse getById(int id);
    void add(AddPaymentMethodRequest addPaymentMethodRequest);
    void update(UpdatePaymentMethodRequest updatePaymentMethodRequest);
    void delete(int id);
}
