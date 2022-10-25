package com.veikka.studiesapp.fileService;

import java.util.List;
import java.util.*;
import org.springframework.stereotype.Service;
import com.veikka.studiesapp.data.Studies;
import java.io.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.FileInputStream;
import java.io.InputStream;

@Service
public class StudiesFileService {

    public void WriteDataToFile(List<Studies> studies) throws Exception {
        File f = new File("c:/data");
        f.mkdir();
        f = new File(f.getAbsolutePath() + "/data.txt");
        f.createNewFile();
        // The folder and file has been created
        PrintStream write = new PrintStream(f);
        for (Studies std : studies) {
            write.println("Student/Students: " + std.getstudentnames());
            write.println("Course: " + std.getcourse());
            write.println("Teacher: " + std.getteacher());
            write.println("Grade: " + std.getgrade());
            write.println("Classroom: " + std.getclassroom() + "\n");
        }
        // The content has been written to the file
        write.flush();
        write.close();
        // The writer is closed - let's print some facts next!
        LetsPrintTheFileInfo();
        LetsReadTheFile();
    }

    public void LetsReadTheFile() throws Exception {
        byte[] array = new byte[2000];
        try {
            InputStream input = new FileInputStream("C:\\data\\data.txt");
            System.out.println("\nAvailable bytes in the file: " + input.available());
            // Read byte from the input stream
            input.read(array);
            System.out.println("\nData read from the file:\n");
            // Convert byte array into string
            String data = new String(array);
            System.out.println(data);
            // Close the input stream
            input.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public void LetsPrintTheFileInfo() {
        File file = new File("C:\\data\\data.txt");
        if (file.exists()) {
            // Everything essential
            System.out.println("---------------------\n");
            System.out.println("File name: " + file.getName());
            System.out.println("Path: " + file.getAbsolutePath());
            System.out.println("Is directory? " + file.isDirectory());
            System.out.println("Write access? " + file.canWrite());
        }
    }

    public void WhatWentWrong(String errormsg) throws Exception {
        File f2 = new File("c:/data");
        f2.mkdir();
        f2 = new File(f2.getAbsolutePath() + "/failure.txt");
        f2.createNewFile();
        // The folder and file has been created
        FileWriter fw2 = new FileWriter(f2, true);
        fw2.write(errormsg + System.lineSeparator());
        // The error message has been written to the file
        fw2.flush();
        fw2.close();
        // The writer is closed
        System.out.println("A cause of failure has been generated into folder -> C:/data/failure.txt");
    }
}