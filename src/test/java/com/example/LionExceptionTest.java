package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class LionExceptionTest {
private static final String EXPECTED_ERROR = "Используйте допустимые значения пола животного - самец или самка";
    String sex;

    public LionExceptionTest(String sex) {
        this.sex = sex;
    }

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {"unknown"},
                {null},
                {"Самецц"}
        };
    }
    @Test()
    public void doesHaveManeExceptionTest() {
        Exception exception = Assert.assertThrows(Exception.class,
                () -> new Lion(sex, null));

        Assert.assertEquals(EXPECTED_ERROR, exception.getMessage());
    }
}