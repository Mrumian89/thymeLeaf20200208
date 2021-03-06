package com.example.thymeLeaf20200208.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PositiveOrZero;
import java.util.Date;

@Entity
@Table(name = "skierowania")
public class SkierowanieDoLekarza {

    @Id
    @GeneratedValue
    @Column
    int id;

    @NotEmpty
    @Column(nullable = false)
    String lekarz;

    @NotEmpty
    @Column(nullable = false)
    String pacjent;

    @FutureOrPresent
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date termin;


    public SkierowanieDoLekarza(int id, String lekarz, String pacjent, Date termin) {
        this.id = id;
        this.lekarz = lekarz;
        this.pacjent = pacjent;
        this.termin = termin;
    }

    public SkierowanieDoLekarza() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLekarz() {
        return lekarz;
    }

    public void setLekarz(String lekarz) {
        this.lekarz = lekarz;
    }

    public String getPacjent() {
        return pacjent;
    }

    public void setPacjent(String pacjent) {
        this.pacjent = pacjent;
    }

    public Date getTermin() {
        return termin;
    }

    public void setTermin(Date termin) {
        this.termin = termin;
    }
}
