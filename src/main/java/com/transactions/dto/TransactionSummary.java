package com.transactions.dto;

/**
 * Created by Bartosz Piśkiewicz on 14.04.2017.
 */
public class TransactionSummary {

    private String currency;
    private double price;
    private String type;
    private double commision;
    private double toChargeValue;
    private double settlementValue;

    public TransactionSummary(String currency, double price, String type, double commision, double toChargeValue, double settlementValue) {
        this.currency = currency;
        this.price = price;
        this.type = type;
        this.commision = commision;
        this.toChargeValue = toChargeValue;
        this.settlementValue = settlementValue;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getCommision() {
        return commision;
    }

    public void setCommision(double commision) {
        this.commision = commision;
    }

    public double getToChargeValue() {
        return toChargeValue;
    }

    public void setToChargeValue(double toChargeValue) {
        this.toChargeValue = toChargeValue;
    }

    public double getSettlementValue() {
        return settlementValue;
    }

    public void setSettlementValue(double settlementValue) {
        this.settlementValue = settlementValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TransactionSummary that = (TransactionSummary) o;

        if (Double.compare(that.price, price) != 0) return false;
        if (Double.compare(that.commision, commision) != 0) return false;
        if (Double.compare(that.toChargeValue, toChargeValue) != 0) return false;
        if (Double.compare(that.settlementValue, settlementValue) != 0) return false;
        if (currency != null ? !currency.equals(that.currency) : that.currency != null) return false;
        return type != null ? type.equals(that.type) : that.type == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = currency != null ? currency.hashCode() : 0;
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (type != null ? type.hashCode() : 0);
        temp = Double.doubleToLongBits(commision);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(toChargeValue);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(settlementValue);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
