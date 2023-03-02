
package acme.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.PastOrPresent;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.datatypes.Mark;
import acme.framework.data.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class AuditingRecords extends AbstractEntity {

	protected static final long	serialVersionUID	= 1L;

	@NotBlank
	@Length(max = 75)
	protected String			subject;

	@NotBlank
	@Length(max = 100)
	protected String			assessment;

	@Temporal(value = TemporalType.TIMESTAMP)
	@Past
	@NotNull
	protected Date				auditedPeriodBegin;

	@Temporal(value = TemporalType.TIMESTAMP)
	@PastOrPresent
	@NotNull
	protected Date				auditedPreriodFinish;

	@NotBlank
	protected Mark				mark;

	@URL
	protected String			link;

	@ManyToOne(optional = false)
	protected Audit				audit;
}
