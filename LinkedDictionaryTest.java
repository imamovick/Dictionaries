package homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedDictionaryTest {

    Dictionary<Integer, String> d = new LinkedDictionary<>();

    @Test
    void isInitiallyEmpty() {
        assertTrue(d.isEmpty());
    }

    @Test
    void isNotEmptyAfterPut() {
        d.put(1, "one");
        assertFalse(d.isEmpty());
    }

    @Test
    void remembersAddedKey() {
        d.put(1, "one");
        assertEquals("one", d.get(1));
    }

    @Test
    void overwritesOldValue() {
        d.put(1, "one");
        d.put(1, "tasi");
        assertEquals("tasi", d.get(1));
    }

    @Test
    void getsNullForNonexistentKeys() {
        assertNull(d.get(2));
    }

    @Test
    void doesNotOverwriteOtherKey() {
        d.put(1, "one");
        d.put(2, "two");
        assertEquals("one", d.get(1));
    }

    @Test
    void becomesEmptyAtCorrectTime() {
        d.put(1, "one");
        d.put(2, "two");
        d.put(1, null);
        assertFalse(d.isEmpty());
        d.put(2, null);
        assertTrue(d.isEmpty());
    }

    @Test
    void doesNotStoreNullValues() {
        d.put(1, null);
        assertTrue(d.isEmpty());
    }

    @Test
    void isGeneric() {
        Dictionary<String, Double> d1 = new LinkedDictionary<>();
        assertTrue(d1.isEmpty());
        d1.put("Three", 3.0);
        d1.put("Four", 4.0);
        d1.put("Fourty-Two", 42.0);
        assertFalse(d1.isEmpty());
    }

}