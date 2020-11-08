-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Sam 11 Mars 2017 à 15:59
-- Version du serveur :  10.1.13-MariaDB
-- Version de PHP :  5.6.20

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `pfe`
--

-- --------------------------------------------------------

--
-- Structure de la table `etudiant`
--

CREATE TABLE `etudiant` (
  `cne` varchar(11) NOT NULL,
  `nom` varchar(20) DEFAULT NULL,
  `prenom` varchar(20) DEFAULT NULL,
  `motdepasse` varchar(20) DEFAULT NULL,
  `adresse_IP` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `etudiant`
--

INSERT INTO `etudiant` (`cne`, `nom`, `prenom`, `motdepasse`, `adresse_IP`) VALUES
('1215141316', 'Boujaada', 'Hind', '12345', ''),
('123', 'amchayd', 'mariam', '123', '192.168.56.1'),
('1234', 'daadi', 'farah', '1234', ''),
('123456789', 'AGGAGUI', 'Yassine', 'test', '192.168.56.1'),
('141251556', 'lhabib', 'souhayla', '159', ''),
('987654321', 'IDRISSI', 'Ayoube', 'test', '192.168.56.1');

-- --------------------------------------------------------

--
-- Structure de la table `examen`
--

CREATE TABLE `examen` (
  `id_examen` int(11) NOT NULL,
  `cin` varchar(20) DEFAULT NULL,
  `date_debut` varchar(20) DEFAULT NULL,
  `date_fin` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `examen`
--

INSERT INTO `examen` (`id_examen`, `cin`, `date_debut`, `date_fin`) VALUES
(1, 'X123456', '28/01/2017;13:00', '28/01/2017;14:30'),
(2, 'X456789', '25/01/2017;14:00', '25/01/2017;16:30'),
(3, 'X654321', '30/01/2017;10:00', '30/01/2017;12:00');

-- --------------------------------------------------------

--
-- Structure de la table `processus_nonautoriser`
--

CREATE TABLE `processus_nonautoriser` (
  `nom_pros` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `processus_nonautoriser`
--

INSERT INTO `processus_nonautoriser` (`nom_pros`) VALUES
('WINWORD.EXE'),
('notepad.exe'),
('glcnd.exe');

-- --------------------------------------------------------

--
-- Structure de la table `professeur`
--

CREATE TABLE `professeur` (
  `cin` varchar(20) NOT NULL,
  `nom` varchar(20) DEFAULT NULL,
  `prenom` varchar(20) DEFAULT NULL,
  `motdepasse` varchar(20) DEFAULT NULL,
  `matiere` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `professeur`
--

INSERT INTO `professeur` (`cin`, `nom`, `prenom`, `motdepasse`, `matiere`) VALUES
('4545', 'El Hassnaoui', 'Mohammed', 'test', 'ruby'),
('64165', 'Aggagui', 'Yassine', 'test', 'CSS'),
('65156', 'Amchayd', 'Maryeme', 'test', 'python'),
('65161', 'Mohemmed', 'Rhattoy', 'test', 'javascript'),
('6546', 'Naciri', 'Samia', 'test', 'sql'),
('684565', 'El Hassnaoui', 'Mohammed', 'test', 'C'),
('X123456', 'LAHMAR', 'Ahmed', 'test', 'JAVA'),
('X654321', 'AGAG', 'Salma', 'test', 'PHP');

--
-- Index pour les tables exportées
--

--
-- Index pour la table `etudiant`
--
ALTER TABLE `etudiant`
  ADD PRIMARY KEY (`cne`);

--
-- Index pour la table `examen`
--
ALTER TABLE `examen`
  ADD PRIMARY KEY (`id_examen`),
  ADD KEY `cin` (`cin`),
  ADD KEY `cin_2` (`cin`);

--
-- Index pour la table `professeur`
--
ALTER TABLE `professeur`
  ADD PRIMARY KEY (`cin`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
