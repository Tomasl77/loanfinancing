package fr.formation.loanfinancing.jobs.entities;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.modelmapper.ModelMapper;

import fr.formation.loanfinancing.jobs.dtos.LoanFinancingDto;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class LoanFinancing {

    ModelMapper mapper = new ModelMapper();

    LoanFinancing loanFinancing = mapper.map(LoanFinancingDto.class,
            LoanFinancing.class);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "amount", nullable = false)
    private BigDecimal amount;

    @Column(name = "first_deposit", nullable = false)
    private LocalDate firstDeposit;

    @Column(name = "duration", nullable = false)
    private int duration;

    @Column(name = "interest_rate", nullable = false)
    private BigDecimal interestRate;

    @Column(name = "insurance_rate")
    private BigDecimal insuranceRate;

    @Column(name = "loan_type")
    private String loanType;
}
