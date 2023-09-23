document.addEventListener("DOMContentLoaded", function () {
    const topicForm = document.getElementById("topic-form");

    topicForm.addEventListener("submit", function (event) {
        event.preventDefault(); // Evita que el formulario se envíe normalmente

        // Obtén los valores de los campos del formulario
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
            estatus_tpc: estatus,
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
                // Puedes redirigir al usuario a otra página o restablecer el formulario aquí si lo deseas.
            } else {
                alert("Error al registrar el tópico.");
            }
        })
        .catch(error => {
            console.error("Error en la solicitud POST:", error);
        });
    });
});
