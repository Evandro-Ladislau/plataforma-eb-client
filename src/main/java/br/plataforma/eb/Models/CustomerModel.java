package br.plataforma.eb.Models;

import lombok.Getter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import de.huxhorn.sulky.ulid.ULID;

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
    private LocalDateTime updateAt;
    @Getter
    private Boolean isActive;

    public CustomerModel(String name, String surname, String email, LocalDateTime birthDate){
        this.id = generateULID();
        setName(name);
        setSurname(surname);
        setEmail(email);
        setBirthDate(birthDate);
        this.createdAt = LocalDateTime.now();
        this.updateAt = this.createdAt;
        this.isActive = Boolean.TRUE;
    }

    private String generateULID() {
        ULID ulid = new ULID();
        return ulid.nextULID();
    }
    public void setName(String name){
        if(name != null && !name.isEmpty()){
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

    public void setBirthDate(LocalDateTime birthDate){
        int age = Period.between(birthDate.toLocalDate(), LocalDate.now()).getYears();
        if (age > 18){
            this.birthDate = birthDate;
        }
    }
}
