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
@Table(name = "xodim")
public class Xodim implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String ism;
    private String familiya;
    private String jins;
    @JsonFormat(pattern = "yyyy-MM-dd  HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd  HH:mm:ss")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime boshVaqt;
    @JsonFormat(pattern = "yyyy-MM-dd  HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd  HH:mm:ss")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime tugashVaqt;
    private String pasportId;
    
    public Xodim() {
    }

    public Xodim(Long id, String ism, String familiya, String jins, LocalDateTime boshVaqt, LocalDateTime tugashVaqt,
            String pasportId) {
        this.id = id;
        this.ism = ism;
        this.familiya = familiya;
        this.jins = jins;
        this.boshVaqt = boshVaqt;
        this.tugashVaqt = tugashVaqt;
        this.pasportId = pasportId;
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

    public LocalDateTime getBoshVaqt() {
        return boshVaqt;
    }

    public void setBoshVaqt(LocalDateTime boshVaqt) {
        this.boshVaqt = boshVaqt;
    }

    public LocalDateTime getTugashVaqt() {
        return tugashVaqt;
    }

    public void setTugashVaqt(LocalDateTime tugashVaqt) {
        this.tugashVaqt = tugashVaqt;
    }

    public String getPasportId() {
        return pasportId;
    }

    public void setPasportId(String pasportId) {
        this.pasportId = pasportId;
    }
    

    

    
}
