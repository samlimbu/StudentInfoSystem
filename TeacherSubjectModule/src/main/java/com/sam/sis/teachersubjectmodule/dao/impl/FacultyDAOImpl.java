/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sam.sis.teachersubjectmodule.dao.impl;

import com.sam.sis.genericmodule.dao.impl.GenericDAOImpl;
import com.sam.sis.teachersubjectmodule.dao.FacultyDAO;
import com.sam.sis.teachersubjectmodule.entity.Faculty;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Sam
 */
@Repository
@Transactional
public class FacultyDAOImpl extends GenericDAOImpl<Faculty> implements FacultyDAO<Faculty>{
    
}
