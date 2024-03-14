package org.example;

import java.io.IOException;
import java.util.Scanner;

public class HttpImageStatusCli {
    static void askStatus(){
        int code = -1;
        String startMessage = "Enter HTTP Status code: ";
        Scanner scanner = new Scanner(System.in);

        while (true) {
            if (code == -1) {
                System.out.print(startMessage);
            }

            if (scanner.hasNextInt()) {
                code = scanner.nextInt();
                if (code == 0) {
                    break;
                }

        try {
            HttpStatusImageDownloader.downloadStatusImage(code);
            System.out.println("Downloaded image with code: " + code);
        } catch (Exception e) {
            System.out.println("There is no image for HTTP status " + code + ". Exception: " + e.getMessage());
        }
        code = -1;

    } else {
        System.out.print("Incorrect code! " + startMessage);
        scanner.next();
        code = -2;
    }
}
}
}
//    Коли викликається цей метод, то програма повинна:
//
//        запитати у юзера код статусу (наприклад, Enter HTTP status code)
//        юзер вводить в консоль код статусу (наприклад, 200)
//        програма перевіряє, чи є картинка для цього статусу на сайті https://http.cat, і якщо є - то скачує цю картинку.
//        Якщо ж картинки немає - виводить в консоль фразу There is not image for HTTP status <CODE>
//        (замість <CODE> підставляється код статусу, що ввів користувач)
//        якщо користувач вводить некоректне число (наприклад, test) - програма має вивести фразу Please enter valid number