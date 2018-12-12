package ug.techut.zad04.domain;

import javax.persistence.*;

@Entity
public class Lock {
    private Long id;
    private Producer producer;
    private boolean electronic;

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

    public boolean isElectronic() {
        return electronic;
    }

    public void setElectronic(boolean electronic) {
        this.electronic = electronic;
    }
}
