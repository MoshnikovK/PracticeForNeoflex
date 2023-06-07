package ru.neoflex.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.neoflex.practice.entity.CalcResult;

import java.util.List;

public interface CalcRepository extends JpaRepository<CalcResult, Integer> {
}
