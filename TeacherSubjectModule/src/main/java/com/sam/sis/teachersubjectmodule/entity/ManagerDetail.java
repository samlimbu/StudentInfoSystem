/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sam.sis.teachersubjectmodule.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Sam
 */
@Entity
@Table(name = "manager_details")
@NamedQueries({
    @NamedQuery(name = "ManagerDetail.findAll", query = "SELECT m FROM ManagerDetail m")})
public class ManagerDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "manager_detail_id")
    private Integer managerDetailId;
    @Column(name = "department")
    private String department;
    @JoinColumn(name = "manager_id", referencedColumnName = "manager_id")
    @ManyToOne
    private Manager managerId;

    public ManagerDetail() {
    }

    public ManagerDetail(Integer managerDetailId) {
        this.managerDetailId = managerDetailId;
    }

    public Integer getManagerDetailId() {
        return managerDetailId;
    }

    public void setManagerDetailId(Integer managerDetailId) {
        this.managerDetailId = managerDetailId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Manager getManagerId() {
        return managerId;
    }

    public void setManagerId(Manager managerId) {
        this.managerId = managerId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (managerDetailId != null ? managerDetailId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ManagerDetail)) {
            return false;
        }
        ManagerDetail other = (ManagerDetail) object;
        if ((this.managerDetailId == null && other.managerDetailId != null) || (this.managerDetailId != null && !this.managerDetailId.equals(other.managerDetailId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sam.sis.teachersubjectmodule.entity.ManagerDetail[ managerDetailId=" + managerDetailId + " ]";
    }
    
}
