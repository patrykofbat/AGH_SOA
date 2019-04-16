-- phpMyAdmin SQL Dump
-- version 4.6.6deb5
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Czas generowania: 16 Kwi 2019, 15:58
-- Wersja serwera: 5.7.25-0ubuntu0.18.04.2
-- Wersja PHP: 7.2.15-0ubuntu0.18.04.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `SOA`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `books`
--

CREATE TABLE `books` (
  `id` int(11) NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `book_author_id` int(11) NOT NULL,
  `category` varchar(255) DEFAULT NULL,
  `pages` int(11) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `currency` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Zrzut danych tabeli `books`
--

INSERT INTO `books` (`id`, `title`, `book_author_id`, `category`, `pages`, `price`, `currency`) VALUES
(2, 'Ingmar Bergman on Life and Work (Ingmar Bergman: Om liv och arbete)', 16, 'Documentary', 113, 140, 'PLN'),
(3, 'SS Experiment Love Camp (Lager SSadis Kastrat Kommandantur)', 54, 'Horror|War', 348, 73, 'PLN'),
(4, 'Man in the Chair', 31, 'Comedy|Drama', 169, 189, 'PLN'),
(5, 'How to Survive a Plague', 53, 'Documentary', 146, 150, 'PLN'),
(6, 'La nación clandestina', 21, 'Drama', 129, 97, 'PLN'),
(7, 'Black Christmas', 54, 'Horror|Mystery|Thriller', 371, 139, 'PLN'),
(8, 'Tom Petty and the Heartbreakers: Runnin\' Down a Dream', 21, 'Documentary|Musical', 424, 82, 'PLN'),
(9, 'Band Baaja Baaraat', 43, 'Comedy|Drama|Musical', 393, 136, 'PLN'),
(10, 'Prisoner of Zenda, The', 10, 'Action|Adventure|Romance', 133, 166, 'PLN'),
(11, 'Countdown to Looking Glass', 54, 'Drama', 309, 130, 'PLN'),
(12, 'Magnificent Obsession', 74, 'Drama|Romance', 394, 123, 'PLN'),
(13, 'Booty Call', 62, 'Comedy|Romance', 355, 166, 'PLN'),
(14, 'Female Perversions', 13, 'Drama', 484, 120, 'PLN'),
(15, 'Tank on the Moon', 32, 'Documentary', 381, 183, 'PLN'),
(16, 'Kaena: The Prophecy (Kaena: La prophétie)', 53, 'Action|Adventure|Animation|Children|Sci-Fi', 454, 105, 'PLN'),
(17, 'Portrait of Jennie', 25, 'Drama|Fantasy|Mystery|Romance', 253, 67, 'PLN'),
(18, 'Shaolin Soccer (Siu lam juk kau)', 80, 'Action|Comedy', 429, 55, 'PLN'),
(19, 'Murder of Crows, A', 24, 'Action|Crime|Thriller', 396, 94, 'PLN'),
(20, 'Something the Lord Made', 51, 'Drama', 453, 85, 'PLN'),
(21, 'Star!', 28, 'Musical', 481, 129, 'PLN'),
(22, 'Painting Sellers, The (Taulukauppiaat)', 38, 'Drama', 330, 85, 'PLN'),
(23, 'Dead Pit, The', 55, 'Horror', 302, 190, 'PLN'),
(24, 'Big Bad Mama', 91, 'Action|Comedy', 453, 176, 'PLN'),
(25, 'Shadow Kill', 20, 'Drama', 430, 83, 'PLN'),
(26, 'Innocent, The (Innocente, L\')', 53, 'Drama|Romance', 133, 185, 'PLN'),
(27, 'Victory', 48, 'Drama', 215, 117, 'PLN'),
(28, 'City Hall', 70, 'Drama|Thriller', 232, 119, 'PLN'),
(29, 'Cabin Fever 2: Spring Fever', 24, 'Horror|Thriller', 285, 183, 'PLN'),
(30, 'Tension at Table Rock', 50, 'Western', 325, 145, 'PLN'),
(31, 'Two Deaths', 88, 'Drama', 471, 52, 'PLN'),
(32, 'Secret of Santa Vittoria, The', 21, 'Comedy|Drama|War', 255, 127, 'PLN'),
(33, 'Casper\'s Haunted Christmas', 32, 'Animation|Children', 498, 57, 'PLN'),
(34, 'Seven Ways from Sundown', 42, 'Action|Adventure|Western', 314, 56, 'PLN'),
(35, 'Tristana', 49, 'Drama', 364, 66, 'PLN'),
(36, 'Árido Movie', 79, 'Drama', 173, 155, 'PLN'),
(37, 'Bogus', 84, 'Children|Drama|Fantasy', 103, 94, 'PLN'),
(38, 'Werner - Gekotzt wird später', 72, 'Animation|Comedy', 169, 90, 'PLN'),
(39, 'Privilege', 97, 'Drama|Musical', 425, 115, 'PLN'),
(40, 'People, Places, Things', 20, 'Comedy', 419, 107, 'PLN'),
(41, 'One Man\'s Hero', 8, 'Drama|War', 111, 189, 'PLN'),
(42, 'Nomad (Köshpendiler)', 85, 'Drama|War', 363, 141, 'PLN'),
(43, 'Hound of the Baskervilles, The', 29, 'Crime|Mystery', 149, 134, 'PLN'),
(44, 'Rocket, The', 5, 'Drama', 124, 70, 'PLN'),
(45, 'Millhaven', 93, 'Animation', 265, 114, 'PLN'),
(46, 'Bleak Moments', 85, 'Comedy|Drama', 261, 111, 'PLN'),
(47, 'Bionicle: Mask of Light (Bionicle: Mask of Light - The Movie)', 27, 'Action|Adventure|Animation|Children|Fantasy', 337, 184, 'PLN'),
(48, 'Gremlins', 35, 'Comedy|Horror', 170, 96, 'PLN'),
(49, 'Moment by Moment', 11, 'Drama|Romance', 315, 63, 'PLN'),
(50, 'The Last Gladiators', 47, 'Documentary', 417, 198, 'PLN'),
(51, 'American Pimp', 41, 'Documentary', 415, 150, 'PLN'),
(52, 'Wanda Sykes: Sick and Tired', 58, 'Comedy|Documentary', 247, 187, 'PLN'),
(53, 'Batman', 67, 'Action|Crime|Thriller', 383, 87, 'PLN'),
(54, 'Ordinary People', 76, 'Drama', 263, 139, 'PLN'),
(55, 'Jingle All the Way 2', 16, 'Children|Comedy', 424, 112, 'PLN'),
(56, 'Enquiring Minds: The Untold Story of the Man Behind the National Enquirer', 72, 'Documentary', 225, 158, 'PLN'),
(57, 'Stonewall Uprising', 43, 'Documentary', 182, 112, 'PLN'),
(58, 'Boogie (Boogie, el aceitoso)', 29, 'Action|Animation|Crime', 368, 110, 'PLN'),
(59, 'Rainmaker, The', 26, 'Drama', 400, 108, 'PLN'),
(60, 'Rollover', 18, 'Drama', 374, 156, 'PLN'),
(61, 'Red Psalm (Még kér a nép)', 21, 'Drama|Musical|War', 143, 52, 'PLN'),
(62, 'King Is Dead!, The', 60, 'Comedy|Drama|Thriller', 294, 189, 'PLN'),
(63, 'Border Café', 21, 'Drama', 312, 179, 'PLN'),
(64, 'Hard Day\'s Night, A', 2, 'Adventure|Comedy|Musical', 432, 66, 'PLN'),
(65, 'Crossroads', 70, 'Drama', 122, 175, 'PLN'),
(66, 'Spirit Trap', 80, 'Horror|Thriller', 228, 119, 'PLN'),
(67, 'Catlow', 99, 'Comedy|Western', 478, 133, 'PLN'),
(68, 'Sexy Baby', 24, 'Documentary', 341, 135, 'PLN'),
(69, 'I Never Promised You a Rose Garden', 27, 'Drama', 201, 177, 'PLN'),
(70, 'Bully', 40, 'Documentary', 179, 198, 'PLN'),
(71, 'Navajo Joe', 92, 'Western', 400, 162, 'PLN'),
(72, 'Order of Myths, The', 83, 'Documentary', 192, 79, 'PLN'),
(73, 'The Phantom Light', 76, 'Mystery|Thriller', 185, 188, 'PLN'),
(74, 'We Are What We Are (Somos lo que hay)', 11, 'Drama|Horror', 423, 129, 'PLN'),
(75, 'End of Days', 96, 'Action|Fantasy|Horror|Mystery|Thriller', 413, 125, 'PLN'),
(76, 'Nora\'s Will (Cinco días sin Nora)', 72, 'Comedy|Drama', 344, 123, 'PLN'),
(77, 'Power and Terror: Noam Chomsky in Our Times', 9, 'Documentary', 397, 152, 'PLN'),
(78, 'Amityville: A New Generation', 40, 'Horror', 458, 198, 'PLN'),
(79, 'Conan the Barbarian', 59, 'Action|Adventure|Fantasy', 326, 142, 'PLN'),
(80, 'I Don\'t Want to Sleep Alone (Hei yan quan)', 8, 'Comedy|Drama', 121, 189, 'PLN'),
(81, 'Games People Play: New York', 26, 'Comedy|Documentary|Drama', 321, 183, 'PLN'),
(82, 'Ghost Rider: Spirit of Vengeance', 49, 'Action|Fantasy|Thriller', 168, 95, 'PLN'),
(83, 'Finding Amanda', 64, 'Comedy|Drama', 195, 70, 'PLN'),
(84, 'Days and Clouds (Giorni e nuvole)', 8, 'Drama', 156, 157, 'PLN'),
(85, 'Palestine Is Still the Issue', 84, 'Documentary', 356, 196, 'PLN'),
(86, 'Holding Trevor', 33, 'Drama|Romance', 176, 113, 'PLN'),
(87, 'Captives', 49, 'Crime|Drama|Romance|Thriller', 339, 71, 'PLN'),
(88, 'Hot Chick, The', 48, 'Comedy', 339, 148, 'PLN'),
(89, 'Score, The', 25, 'Action|Drama', 180, 114, 'PLN'),
(90, 'Endangered Species', 63, 'Mystery|Sci-Fi|Thriller', 383, 129, 'PLN'),
(91, 'Edge of Darkness', 8, 'Drama|War', 333, 159, 'PLN'),
(92, 'Episode 3: Enjoy Poverty', 34, 'Documentary|War', 224, 80, 'PLN'),
(93, 'The Hunting Ground', 98, 'Documentary', 236, 162, 'PLN'),
(94, 'How They Get There', 34, '(no genres listed)', 464, 94, 'PLN'),
(95, 'Amazonia', 65, 'Adventure|Documentary', 138, 145, 'PLN'),
(96, 'The Green Prince', 26, 'Documentary|Drama|Thriller', 442, 61, 'PLN'),
(97, 'Drag Me to Hell', 3, 'Comedy|Horror', 126, 81, 'PLN'),
(98, 'Swept Away (Travolti da un insolito destino nell\'azzurro mare d\'Agosto)', 29, 'Comedy|Drama', 249, 55, 'PLN'),
(99, 'Soldier of Orange (a.k.a. Survival Run) (Soldaat van Oranje)', 54, 'Drama|Thriller|War', 109, 80, 'PLN'),
(100, 'Hollywood Shuffle', 47, 'Comedy', 193, 67, 'PLN'),
(101, 'It', 87, 'Comedy|Romance', 404, 163, 'PLN'),
(102, 'Chinese Zodiac (Armour of God III) (CZ12)', 44, 'Action|Adventure|IMAX', 155, 151, 'PLN'),
(103, 'Dodes\'ka-den (Clickety-Clack)', 43, 'Drama|Fantasy', 317, 172, 'PLN'),
(104, 'Deadline at Dawn', 35, 'Film-Noir|Mystery|Romance|Thriller', 184, 199, 'PLN'),
(105, 'Secret Garden, The', 50, 'Children|Drama', 282, 76, 'PLN'),
(106, 'Poison Ivy', 53, 'Drama|Thriller', 380, 59, 'PLN'),
(107, 'Shooting Fish', 27, 'Comedy|Romance', 247, 104, 'PLN'),
(108, 'Final Option, The (Who Dares Wins)', 6, 'Action|War', 374, 163, 'PLN'),
(109, 'Jamilya', 65, 'Drama|Romance|War', 110, 94, 'PLN'),
(110, 'Three of Hearts', 17, 'Comedy|Romance', 393, 163, 'PLN'),
(111, 'Wolf Creek 2', 14, 'Horror|Thriller', 468, 62, 'PLN'),
(112, 'Manhattan Baby', 16, 'Horror', 274, 73, 'PLN'),
(113, 'Memories (Memorîzu)', 47, 'Animation|Fantasy|Sci-Fi|Thriller', 237, 154, 'PLN'),
(114, 'Nightbreed', 59, 'Fantasy|Horror', 376, 57, 'PLN'),
(115, 'K-20: The Fiend with Twenty Faces', 87, 'Action|Adventure|Crime', 318, 93, 'PLN'),
(116, 'Kurt & Courtney', 60, 'Documentary', 287, 61, 'PLN'),
(117, 'Stewart Lee: If You Prefer a Milder Comedian, Please Ask for One', 55, 'Comedy', 414, 86, 'PLN'),
(118, 'His Brother (Son frère)', 81, 'Drama', 242, 114, 'PLN'),
(119, 'Detention', 21, 'Comedy|Horror', 283, 83, 'PLN'),
(120, 'Looker', 83, 'Drama|Horror|Sci-Fi|Thriller', 144, 128, 'PLN'),
(121, 'Hide in Plain Sight', 9, 'Drama', 261, 171, 'PLN'),
(122, 'Russian Specialist, The (Mechanik, The)', 1, 'Action|Drama|Thriller', 239, 160, 'PLN'),
(123, 'Dana Carvey: Squatting Monkeys Tell No Lies', 69, 'Comedy', 372, 99, 'PLN'),
(124, 'Cyborg Girl (Boku no kanojo wa saibôgu)', 78, 'Action|Comedy|Romance|Sci-Fi', 127, 183, 'PLN'),
(125, 'Assault on a Queen', 37, 'Action|Adventure|Crime|Drama|Thriller', 473, 148, 'PLN'),
(126, 'Masque of the Red Death, The', 98, 'Horror', 489, 184, 'PLN'),
(127, 'Too Beautiful for You (Trop belle pour toi)', 82, 'Comedy|Drama|Romance', 256, 100, 'PLN'),
(128, 'Singing Marine, The', 51, 'Comedy|Musical|Romance', 241, 129, 'PLN'),
(129, 'Love and Anarchy (Film d\'amore e d\'anarchia, ovvero \'stamattina alle 10 in via dei Fiori nella nota casa di tolleranza...\')', 75, 'Comedy|Drama|Romance', 480, 138, 'PLN'),
(130, 'Chipmunk Adventure, The', 7, 'Adventure|Animation|Children|Comedy|Fantasy|Musical', 187, 103, 'PLN'),
(131, 'Cheerleader Camp', 46, 'Comedy|Horror|Mystery', 131, 89, 'PLN'),
(132, 'Of Human Hearts', 10, 'Drama', 123, 54, 'PLN'),
(133, 'Teacher\'s Pet', 64, 'Animation|Children', 400, 171, 'PLN'),
(134, 'Stuck in Love', 92, 'Comedy|Drama|Romance', 153, 160, 'PLN'),
(135, 'Carrie', 84, 'Drama|Horror|Thriller', 151, 68, 'PLN'),
(136, 'Miss Violence', 19, 'Drama|Mystery', 211, 59, 'PLN'),
(137, 'Our Vines Have Tender Grapes', 77, 'Drama', 462, 147, 'PLN'),
(138, 'Youth Without Youth', 69, 'Drama|Romance|Sci-Fi', 217, 125, 'PLN'),
(139, 'World Trade Center', 89, 'Drama', 273, 157, 'PLN'),
(140, 'I\'ll Never Forget What\'s\'isname', 46, 'Comedy|Drama', 433, 138, 'PLN'),
(141, 'Ghetto (Vilniaus Getas)', 20, 'War', 491, 137, 'PLN'),
(142, 'She-Wolf of London', 11, 'Action|Drama|Horror|Mystery', 388, 67, 'PLN'),
(143, 'Detour', 2, 'Crime|Film-Noir', 147, 61, 'PLN'),
(144, 'Rough Magic', 79, 'Drama|Romance', 417, 159, 'PLN'),
(145, 'Bad Country', 38, 'Action|Crime|Drama|Thriller', 269, 64, 'PLN'),
(146, 'One Night with the King', 6, 'Drama', 279, 105, 'PLN'),
(147, 'Dutch', 89, 'Comedy', 200, 132, 'PLN'),
(148, 'Circle, The', 82, 'Drama', 477, 181, 'PLN'),
(149, 'Single Girl, A (Fille seule, La)', 52, 'Drama', 331, 133, 'PLN'),
(150, 'All Things Fair (Lust och fägring stor)', 91, 'Drama|Romance|War', 131, 99, 'PLN'),
(151, 'I Like It Like That', 62, 'Comedy|Drama|Romance', 405, 173, 'PLN'),
(152, 'Rosalie Goes Shopping', 41, 'Comedy', 408, 186, 'PLN'),
(153, 'Gangster No. 1', 75, 'Action|Crime|Thriller', 376, 72, 'PLN'),
(154, 'Married to the Mob', 92, 'Comedy', 351, 134, 'PLN'),
(155, 'Story of Science, The', 43, 'Documentary', 140, 60, 'PLN'),
(156, '20 Million Miles to Earth', 81, 'Sci-Fi', 235, 197, 'PLN'),
(157, 'Frances', 5, 'Drama', 326, 194, 'PLN'),
(158, 'Just love me (Tylko mnie kochaj)', 48, 'Comedy|Romance', 382, 50, 'PLN'),
(159, 'Broken City', 14, 'Crime|Drama|Thriller', 112, 163, 'PLN'),
(160, 'Little World of Don Camillo, The (Petit monde de Don Camillo, Le)', 28, 'Comedy', 440, 116, 'PLN'),
(161, 'Buffet froid', 97, 'Comedy|Crime', 371, 93, 'PLN'),
(162, 'Delusions of Grandeur (La folie des grandeurs)', 14, 'Comedy', 445, 122, 'PLN'),
(163, 'Criminal Law', 4, 'Thriller', 380, 57, 'PLN'),
(164, 'American Crude', 33, 'Comedy|Drama', 159, 200, 'PLN'),
(165, 'Chariots of Fire', 6, 'Drama', 151, 200, 'PLN'),
(166, 'Monster X Strikes Back: Attack the G8 Summit, The (Girara no gyakushû: Tôya-ko Samitto kikiippatsu)', 74, 'Comedy|Sci-Fi', 161, 183, 'PLN'),
(167, 'Kicking and Screaming', 41, 'Comedy|Drama', 133, 107, 'PLN'),
(168, 'Tall Target, The', 60, 'Adventure|Crime|Drama|Thriller', 274, 125, 'PLN'),
(169, 'Zorro, the Gay Blade', 99, 'Comedy', 173, 66, 'PLN'),
(170, 'Sum of Us, The', 30, 'Comedy|Drama', 132, 83, 'PLN'),
(171, 'Live-In Maid (Cama adentro)', 81, 'Drama', 368, 119, 'PLN'),
(172, 'Dark Habits (Entre tinieblas)', 89, 'Comedy|Drama', 417, 163, 'PLN'),
(173, 'Pit, the Pendulum and Hope, The (Kyvadlo, jáma a nadeje)', 79, 'Horror|Thriller', 165, 91, 'PLN'),
(174, 'Banger Sisters, The', 61, 'Comedy|Drama', 212, 84, 'PLN'),
(175, 'Leviathan', 16, 'Horror|Sci-Fi|Thriller', 138, 80, 'PLN'),
(176, 'Finding a Family', 13, 'Drama', 359, 133, 'PLN'),
(177, 'It\'s My Mother\'s Birthday Today', 20, '(no genres listed)', 449, 125, 'PLN'),
(178, 'Legend of Lizzie Borden, The', 4, 'Drama', 404, 76, 'PLN'),
(179, 'Laws of Gravity', 54, 'Drama', 292, 133, 'PLN'),
(180, 'Dikkenek', 53, 'Comedy', 442, 102, 'PLN'),
(181, 'Cries and Whispers (Viskningar och rop)', 95, 'Drama', 354, 77, 'PLN'),
(182, 'Thief Lord, The', 71, 'Adventure|Children|Fantasy', 431, 188, 'PLN'),
(183, 'Morning After, The', 94, 'Drama|Mystery', 391, 137, 'PLN'),
(184, '588 Rue Paradis (Mother)', 71, 'Drama', 358, 108, 'PLN'),
(185, 'Mean Girls', 32, 'Comedy', 487, 57, 'PLN'),
(186, 'Live Forever', 1, 'Comedy|Documentary', 146, 98, 'PLN'),
(187, 'Batman: Under the Red Hood', 47, 'Action|Animation', 362, 192, 'PLN'),
(188, 'Memorial Day', 56, 'Action|Drama|War', 120, 108, 'PLN'),
(189, 'Berserk: The Golden Age Arc 2 - The Battle for Doldrey', 74, 'Action|Animation|Fantasy', 145, 113, 'PLN'),
(190, 'Amityville 3-D', 85, 'Horror', 495, 151, 'PLN'),
(191, 'Voyager (Homo Faber)', 10, 'Drama', 113, 106, 'PLN'),
(192, 'Naked Kiss, The', 61, 'Drama', 376, 183, 'PLN'),
(193, 'Beyond the Black Rainbow', 73, 'Mystery|Sci-Fi', 244, 172, 'PLN'),
(194, 'War Witch (Rebelle)', 69, 'Drama|War', 124, 117, 'PLN'),
(195, 'Back to Bataan', 40, 'Drama|War', 119, 60, 'PLN'),
(196, 'Great Waldo Pepper, The', 20, 'Drama|Romance', 305, 197, 'PLN'),
(197, '3 Blind Mice', 55, 'Crime|Mystery|Romance|Thriller', 231, 81, 'PLN'),
(198, 'Autopsy', 52, 'Horror', 158, 128, 'PLN'),
(199, 'Liebelei', 28, 'Romance', 206, 176, 'PLN'),
(200, 'Lynch', 90, 'Documentary', 176, 172, 'PLN');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `books_authors`
--

CREATE TABLE `books_authors` (
  `id` int(11) NOT NULL,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Zrzut danych tabeli `books_authors`
--

INSERT INTO `books_authors` (`id`, `first_name`, `last_name`) VALUES
(1, 'Patryk', 'Papior'),
(2, 'Shurwood', 'Pyffe'),
(3, 'Alikee', 'Bilston'),
(4, 'Amy', 'Grand'),
(5, 'Dot', 'Dorgan'),
(6, 'Rodger', 'Benson'),
(7, 'Penrod', 'Czaja'),
(8, 'Clay', 'Klempke'),
(9, 'Vivyanne', 'Andrichak'),
(10, 'Tania', 'Kaminski'),
(11, 'Fayth', 'Bolingbroke'),
(12, 'Ethelbert', 'Wybron'),
(13, 'Sylvester', 'Rachuig'),
(14, 'Keefe', 'Kolak'),
(15, 'Aldus', 'Maplethorpe'),
(16, 'Laina', 'Konke'),
(17, 'Parker', 'Lister'),
(18, 'Galina', 'Franciotti'),
(19, 'Miranda', 'Tarling'),
(20, 'Alecia', 'Thireau'),
(21, 'Pamelina', 'Buckbee'),
(22, 'Erl', 'Hug'),
(23, 'Percival', 'Whillock'),
(24, 'Rozanne', 'Crosetto'),
(25, 'Jeremie', 'Bolletti'),
(26, 'Enrique', 'Tchaikovsky'),
(27, 'Alberik', 'Merle'),
(28, 'Cornelius', 'Escalante'),
(29, 'Ambros', 'Tythe'),
(30, 'Clemmy', 'Yockley'),
(31, 'Obed', 'Danslow'),
(32, 'Hermie', 'Graber'),
(33, 'Aurore', 'Murrthum'),
(34, 'Seline', 'Snalom'),
(35, 'Danyelle', 'Harriagn'),
(36, 'Alane', 'Kale'),
(37, 'Ward', 'Life'),
(38, 'Chance', 'McLeoid'),
(39, 'Bevan', 'L\' Estrange'),
(40, 'Stearne', 'Cargon'),
(41, 'Tori', 'Garfitt'),
(42, 'Penny', 'Croix'),
(43, 'Brady', 'Akaster'),
(44, 'Stanislaus', 'Lougheid'),
(45, 'Fowler', 'Wince'),
(46, 'Frayda', 'Duchesne'),
(47, 'Beverly', 'Abbott'),
(48, 'Dotty', 'Crighton'),
(49, 'Berget', 'Lamzed'),
(50, 'Paulie', 'Oulett'),
(51, 'Min', 'Penkman'),
(52, 'Caroljean', 'Golden'),
(53, 'Demetria', 'Gaine'),
(54, 'Tedi', 'Pendrid'),
(55, 'Emilia', 'Duberry'),
(56, 'Hendrick', 'Puddicombe'),
(57, 'Rooney', 'Munnings'),
(58, 'Annette', 'MacEveley'),
(59, 'Rubi', 'Van Arsdall'),
(60, 'Yasmin', 'Corns'),
(61, 'Godart', 'Haggidon'),
(62, 'Darlene', 'Bartkowiak'),
(63, 'Vidovik', 'Kaygill'),
(64, 'Oneida', 'Marsh'),
(65, 'Vivian', 'Almack'),
(66, 'Frankie', 'Brient'),
(67, 'Mac', 'Hemms'),
(68, 'Stanwood', 'Sharland'),
(69, 'Aleksandr', 'Dimont'),
(70, 'Annaliese', 'Nealy'),
(71, 'Stephen', 'Djurkovic'),
(72, 'Winfred', 'Nealand'),
(73, 'Sibley', 'Poe'),
(74, 'Hermina', 'Hubach'),
(75, 'Ken', 'Goodliffe'),
(76, 'Bettine', 'Boulde'),
(77, 'Nan', 'Coutthart'),
(78, 'Lawrence', 'Guillou'),
(79, 'Godart', 'Vasilyev'),
(80, 'Peyton', 'Clac'),
(81, 'Silvain', 'Leney'),
(82, 'Urbano', 'Shortin'),
(83, 'Janka', 'Mattiassi'),
(84, 'Charil', 'Gonet'),
(85, 'Allie', 'Corbert'),
(86, 'Morganne', 'Derrington'),
(87, 'Kiley', 'Della Scala'),
(88, 'Bertie', 'Dive'),
(89, 'Jazmin', 'Collingridge'),
(90, 'Adolphus', 'McCorry'),
(91, 'Ethelyn', 'Beels'),
(92, 'Rodd', 'Arnault'),
(93, 'Abigael', 'Broose'),
(94, 'Gaile', 'Londing'),
(95, 'Stanislas', 'Heckner'),
(96, 'Mycah', 'Southward'),
(97, 'Shalna', 'Dearlove'),
(98, 'Joceline', 'Sebright'),
(99, 'Elene', 'Trahmel'),
(100, 'Cher', 'Hecks');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `books_loans`
--

CREATE TABLE `books_loans` (
  `id` int(11) NOT NULL,
  `reader_id` int(11) NOT NULL,
  `book_id` int(11) NOT NULL,
  `loan_date` date DEFAULT NULL,
  `return_date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Zrzut danych tabeli `books_loans`
--

INSERT INTO `books_loans` (`id`, `reader_id`, `book_id`, `loan_date`, `return_date`) VALUES
(1, 6, 122, '2018-10-29', '2018-09-24'),
(2, 10, 10, '2018-04-23', '2018-07-13'),
(3, 9, 69, '2019-03-30', '2019-01-03'),
(4, 9, 199, '2018-05-11', '2018-07-22'),
(5, 1, 36, '2019-02-15', '2018-10-13'),
(6, 6, 111, '2019-02-20', '2019-04-20'),
(7, 6, 4, '2018-07-01', '2018-12-06'),
(8, 6, 130, '2018-08-24', '2018-10-05'),
(9, 8, 152, '2018-06-28', '2019-03-15'),
(10, 4, 42, '2018-03-22', '2018-05-27'),
(11, 3, 191, '2019-03-28', '2018-09-08'),
(12, 8, 75, '2018-08-03', '2019-02-19'),
(13, 7, 51, '2018-08-02', '2019-02-15'),
(14, 8, 108, '2019-03-30', '2018-06-05'),
(15, 3, 82, '2018-07-13', '2019-01-05'),
(16, 1, 137, '2018-11-17', '2018-05-16'),
(17, 1, 182, '2018-12-28', '2018-11-09'),
(18, 9, 112, '2019-02-13', '2018-04-03'),
(19, 7, 112, '2019-02-24', '2018-12-22'),
(20, 8, 146, '2018-06-16', '2019-03-14'),
(21, 4, 44, '2018-12-31', '2018-10-28'),
(22, 1, 36, '2018-08-12', '2018-04-19'),
(23, 7, 55, '2018-10-12', '2018-09-16'),
(24, 10, 179, '2019-01-13', '2018-05-11'),
(25, 6, 2, '2018-10-13', '2018-07-27'),
(26, 2, 199, '2018-10-03', '2019-03-29'),
(27, 6, 98, '2018-09-18', '2018-07-29'),
(28, 4, 200, '2019-01-22', '2018-06-20'),
(29, 9, 124, '2018-03-18', '2018-06-27'),
(30, 5, 53, '2018-09-29', '2018-06-24'),
(31, 3, 121, '2018-05-31', '2018-10-16'),
(32, 8, 198, '2018-07-21', '2019-02-14'),
(33, 9, 36, '2019-02-28', '2019-02-11'),
(34, 9, 10, '2019-03-02', '2019-01-05'),
(35, 6, 97, '2019-03-25', '2019-01-09'),
(36, 3, 83, '2018-09-22', '2018-10-09'),
(37, 6, 4, '2018-09-19', '2018-04-20'),
(38, 10, 66, '2018-06-28', '2018-09-18'),
(39, 8, 43, '2018-07-09', '2019-01-25'),
(40, 10, 164, '2018-10-06', '2018-11-15'),
(41, 1, 51, '2018-04-27', '2019-01-15'),
(42, 2, 34, '2018-11-25', '2018-07-21'),
(43, 1, 194, '2019-03-29', '2019-04-09'),
(44, 10, 174, '2018-06-05', '2019-04-04'),
(45, 6, 138, '2019-03-01', '2018-10-09'),
(46, 7, 86, '2018-11-24', '2018-05-26'),
(47, 8, 10, '2018-06-25', '2019-03-31'),
(48, 10, 57, '2018-11-29', '2018-05-19'),
(49, 9, 40, '2019-02-21', '2018-12-16'),
(50, 10, 24, '2018-07-08', '2019-03-28'),
(51, 5, 137, '2018-03-16', '2018-12-23'),
(52, 10, 139, '2018-04-21', '2019-02-06'),
(53, 10, 58, '2018-10-11', '2019-02-08'),
(54, 9, 111, '2019-02-23', '2018-04-24'),
(55, 3, 13, '2018-04-29', '2019-03-21'),
(56, 4, 164, '2018-11-19', '2018-06-29'),
(57, 4, 151, '2019-03-30', '2019-02-26'),
(58, 4, 128, '2018-10-10', '2019-03-22'),
(59, 7, 87, '2018-05-20', '2019-02-28'),
(60, 5, 60, '2018-12-24', '2019-03-19'),
(61, 9, 183, '2018-09-18', '2018-04-12'),
(62, 8, 156, '2018-07-07', '2019-04-12'),
(63, 2, 185, '2019-02-17', '2018-12-07'),
(64, 4, 187, '2018-08-10', '2019-01-01'),
(65, 10, 106, '2018-12-11', '2018-11-08'),
(66, 8, 110, '2018-07-09', '2019-03-28'),
(67, 1, 18, '2018-04-27', '2018-06-15'),
(68, 9, 66, '2019-03-04', '2018-05-03'),
(69, 7, 174, '2018-05-14', '2018-07-22'),
(70, 5, 121, '2018-06-15', '2019-04-22'),
(71, 4, 82, '2018-09-25', '2018-12-01'),
(72, 3, 177, '2019-03-22', '2018-07-05'),
(73, 5, 62, '2018-08-28', '2019-02-22'),
(74, 9, 95, '2018-05-11', '2018-04-05'),
(75, 8, 162, '2018-11-30', '2018-08-27'),
(76, 10, 156, '2018-05-13', '2018-09-26'),
(77, 8, 142, '2018-09-14', '2018-10-24'),
(78, 1, 18, '2018-12-19', '2018-12-21'),
(79, 4, 92, '2018-07-16', '2018-10-31'),
(80, 2, 158, '2019-01-10', '2018-06-14'),
(81, 10, 20, '2018-09-29', '2019-01-09'),
(82, 10, 3, '2018-03-05', '2018-08-22'),
(83, 6, 71, '2018-03-12', '2018-11-02'),
(84, 2, 30, '2018-11-24', '2018-08-09'),
(85, 6, 154, '2018-09-02', '2018-09-05'),
(86, 7, 44, '2019-02-09', '2018-05-06'),
(87, 7, 173, '2018-07-12', '2018-05-17'),
(88, 2, 132, '2018-12-20', '2019-02-26'),
(89, 9, 38, '2019-03-07', '2018-08-10'),
(90, 3, 65, '2018-03-28', '2018-08-27'),
(91, 2, 75, '2019-03-28', '2018-09-18'),
(92, 9, 33, '2018-09-22', '2018-09-10'),
(93, 9, 196, '2018-05-11', '2018-05-24'),
(94, 1, 23, '2018-07-05', '2018-08-12'),
(95, 10, 45, '2018-12-26', '2018-08-23'),
(96, 4, 80, '2019-01-17', '2019-01-11'),
(97, 9, 71, '2018-11-29', '2018-04-20'),
(98, 1, 173, '2019-01-07', '2018-05-26'),
(99, 4, 119, '2018-11-27', '2018-12-08'),
(100, 1, 164, '2018-12-08', '2018-12-22'),
(101, 2, 4, '2018-07-24', '2018-06-12'),
(102, 8, 153, '2018-09-21', '2018-04-05'),
(103, 5, 103, '2019-01-24', '2018-12-25'),
(104, 2, 94, '2018-09-17', '2018-06-23'),
(105, 8, 165, '2018-07-01', '2018-12-29'),
(106, 2, 69, '2018-12-19', '2018-06-26'),
(107, 9, 70, '2018-10-20', '2018-04-27'),
(108, 2, 161, '2018-08-25', '2019-04-08'),
(109, 4, 90, '2018-03-19', '2018-04-01'),
(110, 7, 70, '2018-06-30', '2019-01-13'),
(111, 3, 33, '2018-10-21', '2018-04-06'),
(112, 10, 194, '2018-03-30', '2018-07-10'),
(113, 4, 136, '2018-11-26', '2019-03-24'),
(114, 7, 155, '2018-03-27', '2018-10-24'),
(115, 2, 178, '2018-05-18', '2018-12-24'),
(116, 5, 124, '2018-05-02', '2018-05-22'),
(117, 7, 9, '2018-12-08', '2019-01-08'),
(118, 9, 82, '2018-04-29', '2018-10-24'),
(119, 7, 186, '2019-01-05', '2018-11-07'),
(120, 9, 102, '2019-01-09', '2019-03-13'),
(121, 9, 162, '2018-04-02', '2019-03-16'),
(122, 9, 100, '2018-05-29', '2019-01-15'),
(123, 7, 99, '2018-04-27', '2019-01-20'),
(124, 5, 184, '2018-09-19', '2018-08-18'),
(125, 9, 181, '2018-09-14', '2018-12-14'),
(126, 6, 52, '2018-12-12', '2018-07-22'),
(127, 9, 177, '2018-06-25', '2019-01-27'),
(128, 8, 152, '2018-11-30', '2018-07-06'),
(129, 10, 12, '2019-03-16', '2018-08-27'),
(130, 1, 169, '2019-01-05', '2018-06-01'),
(131, 6, 66, '2018-09-24', '2019-01-12'),
(132, 6, 88, '2019-03-28', '2019-04-19'),
(133, 5, 86, '2018-06-03', '2019-03-25'),
(134, 6, 168, '2018-12-27', '2018-08-27'),
(135, 4, 14, '2018-07-08', '2018-08-20'),
(136, 4, 90, '2018-05-06', '2019-02-25'),
(137, 4, 111, '2018-09-12', '2019-04-23'),
(138, 5, 165, '2018-08-28', '2018-04-09'),
(139, 5, 170, '2018-11-22', '2019-02-11'),
(140, 1, 104, '2019-03-24', '2018-10-21'),
(141, 10, 3, '2019-02-22', '2018-11-10'),
(142, 7, 56, '2018-10-31', '2018-06-20'),
(143, 9, 42, '2019-01-30', '2018-06-21'),
(144, 3, 18, '2019-02-08', '2018-09-17'),
(145, 1, 175, '2018-04-03', '2019-02-07'),
(146, 9, 184, '2018-05-16', '2018-09-28'),
(147, 5, 24, '2018-04-21', '2019-02-21'),
(148, 10, 193, '2018-11-25', '2018-10-20'),
(149, 10, 81, '2018-08-26', '2019-01-10'),
(150, 1, 106, '2018-08-26', '2019-04-26'),
(151, 3, 106, '2019-03-08', '2018-09-10'),
(152, 8, 160, '2018-07-21', '2018-09-24'),
(153, 6, 72, '2018-12-31', '2019-04-03'),
(154, 5, 150, '2018-03-13', '2018-12-21'),
(155, 10, 23, '2018-08-18', '2018-09-07'),
(156, 4, 174, '2019-03-20', '2018-08-06'),
(157, 6, 88, '2018-04-23', '2018-06-09'),
(158, 9, 10, '2018-10-22', '2018-12-15'),
(159, 1, 195, '2018-04-15', '2018-08-20'),
(160, 9, 30, '2019-03-25', '2018-08-02'),
(161, 2, 49, '2018-06-11', '2018-04-18'),
(162, 7, 21, '2018-09-17', '2019-02-28'),
(163, 6, 151, '2018-04-14', '2019-03-18'),
(164, 9, 110, '2018-11-11', '2018-11-21'),
(165, 6, 62, '2018-06-13', '2018-11-21'),
(166, 5, 52, '2019-01-17', '2018-08-01'),
(167, 8, 59, '2018-12-14', '2018-04-09'),
(168, 5, 196, '2018-03-26', '2018-04-06'),
(169, 5, 103, '2019-03-02', '2018-10-09'),
(170, 1, 11, '2019-02-28', '2019-01-13'),
(171, 6, 113, '2018-08-04', '2019-03-02'),
(172, 9, 141, '2018-07-25', '2018-04-03'),
(173, 9, 128, '2019-02-17', '2018-05-06'),
(174, 9, 13, '2018-03-03', '2019-02-25'),
(175, 10, 51, '2018-07-07', '2019-04-29'),
(176, 4, 88, '2018-08-13', '2019-03-20'),
(177, 8, 71, '2018-05-26', '2018-04-25'),
(178, 7, 105, '2019-01-19', '2018-05-10'),
(179, 1, 190, '2018-06-10', '2018-07-29'),
(180, 8, 39, '2018-08-19', '2018-07-28'),
(181, 9, 17, '2019-02-10', '2019-01-31'),
(182, 5, 191, '2019-03-12', '2018-04-28'),
(183, 8, 37, '2018-07-19', '2018-07-09'),
(184, 8, 114, '2018-08-05', '2018-04-15'),
(185, 3, 59, '2018-05-21', '2019-02-03'),
(186, 3, 54, '2018-09-29', '2018-09-13'),
(187, 3, 45, '2018-03-04', '2018-12-09'),
(188, 5, 78, '2018-11-18', '2018-07-05'),
(189, 3, 3, '2018-12-05', '2018-09-21'),
(190, 9, 111, '2018-12-24', '2018-09-28'),
(191, 3, 33, '2019-01-06', '2018-09-16'),
(192, 7, 197, '2018-03-21', '2018-08-06'),
(193, 5, 2, '2018-11-14', '2018-04-30'),
(194, 5, 96, '2019-03-03', '2018-12-05'),
(195, 10, 56, '2018-10-08', '2018-10-25'),
(196, 6, 135, '2019-03-15', '2018-05-25'),
(197, 7, 77, '2019-01-25', '2018-05-07'),
(198, 2, 181, '2018-05-12', '2018-11-20'),
(199, 9, 43, '2018-06-28', '2018-08-08'),
(200, 10, 145, '2019-02-09', '2018-11-29');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Zrzut danych tabeli `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `readers`
--

CREATE TABLE `readers` (
  `id` int(11) NOT NULL,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Zrzut danych tabeli `readers`
--

INSERT INTO `readers` (`id`, `first_name`, `last_name`) VALUES
(1, 'Rhody', 'Reckless'),
(2, 'Sydel', 'Tukely'),
(3, 'Layne', 'Marklew'),
(4, 'Bink', 'Cartmale'),
(5, 'Amber', 'Venmore'),
(6, 'Darb', 'O\'dell'),
(7, 'Sherline', 'Cancelier'),
(8, 'Florida', 'Barnicott'),
(9, 'Rodney', 'Burry'),
(10, 'Lanny', 'Eldered'),
(11, 'Peggi', 'Bluschke'),
(12, 'Raff', 'Bohlsen'),
(13, 'Holmes', 'Eyes'),
(14, 'Rickie', 'Hearnaman'),
(15, 'Wanda', 'Firth');
--
-- Indeksy dla zrzutów tabel
--

--
-- Indexes for table `books`
--
ALTER TABLE `books`
  ADD PRIMARY KEY (`id`),
  ADD KEY `book_author_id` (`book_author_id`);

--
-- Indexes for table `books_authors`
--
ALTER TABLE `books_authors`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id` (`id`);

--
-- Indexes for table `books_loans`
--
ALTER TABLE `books_loans`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKpuysdrs3n7u3defsk4srbqw45` (`reader_id`),
  ADD KEY `FKbdyywh017awbpr0h71vxnqxw8` (`book_id`);

--
-- Indexes for table `readers`
--
ALTER TABLE `readers`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT dla tabeli `books`
--
ALTER TABLE `books`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=201;
--
-- AUTO_INCREMENT dla tabeli `books_authors`
--
ALTER TABLE `books_authors`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=101;
--
-- AUTO_INCREMENT dla tabeli `books_loans`
--
ALTER TABLE `books_loans`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=202;
--
-- AUTO_INCREMENT dla tabeli `readers`
--
ALTER TABLE `readers`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=101;
--
-- Ograniczenia dla zrzutów tabel
--

--
-- Ograniczenia dla tabeli `books`
--
ALTER TABLE `books`
  ADD CONSTRAINT `books_ibfk_1` FOREIGN KEY (`book_author_id`) REFERENCES `books_authors` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Ograniczenia dla tabeli `books_loans`
--
ALTER TABLE `books_loans`
  ADD CONSTRAINT `FKbdyywh017awbpr0h71vxnqxw8` FOREIGN KEY (`book_id`) REFERENCES `books` (`id`),
  ADD CONSTRAINT `FKpuysdrs3n7u3defsk4srbqw45` FOREIGN KEY (`reader_id`) REFERENCES `readers` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
