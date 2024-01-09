-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Gen 09, 2024 alle 11:11
-- Versione del server: 10.1.38-MariaDB
-- Versione PHP: 5.6.40

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

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
  `descrizione` varchar(1000) NOT NULL,
  `prezzo` double NOT NULL,
  `disponibilita` int(11) NOT NULL,
  `sconto` double NOT NULL,
  `fk_categoria` int(11) DEFAULT NULL,
  `fk_sottocategoria` int(11) DEFAULT NULL,
  `fk_marca` int(11) DEFAULT NULL,
  `condizione` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `prodotti`
--

INSERT INTO `prodotti` (`id_prodotto`, `nome_prodotto`, `descrizione`, `prezzo`, `disponibilita`, `sconto`, `fk_categoria`, `fk_sottocategoria`, `fk_marca`, `condizione`) VALUES
(1, 'Eko CS-10 Chitarra Classica Ambra Natural', 'CS-10 Natural, tavola, fasce e fondo in Tiglio, Manico e tastiera in Betulla e finitura lucida,\r\nChitarra classica di Eko Guitars della serie Studio dedicata a tutti coloro che intendono avvicinarsi per la prima volta a questo strumento. La chitarra CS-10 di Eko Guitars è il mezzo, con un\'ottimo rapporto qualità/prezzo, che agevola le prime fasi di apprendimento.\\n\\n\r\n\r\nRosetta: Eko Design\\n Materiale Rosetta: Decal\\n\r\nTasti liberi: 12\\n\r\nLarghezza Capotasto: 52 mm\\n\r\nTastiera: Betulla\\n\r\nMeccaniche: Meccaniche Aperte\\n\r\nCorde consigliate: Medium Tension', 56.6, 12, 0.15, 1, 1, 1, 'Nuovo'),
(2, 'Eko Guitars NXT D Blue Sunburst Chitarra', 'Se il tuo obiettivo è quello di imparare a suonare la chitarra e sei alla ricerca di uno shape classico come il Dreadnought, la NXT D è la migliore delle scelte. Una chitarra entry level che ha tutto quello di cui hai bisogno per soddisfare i tuoi occhi e le tue orecchie. La finitura lucida, il design della paletta e del ponte, le forme morbide e arrotondate, i dot sulla tastiera di differenti dimensioni e il logo X al dodicesimo tasto per un look elegante, attraente e dal gusto tutto italiano: dettagli di valore per una chitarra entry level.\r\n\\n\\n\r\nForma corpo: Dreadnought\\n\r\nTavola: Agathis\\n\r\nFasce e fondo: Agathis\\n\r\nLegno manico: Mogano\\n\r\nTastiera: Palissandro', 79.9, 9, 0, 1, 2, 1, 'Nuovo'),
(3, 'Yamaha SG1820A Chitarra elettrica con case black', 'Hardware nero e parti nere che interrompono il colore monotono del corpo e creano un look moderno. Dotata di pickup EMG (EMG85 sulla parte frontale/EMG81 sulla parte posteriore) che producono un suono ben definito.\\n\\n\r\n\r\nCostruzione: Set neck\\n\r\nBody: Acero/Mogano\\n\r\nFinitura: Poliuretano lucido\\n\r\nManico: mogano 3 pezzi\\n\r\nFinitura: Poliuretano lucido\\n\r\nCapotasto: GraphTech TUSQ\\n\r\nTastiera: Palissandro ', 2049.9, 1, 0, 1, 3, 2, 'Usato'),
(4, 'Proel CS-10 Chitarra classica finitura Blue', 'CS-10 Blue Burst, tavola, fasce e fondo in Tiglio, Manico e tastiera in Betulla e finitura lucida, è la chitarra classica di Eko Guitars della serie Studio dedicata a tutti coloro che intendono avvicinarsi per la prima volta a questo strumento. La chitarra CS-10 di Eko Guitars è il mezzo, con un\'ottimo rapporto qualità/prezzo, che agevola le prime fasi di apprendimento.\\n\\n\r\nForma Corpo: Classic\\nTop: Tiglio\\nFasce: Tiglio\\nFondo: Tiglio\\nRosetta: Eko Design\\nManico: Betulla\\nTastiera: Betulla', 65, 3, 0, 1, 1, 3, 'Nuovo'),
(5, 'Huadong Kit Batteria Elettronica 7 Pad con Modulo Sonoro e Pelli Mesh', 'Huadong Kit include tutto ciò che ti occorre per iniziare a suonare la batteria: 4 pad con pelli mesh, 3 pad piatto, pedali per cassa e Hi-Hat, lo sgabello, le bacchette, una cuffia e i cavi.\\n\\n\r\n\r\n4 Pad da 6\" con pelli mesh: Rullante e 3 tom\\n\r\n3 Pad piatto da 10\"\\n\r\nPedali per Cassa e Hi-Hat\\n\r\nRack in metallo\\n\r\nModulo sonoro DM-Lite con 10 kit e 120 suoni\\n\r\n30 Pattern e 12 \"follow me\"\\n\r\nPolifonia massima: 64\\n\r\nMetronomo regolabile dai 30 ai 280bpm\\n\r\nDisplay LED 3 caratteri', 242, 3, 0, 4, 9, 9, 'Nuovo'),
(6, 'Yamaha YBS480 Sassofono Baritono Discendente al La Laccato', 'Il sax baritono discendente Yamaha YBS480 rappresenta un\'eccellenza nel mondo degli strumenti a fiato. Caratterizzato da una costruzione di alta qualità, il corpo laccato in la ottimizza la risposta e la facilità di suonabilità. Le chiavi ergonomiche consentono una rapida e precisa esecuzione, mentre il meccanismo di ottava regala una transizione fluida tra le note. Il suono ricco e potente del sax baritono Yamaha YBS480 offre una gamma dinamica eccezionale, adatto a diversi generi musicali. Ideale per musicisti professionisti e studenti avanzati, questo strumento offre una combinazione perfetta di artigianato superiore e prestazioni straordinarie. Con il suo design elegante e la qualità sonora inconfondibile, il Yamaha YBS480 è una scelta eccellente per coloro che cercano un sax baritono di livello superiore.\\n\\n\r\n\r\nSax baritono in Mib, discendente al La grave, chiave del Fa# acuto\\nFinitura: ottone laccato\\n\r\nCampana incisa\\n\r\nBocchino e custodia inclusi', 5898, 1, 0, 5, 10, 2, 'Nuovo'),
(7, 'Carry-On BC2301 E11 Clarinetto Piccolo in Mib Ebano', 'Il clarinetto in Mib Buffet BC2301 E11 è un\'eccellenza nel mondo degli strumenti a fiato. La sua facilità di emissione, ottime intonazione e alta qualità di manifattura rispettano la tradizione musicale. Costruito in conformità ai metodi tradizionali, questo clarinetto unisce sapientemente tecnologia ed esperienza. Prodotta con cura da Buffet Crampon in Francia, in un reparto dedicato, questa strumento rappresenta un connubio perfetto tra artigianato di alta qualità e prestazioni musicali eccezionali. Il Buffet BC2301 E11 è la scelta ideale per musicisti che cercano un clarinetto in Mib che soddisfi gli standard più elevati.\\n\\n\r\n\r\nMateriale: barilotto\\n \r\nCorpo e campana in ebano\\n Tonalità: Mib 442 Hz\\n\r\nChiavi/anelli: 17/6, argentate\\n Completo di astuccio, bocchino, copri-bocchino, legatura, ance e panno pulizia', 1790, 2, 0, 5, 12, 5, 'Usato'),
(8, 'Bontempi 4480 Mini Tastiera Elettrica', 'Tastiera digitale a 44 tasti, 6 Canzoni preregistrate, 10 Suoni, 8 Ritmi, Tasti selezione suoni, ritmi\r\n\r\n\\nPolifonia 8 note\\nOKON (Funzione di apprendimento)\\n Funzione di registrazione e riascolto\\nGestione facilitata degli accordi (Easy chord) \\nEffetti: Sus', 49.9, 10, 0, 2, 5, 4, 'Nuovo'),
(9, 'Yamaha PSRF52 Tastiera Portatile 61 Tasti', 'La PSR-F52 è la tastiera perfetta per chi vuole imparare a suonare. Ha tutte le funzionalità di cui hai bisogno per la tua prima esperienza musicale. La PSR-F52 offre una solida base per chiunque voglia iniziare a suonare la tastiera.\\n\\n\r\n\r\nTastiera di alta qualità\\n\r\n136 voci (incluse 41 voci dal mondo) + 8 kit di batteria (inclusi 5 kit di batteria dal mondo)\\n\r\n158 stili di accompagnamento (incluso 75 stili dal mondo)\\n\r\n69 song precaricate\\n\r\nSongbook digitale gratuito\\n\r\nVarie funzioni (Panel Sustain, Metronome, Sound, Boost e altro)\\n\r\nLeggera e compatta\\n\r\nAltoparlanti integrati / jack cuffie', 122, 3, 0, 2, 5, 2, 'Usato'),
(10, 'Carry-On 88 tastiera pieghevole', 'Dispone di altoparlanti integrati, uscita per cuffie, porta di ricarica USB per batteria interna ricaricabile, ingresso per pedale sustain (incluso) e molte altre funzioni e strumenti.\r\nLarghezza tasti standard\\n\\n\r\n\r\n88 tasti, Natural Feel\\n\r\nPolifonia a 128 voci\\n\r\nUSB MIDI\\n\r\nTrasposizione ±6 semitoni\\n\r\n128 Stili di accompagnamento, con selezione del tono\\n\r\n30 Brani Demo\\n\r\nTempo regolabile 30-180 bpm\\n\r\nMetronomo con 6 impostazioni accento\\n\r\nAltoparlanti 2x 2 Watt (stereo)', 139, 8, 0.2, 2, 5, 5, 'Nuovo'),
(11, 'Sauter Accento Pianoforte verticale by Peter Maly', 'Il prestigioso pianoforte verticale Sauter, modello Accento, è il risultato dell\'artigianato impeccabile tedesco, incanalato nella perfezione da Peter Maly. Questo strumento esclusivo è stato attentamente progettato per incontrare le esigenze dei pianisti professionisti, offrendo non solo una qualità sonora eccezionale, ma anche una cura meticolosa nei dettagli e una struttura affidabile. Realizzato in Germania, il pianoforte Accento di Sauter è la scelta prediletta di chi cerca un\'eccellenza musicale senza compromessi. La sua raffinata estetica si unisce a una risposta dinamica superiore e a una sensazione tattile precisa, rendendolo un\'opzione ideale per chi cerca un compagno di fiducia in ogni esibizione e studio professionale.\\n\\nMisure:\\n\r\nAltezza cm 119\\n \r\nLarghezza cm 156\\n\r\nProfondità cm 60\\n\r\nColore nero satinato.\r\nDisponibile anche nei colori nero lucido e bianco', 15200, 1, 0, 2, 4, 6, 'Nuovo'),
(12, 'Vhienna Meister VH VOB 4/4 Violino', 'Il violino Basic 4/4 è la scelta ideale per i musicisti principianti e coloro che desiderano esplorare il meraviglioso mondo degli strumenti ad arco. Caratterizzato da una costruzione robusta e materiali di qualità, questo violino offre facilità di suonabilità e una risposta sonora equilibrata. La sua fattura attenta ai dettagli segue tradizioni artigianali, garantendo un\'intonazione precisa e una qualità duratura. Con la sua provenienza da marchi affidabili nel settore della liuteria, il violino Basic 4/4 offre un ottimo rapporto qualità-prezzo, fornendo agli aspiranti musicisti uno strumento di base affidabile per iniziare il loro viaggio musicale.\\n\\nTop: Abete Laminato\\nFondo/Fasce: Laminato\\nTastiera/Piroli: Ebanizzati \\nTendicordiera: In Metallo con 4 mini accordatori \\nArchetto: Entry level, Colofonia compresa (pece)', 89, 7, 0.1, 3, 6, 7, 'Nuovo'),
(13, 'Stentor Violino Student 1 3/4 Settato', 'L\'incredibile strumento, realizzato in acero e abete massello, è il risultato di un\'artigianalità attenta con legni stagionati naturalmente. Materiali di alta qualità e tecnica costruttiva impeccabile si combinano per offrire un\'esperienza sonora e visiva straordinaria. Dotato di piroli e mentoniera in Tiglio, la cordiera metallica con quattro intonatori incorporati permette una regolazione precisa. Le corde Dogal R31 e la pece Dogal aggiungono un tocco di raffinatezza, offrendo agli artisti un\'esperienza musicale eccezionale. Un capolavoro sonoro, plasmato con maestria, per i musicisti più esigenti.\\n\\n\r\nMisura: 3/4\\n\r\nModello: Violino Student 1\\n\r\nSetup incluso: Sì\\n\r\nCostruzione: Legno massello\\n\r\nFinitura: Naturale\\n\r\nAccessori inclusi: Custodia, archetto, colofonia\\n\r\nDestinato a: Studenti e principianti\\n\r\nSuonabilità: Facile e comodo per chi si avvicina per la prima volta al violino', 205, 2, 0, 3, 6, 8, 'Usato'),
(14, 'Bruck Cello 3/4 HDC01 Laminato completo di arco e borsa', 'Il violoncello Bruck 3/4 HDC01 offre un\'opzione eccellente per i musicisti di livello intermedio. Realizzato con laminato di alta qualità, questo strumento presenta una costruzione robusta e una finitura accurata. Completo di arco e altri accessori essenziali, il Bruck Cello assicura una facilità di suonabilità e una risposta sonora equilibrata. La sua progettazione attenta alle specifiche musicali consente una performance consistente e una gamma tonale ricca. Con il marchio Bruck, puoi contare su un violoncello affidabile, ideale per esprimere la tua musicalità con un suono caldo e avvolgente.\\n\\nVioloncello HDC01 3/4, completo di archetto, borsa e pece \\nTavola in abete laminato\\n Cordiera con 4 tiracantini\\n Corde originali con il LA di qualità (sostituito dal liutaio)', 280, 5, 0, 3, 7, 9, 'Nuovo'),
(15, 'Vhienna Meister VH CES12 Violoncello', 'Il violino Vienna Meister VH CES12 è una sublime espressione di artigianato musicale. Costruito con maestria, il suo design prevede l\'uso di legni pregiati che contribuiscono a una sonorità eccezionale. La tavola armonica finemente lavorata garantisce una proiezione sonora ricca e avvolgente. Pensato per soddisfare le esigenze dei musicisti avanzati, offre una suonabilità superiore e una risposta dinamica. La finitura elegante e la precisione artigianale conferiscono un tocco di raffinatezza estetica. Con il suo equilibrio timbrico e la qualità della costruzione, il VH CES12 è una scelta ideale per coloro che cercano uno strumento capace di esprimere la massima musicalità e di elevare le esibizioni a nuove vette.\\n\\nTop: Abete\\n Massello Fondo/Fasce: Acero Laminato \\nTastiera: Ebanizzata \\nTendicordiera: Metallo con Mini Accordatori \\nArchetto: Entry level plus, Colofonia \\n\r\nCustodia: Blu', 550, 3, 0, 3, 7, 7, 'Usato'),
(16, 'Eko Drums ED-200 Drum kit Metallic Blue di 5 pezzi', 'Batteria ad alte prestazioni per soddisfare le esigenze quotidiane. Lunga durata e affidabilità per dispositivi elettronici. Tecnologia avanzata per una ricarica veloce e sicura. Ideale per garantire la massima autonomia ai tuoi dispositivi.\\n\\n\r\nGrancassa 16\" x 10\"\\n\r\nRullante 10\" x 5\"\\n\r\nTom 8\" x 5\"\\n\r\nTom 10\" x 6\"\\n\r\nTimpano 12\" x 10\"\\n\r\nHi-Hat 8\"\\n\r\nPiatto 10\"', 223, 4, 0, 4, 8, 1, 'Nuovo'),
(17, 'Stentor JDK516 MR Batteria Junior di 5 pezzi', 'La serie JDK516 è la linea di batterie SOUNDSATION dedicata allo studio per i più piccoli. Le dimensioni ridotte favoriscono un miglior posizionamento dei fusti anche per bambini al di sotto dei 120 cm di altezza.\\n\\n\r\nFusti in Pioppo con risposta lineare \\nFiniture rivestite\\n Sistema di fissaggio Toms con braccetti \"mini size\" \\nHardware Serie JDK 100 Blocchetti a doppio tirante \\nPelli Soundsation®\\n\r\nDimensioni:\r\nToms 8\", 10\" - Timpano 12\" – Cassa 16\" – Rullante 11\" Fusti in Pioppo Sistema fissaggio tom con braccetti \"Mini-size\" regolabili Meccaniche cromate Soundsation®\\n\r\nCerchi Cromati Blocchetti a doppio tirante (finitura cromata) – 4 su Toms,Timpano e Rullante, 6 sulla Cassa\r\nHi-Hat Stand: HS-JDK 100\r\nSnare Stand: SS-JDK 100\r\nBass Drum Pedal: BP-JDK 100\r\nCymbal Stand: CS-JDK 100\r\nPiatti, sgabello e bacchette inclusi\\n\r\nColore: Metallic Red', 240, 6, 0.1, 4, 8, 8, 'Nuovo'),
(18, 'Proel CCR3882-GSS-Bb-L Cornetta in Sib Laccata', 'La cornetta Proel CCR3882-GSS-Bb-L in Sib è uno strumento di alta qualità perfetto per musicisti di tutti i livelli. Con una finitura laccata che aggiunge eleganza, offre una suonabilità fluida e una risposta rapida. La costruzione robusta assicura durabilità nel tempo, mentre il suono brillante e potente la rende adatta a una varietà di generi musicali. Dotata di meccaniche precise e ergonomiche, questa cornetta offre un\'intonazione precisa e una facilità d\'uso. Ideale per ensemble, band o performance soliste, la Proel CCR3882-GSS-Bb-L è una scelta affidabile e versatile per i musicisti che cercano qualità e affidabilità.\\n\\nCORNETTA Sib CCR3882-GSS-Bb-L\\n Canneggio mm.11.82 (0.465\')\\n Campana cm.12 (4.724\')\\n Astuccio e bocchino 7C compreso', 599, 5, 0.15, 5, 11, 3, 'Nuovo');

-- --------------------------------------------------------

--
-- Struttura della tabella `sottocategorie`
--

CREATE TABLE `sottocategorie` (
  `id_sottocategoria` int(11) NOT NULL,
  `nome_sottocategoria` varchar(255) NOT NULL,
  `fk_id_categoria` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

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
