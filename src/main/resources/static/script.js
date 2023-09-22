// script.js
document.addEventListener("DOMContentLoaded", function () {
    // Hacer una solicitud GET a la API
    fetch("/topico")
        .then(response => response.json())
        .then(data => {
            // Procesar los datos y mostrarlos en el div "api-results"
            const apiResults = document.getElementById("api-results");
            data.forEach(topico => {
                const topicoDiv = document.createElement("div");
                topicoDiv.innerHTML = `
                    <h2>${topico.titulo}</h2>
                    <p>Autor: ${topico.autor}</p>
                    <p>Curso: ${topico.curso}</p>
                    <p>Estatus: ${topico.estatus_topico}</p>
                    <p>Mensaje: ${topico.mensaje}</p>
                `;
                apiResults.appendChild(topicoDiv);
            });
        })
        .catch(error => {
            console.error("Error al obtener datos de la API:", error);
        });
});

document.addEventListener("DOMContentLoaded", function () {
    const topicForm = document.getElementById("topic-form");

    topicForm.addEventListener("submit", function (event) {
        event.preventDefault(); // Evita que el formulario se envíe normalmente

        // Obtén los valores del formulario
        const titulo = document.getElementById("titulo").value;
        const autor = document.getElementById("autor").value;
        const curso = document.getElementById("curso").value;
        const estatus = document.getElementById("estatus").value;
        const mensaje = document.getElementById("mensaje").value;

        // Crea un objeto de datos a enviar en la solicitud POST
        const data = {
            titulo: titulo,
            autor: autor,
            curso: curso,
            estatus_topico: estatus,
            mensaje: mensaje
        };

        // Realiza la solicitud POST a la API
        fetch("/topico", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(data)
        })
        .then(response => {
            if (response.status === 201) {
                alert("Tópico registrado con éxito.");
                // Puedes redirigir al usuario a otra página o actualizar la lista de tópicos aquí si lo deseas.
            } else {
                alert("Error al registrar el tópico.");
            }
        })
        .catch(error => {
            console.error("Error en la solicitud POST:", error);
        });
    });
});
