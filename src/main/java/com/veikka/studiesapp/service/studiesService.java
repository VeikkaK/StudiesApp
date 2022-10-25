package com.veikka.studiesapp.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.veikka.studiesapp.controller.StudiesRestController;
import com.veikka.studiesapp.data.Studies;
import com.veikka.studiesapp.fileService.StudiesFileService;

@Service
public class studiesService {

    @Autowired
    StudiesFileService FileService; // Autowired annotation is used for automatic dependency injection

    public void SaveData() throws Exception { // Calls the writing method in the file service with error handling in mind
        try {
            FileService.WriteDataToFile(oStudies);
        } catch (Exception e) {
            String errormsg = e.getMessage();
            FileService.WhatWentWrong(errormsg);
        }
    }

    private List<Studies> oStudies = new ArrayList<>(); // Creates a new ArrayList. ArrayList in Java is used to store dynamically sized collection of elements

    public void AddNewInfo(Studies studies) { // Via the PostMapping, this one will handle saving the content
        oStudies.add(studies);
    }

    public void eraseData(Studies studies) { // Clears the list
        oStudies.removeAll(oStudies);
    }

    public List<Studies> ShowEverything() { // Simply shows the list by returning it
        return oStudies;
    }

    // We could do this kind of searching by any attribute. On this Spring application we have 3 options...↓

    public List<Studies> GetInfoByGrade(int grade) { // Finds information depending on a grade number given. Creates list, checks if the number from the data class is the same that the one given as a parameter. If so, it will be added to the found ones list and in the end it will be returned                                  
        List<Studies> foundg = new ArrayList<>();    
        for (Studies g : oStudies) {
            if (g.getgrade() == grade) {
                foundg.add(g);
            }
        }
        return foundg;
    }

    public List<Studies> GetInfoByName(String studentname) { // ... With a name
        List<Studies> founds = new ArrayList<>();
        for(Studies s : oStudies) {
            if(s.getstudentnames().equals(studentname)) {
                founds.add(s);
            }
        }
        return founds;
    }

    public List<Studies> GetInfoByClassRoom(int classroom) { // ... With a classroom number
        List<Studies> foundc = new ArrayList<>();
        for(Studies c : oStudies) {
            if(c.getclassroom() == classroom) {
                foundc.add(c);
            }
        }
        return foundc;
    }
}