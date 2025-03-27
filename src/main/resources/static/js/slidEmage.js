let slideIndex = 1;
let autoSlideInterval; // Variable to store the interval

showSlides(slideIndex);
startAutoSlide(); // Start automatic slideshow

function plusSlides(n) {
    clearAutoSlide(); // Clear auto slide when manually changing
    showSlides(slideIndex += n);
    startAutoSlide(); // Restart auto slide
}

function currentSlide(n) {
    clearAutoSlide(); // Clear auto slide when manually changing
    showSlides(slideIndex = n);
    startAutoSlide(); // Restart auto slide
}

function showSlides(n) {
    let i;
    let slides = document.getElementsByClassName("mySlides");
    let dots = document.getElementsByClassName("dot");

    if (n > slides.length) {
        slideIndex = 1;
    }
    if (n < 1) {
        slideIndex = slides.length;
    }

    for (i = 0; i < slides.length; i++) {
        slides[i].style.display = "none";
    }

    for (i = 0; i < dots.length; i++) {
        dots[i].className = dots[i].className.replace(" active", "");
    }

    slides[slideIndex - 1].style.display = "block";
    dots[slideIndex - 1].className += " active";
}

// Event listeners for arrows
document.querySelector(".prev").addEventListener("click", () => {
    plusSlides(-1);
});

document.querySelector(".next").addEventListener("click", () => {
    plusSlides(1);
});

// Event listeners for dots
let dots = document.getElementsByClassName("dot");
for (let i = 0; i < dots.length; i++) {
    dots[i].addEventListener("click", () => {
        currentSlide(i + 1);
    });
}

// Automatic slide change every 5 seconds
function startAutoSlide() {
    autoSlideInterval = setInterval(() => {
        plusSlides(1);
    }, 5000); // 5000 milliseconds = 5 seconds
}

function clearAutoSlide() {
    clearInterval(autoSlideInterval);
}