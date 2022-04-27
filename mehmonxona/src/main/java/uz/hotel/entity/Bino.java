package uz.hotel.entity;

import javax.persistence.*;

@Entity
@Table(name = "bino")
public class Bino {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(unique = true,nullable = false)
    private String nom;
    private String manzil;

    public Bino() {
    }

    public Bino(Long id, String nom, String manzil) {
        this.id = id;
        this.nom = nom;
        this.manzil = manzil;
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

    public String getManzil() {
        return manzil;
    }

    public void setManzil(String manzil) {
        this.manzil = manzil;
    }
}
