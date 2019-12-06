package fr.formation.loanfinancing.controllers;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.loanfinancing.jobs.dtos.LoanFinancingDto;
import fr.formation.loanfinancing.jobs.dtos.LoanFinancingViewDto;
import fr.formation.loanfinancing.services.LoanFinancingService;

@RestController
@RequestMapping("/loan_financing")
@CrossOrigin
public class LoanFinancingController {

    private final LoanFinancingService service;

    protected LoanFinancingController(LoanFinancingService service) {
	this.service = service;
    }

    @PostMapping
    protected void create(@Valid @RequestBody LoanFinancingDto dto) {
	service.create(dto);
    }

    @PutMapping("/{id}")
    protected void update(@PathVariable("id") Long id,
            @Valid @RequestBody LoanFinancingDto dto) {
	service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    protected void delete(@PathVariable("id") Long id) {
	service.delete(id);
    }

    @GetMapping("/{id}")
    protected LoanFinancingViewDto getOne(@PathVariable("id") Long id) {
	return service.getOne(id);
    }

    @GetMapping
    protected Page<LoanFinancingViewDto> getAll(@RequestParam("p") int page,
            @RequestParam("s") int size, @RequestParam("by") String by) {
	Sort sort = Sort.by(Direction.DESC, by);
	Pageable pageable = PageRequest.of(page, size, sort);
	return service.getAll(pageable);
    }
}
