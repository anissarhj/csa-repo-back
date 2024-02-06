package net.anissa.csajava.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "qualificatif")
public class Qualificatif {
    @Id
    @Column(name = "id_qualificatif", nullable = false)
    private Integer id;

    @Column(name = "maximal", nullable = false, length = 16)
    private String maximal;

    @Column(name = "minimal", nullable = false, length = 16)
    private String minimal;

}