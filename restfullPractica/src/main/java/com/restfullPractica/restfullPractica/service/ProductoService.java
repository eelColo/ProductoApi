package com.restfullPractica.restfullPractica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restfullPractica.restfullPractica.Exception.RequestException;
import com.restfullPractica.restfullPractica.entity.Producto;
import com.restfullPractica.restfullPractica.repository.ProductoRepository;

@Service
public class ProductoService {

	
		@Autowired
		private ProductoRepository prodRep;
		
		
		//Crear producto
		public void createProduct(Producto prod) {

			if(prod.getNombre() == null || prod.getNombre().equals("")) {
				throw new RequestException("P-401","El nombre es requerido");
			} else if(prod.getDescripcion().equals("")) {
				throw new RequestException("P-402","La descricpion es requerida");
			} else if(prod.getCantidad() < 0 ) {
				throw new RequestException("P-403","La cantidad de existencias no puede ser negativa");
			} else if (prod.getPrecio() <= 0) {
				throw new RequestException("P-404","El precio no puede ser menor de 0");
			}
			prodRep.save(prod);
		}
		
		//Eliminar producto por Id
		public void deleteProduct(Integer id) {
			prodRep.deleteById(id);
		}
				
		//Editar producto
		public void editProduct(Integer id, Producto newProd) {
			
			
			if(prodRep.findById(id).isEmpty() ) {
				throw new RequestException("P-404", "No se ha encontrado el producto");
			}		
			if(newProd.getNombre().equals("")) {
				throw new RequestException("P-405","El nombre es requerido para editar");
			}
			if(newProd.getDescripcion().equals("")) {
				throw new RequestException("P-406","La descripcion es requerida para editar");
			}
			if(newProd.getCantidad() <= 0) {
				throw new RequestException("P-407","La cantidad es requerida para editar");
			}
			if(newProd.getPrecio() <= 0) {
				throw new RequestException("P-408","El precio es requerido para editar");
			}
				
			
			Producto producto = prodRep.findById(id).orElseThrow();
			
			producto.setNombre(newProd.getNombre());
			producto.setDescripcion(newProd.getDescripcion());
			producto.setPrecio(newProd.getPrecio());
			producto.setCantidad(newProd.getCantidad());
			
			prodRep.save(producto);
			
		}
		
		//Listar producto por ID
		public Producto findProductById(Integer id) {
			if(prodRep.findById(id).isEmpty()) {
				throw new RequestException("P-404","No se ha encontrado el producto");
			} else { 
				return prodRep.findById(id).orElse(null);
			}
		}
		
		//Consultar todos los productos por precio
		public List<Producto> listProductByPrice() {
			return prodRep.findByOrderByPrecioDesc();
		}
	
	
}
