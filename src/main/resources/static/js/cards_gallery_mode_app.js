/*Variables*/
const buttonClose = document.querySelector("#button__close");
const buttonGoBack = document.querySelector("#button__go-back");
const buttonKeepItUp = document.querySelector("#button__keep-it-up");
const cardImage = document.querySelectorAll("#gallery_cards img");
const lightbox = document.querySelector("#main-card-container");
const imgActive = document.querySelector("#img-active");
let imageIndex = 0;

/*Abre el Lightbox*/

const openLightbox = (event) => {
    imgActive.src = event.target.src;
    lightbox.style.display = "flex";
    imageIndex = Array.from(imagenes).indexOf(event.target);
};

cardImage.forEach((cardImage) => {
    cardImage.addEventListener("click", openLightbox);
});

/*Cierra el Lightbox*/
function closeLightbox() {
    lightbox.style.display = "none";
}


buttonClose.addEventListener("click", () => {
    closeLightbox();
})

/*Adelanta la imagen*/

const nextImage = () => {
    if (imageIndex === cardImage.length - 1) {
        imageIndex = -1;
    }
    imgActive.src = cardImage[imageIndex + 1].src;
    imageIndex++;
}

buttonKeepItUp.addEventListener("click", nextImage);


/*Retrocede la imagen*/

const previousImage = () => {
    if (imageIndex === 0) {
        imageIndex = cardImage.length;
    }
    imgActive.src = cardImage[imageIndex - 1].src;
    imageIndex--;
};

buttonGoBack.addEventListener("click", previousImage);

// Eventos de teclado

document.addEventListener("keydown", function(event) {
    if (event.key === "ArrowRight") {
        nextImage();
    } else if (event.key === "ArrowLeft") {
        previousImage();
    }
    if (event.key === "Escape") {
        closeLightbox();
    }
});