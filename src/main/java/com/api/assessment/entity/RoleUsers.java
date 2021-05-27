package com.api.assessment.entity;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;

//@Entity
//@Table(name = "role_users")
//@EntityListeners(AuditingEntityListener.class)
public class RoleUsers extends SharedModel{
    private Integer roleUsersSeq;
    private Integer rolesRoleSeq;
    private Integer usersUserSeq;
    private User user;
    private Role role;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_users_seq", nullable = false, precision = 0)
    public Integer getRoleUsersSeq() {
        return roleUsersSeq;
    }

    public void setRoleUsersSeq(Integer roleUsersSeq) {
        this.roleUsersSeq = roleUsersSeq;
    }

    @Basic
    @Column(name = "roles_role_seq", nullable = false, length = 50)
    public Integer getRolesRoleSeq() {
        return rolesRoleSeq;
    }

    public void setRolesRoleSeq(Integer rolesRoleSeq) {
        this.rolesRoleSeq = rolesRoleSeq;
    }

    @Basic
    @Column(name = "users_user_seq", nullable = false, length = 50)
    public Integer getUsersUserSeq() {
        return usersUserSeq;
    }

    public void setUsersUserSeq(Integer usersUserSeq) {
        this.usersUserSeq = usersUserSeq;
    }

    @OneToOne
    @JoinColumn(name = "users_user_seq", insertable = false, updatable = false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    @OneToOne
    @JoinColumn(name = "roles_role_seq", insertable = false, updatable = false)
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
