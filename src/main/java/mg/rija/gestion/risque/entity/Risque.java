package mg.rija.gestion.risque.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Entity bean with JPA annotations Hibernate provides JPA implementation.
 * 
 * Liste des user.
 * 
 * @author rija.n.ramampiandra
 * 
 */
@Entity
@Table(name = "RISQUE")
public class Risque implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name="description_risque")
	private String descriptionRisque;

	@NotNull
	@Min(1)
	@Max(5)
	private Integer probabiliter;
	private Integer impact;
	private Integer criticiter;

	@Column(name = "create_date")
	private Date createDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescriptionRisque() {
		return descriptionRisque;
	}

	public void setDescriptionRisque(String descriptionRisque) {
		this.descriptionRisque = descriptionRisque;
	}

	public Integer getProbabiliter() {
		return probabiliter;
	}

	public void setProbabiliter(Integer probabiliter) {
		this.probabiliter = probabiliter;
	}

	public Integer getImpact() {
		return impact;
	}

	public void setImpact(Integer impact) {
		this.impact = impact;
	}

	public Integer getCriticiter() {
		return criticiter;
	}

	public void setCriticiter(Integer criticiter) {
		this.criticiter = criticiter;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

}
