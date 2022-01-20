package com.ertugrul.credit.controller;

import com.ertugrul.credit.dto.CreditApplicationRequestDto;
import com.ertugrul.credit.dto.CreditApplicationResponseDto;
import com.ertugrul.credit.service.CreditApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/credit-applications")
@CrossOrigin
@RequiredArgsConstructor
public class CreditApplicationController {
    private final CreditApplicationService creditApplicationService;

    // GET http://localhost:8080/api/v1/creditApplications/1
    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable Long id) {

        CreditApplicationResponseDto creditApplicationDto = creditApplicationService.findById(id);

        return ResponseEntity.ok(creditApplicationDto);
    }

    //GET http://localhost:8080/api/v1/credit-applications/
    @GetMapping("/")
    public ResponseEntity<Object> getAllCreditApplications() {
        List<CreditApplicationResponseDto> all = creditApplicationService.findAll();
        return ResponseEntity.ok(all);
    }

    //POST http://localhost:8080/api/v1/credit-applications
    @PostMapping
    public ResponseEntity<Object> create(@Valid @RequestBody CreditApplicationRequestDto creditApplicationRequestDto) {
        return ResponseEntity.ok(creditApplicationService.create(creditApplicationRequestDto));
    }

    //DELETE http://localhost:8080/api/v1/credit-applications/1
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        creditApplicationService.deleteById(id);
    }

}