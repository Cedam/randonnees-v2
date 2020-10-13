use randonnees;

DROP TABLE `article`;
DROP TABLE `day`;
DROP TABLE `trek`; 

/**************************************************************************************************************/
/******************************** DEBUT GENERATION AUTOMATIQUE ************************************************/
/**************************************************************************************************************/

-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  Dim 03 nov. 2019 à 12:16
-- Version du serveur :  10.4.8-MariaDB
-- Version de PHP :  7.3.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `randonnees`
--

-- --------------------------------------------------------

--
-- Structure de la table `article`
--

CREATE TABLE `article` (
  `ID` bigint(20) NOT NULL,
  `NAME` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `day`
--

CREATE TABLE `day` (
  `ID` int(11) NOT NULL,
  `NUMBER` varchar(50) NOT NULL,
  `TREK_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `trek`
--

CREATE TABLE `trek` (
  `ID` int(11) NOT NULL,
  `NAME` varchar(50) NOT NULL,
  `YEAR` int(11) NULL,
  `LOCATION` varchar(50) NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `article`
--
ALTER TABLE `article`
  ADD PRIMARY KEY (`ID`);

--
-- Index pour la table `day`
--
ALTER TABLE `day`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FK_DAY_TREK` (`TREK_ID`);

--
-- Index pour la table `trek`
--
ALTER TABLE `trek`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `article`
--
ALTER TABLE `article`
  MODIFY `ID` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `day`
--
ALTER TABLE `day`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `trek`
--
ALTER TABLE `trek`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `day`
--
ALTER TABLE `day`
  ADD CONSTRAINT `FK_DAY_TREK` FOREIGN KEY (`TREK_ID`) REFERENCES `trek` (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;


/**************************************************************************************************************/
/********************************** FIN GENERATION AUTOMATIQUE ************************************************/
/**************************************************************************************************************/

GRANT USAGE ON *.* TO 'AdminDCO'@'%' IDENTIFIED BY PASSWORD '*854317ECEE4E927A2EFA277BEB3C0FAFF7616F1F';
GRANT ALL PRIVILEGES ON `randonnee`.* TO 'AdminDCO'@'%';

