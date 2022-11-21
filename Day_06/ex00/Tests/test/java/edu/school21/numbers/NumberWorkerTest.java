package edu.school21.numbers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class NumberWorkerTest {

    private NumberWorker _numberWorker;

    @BeforeEach
    public void Init(){
        _numberWorker = new NumberWorker();
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 3, 5, 7, 691, 911})
    void isPrimeForPrimes(int argument){
        assertTrue(_numberWorker.isPrime(argument));
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 6, 15, 27, 692, 927})
    void isNotPrimeForPrimes(int argument){
        assertFalse(_numberWorker.isPrime(argument));
    }

    @ParameterizedTest
    @ValueSource(ints = {-4, -6, -15, 0, 1})
    void  isPrimeForIncorrectNumbers(int argument){
        assertThrows(NumberWorker.IllegalNumberException.class, () -> _numberWorker.isPrime(argument));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/data.csv")
    void DigitSumsTest(int first, int second) {
        assertEquals(second, _numberWorker.digitsSum(first));
    }
}
