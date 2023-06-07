package ru.neoflex.practice.UnitTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.neoflex.practice.entity.CalcResult;
import ru.neoflex.practice.repository.CalcRepository;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class CalcRepositoryUnitTest {
    @Mock
    private CalcRepository calcRepository;

    private CalcUseCase calcUseCase;
    @BeforeEach
    void initUseCase(){
        calcUseCase = new CalcUseCase(calcRepository);
    }
    @Test
    void addedPlusTest(){
        CalcResult calcResult = new CalcResult();
        when(calcRepository.save(any(CalcResult.class))).then(returnsFirstArg());
        CalcResult savedResult = calcUseCase.AddPlus(calcResult);
        assertThat(savedResult.getResult()).isNotNull();
    }
    @Test
    void addedMinusTest(){
        CalcResult calcResult = new CalcResult();
        when(calcRepository.save(any(CalcResult.class))).then(returnsFirstArg());
        CalcResult savedResult = calcUseCase.AddMinus(calcResult);
        assertThat(savedResult.getResult()).isNotNull();
    }
    @Test
    void getAllAsArrayList(){
      assertThat(calcRepository.findAll()).isEqualTo(new ArrayList<CalcResult>());
    }
    @Test
    void getOperationIsNotMinus(){
        CalcResult calcResult = new CalcResult();
        when(calcRepository.save(any(CalcResult.class))).then(returnsFirstArg());
        CalcResult savedResult = calcUseCase.AddPlus(calcResult);
        assertThat(savedResult.getOperation()).isNotEqualTo("minus");
    }
    @Test
    void getOperationIsNotPlus(){
        CalcResult calcResult = new CalcResult();
        when(calcRepository.save(any(CalcResult.class))).then(returnsFirstArg());
        CalcResult savedResult = calcUseCase.AddMinus(calcResult);
        assertThat(savedResult.getOperation()).isNotEqualTo("plus");
    }
    @Test
    void getAllIsNotNull(){
        assertThat(calcRepository.findAll()).isNotEqualTo(null);
    }
}
