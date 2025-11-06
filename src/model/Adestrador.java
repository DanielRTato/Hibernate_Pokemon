package model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "adestrador")
public class Adestrador {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false, length = 50)
    private String nome;

    @Column(name = "nacemento")
    @Temporal(TemporalType.DATE)
    private Date nacemento;


    public Adestrador() {}

    public Adestrador(String nome, Date nacemento) {
        this.nome = nome;
        this.nacemento = nacemento;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getNacemento() {
        return nacemento;
    }

    public void setNacemento(Date nacemento) {
        this.nacemento = nacemento;
    }
}
