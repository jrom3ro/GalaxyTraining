package pe.edu.galaxy.training.java.ms.sc.ventas.msventasgestionproductos.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;
import pe.edu.galaxy.training.java.ms.sc.ventas.msventasgestionproductos.dto.ClienteDTO;
import pe.edu.galaxy.training.java.ms.sc.ventas.msventasgestionproductos.service.ClienteService;
import static pe.edu.galaxy.training.java.ms.sc.ventas.msventasgestionproductos.commons.GlobalConstants.API_ClIENTE;
import static pe.edu.galaxy.training.java.ms.sc.ventas.msventasgestionproductos.commons.GlobalConstants.COD_MSG_EXITO;
import static pe.edu.galaxy.training.java.ms.sc.ventas.msventasgestionproductos.commons.GlobalConstants.MSG_CONSULTA_EXITO;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(API_ClIENTE)
public class ClienteREST {

	private ClienteService productoService;

	public ClienteREST(ClienteService productoService) {
		super();
		this.productoService = productoService;
	}

	@GetMapping
	public ResponseEntity<Response>  findByLike(){
		try {
			List<ClienteDTO> lstClienteDTO= this.productoService.findByLike(null);
			if (lstClienteDTO.isEmpty()) {
				return ResponseEntity.noContent().build();
			}
			return ResponseEntity.ok(
					Response
					.builder()
					.message(Message.builder().code(COD_MSG_EXITO).message(MSG_CONSULTA_EXITO).build())
					.data(lstClienteDTO)
					.build());
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			return ResponseEntity.internalServerError().build();
		}
	}
	
	@PostMapping
	public ResponseEntity<Response>  save(@RequestBody ClienteDTO clienteDTO){
		try {
			ClienteDTO rClienteDTO=  this.productoService.save(clienteDTO);
			 
			if (rClienteDTO==null) {
				return ResponseEntity.noContent().build();
			}
			return ResponseEntity.ok(
					Response
					.builder()
					.message(Message.builder().code(COD_MSG_EXITO).message(MSG_CONSULTA_EXITO).build())
					.data(rClienteDTO)
					.build());
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			return ResponseEntity.internalServerError().build();
		}
	}


}
