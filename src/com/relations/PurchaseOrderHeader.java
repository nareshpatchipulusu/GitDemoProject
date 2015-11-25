package com.relations;
// Generated Nov 24, 2015 10:01:10 AM by Hibernate Tools 4.3.1

import java.math.BigDecimal;
import java.util.Date;

/**
 * PurchaseOrderHeader generated by hbm2java
 */
public class PurchaseOrderHeader implements java.io.Serializable {

    private int poheaderId;
    private String ponumber;
    private Date podate;
    private BigDecimal orderValue;
    private PurchaseOrderDetail purchaseOrderDetail;

    public PurchaseOrderHeader() {
    }

    public PurchaseOrderHeader(int poheaderId, String ponumber, Date podate, BigDecimal orderValue) {
       
        this.ponumber = ponumber;
        this.podate = podate;
        this.orderValue = orderValue;
    }

    public PurchaseOrderHeader(int poheaderId, String ponumber, Date podate, BigDecimal orderValue, PurchaseOrderDetail purchaseOrderDetail) {
        this.poheaderId = poheaderId;
        this.ponumber = ponumber;
        this.podate = podate;
        this.orderValue = orderValue;
        this.purchaseOrderDetail = purchaseOrderDetail;
    }
    
    public PurchaseOrderHeader(String ponumber, Date podate, BigDecimal orderValue, PurchaseOrderDetail purchaseOrderDetail) {
        this.ponumber = ponumber;
        this.podate = podate;
        this.orderValue = orderValue;
        this.purchaseOrderDetail = purchaseOrderDetail;
    }

    public int getPoheaderId() {
        return this.poheaderId;
    }

    public void setPoheaderId(int poheaderId) {
        this.poheaderId = poheaderId;
    }

    public String getPonumber() {
        return this.ponumber;
    }

    public void setPonumber(String ponumber) {
        this.ponumber = ponumber;
    }

    public Date getPodate() {
        return this.podate;
    }

    public void setPodate(Date podate) {
        this.podate = podate;
    }

    public BigDecimal getOrderValue() {
        return this.orderValue;
    }

    public void setOrderValue(BigDecimal orderValue) {
        this.orderValue = orderValue;
    }

    public PurchaseOrderDetail getPurchaseOrderDetail() {
        return this.purchaseOrderDetail;
    }

    public void setPurchaseOrderDetail(PurchaseOrderDetail purchaseOrderDetail) {
        this.purchaseOrderDetail = purchaseOrderDetail;
    }

}