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
    private User debit;

    @Column(name = "credit")
    private User credit;

    @Column(name = "sum")
    private double sum;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getDebit() {
        return debit;
    }

    public void setDebit(User debit) {
        this.debit = debit;
    }

    public User getCredit() {
        return credit;
    }

    public void setCredit(User credit) {
        this.credit = credit;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }
}