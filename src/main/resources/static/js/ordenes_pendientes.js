const URL_BASE = "";

const getAllOrdersPendients = async() => {
    const response = await fetch("/orden");
    
    if(response.status === 200){
        const datos = await response.json();
        console.log(datos);

        var ordenes = ``;

        datos.forEach(orden => {

            ordenes += `
            <tr>
                <th scope="row">${orden.id_cabecera_orden}</th>
                <td>${orden.fk_cliente}</td>
                <td>${orden.fecha_pedido}</td>
                <td>${orden.fecha_entrega}</td>
                <td>${orden.estado}</td>
            </tr>
            `;
        });

        document.querySelector("#respuesta").innerHTML = `${ordenes}`;
    }
};

getAllOrdersPendients();

// alert("Hola")