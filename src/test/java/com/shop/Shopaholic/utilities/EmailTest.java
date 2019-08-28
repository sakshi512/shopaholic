package com.shop.Shopaholic.utilities;

import org.junit.Test;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

public class EmailTest {
    @Test
    public void sendMailTest()
    {
        Email email = new Email();
        email.sendImage();
    }

    @Test
    public void getFilePathFromStatic() throws URISyntaxException {
        EmailTest main = new EmailTest();
        File file = main.getFileFromResources("static/images/NoImage.png");
        System.out.println(file.getAbsolutePath());
    }


    @Test
    public void getFilePath()
    {
        Email  email= new Email();
        String filePath = email.getFilePathFromDesktop("Jeans.jpeg");
        System.out.println(filePath);

    }


    private File getFileFromResources(String fileName) {

        ClassLoader classLoader = getClass().getClassLoader();

        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new IllegalArgumentException("file is not found!");
        } else {
            return new File(resource.getFile());
        }

    }
}
