package com.lucentit.pecuniam.domain.service;

import com.lucentit.pecuniam.domain.model.Cashflow;

public interface CashflowService {
    void saveNewEvent(Cashflow cashflowEvent);
}
