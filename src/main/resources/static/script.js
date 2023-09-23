document.addEventListener("DOMContentLoaded", function () {
    // Hacer una solicitud GET a la API y llenar la tabla con los resultados
    fetch("/topico")
        .then(response => response.json())
        .then(data => {
            const apiResultsTable = document.querySelector("#api-results tbody");

            data.forEach(topico => {
                const row = document.createElement("tr");
                row.innerHTML = `
                    <td>${topico.titulo}</td>
                    <td>${topico.autor}</td>
                    <td>${topico.curso}</td>
                    <td>${topico.estatus_topico}</td>
                    <td>${topico.mensaje}</td>
                `;
                apiResultsTable.appendChild(row);
            });
        })
        .catch(error => {
            console.error("Error al obtener datos de la API:", error);
        });
});

