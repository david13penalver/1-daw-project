let giro = document.querySelectorAll(".pasa .giro img"); // selecciona las imágenes dentro de .giro
let botonGiro = document.querySelectorAll(".girador");
let i = 1;

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