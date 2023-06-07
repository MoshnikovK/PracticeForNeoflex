package ru.neoflex.practice.UnitTest;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.neoflex.practice.entity.CalcResult;
import ru.neoflex.practice.repository.CalcRepository;

@Service
@RequiredArgsConstructor
public class CalcUseCase {
    private final CalcRepository calcRepository;
    public CalcResult AddPlus(CalcResult item){
        item.setOperation("plus");
        item.setFirstValue(5);
        item.setLastValue(5);
        item.setResult(10);
        return calcRepository.save(item);
    }
    public CalcResult AddMinus(CalcResult item){
        item.setOperation("minus");
        item.setFirstValue(10);
        item.setLastValue(4);
        item.setResult(6);
        return  calcRepository.save(item);
    }
    /*public CalcResult PlusNegativeAll(CalcResult item){
        item.setOperation("plus");
        item.setFirstValue(-5);
        item.setLastValue(-5);
        item.setResult(-10);
        return calcRepository.save(item);
    }
    public CalcResult PlusNegativeAndPositive(CalcResult item){
        item.setOperation("plus");
        item.setFirstValue(-5);
        item.setLastValue(5);
        item.setResult(0);
        return calcRepository.save(item);
    }*/
}
