/* 
--------TUTORIAL--------
pones abajo del body script 
    <script src="./js/template.js"></script>
creas un div con la clase .contenedor
    <div class="contenedor"> </div>
*/

// Selecciona los elementos
let tempHeader = document.querySelector('.temp-header');
let contenedor = document.querySelector('.contenedor');
let tempFooter = document.querySelector('.temp-footer');
let head = document.querySelector('head');
let path = document.location.pathname;
let filename = path.split("/").pop().split(".")[0];


// Verifica si el elemento existe
if (!contenedor) {
    contenedor = document.createElement('div');

    contenedor.classList.add('contenedor');

    document.body.prepend(contenedor);
}
// Verifica si el elemento existe
if (!tempHeader) {
    // Crea un nuevo elemento 'header'
    tempHeader = document.createElement('header');
    // Agrega la clase 'temp-header' al nuevo elemento
    tempHeader.classList.add('temp-header');
    // Agrega el nuevo elemento al documento
    contenedor.prepend(tempHeader);
}

// Establece el innerHTML del elemento al código HTML proporcionado
tempHeader.innerHTML = `
<img src="../static/images/logo.png" alt="Logo de Dimentials">    
<h1>Dimentials</h1>
    <nav>
        <ul>
            <li><a href="./index.html">Inicio</a></li>
            <li><a href="./faq.html">FAQ</a></li>
            <li><a href="#">Tienda</a></li>
            <li><a href="#">Contacto</a></li>
            <li><a href="./about.html">Sobre nosotros</a></li>
        </ul>
    </nav>
`;


// Verifica si el elemento existe
if (!tempFooter) {
    // Crea un nuevo elemento 'footer'
    tempFooter = document.createElement('footer');
    // Agrega la clase 'temp-footer' al nuevo elemento
    tempFooter.classList.add('temp-footer');
    // Agrega el nuevo elemento al documento
    contenedor.append(tempFooter);
}

// Establece el innerHTML del elemento al código HTML proporcionado
tempFooter.innerHTML = `

        <img src="../static/images/logo.png">
        <h4>The Dimentials Company</h4>
        <ul class="redes">
            <li><a href="#"><i class="fa-brands fa-instagram"></i> </a></li>
            <li><a href="#"><i class="fa-brands fa-facebook"></i></a></li>
            <li><a href="#"><i class="fa-brands fa-youtube"></i></a></li>
            <li><a href="#"><i class="fa-brands fa-discord"></i></a></li>
            <li><a href="#"><i class="fa-brands fa-twitch"></i> </a></li>
            <li><a href="#"><i class="fa-brands fa-x"></i></a></li>
        </ul>
        <ul class="legal">
            <li><a href="./cookies.html">Política de cookies</a></li>
            <li><a href="./privacy.html">Aviso de privacidad</a></li>
            <li><a href="./terms.html">Condiciones de uso</a></li>
        </ul>
        <p>Dimentials&#169; 2024 es una marca registrada por RómpelHielo&#169;</p>

`;

head.innerHTML = `
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="../static/css/bootstrap.css">
<link rel="stylesheet" href="../static/css/styles.css">
<link rel="stylesheet" href="../static/css/mobile.css">
<link rel="stylesheet" href="../static/css/tablet.css">
<link rel="stylesheet" href="../static/css/desktop.css">
<link rel="stylesheet" href="../static/css/aminations.css">
<link rel="icon" type="image/png" href="../static/images/favicon.png">
<title>${filename}</title>
</head>`



let scriptMain = document.createElement('script');
scriptMain.src = "../static/js/main.js";
document.body.appendChild(scriptMain);

let scriptFontAwesome = document.createElement('script');
scriptFontAwesome.src = "https://kit.fontawesome.com/2508d31af3.js";
scriptFontAwesome.crossOrigin = "anonymous";
document.body.appendChild(scriptFontAwesome);

let scriptBootStrap = document.createElement('script');
scriptBootStrap.src = "../static/js/bootstrap.js";
scriptBootStrap.crossOrigin = "anonymous";
document.body.appendChild(scriptBootStrap);