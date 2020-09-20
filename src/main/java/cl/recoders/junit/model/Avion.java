package cl.recoders.junit.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "avion")
@Getter
@Setter
@NoArgsConstructor
public class Avion {
	
	@Id
	@Column(name = "id")
	private Long id;
	
	@Column(name = "codigo", length = 6, nullable = false)
	private String codigo;
	
	@ManyToMany(fetch = FetchType.LAZY,
				cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinTable(name = "vuelo_avion" , 
				joinColumns = @JoinColumn(name = "id_vuelo"),
				inverseJoinColumns = @JoinColumn(name = "id_avion"))
	private Set<Vuelo> vuelos = new HashSet<>();

}
