const validarDetalleOrden = (cantidad_pizzas, base_pizza, ingredientes, comentario, otros) => {
    let errores = 0;

    if(base_pizza === null) {
        console.log("base")
        errores += 1;
    }
    if(cantidad_pizzas <= 0){
        console.log("cant p")
        errores += 1;
    }
    if(ingredientes.length === 0){
        console.log("ingre")
        errores += 1;
    }
    if(otros === NaN){
        otros = 0;
    }

    if(errores === 0){
        console.log("la pizza pasa")
        return new DetalleOrden(cantidad_pizzas, base_pizza, ingredientes, comentario, otros);
    }else{
        console.log("la pizza no pasa" + errores);
    }
    
}