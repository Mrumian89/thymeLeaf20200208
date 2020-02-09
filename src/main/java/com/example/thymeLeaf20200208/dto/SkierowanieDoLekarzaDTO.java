package com.example.thymeLeaf20200208.dto;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

public class SkierowanieDoLekarzaDTO {


    @Id
    @GeneratedValue
    @Column
    int id;

    @Column(nullable = false)
    String lekarz;

    @Column(nullable = false)
    String pacjent;


    Date termin;

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
