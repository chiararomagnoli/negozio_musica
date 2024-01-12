// ---- JS HOMEPAGE -----

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

    // Cambia diapositiva ogni 3 secondi 
    setInterval(autoSlide, 3000);
  });

 // ritardo sottomenu 
 document.addEventListener('DOMContentLoaded', function () {
  var navItems = document.querySelectorAll('.navbar-nav .nav-item');

  navItems.forEach(function (navItem) {
    var sottomenu1 = navItem.querySelector('.sottomenu1');
    var timeoutId;

    if (sottomenu1) {
      navItem.addEventListener('mouseenter', function () {
        clearTimeout(timeoutId); // Cancella eventuali timeout precedenti
        sottomenu1.style.display = 'block';
      });

      navItem.addEventListener('mouseleave', function () {
        // Imposta un ritardo prima di chiudere il sottomenu1
        timeoutId = setTimeout(function () {
          sottomenu1.style.display = 'none';
        }, 60); // 60 millisecondi (0.06 secondi)
      });
    }
  });
});

        $('.owl-carousel').owlCarousel({
            margin: 10,
            nav: true,
            navText:["<div class='nav-btn prev-slide'></div>","<div class='nav-btn next-slide'></div>"],
            responsive: {
                0: {
                    items: 1
                },
                600: {
                    items: 3
                },
                1000: {
                    items: 3
                }
            }
        });

// ---- FINE HOMEPAGE -----




