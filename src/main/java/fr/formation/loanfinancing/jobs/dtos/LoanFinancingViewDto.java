package fr.formation.loanfinancing.jobs.dtos;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface LoanFinancingViewDto {

    BigDecimal getAmount();

    BigDecimal getInterestRate();

    BigDecimal getInsuranceRate();

    BigDecimal getDuration();

    String getLoanType();

    LocalDate getFirstDeposit();
}
