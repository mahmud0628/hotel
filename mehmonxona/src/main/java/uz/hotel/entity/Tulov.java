package uz.hotel.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "tulov")
public class Tulov implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Buyurtma buyurtma;
    private String plastikTulov;
    private String naqdTulov;
    private LocalDateTime tulovVaqt;

    public Tulov() {
    }

    public Tulov(Long id, Buyurtma buyurtma, String plastikTulov, String naqdTulov, LocalDateTime tulovVaqt) {
        this.id = id;
        this.buyurtma = buyurtma;
        this.plastikTulov = plastikTulov;
        this.naqdTulov = naqdTulov;
        this.tulovVaqt = tulovVaqt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Buyurtma getBuyurtma() {
        return buyurtma;
    }

    public void setBuyurtma(Buyurtma buyurtma) {
        this.buyurtma = buyurtma;
    }

    public String getPlastikTulov() {
        return plastikTulov;
    }

    public void setPlastikTulov(String plastikTulov) {
        this.plastikTulov = plastikTulov;
    }

    public String getNaqdTulov() {
        return naqdTulov;
    }

    public void setNaqdTulov(String naqdTulov) {
        this.naqdTulov = naqdTulov;
    }

    public LocalDateTime getTulovVaqt() {
        return tulovVaqt;
    }

    public void setTulovVaqt(LocalDateTime tulovVaqt) {
        this.tulovVaqt = tulovVaqt;
    }
}
