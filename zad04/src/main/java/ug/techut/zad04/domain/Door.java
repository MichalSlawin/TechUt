package ug.techut.zad04.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name = "door.all", query = "Select d from Door d"),
})
public class Door {
    private Long id;
    private Producer producer;
    private List<Lock> locks;
    private Handles handles;
    private List<Insurance> insurances;
    private Date productionDate;
    private boolean exterior;
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

    @OneToMany
    public List<Lock> getLock() {
        return locks;
    }

    public void setLock(List<Lock> locks) {
        this.locks = locks;
    }

    @OneToOne
    public Handles getHandles() {
        return handles;
    }

    public void setHandles(Handles handles) {
        this.handles = handles;
    }

    @ManyToMany
    public List<Insurance> getInsurance() {
        return insurances;
    }

    public void setInsurance(List<Insurance> insurances) {
        this.insurances = insurances;
    }

    @Temporal(TemporalType.DATE)
    public Date getProductionDate() {
        return productionDate;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", producer='" + producer + '\'' +
                ", productionDate=" + productionDate +
                ", exterior=" + exterior +
                ", weight=" + weight;
    }

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    public boolean isExterior() {
        return exterior;
    }

    public void setExterior(boolean exterior) {
        this.exterior = exterior;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
