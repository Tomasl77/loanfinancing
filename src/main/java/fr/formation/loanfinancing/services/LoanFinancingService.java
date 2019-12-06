package fr.formation.loanfinancing.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import fr.formation.loanfinancing.jobs.dtos.LoanFinancingDto;
import fr.formation.loanfinancing.jobs.dtos.LoanFinancingViewDto;

public interface LoanFinancingService {

    void create(LoanFinancingDto dto);

    void delete(Long id);

    LoanFinancingViewDto getOne(Long id);

    Page<LoanFinancingViewDto> getAll(Pageable pageable);

    void update(Long id, LoanFinancingDto dto);
}
