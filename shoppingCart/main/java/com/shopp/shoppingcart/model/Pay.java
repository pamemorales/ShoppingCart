package com.shopp.shoppingcart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="pays")
public class Pay {

    @Id
    @GeneratedValue
    int idPay;
    @Column(name="creditName")
    private String name = "";
    @Column(name = "creditNumber")
    private long creditNumber;
    @Column(name="mail")
    private String mail;
    @Column(name="password")
    String pass;
    @Enumerated(EnumType.ORDINAL)
    private TypePay typePay;

    public TypePay getTypePay() {
        return typePay;
    }

    public void setTypePay(TypePay typePay) {
        this.typePay = typePay;
    }

    private Pay() {

    }

    private Pay(String credit_Name, long credit_Number, TypePay CreditCard) {
        this.name = credit_Name;
        this.creditNumber = credit_Number;
        this.typePay = CreditCard;
    }

    private Pay(String mail, String pass, TypePay PayPal) {
        this.mail = mail;
        this.pass = pass;
        this.typePay = PayPal;
    }

    public String getCreditName() {
        return name;
    }

    public void setCreditName(String credit_Name) {
        this.name = credit_Name;
    }

    public long getCreditNumber() {
        return creditNumber;
    }

    public void setCrediNumber(long credit_Number) {
        this.creditNumber = credit_Number;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String pass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + idPay;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Pay other = (Pay) obj;
        if (idPay != other.idPay)
            return false;
        return true;
    }

}
