package com.lucentit.pecuniam.domain.facade.impl;

import com.lucentit.pecuniam.domain.facade.CashflowFacade;
import com.lucentit.pecuniam.domain.model.Cashflow;
import com.lucentit.pecuniam.domain.repository.CashflowRepository;
import com.lucentit.pecuniam.domain.service.CashflowService;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class CashflowFacadeImpl implements CashflowFacade {
    private CashflowRepository cashflowRepo;
    private CashflowService cashflowService;
            
    @Override
    public List<Cashflow> returnCurrentCashflow() {
        Calendar calToday = Calendar.getInstance();        
        calToday.setTime(new Date());
        return returnCashflowByMonthAndYear(calToday.get(Calendar.MONTH), calToday.get(Calendar.YEAR));
    }

    @Override
    public List<Cashflow> returnCashflowByMonthAndYear(int month, int year) {        
        return cashflowRepo.returnCashflowByMonthAndYear(month, year);
    }

    @Override
    public void saveNewEvent(Cashflow newCashflowEvent) {
        cashflowService.saveNewEvent(newCashflowEvent);
    }    
}
