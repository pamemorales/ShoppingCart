package com.shopp.shoppingcart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name = "linesales", uniqueConstraints = { @UniqueConstraint(columnNames = { "idsale", "idproduct" }) })
public class LineSale {
    @Id
    @GeneratedValue
    @Column(name="idline")
    private Integer id;

    @Column(name = "quantity")
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "idproduct")
    @ForeignKey(name = "FK_idproduct")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "idsale")
    @ForeignKey(name = "FK_idsale")
    private Sale sale;
    @Transient
    private double totalLineSale;

    public LineSale() {

    }

    public LineSale(Sale sale, Product product, int quantity) {
        this.sale = sale;
        this.quantity = quantity;
        this.product = product;
        totalLineSale = quantity * product.getPrice();

    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }

    public double getTotalLineSale() {
        return totalLineSale;
    }

    public void setTotalLineSale(double totalLineSale) {
        this.totalLineSale = totalLineSale;
    }

}
