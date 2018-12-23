/**
 * Copyright (c) 2018 jiuchou. All rights reserved worldwise.
 */
package com.jiuchou.demo.file_jiuchou;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ReadAndWrite {
    public static void saveFile(String filename, String content) {
        try {
            FileWriter fileWriter = new FileWriter(filename, true);
            fileWriter.write(content);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String filename = "D:\\jiuchou_ReadAndWrite";
        String content = "test";
        saveFile(filename, content);
    }
}
