package com.sample.hibernate.entity.onetomany;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cust")
public class Cust {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cid")
    private Integer id;

    @Column(name="name")
    private String name;

    @Column(name="sal")
    private String sal;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "cust_id")
    List<Account> accounts;

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSal() {
        return sal;
    }

    public void setSal(String sal) {
        this.sal = sal;
    }
}
