/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sam.sis.websismodule.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Sam
 */
@Controller
public class DefaultController {

    @RequestMapping(value = "/")
    public ModelAndView redirectToMainPage() {
        return new ModelAndView("index");
    }
}