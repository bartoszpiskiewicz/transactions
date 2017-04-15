package com.transactions.entities;

/**
 * Created by Bartosz Piśkiewicz on 14.04.2017.
 */
public class Transaction {

    private long id;
    private String type;
    private double price;
    private double commision;
    private String currency;
    private boolean paid;

    private Transaction(Builder builder) {
        id = builder.id;
        type = builder.type;
        price = builder.price;
        commision = builder.commision;
        currency = builder.currency;
        paid = builder.paid;
    }

    public long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public double getCommision() {
        return commision;
    }

    public String getCurrency() {
        return currency;
    }

    public boolean isPaid() {
        return paid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Transaction that = (Transaction) o;
        if (id != that.id) return false;
        if (Double.compare(that.price, price) != 0) return false;
        if (Double.compare(that.commision, commision) != 0) return false;
        if (paid != that.paid) return false;
        if (!type.equals(that.type)) return false;
        return currency.equals(that.currency);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (id ^ (id >>> 32));
        result = 31 * result + type.hashCode();
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(commision);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + currency.hashCode();
        result = 31 * result + (paid ? 1 : 0);
        return result;
    }

    public static class Builder{
        private long id;
        private String type;
        private double price;
        private double commision;
        private String currency;
        private boolean paid;

        public Builder id(long id) {
            this.id = id;
            return this;
        }

        public Builder type(String type) {
            this.type = type;
            return this;
        }

        public Builder price(double price) {
            this.price = price;
            return this;
        }

        public Builder commision(double commision) {
            this.commision = commision;
            return this;
        }

        public Builder currency(String currency) {
            this.currency = currency;
            return this;
        }

        public Builder paid(boolean paid) {
            this.paid = paid;
            return this;
        }

        public Transaction build() {
            return new Transaction(this);
        }
    }
}
