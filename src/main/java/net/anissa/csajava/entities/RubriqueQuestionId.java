package net.anissa.csajava.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class RubriqueQuestionId implements Serializable {
    private static final long serialVersionUID = 979162056814078014L;
    @Column(name = "id_rubrique", nullable = false)
    private Integer idRubrique;

    @Column(name = "id_question", nullable = false)
    private Integer idQuestion;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        RubriqueQuestionId entity = (RubriqueQuestionId) o;
        return Objects.equals(this.idRubrique, entity.idRubrique) &&
                Objects.equals(this.idQuestion, entity.idQuestion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRubrique, idQuestion);
    }

}