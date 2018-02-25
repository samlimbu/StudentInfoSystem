/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sam.sis.websismodule.wrapper;

import com.sam.sis.teachersubjectmodule.entity.Subject;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sam
 */
public class SubjectList {
    List<Subject> subjects = new ArrayList<>();
  
    
    public SubjectList() {
    }

    public SubjectList(List<Subject> subjectList) {
        this.subjects= subjectList;
    }

    public List<Subject> getSubjectList() {
        return subjects;
    }

    public void setSubjectList(List<Subject> subjectList) {
        this.subjects = subjectList;
    }

  
}
