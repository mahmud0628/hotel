package uz.hotel.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;
@Entity
@Table(name = "buyurtma")
public class Buyurtma implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @ManyToOne
    private Mijoz mijoz;
    @ManyToOne
    private Xona xona;
    @JsonFormat(pattern = "yyyy-MM-dd  HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd  HH:mm:ss")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime buyurtmaYaratilganVaqt;
    @JsonFormat(pattern = "yyyy-MM-dd  HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd  HH:mm:ss")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime buyurtmaYopilganVaqt;
    @ManyToOne
    private Xodim xodim;
    

    public Buyurtma() {
    }

    public Buyurtma(Long id, Mijoz mijoz, Xona xona,
                    LocalDateTime buyurtmaYaratilganVaqt, 
                    Xodim xodim, LocalDateTime buyurtmaYopilganVaqt) {
        this.id = id;
        this.mijoz = mijoz;
        this.xona = xona;
        this.buyurtmaYaratilganVaqt = buyurtmaYaratilganVaqt;
        this.xodim = xodim;
        this.buyurtmaYopilganVaqt = buyurtmaYopilganVaqt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Mijoz getMijoz() {
        return mijoz;
    }

    public void setMijoz(Mijoz mijoz) {
        this.mijoz = mijoz;
    }

    public Xona getXona() {
        return xona;
    }

    public void setXona(Xona xona) {
        this.xona = xona;
    }

    public LocalDateTime getBuyurtmaYaratilganVaqt() {
        return buyurtmaYaratilganVaqt;
    }

    public void setBuyurtmaYaratilganVaqt(LocalDateTime buyurtmaYaratilganVaqt) {
        this.buyurtmaYaratilganVaqt = buyurtmaYaratilganVaqt;
    }

    public Xodim getXodim() {
        return xodim;
    }

    public void setXodim(Xodim xodim) {
        this.xodim = xodim;
    }

    public LocalDateTime getBuyurtmaYopilganVaqt() {
        return buyurtmaYopilganVaqt;
    }

    public void setBuyurtmaYopilganVaqt(LocalDateTime buyurtmaYopilganVaqt) {
        this.buyurtmaYopilganVaqt = buyurtmaYopilganVaqt;
    }
}
