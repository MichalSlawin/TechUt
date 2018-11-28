package ug.techut.zad02.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@NamedQueries({
        @NamedQuery(name = "door.all", query = "Select d from Door d"),
})
public class Door {
    private Long id;
    private Producer producer;
    private Date productionDate;
    private boolean isExterior;
    private double weight;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public Date getProductionDate() {
        return productionDate;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", producer='" + producer + '\'' +
                ", productionDate=" + productionDate +
                ", isExterior=" + isExterior +
                ", weight=" + weight;
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
