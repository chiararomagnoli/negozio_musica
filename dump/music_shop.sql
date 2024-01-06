-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Gen 06, 2024 alle 11:49
-- Versione del server: 10.4.28-MariaDB
-- Versione PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `music_shop`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `categorie`
--

CREATE TABLE `categorie` (
  `id_categoria` int(11) NOT NULL,
  `nome_categoria` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `categorie`
--

INSERT INTO `categorie` (`id_categoria`, `nome_categoria`) VALUES
(1, 'chitarre'),
(2, 'tastiere'),
(3, 'archi'),
(4, 'percussioni'),
(5, 'fiati');

-- --------------------------------------------------------

--
-- Struttura della tabella `marche`
--

CREATE TABLE `marche` (
  `id_marca` int(11) NOT NULL,
  `nome_marca` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `marche`
--

INSERT INTO `marche` (`id_marca`, `nome_marca`) VALUES
(1, 'Ekò'),
(2, 'Yamaha'),
(3, 'Proel'),
(4, 'Bontempi'),
(5, 'Carry-On'),
(6, 'Sauter'),
(7, 'Vhienna'),
(8, 'Stentor'),
(9, 'Huadong');

-- --------------------------------------------------------

--
-- Struttura della tabella `prodotti`
--

CREATE TABLE `prodotti` (
  `id_prodotto` int(11) NOT NULL,
  `nome_prodotto` varchar(255) NOT NULL,
  `descrizione` varchar(255) NOT NULL,
  `prezzo` double NOT NULL,
  `disponibilita` int(11) NOT NULL,
  `sconto` double NOT NULL,
  `fk_categoria` int(11) DEFAULT NULL,
  `fk_sottocategoria` int(11) DEFAULT NULL,
  `fk_marca` int(11) DEFAULT NULL,
  `condizione` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `prodotti`
--

INSERT INTO `prodotti` (`id_prodotto`, `nome_prodotto`, `descrizione`, `prezzo`, `disponibilita`, `sconto`, `fk_categoria`, `fk_sottocategoria`, `fk_marca`, `condizione`) VALUES
(1, 'Eko CS-10 Chitarra Classica Ambra Natural', 'CS-10 Natural, tavola, fasce e fondo in Tiglio, Manico e tastiera in Betulla e finitura lucida.\r\nChitarra classica di Eko Guitars della serie Studio dedicata a tutti coloro che intendono avvicinarsi per la prima volta a questo strumento.', 56.6, 12, 0.15, 1, 1, 1, 'Nuovo'),
(2, 'Eko Guitars NXT D Blue Sunburst', 'Se il tuo obiettivo è quello di imparare a suonare la chitarra e sei alla ricerca di uno shape classico,la NXT D è la migliore delle scelte.Una chitarra entry level che ha tutto quello di cui hai bisogno per soddisfare i tuoi occhi e le tue orecchie.', 79.9, 9, 0, 1, 2, 1, 'Nuovo'),
(3, 'Yamaha SG1820A CHITARRA ELETTRICA CON CASE BLACK', 'Hardware nero e parti nere che interrompono il colore monotono del corpo e creano un look moderno. Dotata di pickup EMG (EMG85 sulla parte frontale/EMG81 sulla parte posteriore) che producono un suono ben definito.', 2049.9, 1, 0, 1, 3, 2, 'Usato'),
(4, 'Proel CS-10 Chitarra classica finitura Blue', 'CS-10 Blue Burst, tavola, fasce e fondo in Tiglio, Manico e tastiera in Betulla e finitura lucida, è la chitarra classica di Proel della serie Studio dedicata a tutti coloro che intendono avvicinarsi per la prima volta a questo strumento.', 65, 3, 0, 1, 1, 3, 'Nuovo'),
(5, ' Huadong Kit Batteria Elettronica 7 Pad con Modulo Sonoro e Pelli Mesh', 'Huadong Kit include tutto ciò che ti occorre per iniziare a suonare la batteria: 4 pad con pelli mesh, 3 pad piatto, pedali per cassa e Hi-Hat, lo sgabello, le bacchette, una cuffia e i cavi.', 242, 3, 0, 4, 9, 9, 'Nuovo'),
(6, 'Yamaha YBS480 Sax Baritono Discendente al La Laccato', '-Sax baritono in Mib\r\n-Discendente al La grave\r\n-Chiave del Fa# acuto\r\n-Finitura: ottone laccato\r\n-Campana incisa\r\n-Bocchino e custodia inclusi', 5898, 1, 0, 5, 10, 2, 'Nuovo'),
(7, 'Carry-On BC2301 E11 Clarinetto Piccolo in Mib Ebano', 'Materiale: barilotto, corpo e campana in ebano, tonalità: Mib 442 Hz, chiavi/anelli: 17/6, argentate, completo di astuccio, bocchino, copri-bocchino, legatura, ance e panno pulizia', 1790, 2, 0, 5, 12, 5, 'Usato'),
(8, 'Bontempi 4480 Mini Keyboard', 'Tastiera digitale a 44 tasti, 6 Canzoni preregistrate, 10 Suoni, 8 Ritmi, Tasti selezione suoni, ritmi, Polifonia 8 note, OKON (Funzione di apprendimento), Funzione di registrazione e riascolto, Gestione facilitata degli accordi (Easy chord), Effetti: Sus', 49.9, 10, 0, 2, 5, 4, 'Nuovo'),
(9, 'Yamaha PSRF52 Tastiera Portatile 61 Tasti', 'La PSR-F52 è la tastiera perfetta per chi vuole imparare a suonare. Ha tutte le funzionalità di cui hai bisogno per la tua prima esperienza musicale. La PSR-F52 offre una solida base per chiunque voglia iniziare a suonare la tastiera.', 122, 3, 0, 2, 5, 2, 'Usato'),
(10, 'Carry-On 88 tastiera pieghevole', 'Dispone di altoparlanti integrati, uscita per cuffie, porta di ricarica USB per batteria interna ricaricabile, ingresso per pedale sustain (incluso) e molte altre funzioni e strumenti.\r\nLarghezza tasti standard', 139, 8, 0.2, 2, 5, 5, 'Nuovo'),
(11, 'Sauter Accento Pianoforte verticale by Peter Maly', 'Sauter Pianoforte verticale modello Accento. Design by Peter Maly. Misure\r\nAltezza cm.119 - Larghezza cm.156 - Profondita\' cm.60. Colore nero satinato.\r\nDisponibile anche nei colori nero lucido e bianco. Made in Germany.', 15200, 1, 0, 2, 4, 6, 'Nuovo'),
(12, 'VHIENNA MEISTER VH VOB 4/4 Violino', 'Top: Abete Laminato, Fondo/Fasce: Laminato, Tastiera/Piroli: Ebanizzati, Tendicordiera: In Metallo con 4 mini accordatori, Archetto: Entry level, Colofonia compresa (pece)', 89, 7, 0.1, 3, 6, 7, 'Nuovo'),
(13, 'STENTOR Violino Student 1 3/4 Settato', 'Strumento in acero e abete tutto massello realizzato con legni stagionati naturalmente da almeno tre anni. Piroli e mentoniera in Linden, cordiera in metallo con quattro intonatori incorporati e Corde Dogal R31 e pece Dogal.', 205, 2, 0, 3, 6, 8, 'Usato'),
(14, 'Bruck Cello 3/4 HDC01 Laminato completo di arco e borsa', 'Violoncello HDC01 3/4, completo di archetto, borsa e pece, tavola in abete laminato, cordiera con 4 tiracantini, corde originali con il LA di qualità (sostituito dal liutaio)', 280, 5, 0, 3, 7, 9, 'Nuovo'),
(15, 'VHIENNA MEISTER VH CES12', 'Top: Abete Massello Fondo/Fasce: Acero Laminato Tastiera: Ebanizzata Tendicordiera: Metallo con Mini Accordatori Archetto: Entry level plus, Colofonia Custodia: Blu', 550, 3, 0, 3, 7, 7, 'Usato'),
(16, 'Eko Drums ED-200 Drum kit Metallic Blue - 5 pezzi', 'Batteria ad alte prestazioni per soddisfare le esigenze quotidiane. Lunga durata e affidabilità per dispositivi elettronici. Tecnologia avanzata per una ricarica veloce e sicura. Ideale per garantire la massima autonomia ai tuoi dispositivi.', 223, 4, 0, 4, 8, 1, 'Nuovo'),
(17, 'Stentor JDK516 MR Batteria Junior 5 pezzi Completa', 'La serie JDK516 è la linea di batterie SOUNDSATION dedicata allo studio per i più piccoli.Le dimensioni ridotte favoriscono un miglior posizionamento dei fusti anche per bambini al di sotto dei 120 cm di altezza.', 240, 6, 0.1, 4, 8, 8, 'Nuovo'),
(18, 'Proel CCR3882-GSS-Bb-L Cornetta in Sib Laccata', 'CORNETTA Sib CCR3882-GSS-Bb-L, canneggio mm.11.82 (0.465\'), campana cm.12 (4.724\'), astuccio e bocchino 7C compreso', 599, 5, 0.15, 5, 11, 3, 'Nuovo');

-- --------------------------------------------------------

--
-- Struttura della tabella `sottocategorie`
--

CREATE TABLE `sottocategorie` (
  `id_sottocategoria` int(11) NOT NULL,
  `nome_sottocategoria` varchar(255) NOT NULL,
  `fk_id_categoria` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `sottocategorie`
--

INSERT INTO `sottocategorie` (`id_sottocategoria`, `nome_sottocategoria`, `fk_id_categoria`) VALUES
(1, 'chitarre classiche', 1),
(2, 'chitarre acustiche', 1),
(3, 'chitarre elettriche', 1),
(4, 'pianoforti', 2),
(5, 'tastiere elettriche', 2),
(6, 'violini', 3),
(7, 'violoncelli', 3),
(8, 'batterie acustiche', 4),
(9, 'batterie elettriche', 4),
(10, 'sassofoni', 5),
(11, 'trombe', 5),
(12, 'clarinetti', 5);

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `categorie`
--
ALTER TABLE `categorie`
  ADD PRIMARY KEY (`id_categoria`);

--
-- Indici per le tabelle `marche`
--
ALTER TABLE `marche`
  ADD PRIMARY KEY (`id_marca`);

--
-- Indici per le tabelle `prodotti`
--
ALTER TABLE `prodotti`
  ADD PRIMARY KEY (`id_prodotto`),
  ADD KEY `categoria` (`fk_categoria`),
  ADD KEY `sottocategoria` (`fk_sottocategoria`),
  ADD KEY `marca` (`fk_marca`);

--
-- Indici per le tabelle `sottocategorie`
--
ALTER TABLE `sottocategorie`
  ADD PRIMARY KEY (`id_sottocategoria`),
  ADD KEY `categoria_sottocategoria` (`fk_id_categoria`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `categorie`
--
ALTER TABLE `categorie`
  MODIFY `id_categoria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT per la tabella `marche`
--
ALTER TABLE `marche`
  MODIFY `id_marca` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT per la tabella `prodotti`
--
ALTER TABLE `prodotti`
  MODIFY `id_prodotto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT per la tabella `sottocategorie`
--
ALTER TABLE `sottocategorie`
  MODIFY `id_sottocategoria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `prodotti`
--
ALTER TABLE `prodotti`
  ADD CONSTRAINT `categoria` FOREIGN KEY (`fk_categoria`) REFERENCES `categorie` (`id_categoria`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `marca` FOREIGN KEY (`fk_marca`) REFERENCES `marche` (`id_marca`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `sottocategoria` FOREIGN KEY (`fk_sottocategoria`) REFERENCES `sottocategorie` (`id_sottocategoria`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limiti per la tabella `sottocategorie`
--
ALTER TABLE `sottocategorie`
  ADD CONSTRAINT `categoria_sottocategoria` FOREIGN KEY (`fk_id_categoria`) REFERENCES `categorie` (`id_categoria`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
