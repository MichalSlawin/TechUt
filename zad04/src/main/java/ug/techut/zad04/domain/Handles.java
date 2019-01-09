package ug.techut.zad04.domain;

import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name = "handles.all", query = "SELECT h FROM Handles h"),
        @NamedQuery(name = "handles.byId", query = "SELECT h FROM Handles h WHERE h.id = :id")
})
public class Handles {
    private Long id;
    private Producer producer;
    private String shape;

    public Handles() {}

    public Handles(Producer producer, String shape) {
        this.producer = producer;
        this.shape = shape;
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

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }
}
