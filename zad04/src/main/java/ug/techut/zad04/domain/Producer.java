package ug.techut.zad04.domain;

import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name = "producer.all", query = "SELECT p FROM Producer p"),
        @NamedQuery(name = "producer.byName", query = "SELECT p FROM Producer p WHERE p.name = :name")
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

    @Column(unique = true, nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
