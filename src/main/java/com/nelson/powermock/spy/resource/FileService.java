package com.nelson.powermock.spy.resource;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileService {

    public void write(String text) {

        try {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(
                    new StringBuilder().append(System.getProperty("user.dir")).append("haoxunwang.txt").toString()))) {

                bw.write(text);
                bw.flush();
                System.out.println("content write successfully.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
