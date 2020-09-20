package cl.recoders.junit.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ciudad")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Ciudad {
	
	@Id
	@Column(name = "id")
	private Long id;
	
	@Column(name = "codigo", length = 3, nullable = false, unique = true)
	private String codigo;
	
	@Column(name = "nombre", length = 30, nullable = false)
	private String nombre;
	
	@Column(name = "pais", length = 30, nullable = false)
	private String pais;
	
	@OneToMany(mappedBy = "origen", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Vuelo> vuelosOrigen = new HashSet<>();
	
	@OneToMany(mappedBy = "destino", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Vuelo> vuelosDestino = new HashSet<>();

}
