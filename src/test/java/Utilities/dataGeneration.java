package Utilities;

import com.github.javafaker.Faker;

import java.util.Random;

public class dataGeneration {

    /**
     * Генерирует и возвращает email адрес с использованием библиотеки Faker.
     *
     * @return случайный email
     */
    public static String getFakeEmail() {
        Faker faker = new Faker();
        return faker.internet().emailAddress();
    }

    /**
     * Возвращает случайное целое число
     *
     * @return случайное число
     */
    public static int getRandomNumber(int minValue, int maxValue) {
        Random random = new Random();
        return random.nextInt(minValue, maxValue);
    }
}
