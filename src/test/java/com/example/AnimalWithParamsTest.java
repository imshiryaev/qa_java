package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;


@RunWith(Parameterized.class)
public class AnimalWithParamsTest {

    Animal animal;
    String animalKind;
    List<String> animalsFood;

    public AnimalWithParamsTest(String animalKind, List<String> animalsFood){
        this.animalKind = animalKind;
        this.animalsFood = animalsFood;
    }

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][] {
                {"Травоядное", List.of("Трава", "Различные растения")},
                {"Хищник", List.of("Животные", "Птицы", "Рыба")},
        };
    }

    @Before
    public void setup(){
        animal = new Animal();
    }

    @Test
    public void getFood() throws Exception {
        List<String> expectedResult = animal.getFood(animalKind);
        Assert.assertEquals("Список еды не совпадает с ожидаемым",expectedResult, animalsFood);
    }

}