package com.shopp.shoppingcart.model;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "sales")
public class Sale {
    @Id
    @GeneratedValue
    @Column(name = "idsale")
    private int idSale;
    @ManyToOne
    @JoinColumn(name = "id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "idPay")
    private Pay pay;
    @OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "sale")
    private Set<LineSale> lines;
	@Column(name="total")
    private double total;
	@Column(name="status")
	private boolean status =false;

   
	public Sale() {

    }

    public Sale(User user, Pay pay, Set<LineSale> lines, double total) {
        this.user = user;
        this.pay = pay;
        this.lines = lines;
        this.total = total;
    }

    public int getIdSale() {
        return idSale;
    }

    public Set<LineSale> getProductSale() {
        return lines;
    }
    public double getTotal(){
    	return total;
    }

    public void setProductSale(Set<LineSale> lines) {
        this.lines = lines;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setPay(Pay pay) {
        this.pay = pay;
    }

    public Pay getPay() {
        return pay;
    }

    public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + idSale;
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
        Sale other = (Sale) obj;
        if (idSale != other.idSale)
            return false;
        return true;
    }
}
