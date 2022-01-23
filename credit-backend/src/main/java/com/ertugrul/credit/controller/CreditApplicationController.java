package com.ertugrul.credit.controller;

import com.ertugrul.credit.dto.CreditApplicationRequestDto;
import com.ertugrul.credit.service.CreditApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;

@RestController
@RequestMapping("/api/v1/credit-applications")
@CrossOrigin
@RequiredArgsConstructor
public class CreditApplicationController {
    private final CreditApplicationService creditApplicationService;

    //POST http://localhost:8080/api/v1/credit-applications
    @PostMapping
    public ResponseEntity<Object> create(@Valid @RequestBody CreditApplicationRequestDto creditApplicationRequestDto) {
        return ResponseEntity.ok(creditApplicationService.saveCreditApplication(creditApplicationRequestDto));
    }

    //GET http://localhost:8080/api/v1/credit-applications/
    @GetMapping("/")
    public ResponseEntity<Object> getByByNationalIdNumberAndBirthDate(@RequestParam("birthdate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate birthDate,
                                                                      @RequestParam("id") String nationalIdNumber) {
        return ResponseEntity.ok(creditApplicationService.findCreditApplicationByNationalIdNumberAndBirthDate(nationalIdNumber, birthDate));
    }

}