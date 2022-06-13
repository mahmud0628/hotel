package uz.hotel.entity;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "tulov")
public class Tulov implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String plastikTulov;
    private String naqdTulov;
    @JsonFormat(pattern = "yyyy-MM-dd  HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd  HH:mm:ss")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime tulovVaqt;
    
    @ManyToOne
    private Buyurtma buyurtma;

    public Tulov() {
    }

    public Tulov(Long id, String plastikTulov, String naqdTulov, LocalDateTime tulovVaqt, Buyurtma buyurtma) {
        this.id = id;
        this.plastikTulov = plastikTulov;
        this.naqdTulov = naqdTulov;
        this.tulovVaqt = tulovVaqt;
        this.buyurtma = buyurtma;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Buyurtma getBuyurtma() {
        return buyurtma;
    }

    public void setBuyurtma(Buyurtma buyurtma) {
        this.buyurtma = buyurtma;
    }

}
