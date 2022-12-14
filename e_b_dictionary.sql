-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:tcp
-- Generation Time: Mar 23, 2017 at 06:13 AM
-- Server version: 10.1.21-MariaDB
-- PHP Version: 7.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `e_b_dictionary`
--

-- --------------------------------------------------------

--
-- Table structure for table `rule`
--

CREATE TABLE `rule` (
  `id` int(10) NOT NULL,
  `bangla_rule` varchar(20) NOT NULL,
  `english_rule` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `rule`
--

INSERT INTO `rule` (`id`, `bangla_rule`, `english_rule`) VALUES
(1, 'NP Adj N V', 'NP Aux V N Adj'),
(2, 'NP NN Det V', 'NP Aux V Det NN'),
(3, 'NP Qntfr NN V', 'NP Aux V Qntfr NN'),
(4, 'NP NN Biv V', 'NP Aux V NN'),
(5, 'NP NN V', 'NP Aux V NN'),
(6, 'NP Qntfr Adj NN V', 'NP V Qntfr Adj NN');

-- --------------------------------------------------------

--
-- Table structure for table `verb`
--

CREATE TABLE `verb` (
  `id` int(20) NOT NULL,
  `root` varchar(10) NOT NULL,
  `person` varchar(10) NOT NULL,
  `past` varchar(10) NOT NULL,
  `participle` varchar(10) NOT NULL,
  `continuous` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `verb`
--

INSERT INTO `verb` (`id`, `root`, `person`, `past`, `participle`, `continuous`) VALUES
(1, 'know', 'knows', 'knew', 'known', 'knowing'),
(2, 'do', 'does', 'did', 'done', 'doing'),
(3, 'write', 'writes', 'wrote', 'written', 'writing'),
(4, 'want', 'wants', 'wanted', 'wanted', 'wanting'),
(5, 'can', 'can', 'could', 'could', 'can'),
(6, 'go to', 'goes to', 'went to', 'gone to', 'going to'),
(7, 'play', 'plays', 'played', 'played', 'playing'),
(8, 'come', 'comes', 'came', 'come', 'coming'),
(9, 'go', 'goes', 'went', 'gone', 'going'),
(10, 'sleep', 'sleeps', 'slept', 'slept', 'sleeping');

-- --------------------------------------------------------

--
-- Table structure for table `word_meaning`
--

CREATE TABLE `word_meaning` (
  `id` int(11) NOT NULL,
  `english_word` varchar(40) NOT NULL,
  `bangla_word` varchar(40) CHARACTER SET utf8 NOT NULL,
  `Features` varchar(40) NOT NULL,
  `Person` varchar(40) NOT NULL,
  `Type` varchar(40) NOT NULL,
  `Tense` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `word_meaning`
--

INSERT INTO `word_meaning` (`id`, `english_word`, `bangla_word`, `Features`, `Person`, `Type`, `Tense`) VALUES
(131, 'He', '??????', 'NP', '31', '', ''),
(132, 'work', '?????????', 'NN', '', '', ''),
(133, 'the', '??????', 'Det', '', '', ''),
(134, 'do', '??????', 'V', '', '', ''),
(135, 'He', '????????????', 'NP', '31', '', ''),
(136, 'poem', '???????????????', 'NN', '', '', ''),
(137, 'write', '?????????', 'V', '', '', ''),
(138, 'a', '????????????', 'Qntfr', '', '', ''),
(139, 'Karim', '????????????', 'NP', '31', '', ''),
(140, 'toy', '???????????????', 'NN', '', '', ''),
(141, 'want', '??????', 'V', '', '', ''),
(142, 'can', '?????????', 'V', '', '', ''),
(143, 'dance', '?????????', 'NN', '', '', ''),
(144, 'Mishu', '????????????', 'NP', '31', '', ''),
(145, '', '??????', 'Biv', '', '', ''),
(146, '', '???', 'Biv', '', '', ''),
(147, 'school', '????????????????????????', 'NN', '', '', ''),
(148, 'go to', '????????????', 'V', '', '', ''),
(149, 'Jamal', '???????????????', 'NP', '31', '', ''),
(150, 'football', '???????????????', 'NN', '', '', ''),
(151, 'play', '?????????', 'V', '', '', ''),
(152, 'I', '?????????', 'NP', '11', '', ''),
(153, 'want', '??????', 'V', '', '', ''),
(154, 'red', '?????????', 'Adj', '', '', ''),
(155, 'flower', '?????????', 'NN', '', '', ''),
(156, 'tomorrow', '?????????', 'NN', '', '', ''),
(157, 'come', '??????', 'V', '', '', ''),
(158, 'We', '????????????', 'NP', '12', '', ''),
(159, 'home', '????????????', 'NN', '', '', ''),
(160, 'go', '??????', 'V', '', '', ''),
(161, 'at night', '????????????', 'NN', '', '', ''),
(162, 'sleep', '????????????', 'V', '', '', '');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `rule`
--
ALTER TABLE `rule`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `verb`
--
ALTER TABLE `verb`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `word_meaning`
--
ALTER TABLE `word_meaning`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `rule`
--
ALTER TABLE `rule`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `verb`
--
ALTER TABLE `verb`
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT for table `word_meaning`
--
ALTER TABLE `word_meaning`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=163;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
