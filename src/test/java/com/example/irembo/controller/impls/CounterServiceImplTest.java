package com.example.irembo.controller.impls;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class CounterServiceImplTest {

    @InjectMocks
    private CounterServiceImpl counterService;

    @Test
    void givenEmptyOrNullArray_If_CountResultEqualsExpectedResult_Then_Succeed(){
        String result = counterService.count(null);
        Assertions.assertEquals(result, "");
    }

    @Test
    void givenArrayString_If_CountResultEqualsExpectedResult_Then_Succeed() {
        String[] fruits = {"Apple", "Apricot", "Cherry", "Banana", "Cherry", "Papaya",
                "Cantaloupe"};
        String result = counterService.count(fruits);
        String expected = "A:2\n" +
                "B:1\n" +
                "C:3\n" +
                "D:0\n" +
                "E:0\n" +
                "F:0\n" +
                "G:0\n" +
                "H:0\n" +
                "I:0\n" +
                "J:0\n" +
                "K:0\n" +
                "L:0\n" +
                "M:0\n" +
                "N:0\n" +
                "O:0\n" +
                "P:1\n" +
                "Q:0\n" +
                "R:0\n" +
                "S:0\n" +
                "T:0\n" +
                "U:0\n" +
                "V:0\n" +
                "W:0\n" +
                "X:0\n" +
                "Y:0\n" +
                "Z:0\n";
        assert result != null;
        Assertions.assertEquals(result, expected);
    }

    @Test
    void givenArrayString_If_CountEnhanced_Result_EqualsExpectedResult_Then_Succeed() {

        String[] fruits = {"Apple", "Apricot", "Cherry", "Banana", "Cherry", "Papaya",
                "Cantaloupe"};
        String result = counterService.enhancedCount(fruits);
        String expected = "A:2\n" +
                "1 Apple\n" +
                "1 Apricot\n" +
                "B:1\n" +
                "1 Banana\n" +
                "C:3\n" +
                "2 Cherry\n" +
                "1 Cantaloupe\n" +
                "D:0\n" +
                "E:0\n" +
                "F:0\n" +
                "G:0\n" +
                "H:0\n" +
                "I:0\n" +
                "J:0\n" +
                "K:0\n" +
                "L:0\n" +
                "M:0\n" +
                "N:0\n" +
                "O:0\n" +
                "P:1\n" +
                "1 Papaya\n" +
                "Q:0\n" +
                "R:0\n" +
                "S:0\n" +
                "T:0\n" +
                "U:0\n" +
                "V:0\n" +
                "W:0\n" +
                "X:0\n" +
                "Y:0\n" +
                "Z:0\n";
        assert result != null;
        Assertions.assertEquals(result, expected);
    }

    @Test
    void givenEmptyOrNullArray_If_CountEnhanced_Result_is_EmptyString_Then_Succeed(){
        String result = counterService.enhancedCount(null);
        Assertions.assertEquals(result, "");
    }

}