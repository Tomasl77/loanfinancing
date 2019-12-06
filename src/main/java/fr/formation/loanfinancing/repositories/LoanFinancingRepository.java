package fr.formation.loanfinancing.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.loanfinancing.jobs.dtos.LoanFinancingViewDto;
import fr.formation.loanfinancing.jobs.entities.LoanFinancing;

public interface LoanFinancingRepository
        extends JpaRepository<LoanFinancing, Long> {

    LoanFinancingViewDto getById(Long id);

    Page<LoanFinancingViewDto> getAllProjectedBy(Pageable page);
}
