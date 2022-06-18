package pe.edu.galaxy.training.java.ms.sc.ventas.msventasgestionproductos.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "cliente")
public class ClienteEntity implements Serializable{
		  
	private static final long serialVersionUID = -2170897015344177815L;

		@Id
	  	@Column(name = "ID_CLIENTE")
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
	  
	  	@NotNull(message = "Nombre del producto es requerido")
	  	@Size(min = 5, max = 120, message = "El nombre.....")
	  	@Column(name = "RAZON_SOCIAL")
	  	private String razonSocial;
	  	
	  	@Column(name = "RUC")
	  	private String ruc;

	  	@Column(name = "DIRECCION")
	  	private String direccion;

	  	@Column(name = "TELEFONO")
	  	private String telefono;
	  	
	  	@Column(name = "CORREO")
	  	private String correo;
	  	

	  	@Column(name = "ESTADO")
	  	private String estado;

}
