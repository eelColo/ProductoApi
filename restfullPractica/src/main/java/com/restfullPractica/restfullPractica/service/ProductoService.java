package com.restfullPractica.restfullPractica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restfullPractica.restfullPractica.entity.Producto;
import com.restfullPractica.restfullPractica.repository.ProductoRepository;

@Service
public class ProductoService {

	
		@Autowired
		private ProductoRepository prodRep;
		
		
		//Crear producto
		public void createProduct(Producto prod) {

			if(prod.getNombre() == null || prod.getNombre().equals("")) {
				throw new RuntimeException("El nombre es requerido");
			} else if(prod.getDescripcion().equals("")) {
				throw new RuntimeException("La descricpion es requerida");
			} else if(prod.getCantidad() < 0 ) {
				throw new RuntimeException("La cantidad de existencias no puede ser negativa");
			} else if (prod.getPrecio() <= 0) {
				throw new RuntimeException("El precio no puede ser menor de 0");
			}
			prodRep.save(prod);
		}
		
		//Eliminar producto por Id
		public void deleteProduct(Integer id) {
			prodRep.deleteById(id);
		}
				
		//Editar producto
		public void editProduct(Integer id, Producto newProd) {
			
			Producto producto = prodRep.findById(id).orElseThrow();
			
			producto.setNombre(newProd.getNombre());
			producto.setDescripcion(newProd.getDescripcion());
			producto.setPrecio(newProd.getPrecio());
			producto.setCantidad(newProd.getCantidad());
			
			prodRep.save(producto);
			
		}
		
		//Listar producto por ID
		public Producto findProductById(Integer id) {
			return prodRep.findById(id).orElse(null);
		}
		
		//Consultar todos los productos por precio
		public List<Producto> listProductByPrice() {
			return prodRep.findByOrderByPrecioDesc();
		}
	
	
}
