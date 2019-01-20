package ug.techut.zad04.domain;

import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name = "lock.all", query = "SELECT l FROM Lock l"),
        @NamedQuery(name = "lock.byId", query = "SELECT l FROM Lock l WHERE l.id = :id"),
        @NamedQuery(name = "lock.byElectronic", query = "SELECT l FROM Lock l WHERE l.electronic = :electronic"),
        @NamedQuery(name = "lock.byProducer", query = "SELECT l FROM Lock l WHERE l.producer = :producer")
})
public class Lock {
    private Long id;
    private Producer producer;
    private boolean electronic;

    public Lock() {}

    public Lock(Producer producer, boolean electronic) {
        this.producer = producer;
        this.electronic = electronic;
    }

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
