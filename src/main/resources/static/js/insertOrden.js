class Producto{
    constructor(cantidad, ingrediente){
        this.cantidad = cantidad;
        this.ingrediente = ingrediente;
    }
}
// listaProductos = [new Producto(1, 1)]


class DetalleOrden{
    constructor(cantidad, base_pizza, comentario, otros = 0, ingredientes){
        this.cantidad = cantidad;
        this.base_pizza = base_pizza;
        this.comentario = comentario;
        this.otros = otros;
        this.ingredientes = ingredientes;
    }
}
// var listaDetalles = [new DetalleOrden(1, 1, "Sin bordes", 0, listaProductos)]


class Orden{
    constructor(nombre, contacto, detallesDeLaOrden){
        this.nombre = nombre;
        this.contacto = contacto;
        this.detallesDeLaOrden = detallesDeLaOrden;
    }
}
// var test = new Orden("Efren", "0997188086", listaDetalles);
// console.log(JSON.stringify(test));


listaProductos = [];
listaDetalleOrden = [];
listaOrden = [];

