package com.epam.mjc.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FilterReader;
import java.io.IOException;


public class FileReader {

    public Profile getDataFromFile(File file) {
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(file)
        )) {
            String line;
            String name = null;
            int age = 0;
            String email = null;
            String phone = null;

            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Name:")) {
                    name = line.substring(6).trim();
                } else if (line.startsWith("Age:")) {
                    age = Integer.parseInt(line.substring(5).trim());
                } else if (line.startsWith("Email:")) {
                    email = line.substring(7).trim();
                } else if (line.startsWith("Phone:")) {
                    phone = line.substring(7).trim();
                }
            }

            return new Profile(name, age, email, Long.valueOf(phone));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
