package com.api.assessment.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "role")
public class Role extends SharedModel{
    private Integer roleSeq;
    private String roleName;

    public Role() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_seq")
    public Integer getRoleSeq() {
        return roleSeq;
    }

    public void setRoleSeq(Integer roleSeq) {
        this.roleSeq = roleSeq;
    }

    @Basic
    @Column(name = "role_name", nullable = false, length = 250)
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }


}
