package fr.formation.loanfinancing.services;

import org.springframework.stereotype.Service;

import fr.formation.loanfinancing.jobs.dtos.LoanFinancingDto;
import fr.formation.loanfinancing.jobs.entities.AmortizationTable;

@Service
public class LoanSimulator {

    private LoanCalculatorTempl template;

    public LoanSimulator(LoanCalculatorTempl template) {
	this.template = template;
    }

    public AmortizationTable constructTable(LoanFinancingDto dto) {
	int duration = dto.getDuration();
	return null;
    }
}
