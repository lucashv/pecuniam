package com.lucentit.pecuniam.domain.facade;

import com.lucentit.pecuniam.domain.model.Cashflow;
import java.util.List;

public interface CashflowFacade {
    List<Cashflow> returnCurrentCashflow();
    List<Cashflow> returnCashflowByMonthAndYear(int month, int year);
    void saveNewEvent(Cashflow newCashflowEvent);
}
