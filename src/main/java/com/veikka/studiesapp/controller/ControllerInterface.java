package com.veikka.studiesapp.controller;

import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import com.veikka.studiesapp.data.Studies;

interface ControllerInterface { // Method prototypes for the Rest Controller
    String BeingPolite();

    Studies AddNewInfo(Studies studies) throws Exception;

    String Save() throws Exception;

    List<Studies> ShowEverything();

    List<Studies> GetInfoByGrade(@PathVariable int grade);

    List<Studies> GetInfoByName(@PathVariable String studentname);

    List<Studies> GetInfoByClassRoom(@PathVariable int classroom);

    String delete(Studies studies);
}