/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sam.sis.websismodule.controller;

import com.sam.sis.teachersubjectmodule.dao.FacultyDAO;
import com.sam.sis.teachersubjectmodule.dao.SubjectDAO;
import com.sam.sis.teachersubjectmodule.entity.Faculty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Sam
 */

@Controller
@RequestMapping(value = "faculty")
public class FacultyController {
    @Autowired
    FacultyDAO facultyDAO;
    @Autowired
    SubjectDAO subjectDAO;
    
    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model){
        model.addAttribute("facultylist", facultyDAO.getAll());
        model.addAttribute("form", new Faculty());
        model.addAttribute("subjects", subjectDAO.getAll());
        return "faculty";
    }
    
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String addFaculty(Model model, @ModelAttribute(value = "form") Faculty faculty
                                            ){
      System.out.println("...fadsfadsfadsafsddfsa:::::" + faculty.getFacultyName());
      
      

      
        facultyDAO.insert(faculty);
        
        
        return "redirect: ";
    }
    
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public String updateFaculty(Model model, @ModelAttribute(value = "form") Faculty faculty
                                            ){
 
        facultyDAO.update(faculty);
        
        
        return "redirect: ";
    }
    
    @RequestMapping(value = "/edit/{id}",method = RequestMethod.GET)
    public String editFaculty(Model model, @PathVariable("id")int id){
        model.addAttribute("facultylist", facultyDAO.getAll());
        model.addAttribute("form", facultyDAO.getbyId(id));
        
        return "faculty";
    }
    
    @RequestMapping(value = "/remove/{id}",method = RequestMethod.GET)
    public String removeFaculty(@PathVariable("id")int id){
       facultyDAO.delete(id);
        return "redirect:/faculty";
    }
}
/*
        Faculty faculty = new Faculty();
        faculty.setFacultyId(4);
        faculty.setFacultyName("Ot");
        
        Faculty subject = new Faculty();
        subject.setFacultyId(3);
        subject.setFacultyName("S2");
        
        Faculty subject2 = new Faculty();
        subject2.setFacultyId(4);
        subject2.setFacultyName("S3");

        
        List<Faculty> subjectlist = new ArrayList<>();
        subjectlist.add(subject);
        subjectlist.add(subject2);
        */
        //faculty.getFacultyList().add(subject);
        //faculty.getFacultyList().add(subject2);
       // faculty.setFacultyList(subjectlist);