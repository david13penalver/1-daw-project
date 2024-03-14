let giro = document.querySelectorAll(".pasa .giro img"); // selecciona las imágenes dentro de .giro
let botonGiro = document.querySelectorAll(".girador");
let i = 1;

let alertPrimary = document.querySelector('.alert-primary');
let aceptarCookies = document.querySelector('#aceptar-cookies');
let rechazarCookies = document.querySelector('#rechazar-cookies');

aceptarCookies.addEventListener('click', () => {
    alertPrimary.classList.add('hidden');
});

rechazarCookies.addEventListener('click', () => {
    alertPrimary.classList.add('hidden');
});


botonGiro.forEach((boton) => {
    boton.addEventListener('click', () => {
        giro.forEach((element) => {
            element.classList.add('girando');
            element.src = `./src/carta${i++}.png`; // cambia el src de la imagen
            if (i > 3) i = 1; // resetea i a 1 si es mayor que 3
            setTimeout(() => {
                element.classList.remove('girando');
            }, 1000);
        });
    });
});
setInterval(() => {
    giro.forEach((element) => {
        element.classList.add('girando');
        element.src = `./src/carta${i++}.png`; // cambia el src de la imagen
        if (i > 3) i = 1; // resetea i a 1 si es mayor que 3
    });
}, 2000) // Add this closing curly brace