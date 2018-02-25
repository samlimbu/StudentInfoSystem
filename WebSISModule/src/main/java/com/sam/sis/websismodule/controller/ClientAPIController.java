/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sam.sis.websismodule.controller;

import com.sam.sis.teachersubjectmodule.dao.FacultyDAO;
import com.sam.sis.teachersubjectmodule.entity.Faculty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Sam
 */
@RestController
@RequestMapping(value="/api")
public class ClientAPIController {
    @Autowired
    FacultyDAO facultyDAO;
    
    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity index(){
        return ResponseEntity.ok(facultyDAO.getAll());
    }
}
