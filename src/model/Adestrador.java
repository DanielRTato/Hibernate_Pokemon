package model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "adestrador")
public class Adestrador implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nome", nullable = false, length = 50)
    private String nome;

    @Column(name = "nacemento")
    private LocalDate nacemento;


    public Adestrador() {}

    public Adestrador(String nome, LocalDate nacemento) {
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

    public LocalDate getNacemento() {
        return nacemento;
    }

    public void setNacemento(LocalDate nacemento) {
        this.nacemento = nacemento;
    }

    @Override
    public String toString() {
        return "Adestrador{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", nacemento=" + nacemento +
                '}';
    }
}

