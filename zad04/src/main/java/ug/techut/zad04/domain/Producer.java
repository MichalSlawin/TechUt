package ug.techut.zad04.domain;

import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name = "producer.all", query = "Select p from Producer p"),
})
public class Producer {
    private Long id;
    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
