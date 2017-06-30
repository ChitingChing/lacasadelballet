package Pojos;
// Generated 29-jun-2017 18:26:17 by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Curso generated by hbm2java
 */
@Entity
@Table(name="curso"
    ,schema="public"
)
public class Curso  implements java.io.Serializable {


     private int id;
     private Tipocurso tipocurso;
     private Date fechainicio;
     private Date fechafin;
     private BigDecimal nummeses;
     private BigDecimal valormatricularef;
     private BigDecimal valormensualidadref;
     private Character estado;
     private Set matriculas = new HashSet(0);

    public Curso() {
    }

	
    public Curso(int id, Tipocurso tipocurso) {
        this.id = id;
        this.tipocurso = tipocurso;
    }
    public Curso(int id, Tipocurso tipocurso, Date fechainicio, Date fechafin, BigDecimal nummeses, BigDecimal valormatricularef, BigDecimal valormensualidadref, Character estado, Set matriculas) {
       this.id = id;
       this.tipocurso = tipocurso;
       this.fechainicio = fechainicio;
       this.fechafin = fechafin;
       this.nummeses = nummeses;
       this.valormatricularef = valormatricularef;
       this.valormensualidadref = valormensualidadref;
       this.estado = estado;
       this.matriculas = matriculas;
    }
   
     @Id 

    
    @Column(name="id", unique=true, nullable=false)
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idtipocurso", nullable=false)
    public Tipocurso getTipocurso() {
        return this.tipocurso;
    }
    
    public void setTipocurso(Tipocurso tipocurso) {
        this.tipocurso = tipocurso;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="fechainicio", length=13)
    public Date getFechainicio() {
        return this.fechainicio;
    }
    
    public void setFechainicio(Date fechainicio) {
        this.fechainicio = fechainicio;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="fechafin", length=13)
    public Date getFechafin() {
        return this.fechafin;
    }
    
    public void setFechafin(Date fechafin) {
        this.fechafin = fechafin;
    }

    
    @Column(name="nummeses", precision=3, scale=1)
    public BigDecimal getNummeses() {
        return this.nummeses;
    }
    
    public void setNummeses(BigDecimal nummeses) {
        this.nummeses = nummeses;
    }

    
    @Column(name="valormatricularef", precision=4)
    public BigDecimal getValormatricularef() {
        return this.valormatricularef;
    }
    
    public void setValormatricularef(BigDecimal valormatricularef) {
        this.valormatricularef = valormatricularef;
    }

    
    @Column(name="valormensualidadref", precision=4)
    public BigDecimal getValormensualidadref() {
        return this.valormensualidadref;
    }
    
    public void setValormensualidadref(BigDecimal valormensualidadref) {
        this.valormensualidadref = valormensualidadref;
    }

    
    @Column(name="estado", length=1)
    public Character getEstado() {
        return this.estado;
    }
    
    public void setEstado(Character estado) {
        this.estado = estado;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="curso")
    public Set getMatriculas() {
        return this.matriculas;
    }
    
    public void setMatriculas(Set matriculas) {
        this.matriculas = matriculas;
    }




}

