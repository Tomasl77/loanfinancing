package fr.formation.loanfinancing.jobs.dtos;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.Digits;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

import org.modelmapper.ModelMapper;
import org.springframework.validation.annotation.Validated;

import fr.formation.loanfinancing.jobs.entities.LoanFinancing;
import lombok.Getter;
import lombok.Setter;

@Validated
@Getter
@Setter
public class LoanFinancingDto {

    ModelMapper mapper = new ModelMapper();

    LoanFinancingDto loanFinancingDto = mapper.map(LoanFinancing.class,
            LoanFinancingDto.class);

    @NotNull
    @Positive
    private BigDecimal amount;

    @NotNull
    @PositiveOrZero
    @Digits(integer = 10 /* precision */, fraction = 2 /* scale */)
    private BigDecimal interestRate;

    @NotNull
    @PositiveOrZero
    @Digits(integer = 10 /* precision */, fraction = 2 /* scale */)
    private BigDecimal insuranceRate;

    @Positive
    @NotNull
    private int duration;

    @NotBlank
    private String loanType;

    @NotNull
    @FutureOrPresent
    private LocalDate firstDeposit;

    public LoanFinancingDto() {
    }
}
