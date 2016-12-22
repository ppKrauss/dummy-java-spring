package org.springframework.roo.petclinic.domain;
import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import org.springframework.roo.addon.javabean.annotations.RooToString;
import org.springframework.roo.addon.jpa.annotations.entity.RooJpaEntity;
import javax.validation.constraints.Size;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import org.springframework.roo.addon.ws.annotations.jaxb.RooJaxbEntity;

/**
 * = Visit
 *
 * TODO Auto-generated class documentation
 *
 */
@RooJavaBean
@RooToString
@RooJpaEntity(sequenceName = "VISIT_SEQ")
@RooJaxbEntity
public class Visit {

    /**
     * TODO Auto-generated field documentation
     *
     */
    @Size(max = 255)
    private String description;

    /**
     * TODO Auto-generated field documentation
     *
     */
    @NotNull
    @Past
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date visitDate;

    /**
     * TODO Auto-generated field documentation
     *
     */
    @ManyToOne(fetch = FetchType.LAZY)
    private Pet pet;

    /**
     * TODO Auto-generated field documentation
     *
     */
    @ManyToOne(fetch = FetchType.LAZY)
    private Vet vet;
}
