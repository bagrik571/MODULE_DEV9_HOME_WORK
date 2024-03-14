package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class HttpStatusImageDownloaderTest {
    @Test
    void status404DownloadAndSaveFileTest() throws Exception {
        File file = new File("status_code_images/404.jpg");
        if (file.exists()) {
            file.delete();
        }
        HttpStatusImageDownloader.downloadStatusImage(404);

        Assertions.assertTrue(file.exists());
    }
    @Test
    void status666FailDownloadAndSaveFileTest () {
        Assertions.assertThrows(Exception.class, () -> HttpStatusImageDownloader.downloadStatusImage(666));
    }

}