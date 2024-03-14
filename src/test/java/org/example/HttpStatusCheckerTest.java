package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class HttpStatusCheckerTest {
    @Test
    void testStatus404ReturnStringUrl() throws Exception {
        //When
        String actual = HttpStatusChecker.getStatusImage(200);

        //Then
        String expected = "https://http.cat/200.jpg";
        Assertions.assertEquals(expected, actual);
    }
    @Test
    void statusImage666FailTest(){
        Assertions.assertThrows(Exception.class, () -> HttpStatusChecker.getStatusImage(666));
    }

}