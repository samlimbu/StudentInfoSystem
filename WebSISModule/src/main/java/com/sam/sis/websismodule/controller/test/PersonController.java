/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sam.sis.websismodule.controller.test;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Sam
 */
@Controller
@RequestMapping("person")
public class PersonController {
    @RequestMapping(method = RequestMethod.GET)
    public String person(Model model){
        model.addAttribute("personListContainer", getDummyPersonListContainer());
        return"person";
    }
    
    private PersonListContainer getDummyPersonListContainer() {
        List<Person> personList = new ArrayList<Person>();
        for( int i=0; i<5; i++ ) {
            personList.add( new Person("Person Name [" + i + "]", String.valueOf(i)) );
        }
        return new PersonListContainer(personList);
    }
    @RequestMapping(value="/editpersonlistcontainer", method= RequestMethod.POST)
    public String editpersonListContainer(@ModelAttribute PersonListContainer personListContainer, HttpSession session) {
        for( Person p : personListContainer.getPersonList() ) {
            //System.out.println("Name: " + p.getName());
            //System.out.println("Age: " + p.getAge());
        }
        session.setAttribute("personListContainer",personListContainer);
        return "redirect:/?message=Form Submitted Ok. Number of rows is: ["+personListContainer.getPersonList().size()+"]";
    }
}
