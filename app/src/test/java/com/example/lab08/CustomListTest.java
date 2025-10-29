package com.example.lab08;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CustomListTest {
    @Test
    public void testHasCity() {
        CustomList list = new CustomList();
        City city = new City("Calgary", "AB");
        assertNotNull(city);
        assertFalse(list.hasCity(city));
        list.addCity(city);
        assertTrue(list.hasCity(city));
    }

    @Test
    public void testDeleteCity() {
        CustomList list = new CustomList();
        City city = new City("Calgary", "AB");
        assertThrows(IllegalStateException.class, () -> list.deleteCity(city));
        City city2 = new City("Edmonton", "AB");
        list.addCity(city2);
        assertThrows(IllegalStateException.class, () -> list.deleteCity(city));
        list.addCity(city);
        assertDoesNotThrow(() -> list.deleteCity(city));
    }

    @Test
    public void testCountCity() {
        CustomList list = new CustomList();
        City city = new City("Calgary", "AB");
        assertEquals(0, list.countCities());
        list.addCity(new City("Edmonton", "AB"));
        assertEquals(1, list.countCities());
        list.addCity(city);
        assertEquals(2, list.countCities());
        list.deleteCity(city);
        assertEquals(1, list.countCities());
        list.deleteCity(new City("Edmonton", "AB"));
        assertEquals(0, list.countCities());
    }
}
