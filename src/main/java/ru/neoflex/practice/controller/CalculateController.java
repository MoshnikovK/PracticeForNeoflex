package ru.neoflex.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.neoflex.practice.entity.CalcResult;
import ru.neoflex.practice.repository.CalcRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/calc")
public class CalculateController {

    @Autowired
    CalcRepository calcRepository;

    @GetMapping("/all")
    public ResponseEntity<List<CalcResult>> getAllResult() {
        try {
            List<CalcResult> result = new ArrayList<CalcResult>();

            result.addAll(calcRepository.findAll());
            if(result.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/plus/{a}/{b}")
    public ResponseEntity<CalcResult> Plus(@PathVariable int a, @PathVariable int b) {
        int result = a + b;
        try {
            CalcResult _calcResult = calcRepository
                    .save(new CalcResult("+", a, b, result));
            return new ResponseEntity<>(_calcResult, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/minus/{a}/{b}")
    public ResponseEntity<CalcResult> Minus(@PathVariable int a, @PathVariable int b) {
        int result = a - b;
        try {
            CalcResult _calcResult = calcRepository
                    .save(new CalcResult("-", a, b, result));
            return new ResponseEntity<>(_calcResult, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
