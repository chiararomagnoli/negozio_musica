

  document.addEventListener("DOMContentLoaded", function () {
    const slider = document.querySelector('.slider');
    let currentIndex = 0;
    const totalSlides = document.querySelectorAll('.card').length;

    function showSlide(index) {
      const slideWidth = document.querySelector('.card').offsetWidth;
      const newPosition = -index * slideWidth;
      slider.style.transform = 'translateX(' + newPosition + 'px)';
    }

    function nextSlide() {
      currentIndex = (currentIndex + 1) % totalSlides;
      showSlide(currentIndex);
    }

    function prevSlide() {
      currentIndex = (currentIndex - 1 + totalSlides) % totalSlides;
      showSlide(currentIndex);
    }

    // Gestione eventi per scorrimento
    document.querySelector('.slider-container .prev').addEventListener('click', prevSlide);
    document.querySelector('.slider-container .next').addEventListener('click', nextSlide);

    // Automatic sliding (opzionale)
    function autoSlide() {
      nextSlide();
    }

    // Cambia diapositiva ogni 3 secondi (regola secondo necessità)
    setInterval(autoSlide, 3000);
  });


