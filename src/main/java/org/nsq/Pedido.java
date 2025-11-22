package org.nsq;

import java.util.List;

public class Pedido {

    public List<Producto> detallesPedido;

    public boolean agregarProducto(Producto producto, int cantidad) {
        
        if (cantidad <= 0) {

            System.err.println("Error: La cantidad a agregar debe ser positiva.");

            return false;

        }

        // Busca si el producto ya existe en la lista

        boolean productoYaExiste = detallesPedido.stream()

                .anyMatch(p -> p.getNombre().equals(producto.getNombre()));

        if (productoYaExiste) {

            return false; // Falla porque ya existe

        } else {

            // Creamos una nueva instancia con la cantidad especificada y la añadimos a la
            // lista detallesPedido.add(new Producto(producto.getNombre(),
            // producto.getPrecio(), cantidad)); return true;

        }

        return productoYaExiste;

    }

    public boolean validarStock(Producto producto) {
        for (Producto p : detallesPedido) {

            if (p.equals(producto) && p.getCantidad() <= 0) {
                return false;
            }

        }

        return true;

    }

    public boolean existeStock(Producto producto){
        if(producto.getCantidad() >= 0){
            return true;
        }

        return false;
    }

    public double calcularTotalPedido(List<Producto> productos, double descuento) {
        if (productos == null || productos.isEmpty()) {
            throw new IllegalArgumentException("Error: no hay productos en el pedido");
        }

        double subtotal = productos.stream()
                .mapToDouble(p -> p.getPrecio() * p.getCantidad())
                .sum();
        if (subtotal <= 0) {
            throw new IllegalArgumentException("Error: monto inválido");
        }
        return subtotal - (subtotal * (descuento / 100));
    }
}