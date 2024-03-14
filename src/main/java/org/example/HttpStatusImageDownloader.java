package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.example.Util.*;

public class HttpStatusImageDownloader {
    static void downloadStatusImage(int code)throws Exception {
            String url = new HttpStatusChecker().getStatusImage(code);
            try(InputStream in = new URL(url).openStream()) {
                String path = DIRECTORY_FOR_SAVE + code + EXTENSION;
                if (!new File(path).exists()) {
                    Files.copy(in, Paths.get(path));
                } else {
                    System.out.println(String.format(FILE_ALREADY_EXIST_TEXT, code));
                }
            } catch(Exception e) {
                throw new FileNotFoundException(String.format(FILE_NOT_FOUND_EXCEPTION_TEXT, code));
            }
        }
    }

//        Він приймає код статусу, і якщо для цього коду статусу є картинка - скачує цю картинку, і зберігає її в папці, де була запущена програма.
//        Якщо картинки немає - метод викидає Exception.
//        Використай клас HttpStatusSchecker з попереднього завдання для отримання шляху до картинки та визначення наявності самої картинки.
