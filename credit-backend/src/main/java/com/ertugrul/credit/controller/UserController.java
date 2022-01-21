package com.ertugrul.credit.controller;

import com.ertugrul.credit.dto.UserRequestDto;
import com.ertugrul.credit.dto.UserResponseDto;
import com.ertugrul.credit.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@CrossOrigin
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    // GET http://localhost:8080/api/v1/users/13241052323'
    @GetMapping("/{nationalIdNumber}")
    public ResponseEntity<Object> getByNationalIdNumber(@PathVariable String nationalIdNumber) {

        UserResponseDto userResponseDto = userService.findByNationalIdNumber(nationalIdNumber);

        return ResponseEntity.ok(userResponseDto);
    }

    //GET http://localhost:8080/api/v1/users/
    @GetMapping("/")
    public ResponseEntity<Object> getAllUsers() {
        List<UserResponseDto> all = userService.findAll();
        return ResponseEntity.ok(all);
    }

    //POST http://localhost:8080/api/v1/users
    @PostMapping
    public ResponseEntity<Object> create(@Valid @RequestBody UserRequestDto userRequestDto) {
        return ResponseEntity.ok(userService.create(userRequestDto));
    }

    //PUT http://localhost:8080/api/v1/users/13241052323'
    @PutMapping("/{nationalIdNumber}")
    public ResponseEntity<Object> update(@Valid @RequestBody UserRequestDto userRequestDto, @PathVariable String nationalIdNumber) {
        return ResponseEntity.ok(userService.update(userRequestDto, nationalIdNumber));
    }

    //DELETE http://localhost:8080/api/v1/users/13241052323
    @DeleteMapping("/{nationalIdNumber}")
    public void deleteByNationalIdNumber(@PathVariable String nationalIdNumber) {
        userService.deleteByNationalIdNumber(nationalIdNumber);
    }

}