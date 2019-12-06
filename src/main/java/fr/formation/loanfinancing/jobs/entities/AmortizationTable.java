package fr.formation.loanfinancing.jobs.entities;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AmortizationTable {

    private int duration;

    private ArrayList<LoanCapital> loanTotalCapital;

    public AmortizationTable(int duration,
            ArrayList<LoanCapital> loanTotalCapital) {
	this.duration = duration;
	this.loanTotalCapital = loanTotalCapital;
    }
}
