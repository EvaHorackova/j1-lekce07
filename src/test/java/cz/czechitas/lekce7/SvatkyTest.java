package cz.czechitas.lekce7;

import org.junit.jupiter.api.Test;

import java.time.Month;
import java.time.MonthDay;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Filip Jirsák
 */
class SvatkyTest {

    /**
     * Testuje metodu {@link Svatky#kdyMaSvatek(String)}
     */
    @Test
    void kdyMaSvatek() {
        Svatky svatky = new Svatky();
        assertEquals(MonthDay.of(5, 18), svatky.kdyMaSvatek("Nataša"));
        assertNull(svatky.kdyMaSvatek("Eva"));
        assertNull(svatky.kdyMaSvatek("Vidlička"));
    }

    /**
     * Testuje metodu {@link Svatky#jeVSeznamu(String)}
     */
    @Test
    void jeVSeznamu() {
        //Otestovat, že najde v seznamu existující jméno a nenajde neexistující jméno
        Svatky svatky = new Svatky();
        assertTrue(svatky.jeVSeznamu("Nataša"));
        assertFalse(svatky.jeVSeznamu("Eva"));
        assertFalse(svatky.jeVSeznamu("Vidlička"));
    }

    /**
     * Testuje metodu {@link Svatky#getPocetJmen()}
     */
    @Test
    void getPocetJmen() {
        //Otestovat, že vrací počet jmen, která máme v seznamu
        Svatky svatky = new Svatky();
        assertEquals(37, svatky.getPocetJmen());
        assertNotEquals(50, svatky.getPocetJmen());
    }

    /**
     * Testuje metodu {@link Svatky#getSeznamJmen()}
     */
    @Test
    void getSeznamJmen() {
        //Zkontrolovat, že seznam jmen má správný počet položek
        Svatky svatky = new Svatky();
        assertNotNull(svatky.getSeznamJmen());
        assertEquals(37, svatky.getPocetJmen());
        assertNotEquals(50, svatky.getPocetJmen());
    }

    /**
     * Testuje metodu {@link Svatky#pridatSvatek(String, int, int)}
     */
    @Test
    void pridatSvatekDenMesicInt() {
        //Otestuje, že je jméno v seznamu svátků a že má přiřazen správný den
        Svatky svatky = new Svatky();
        svatky.pridatSvatek("Hugo", 1, 4);
        assertTrue(svatky.jeVSeznamu("Hugo"));
        assertEquals(MonthDay.of(4, 1), svatky.kdyMaSvatek("Hugo"));
        assertNotEquals(MonthDay.of(5, 31), svatky.kdyMaSvatek("Hugo"));
    }

    /**
     * Testuje metodu {@link Svatky#pridatSvatek(String, int, Month)}
     */
    @Test
    void pridatSvatekDenMesicMonth() {
        //Otestuje, že je jméno v seznamu svátků a že má přiřazen správný den
        Svatky svatky = new Svatky();
        svatky.pridatSvatek("Erika", 2, Month.APRIL);
        assertTrue(svatky.jeVSeznamu("Erika"));
        assertEquals(MonthDay.of(4, 2), svatky.kdyMaSvatek("Erika"));
        assertNotEquals(MonthDay.of(5, 31), svatky.kdyMaSvatek("Erika"));
    }

    /**
     * Testuje metodu {@link Svatky#pridatSvatek(String, MonthDay)}
     */
    @Test
    void prridatSvatekMonthDay() {
        //Otestuje, že je jméno v seznamu svátků a že má přiřazen správný den
        Svatky svatky = new Svatky();
        svatky.pridatSvatek("Richard", MonthDay.of(4, 3));
        assertTrue(svatky.jeVSeznamu("Richard"));
        assertEquals(MonthDay.of(4, 3), svatky.kdyMaSvatek("Richard"));
        assertNotEquals(MonthDay.of(5, 31), svatky.kdyMaSvatek("Richard"));
    }

    /**
     * Testuje metodu {@link Svatky#smazatSvatek(String)}
     */
    @Test
    void smazatSvatek() {
        //Zkontrolovat, že po smazání bude počet svátků odpovídat novému počtu
        Svatky svatky = new Svatky();
        assertEquals(37, svatky.getPocetJmen());
        assertTrue(svatky.jeVSeznamu("Nataša"));
        svatky.smazatSvatek("Nataša");
        assertFalse(svatky.jeVSeznamu("Nataša"));
        assertEquals(36, svatky.getPocetJmen());
        assertNotEquals(50, svatky.getPocetJmen());
    }
}
