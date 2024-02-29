// ---- JS HOMEPAGE -----
  
 // scorrimento card automatico
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


// ---- FINE HOMEPAGE -----

// -- LISTA STRUMENTI -----
	// -- sottocategorie --
	
	function selezionaCategoria() {
            const categoriaSelect = document.getElementById('categoria');
            const sottocategoriaSelect = document.getElementById('sottocategoria');

            // Ottieni il valore selezionato nella select della categoria
            const selectedCategoria = categoriaSelect.value;

            // Abilita la select delle sottocategorie
            sottocategoriaSelect.disabled = false;

            // Rimuovi tutte le opzioni attuali nella select delle sottocategorie
            sottocategoriaSelect.innerHTML = '';

            // Aggiungi un'opzione vuota nella select delle sottocategorie
            const emptyOption = document.createElement('option');
            emptyOption.value = '';
            emptyOption.text = '-- Seleziona una sottocategoria --';
            sottocategoriaSelect.appendChild(emptyOption);

            // Simuliamo l'aggiunta di opzioni in base alla categoria selezionata
            // In una situazione reale, dovresti ottenere le opzioni dal server o da qualche altra fonte di dati
            if (selectedCategoria == 1) {
                // Aggiungi opzioni per Categoria 1
                addOptionsForCategoria1();
            } else if (selectedCategoria == 2) {
                // Aggiungi opzioni per Categoria 2
                addOptionsForCategoria2();
            }else if (selectedCategoria == 3) {
                // Aggiungi opzioni per Categoria 2
                addOptionsForCategoria3();
            }else if (selectedCategoria == 4) {
                // Aggiungi opzioni per Categoria 2
                addOptionsForCategoria4();
            }else if (selectedCategoria == 5) {
                // Aggiungi opzioni per Categoria 2
                addOptionsForCategoria5();
            }
            
            // Aggiungi altre clausole 'else if' secondo le tue esigenze
        }

        function addOptionsForCategoria1() {
            const sottocategoriaSelect = document.getElementById('sottocategoria');

            // Simuliamo l'aggiunta di opzioni per Categoria 1
            const option1 = document.createElement('option');
            option1.value = 1;
            option1.text = 'Chitarre classiche';
            sottocategoriaSelect.appendChild(option1);

            const option2 = document.createElement('option');
            option2.value = 2;
            option2.text = 'Chitarre acustiche';
            sottocategoriaSelect.appendChild(option2);

            const option3 = document.createElement('option');
            option3.value = 3;
            option3.text = 'Chitarre elettriche';
            sottocategoriaSelect.appendChild(option3);
        }

        function addOptionsForCategoria2() {
            const sottocategoriaSelect = document.getElementById('sottocategoria');

            // Simuliamo l'aggiunta di opzioni per Categoria 2
            const option4 = document.createElement('option');
            option4.value = 4;
            option4.text = 'Pianoforti';
            sottocategoriaSelect.appendChild(option4);

            const option5 = document.createElement('option');
            option5.value = 5;
            option5.text = 'Tastiere elettriche';
            sottocategoriaSelect.appendChild(option5);
        }
        function addOptionsForCategoria3() {
            const sottocategoriaSelect = document.getElementById('sottocategoria');

            // Simuliamo l'aggiunta di opzioni per Categoria 3
            const option6 = document.createElement('option');
            option6.value = 6;
            option6.text = 'Violini';
            sottocategoriaSelect.appendChild(option6);

            const option7 = document.createElement('option');
            option7.value = 7;
            option7.text = 'Violoncelli';
            sottocategoriaSelect.appendChild(option7);
        }
        function addOptionsForCategoria4() {
            const sottocategoriaSelect = document.getElementById('sottocategoria');

            // Simuliamo l'aggiunta di opzioni per Categoria 4
            const option8 = document.createElement('option');
            option8.value = 8;
            option8.text = 'Batterie acustiche';
            sottocategoriaSelect.appendChild(option8);

            const option9 = document.createElement('option');
            option9.value = 9;
            option9.text = 'Batterie elettriche';
            sottocategoriaSelect.appendChild(option9);
        }
        function addOptionsForCategoria5() {
            const sottocategoriaSelect = document.getElementById('sottocategoria');

            const option10 = document.createElement('option');
            option10.value = 10;
            option10.text = 'Sassofoni';
            sottocategoriaSelect.appendChild(option10); 

            const option11 = document.createElement('option');
            option11.value = 11;
            option11.text = 'Trombe';
            sottocategoriaSelect.appendChild(option11);

            const option12 = document.createElement('option');
            option12.value = 12;
            option12.text = 'Clarinetti';
            sottocategoriaSelect.appendChild(option12);
        }
	// -- fine sottocategoria --


