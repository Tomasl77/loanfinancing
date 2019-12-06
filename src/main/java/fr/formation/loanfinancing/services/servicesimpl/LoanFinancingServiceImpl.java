package fr.formation.loanfinancing.services.servicesimpl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import fr.formation.loanfinancing.jobs.dtos.LoanFinancingDto;
import fr.formation.loanfinancing.jobs.dtos.LoanFinancingViewDto;
import fr.formation.loanfinancing.jobs.entities.AmortizationTable;
import fr.formation.loanfinancing.jobs.entities.LoanFinancing;
import fr.formation.loanfinancing.repositories.LoanFinancingRepository;
import fr.formation.loanfinancing.services.LoanFinancingService;

@Service
public class LoanFinancingServiceImpl implements LoanFinancingService {

    private final LoanFinancingRepository repo;

    protected LoanFinancingServiceImpl(
            LoanFinancingRepository loanFinancingRepo) {
	this.repo = loanFinancingRepo;
    }

    @Override
    public AmortizationTable create(LoanFinancingDto dto) {
	LoanFinancing loanFinancing = new LoanFinancing();
	populateAndSave(dto, loanFinancing);
	return null;
    }

    @Override
    public void update(Long id, LoanFinancingDto dto) {
	LoanFinancing loanFinancing = repo.findById(id).get();
	populateAndSave(dto, loanFinancing);
    }

    private void populateAndSave(LoanFinancingDto dto,
            LoanFinancing loanFinancing) {
	loanFinancing.setAmount(dto.getAmount());
	loanFinancing.setDuration(dto.getDuration());
	loanFinancing.setInterestRate(dto.getInterestRate());
	loanFinancing.setInsuranceRate(dto.getInsuranceRate());
	loanFinancing.setLoanType(dto.getLoanType());
	loanFinancing.setFirstDeposit(dto.getFirstDeposit());
	repo.save(loanFinancing);
    }

    @Override
    public void delete(Long id) {
	repo.deleteById(id);
    }

    @Override
    public Page<LoanFinancingViewDto> getAll(Pageable pageable) {
	return repo.getAllProjectedBy(pageable);
    }

    @Override
    public LoanFinancingViewDto getOne(Long id) {
	return repo.getById(id);
    }
}
