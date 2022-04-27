package uz.hotel.entity;

import javax.persistence.*;

@Entity
@Table(name = "xona")
public class Xona {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(unique = true,nullable = false)
    private String sigim;
    private boolean isLux;
    private int narx;
    private boolean status;
    @ManyToOne
    private Bino bino;

    public Xona() {
    }


    public Xona(Long id, String sigim, boolean isLux, int narx, boolean status, Bino bino) {
        this.id = id;
        this.sigim = sigim;
        this.isLux = isLux;
        this.narx = narx;
        this.status = status;
        this.bino = bino;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSigim() {
        return sigim;
    }

    public void setSigim(String sigim) {
        this.sigim = sigim;
    }

    public boolean isLux() {
        return isLux;
    }

    public void setLux(boolean lux) {
        isLux = lux;
    }

    public int getNarx() {
        return narx;
    }

    public void setNarx(int narx) {
        this.narx = narx;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Bino getBino() {
        return bino;
    }

    public void setBino(Bino bino) {
        this.bino = bino;
    }
}
