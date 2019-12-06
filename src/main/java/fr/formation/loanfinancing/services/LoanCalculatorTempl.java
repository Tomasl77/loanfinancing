package fr.formation.loanfinancing.services;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class LoanCalculatorTempl {

    private final static BigDecimal ONE_HUNDRED = new BigDecimal(100);

    private final static BigDecimal ONE = new BigDecimal(1);

    protected BigDecimal calculAnnuity(BigDecimal amount,
            BigDecimal interestRate, int duration) {
	BigDecimal interestCalculated = interestRate.divide(ONE_HUNDRED);
	BigDecimal annuity = amount.multiply(interestCalculated)
	        .divide(ONE.subtract(ONE.add(interestCalculated).pow(duration)))
	        .setScale(2, BigDecimal.ROUND_HALF_UP);
	return annuity;
    }

    static BigDecimal calculInterest(BigDecimal remainingCapital,
            BigDecimal loanRate) {
	BigDecimal interest = remainingCapital.multiply(loanRate)
	        .divide(ONE_HUNDRED).setScale(2, RoundingMode.HALF_UP);
	return interest;
    }

    static BigDecimal calculStillToPayCapital(BigDecimal amount,
            BigDecimal amortized) {
	BigDecimal stillToPay = amount.subtract(amortized).setScale(2,
	        RoundingMode.HALF_UP);
	return stillToPay;
    }

    static BigDecimal calculAmortizedCapital(BigDecimal annuity,
            BigDecimal interest) {
	BigDecimal amortized = annuity.subtract(interest).setScale(2,
	        RoundingMode.HALF_UP);
	return amortized;
    }

    static BigDecimal calculateInsurance(BigDecimal amount,
            BigDecimal insuranceRate) {
	BigDecimal insurance = amount.multiply(insuranceRate)
	        .divide(ONE_HUNDRED).setScale(2, RoundingMode.HALF_UP);
	return insurance;
    }

    static BigDecimal calculateTotalCost(BigDecimal annuity,
            BigDecimal insurance) {
	BigDecimal totalCost = annuity.add(insurance).setScale(2,
	        RoundingMode.HALF_UP);
	return totalCost;
    }
}
