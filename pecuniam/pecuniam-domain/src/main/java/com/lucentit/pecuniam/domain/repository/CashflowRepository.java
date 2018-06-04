package com.lucentit.pecuniam.domain.repository;

import com.lucentit.pecuniam.domain.model.Cashflow;
import java.util.List;

public interface CashflowRepository {
    List<Cashflow> returnCashflowByMonthAndYear(int month, int year);
}
