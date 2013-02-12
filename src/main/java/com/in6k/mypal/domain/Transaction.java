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
    @ManyToOne
    private User debit;

    @Column(name = "credit")
    @ManyToOne
    private User credit;

    @Column(name = "sum")
    private double sum;

    @Column(name = "desription")
    private String desription;

    public String getDesription() {
        return desription;
    }

    public void setDesription(String desription) {
        this.desription = desription;
    }

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
