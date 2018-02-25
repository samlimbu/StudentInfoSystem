/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sam.sis.websismodule.controller;

import com.sam.sis.teachersubjectmodule.dao.LevelDAO;
import com.sam.sis.teachersubjectmodule.dao.SubjectDAO;
import com.sam.sis.teachersubjectmodule.entity.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
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
@RequestMapping(value = "subject")
public class SubjectController {
    @Autowired
    SubjectDAO subjectDAO;
    @Autowired
    LevelDAO levelDAO;
    
    
    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model){
        model.addAttribute("form", new Subject());
        model.addAttribute("subjects", subjectDAO.getAll());
        model.addAttribute("levels", levelDAO.getAll());
        return "subject";
    }
    
    @RequestMapping(value="/add", method = RequestMethod.POST)
    public String addSubject(@ModelAttribute("form") Subject subject){
        subjectDAO.insert(subject);
        return "redirect:"; //
    }
     @RequestMapping(value="/edit/{id}", method = RequestMethod.GET)
    public String editSubject(Model model,@PathVariable("id") int id){
        model.addAttribute("form", subjectDAO.getbyId(id));
        model.addAttribute("subjects", subjectDAO.getAll());
        model.addAttribute("levels", levelDAO.getAll());
        return "subject";
    }
    
    @RequestMapping(value="/update", method = RequestMethod.POST)
    public String updateSubject(@ModelAttribute("form") Subject subject){
        subjectDAO.update(subject);
        return "redirect:";
    }
    
    @RequestMapping(value="/remove/{id}", method = RequestMethod.GET)
    public String loadRemoveSubject(Model model,@PathVariable("id") int id){
        subjectDAO.getbyId(id);
        model.addAttribute("subject", subjectDAO.getbyId(id));
        return "subject_remove";
    }
    @RequestMapping(value="/removeyes/{id}", method = RequestMethod.GET)
    public String removeSubject(@PathVariable("id") int id){
        subjectDAO.delete(id);
        return "redirect:";
    }
    
}
    
    

