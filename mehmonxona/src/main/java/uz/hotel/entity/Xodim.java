package uz.hotel.entity;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;
@Entity
@Table(name = "xodim")
public class Xodim implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String ism;
    private String familiya;
    private String jins;
    private Time ishVaqt;
    private String pasportId;
    @ManyToOne
    private Lovozim lovozim;

    public Xodim() {
    }

    public Xodim(Long id, String ism, String familiya, String jins, Time ishVaqt, String pasportId, Lovozim lovozim) {
        this.id = id;
        this.ism = ism;
        this.familiya = familiya;
        this.jins = jins;
        this.ishVaqt = ishVaqt;
        this.pasportId = pasportId;
        this.lovozim = lovozim;
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

    public String getJins() {
        return jins;
    }

    public void setJins(String jins) {
        this.jins = jins;
    }

    public Time getIshVaqt() {
        return ishVaqt;
    }

    public void setIshVaqt(Time ishVaqt) {
        this.ishVaqt = ishVaqt;
    }

    public String getPasportId() {
        return pasportId;
    }

    public void setPasportId(String pasportId) {
        this.pasportId = pasportId;
    }

    public Lovozim getLovozim() {
        return lovozim;
    }

    public void setLovozim(Lovozim lovozim) {
        this.lovozim = lovozim;
    }
}
