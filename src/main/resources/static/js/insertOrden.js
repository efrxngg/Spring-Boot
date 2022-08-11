class Producto{
    constructor(cantidad, ingrediente){
        this.cantidad = cantidad;
        this.ingrediente = ingrediente;
    }
}
// listaProductos = [new Producto(1, 1)]


class DetalleOrden{
    constructor(base_pizza, cantidad, ingredientes, comentario, otros){
        this.base_pizza = base_pizza;
        this.cantidad = cantidad;
        this.ingredientes = ingredientes;
        this.comentario = comentario;
        this.otros = otros;
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


const obtenerIngredientes = () => {
    let listaProductos = [];
    let ingredientes = document.getElementsByName("ingredientes");

    ingredientes.forEach((ingrediente) => {
        if(ingrediente.value > 0){
            listaProductos.push(new Producto(parseInt(ingrediente.value), parseInt(ingrediente.id)))
        }
    });

    if(listaProductos.length > 0) 
        return listaProductos;
}




var listaDetalleOrden = [];

const añadirDetallesOrden = () => {
    let cantidad_pizzas = parseInt(document.getElementById("cant-detalle-pizza").value);

    let base_pizza = null;
    let pizzas = document.getElementsByName("pizzas");
    pizzas.forEach((pizza) => {
        if(pizza.checked){
            base_pizza = parseInt(pizza.value);
        }
    });
    let listaIngredientes = obtenerIngredientes();
    let comentario = document.getElementById("comentario").value;
    let otros = parseFloat(document.getElementById("otros").value);
    if(isNaN(otros)) otros = 0.0;

    listaDetalleOrden.push(new DetalleOrden(base_pizza, cantidad_pizzas, listaIngredientes, comentario, otros))
}


const hacerPedido = async() => {
    let nombre = document.getElementById("orden-nombre").value;
    let contacto = document.getElementById("orden-contacto").value;
    let detallesOrden = listaDetalleOrden;

    if(detallesOrden.length === 0){
        añadirDetallesOrden();
    }

    let orden = new Orden(nombre, contacto, detallesOrden);
    console.log(orden);

    // API---
    console.log("Llego");
    const pedido = JSON.stringify(orden);
    console.log(pedido);
    const options = {
        method: 'POST',
        body: pedido,
        headers: {
            'Content-type': 'application/json; charset=UTF-8'
        }
    };

    let response = await fetch("/orden/insertar", options);

    if(response.status === 200){
        alert("La orden se realizo correctamente");
    }

}




