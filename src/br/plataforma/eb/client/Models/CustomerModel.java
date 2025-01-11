package br.plataforma.eb.client.Models;

import lombok.Getter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

public class CustomerModel {
    @Getter
    private String id;
    @Getter
    private String name;
    @Getter
    private String surname;
    @Getter
    private String email;
    @Getter
    private LocalDateTime birthDate;
    @Getter
    private LocalDateTime createdAt;
    @Getter
    private LocalDateTime updatedAt;

    public  CustomerModel(String id, String name, String surname, String email, LocalDateTime birthDate){
        setId(id);
        setName(name);
        setSurname(surname);
        setEmail(email);
        setBirthDate(birthDate);
        this.createdAt = LocalDateTime.now();
        this.updatedAt = this.createdAt;
    }

    public void setId(String id) {
        if(id != null && !id.isEmpty()) {
            this.id = id;
        }
    }

    public void setName(String name){
        if(name != null && !name.isEmpty()) {
            this.name = name;
        }
    }

    public void setSurname(String surname){
        if(surname != null && !surname.isEmpty()){
            this.surname = surname;
        }
    }

    public void setEmail(String email){
        if(email != null && !email.isEmpty()){
            this.email = email;
        }
    }

    public void setBirthDate(LocalDateTime birthdate){
        int age = Period.between(birthdate.toLocalDate(), LocalDate.now()).getYears();
        if (age > 18) {
            this.birthDate = birthdate;
        }
    }
}
