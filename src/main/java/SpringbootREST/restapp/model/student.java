package SpringbootREST.restapp.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Table(name = "student")
@Data
@Entity

public class student implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false,name = "name")
    private String name;

    @Column(name = "phone")
    private String phone;

    public student() {

    }


    @Override
    public String toString() {
        return "student [id=" + id + ", name=" + name + ", phone=" + phone + "]";
    }

    public student( String name, String phone) {

        this.name = name;
        this.phone = phone;
       }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}