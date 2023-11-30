package com.restfullPractica.restfullPractica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restfullPractica.restfullPractica.entity.Producto;
import com.restfullPractica.restfullPractica.service.ProductoService;

@RestController
public class MainController {
	
	@Autowired
	ProductoService prodServ;
	
	
	//Crear producto
	@PostMapping("/producto")
	public void createProduct(@RequestBody Producto prod) {
		prodServ.createProduct(prod);
	}
	
	//Eliminar producto
	@DeleteMapping("/producto/{id}")
	public void deleteProduct(@PathVariable(value= "id") int idProd) {
		prodServ.deleteProduct(idProd);
	}
	
	//Editar
	@PutMapping("/producto/{id}")
	public void editProduct(@PathVariable(value = "id") int idProd, @RequestBody Producto producto) {
		
		
		
		prodServ.editProduct(idProd, producto);
		
	}
	
	//Listar producto por id
	@GetMapping("/producto/{id}")
	public Producto listProductById(@PathVariable(value = "id") int idProd) {
		return prodServ.findProductById(idProd);
		
	}
	
	//Listar todos los productos por precio
	@GetMapping("/productoporprecio")
	public List<Producto> listProductByPrice(){
		return prodServ.listProductByPrice();
	}
	
}
