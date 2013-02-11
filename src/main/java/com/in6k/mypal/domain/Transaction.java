package com.in6k.mypal.domain;

import javax.persistence.*;

@Table(name = "transactions")
@Entity
public class Transaction {
    @Id
    @Column(name = "id")
    @GeneratedValue
    private int id;

    @Column(name = "debit")
    private String debit;

    @Column(name = "credit")
    private String credit;

    @Column(name = "sum")
    private double sum;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDebit() {
        return debit;
    }

    public void setDebit(String debit) {
        this.debit = debit;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }
}
