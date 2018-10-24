package ug.tech_ut.zad02.domain;

import java.util.Date;

public class Door {
    private long id;
    private String producer;
    private Date productionDate;
    private boolean isExterior;
    private double weight;

    public Door() {}

    public Door(String producer, Date productionDate, boolean isExterior, double weight) {
        this.producer = producer;
        this.productionDate = productionDate;
        this.isExterior = isExterior;
        this.weight = weight;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public Date getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    public boolean isExterior() {
        return isExterior;
    }

    public void setExterior(boolean exterior) {
        isExterior = exterior;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
