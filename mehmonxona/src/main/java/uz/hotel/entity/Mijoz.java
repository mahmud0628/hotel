package uz.hotel.entity;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "mijoz")

public class Mijoz implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(length = 50,nullable = false)
    private String ism;
    @Column(length = 50,nullable = false)
    private String familiya;
    @Column(length = 10,nullable = false,unique = true)
    private String pasportId;
    @Column(length = 20,nullable = false)
    private String jins;
    @Column(length = 30,nullable = false)
    private String millati;

    public Mijoz() {
    }

    public Mijoz(Long id, String ism, String familiya, String pasportId, String jins, String millati) {
        this.id = id;
        this.ism = ism;
        this.familiya = familiya;
        this.pasportId=pasportId;
        this.jins = jins;
        this.millati = millati;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsm() {
        return ism;
    }

    public void setIsm(String ism) {
        this.ism = ism;
    }

    public String getFamiliya() {
        return familiya;
    }

    public void setFamiliya(String familiya) {
        this.familiya = familiya;
    }

    public String getPasportId() {
        return pasportId;
    }

    public void setPasportId(String pasportId) {
        this.pasportId = pasportId;
    }

    public String getJins() {
        return jins;
    }

    public void setJins(String jins) {
        this.jins = jins;
    }

    public String getMillati() {
        return millati;
    }

    public void setMillati(String millati) {
        this.millati = millati;
    }
}


