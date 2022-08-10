class Orden{
    constructor(nombre, contacto, detallesDeLaOrden){
        this.nombre = nombre;
        this.contacto = contacto;
        this.detallesDeLaOrden = detallesDeLaOrden;
    }
}



var test = new Orden("Efren", "0997188086", []);
console.log(JSON.stringify(test));