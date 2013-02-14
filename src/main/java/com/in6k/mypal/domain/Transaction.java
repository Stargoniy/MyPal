package com.in6k.mypal.domain;

import javax.persistence.*;

@Entity
@Table(name = "transactions")
public class Transaction {
    private int id;
    private User debit;
    private User credit;
    private double sum;

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "debit_id")
    public User getDebit() {
        return debit;
    }

    public void setDebit(User debit) {
        this.debit = debit;
    }

    @ManyToOne
    @JoinColumn(name = "credit_id")
    public User getCredit() {
        return credit;
    }

    public void setCredit(User credit) {
        this.credit = credit;
    }

    @Column(name = "sum")
    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }
}
