package br.plataforma.eb.Models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import de.huxhorn.sulky.ulid.ULID;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate birthDate;
    @Setter
    @Getter
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;
    @Setter
    @Getter
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateAt;
    @Getter
    @Setter
    private Boolean isActive;

    public  CustomerModel(
            String id,
            String name,
            String surname,
            String email,
            LocalDate birthDate,
            LocalDateTime createdAt,
            LocalDateTime updateAt,
            Boolean isActive
    ){
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.birthDate = birthDate;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
        this.isActive = isActive;
    }

    //#TODO: alterar a anotação para a desserialização para ser feita diretamente nos atributos da classe, ao invés de anotar o construtor.;
    @JsonCreator
    public CustomerModel(
            @JsonProperty("name") String name,
            @JsonProperty("surname") String surname,
            @JsonProperty("email") String email,
            @JsonProperty("birthDate")  LocalDate birthDate
    ){
        this.id = new ULID().nextULID();
        setName(name);
        setSurname(surname);
        setEmail(email);
        setBirthDate(birthDate);
        this.createdAt = LocalDateTime.now();
        this.updateAt = this.createdAt;
        this.isActive = Boolean.TRUE;
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

    public void setBirthDate(LocalDate birthDate){
        int age = Period.between(birthDate, LocalDate.now()).getYears();
        if (age > 18){
            this.birthDate = birthDate;
        }
    }

}