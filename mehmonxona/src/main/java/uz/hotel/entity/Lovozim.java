package uz.hotel.entity;

import javax.persistence.*;

@Entity
@Table(name = "lavozim")

public class Lovozim {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 30,unique = true,nullable = false)
    private String nom;

    public Lovozim() {
    }

    public Lovozim(Long id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
