import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class PhoneBookTest {
    private PhoneBook book;

    @BeforeEach
    void search() {
        book = new PhoneBook();
        book.setContactName("philip");

        boolean actual = book.search("philip");
        assertTrue(actual);
        boolean actual1 = book.search("gaberiel");
        assertFalse(actual1);
    }

    @Test
    void deleteContact() {
        String actual = book.deleteContact("philip");
        assertEquals("Contact Deleted",actual);
    }

    @Test
    void editContactName() {
        String actual = book.editContactName("philip");
        assertEquals("Contact Edited",actual);

    }
    @Test
    void getContactName(){
        book.setContactName("philip");
        book.setContactName("Ajibola");
        ArrayList<String> result = book.getContactName();
        assertTrue(result.contains("philip"));
        assertTrue(result.contains("Ajibola"));
        assertEquals(3,result.size());
    }

    @Test
    void getPhoneNumber(){
        book.setPhoneNumber("09027531222");
        book.setPhoneNumber("09070065967");
        ArrayList<String> result = book.getPhoneNumber();
        assertTrue(result.contains("09027531222"));
        assertTrue(result.contains("09070065967"));
        assertEquals(2,result.size());
    }

    }

