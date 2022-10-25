package com.veikka.studiesapp.controller;

import java.util.List;
import java.util.Map;
import javax.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.servlet.mvc.condition.ParamsRequestCondition;
import com.veikka.studiesapp.data.Studies;
import com.veikka.studiesapp.service.studiesService;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class StudiesRestController implements ControllerInterface {

    @Autowired
    studiesService pStudiesService; // Autowired annotation is used for automatic dependency injection

    @GetMapping
    public String BeingPolite() { // Welcoming
        return "HELLO AND WELCOME!!";
    }

    /*
     * Just a little template for adding stuff, a year grade will be added automatically
     * POST http://localhost:8080/AddNewInfo
    {
      "studentnames":"xx,yy,zz",
      "course": "a",
      "teacher": "b",
      "classroom": "123"
    }
     */

    @PostMapping("AddNewInfo") // Add a new school class of students, course etc...
    public Studies AddNewInfo(@RequestBody Studies studies) {
        pStudiesService.AddNewInfo(studies);
        return studies;
    }

    @PostMapping("Save") // With this you can write and save the content to text file -> C:/data/data.txt
    public String Save() throws Exception {
        pStudiesService.SaveData();
        return "See the terminal below! If it looks a bit narrow/something missing, just hit 'Send' for second time...";
    }

    @GetMapping("ShowEverything") // Shows everything added
    public List<Studies> ShowEverything() {
        return pStudiesService.ShowEverything();
    }

    @DeleteMapping("Erase") // In case you want to, you can manually erase all data
    public String delete(Studies studies) {
        pStudiesService.eraseData(studies);
        return "Your content has been deleted!";
    }

    @GetMapping("/{grade}")
    public List<Studies> GetInfoByGrade(@PathVariable int grade) { // Finds information depending on a grade number given
        return pStudiesService.GetInfoByGrade(grade);
    }

    @GetMapping("/studies/{studentname}")
    public List<Studies> GetInfoByName(@PathVariable String studentname) { // Same but with a name
        return pStudiesService.GetInfoByName(studentname);
    }

    @GetMapping("/school/{classroom}")
    public List<Studies> GetInfoByClassRoom(@PathVariable int classroom) { // With a classroom number
        return pStudiesService.GetInfoByClassRoom(classroom);
    }
}