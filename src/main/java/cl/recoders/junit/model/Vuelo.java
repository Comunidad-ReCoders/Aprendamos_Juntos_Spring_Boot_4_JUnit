package cl.recoders.junit.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "vuelo")
@Getter
@Setter
@NoArgsConstructor
public class Vuelo {
	
	@Id
	@Column(name = "id")
	private Long id;
	
	@Column(name = "codigo", length = 6, nullable = false)
	private String codigo;
	
	@ManyToOne(optional = false, 
				fetch = FetchType.EAGER, 
				cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "ciudad_origen")
	private Ciudad origen;
	
	@ManyToOne(optional = false, 
				fetch = FetchType.EAGER, 
				cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "ciudad_destino")
	private Ciudad destino;
	
	@ManyToMany(mappedBy = "vuelos",
				fetch = FetchType.LAZY,
				cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	private Set<Avion> aviones = new HashSet<>();

}
