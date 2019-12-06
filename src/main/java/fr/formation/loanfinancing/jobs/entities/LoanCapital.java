package fr.formation.loanfinancing.jobs.entities;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoanCapital {

    protected BigDecimal amortizedCapital;

    protected BigDecimal interest;

    protected BigDecimal stillToPayCapital;

    protected BigDecimal insurance;

    protected BigDecimal totalCost;

    public LoanCapital() {
    }
}
