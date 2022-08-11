var id_definida = 0;

const setIdDefinida = (id) => {
    id_definida = id;
}

const getAllOrdersPendients = async() => {
    const response = await fetch("/orden");
    
    if(response.status === 200){
        const datos = await response.json();

        var ordenes = ``;

        datos.forEach(orden => {
            if(orden.estado === null){
                ordenes += `    
                    <tr>
                        <th scope="row">${orden.id_cabecera_orden}</th>
                        <td>${orden.fk_cliente}</td>
                        <td>${cambiaNombre(orden.estado)}</td>
                        <th scope="col">${orden.fecha_pedido}</th>
            
                        <td>
                            <!-- BUTTON -->
                            <a type="button" class="btn btn-danger" data-bs-toggle="modal"
                                data-bs-target="#exampleModal" onclick="setIdDefinida(${orden.id_cabecera_orden})">
                                <i class="bi bi-x"></i>
                            </a>

                            <a type="button" class="btn btn-success" data-bs-toggle="modal" data-bs-target="#success" onclick="setIdDefinida(${orden.id_cabecera_orden})">
                                <i class="bi bi-check2"></i>
                            </a>
                        </td>
                    </tr>
                `;
            }
            
        });

        document.querySelector("#respuesta").innerHTML = `${ordenes}`;
    }
};


const cancelarOrden = async() => {
    console.log(id_definida);
    const body = JSON.stringify({});

    const options = {
        method: 'PUT',
        body: body,
        headers: {
            'Content-type': 'application/json; charset=UTF-8'
        }
    };
    let response = await fetch(`/orden/update/false/${id_definida}`, options);
    getAllOrdersPendients();
}


const completarOrden = async() => {
    console.log(id_definida);
    const body = JSON.stringify({});

    const options = {
        method: 'PUT',
        body: body,
        headers: {
            'Content-type': 'application/json; charset=UTF-8'
        }
    };
    let response = await fetch(`/orden/update/true/${id_definida}`, options);
    getAllOrdersPendients();
}


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


getAllOrdersPendients();