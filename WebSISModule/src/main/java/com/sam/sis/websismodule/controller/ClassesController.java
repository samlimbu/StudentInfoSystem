/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sam.sis.websismodule.controller;

import com.sam.sis.teachersubjectmodule.dao.ClassesDAO;
import com.sam.sis.teachersubjectmodule.entity.Classes;
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
@RequestMapping(value="classes")
public class ClassesController {
    @Autowired
    ClassesDAO classesDAO;
    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model){
        model.addAttribute("classes", classesDAO.getAll());
        model.addAttribute("form", new Classes());
        return"classes";
    }
    
    @RequestMapping(value="/add",method = RequestMethod.POST)
    public String addClasses(@ModelAttribute ("form")Classes classes){
        classesDAO.insert(classes);
        return"redirect:";
    }
    
    
    @RequestMapping(value="/remove/{id}",method = RequestMethod.GET)
    public String removeClasses(@PathVariable("id")int id){
        classesDAO.delete(id);
        return"redirect:/classes";
    }
}
