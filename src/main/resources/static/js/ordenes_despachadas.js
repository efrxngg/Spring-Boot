const cambiaNombre = (estado) => {
    
    switch(estado){
        case null:
            return "Pendiente";
        case false:
            return "Cancelado";
        case true:
            return "Despachado"
        }
}


const getAllOrdersSuccess = async() => {
    const response = await fetch("/orden");
    
    if(response.status === 200){
        const datos = await response.json();

        var ordenes = ``;

        datos.forEach(orden => {
            if(orden.estado === true){
                ordenes += `    
                    <tr>
                        <th scope="row">${orden.id_cabecera_orden}</th>
                        <td>${orden.fk_cliente}</td>
                        <td>${cambiaNombre(orden.estado)}</td>
                        <th scope="col">${orden.fecha_pedido}</th>
                        <th scope="col">${orden.fecha_entrega}</th>                        
                    </tr>
                `;
            }
            
        });

        document.querySelector("#respuesta").innerHTML = `${ordenes}`;
    }
};

getAllOrdersSuccess();