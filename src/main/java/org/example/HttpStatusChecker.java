package org.example;

import java.io.FileNotFoundException;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.example.Util.*;

public class HttpStatusChecker {
    public static String getStatusImage(int code)throws Exception {
            String stringUrl = START_URL + code + EXTENSION;
            HttpURLConnection connection = (HttpURLConnection) new URL(stringUrl).openConnection();
            int responseCode = connection.getResponseCode();
            if(responseCode == 404) {
                throw new FileNotFoundException(String.format(FILE_NOT_FOUND_EXCEPTION_TEXT, code));
            } else {
                return stringUrl;
            }
        }
    }

//    Він приймає код статусу, і повертає посилання на картинку для цього коду.
//    Якщо для відповідного коду картинки немає (сайт https://http.cat повернув 404) - метод викидає Exception.
//        Наприклад, виклик getStatusImage(200) має повернути рядок https://http.cat/200.jpg.
//        А виклик getStatusImage(10000) має викинути виключення, тому що сайт https://http.cat поверне код відповіді 404.
//        Протестуй свою програму, викликаючи її з різними аргументами.
