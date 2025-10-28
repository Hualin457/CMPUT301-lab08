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
}
