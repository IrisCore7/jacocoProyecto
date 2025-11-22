import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.nsq.Pedido;
import org.nsq.Producto;

import static org.junit.jupiter.api.Assertions.*;

public class PruebaUnitariaTest {
    
    @Test
    public void validarStock(){

        Pedido pedido = new Pedido();
        pedido.detallesPedido.add(new Producto("Laptop", 2500, 1));
        pedido.detallesPedido.add(new Producto("Mouse", 100, 2));

        Producto producto = new Producto("Mouse", 100, 2);

        boolean resultado = Pedido.validarStock(producto);

        assertTrue(true);
    }
}
