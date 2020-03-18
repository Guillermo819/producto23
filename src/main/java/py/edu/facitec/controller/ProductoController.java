package py.edu.facitec.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import py.edu.facitec.model.Producto;
import py.edu.facitec.repository.ProductoRepository;

@RestController
@RequestMapping("/producto")
public class ProductoController {
	@Autowired
	private ProductoRepository productoRepository;
	@DeleteMapping("/eliminar/{codigo}")
	public void eliminarProducto(@PathVariable Long codigo) {
		productoRepository.deleteById(codigo);
		System.out.println("URL/producto/eliminar/3");
	}
	@GetMapping
	 public List<Producto> getProducto(){
		 System.out.println("Listando elementos java a json");
		 
		 return productoRepository.findAll();
		 
	 }
	@GetMapping ("/{codigo}")
	//cargar la url de arriba al codigo
	public Optional<Producto> getSuscrito(@PathVariable Long codigo){
		System.out.println("recuperANDO un elemento java a json");
		Optional<Producto> retorno=productoRepository.findById(codigo);
		return retorno;
	}
	@PostMapping
	public Producto guardar(@RequestBody Producto producto){
		System.out.println("convercion de json a java");
		Producto retorno=
		productoRepository.save(producto);
		return retorno;
	}
}
