-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 01-Dez-2019 às 16:49
-- Versão do servidor: 10.4.8-MariaDB
-- versão do PHP: 7.3.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `rezerva`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `avaliacaolab`
--

CREATE TABLE `avaliacaolab` (
  `id` int(11) NOT NULL,
  `comentario` varchar(255) DEFAULT NULL,
  `nota` double DEFAULT NULL,
  `laboratorio_id` int(11) DEFAULT NULL,
  `pessoa_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `avaliacaolab`
--

INSERT INTO `avaliacaolab` (`id`, `comentario`, `nota`, `laboratorio_id`, `pessoa_id`) VALUES
(3, 'Laboratório com boa infraestrutura para o qual é designado.', 9.1, 1, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `equipamento`
--

CREATE TABLE `equipamento` (
  `Id` int(11) NOT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `tipoequipamento_Id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `equipamento`
--

INSERT INTO `equipamento` (`Id`, `nome`, `tipoequipamento_Id`) VALUES
(1, 'Monitor', 1),
(2, 'Mouse e Teclado', 1),
(3, 'Gabinete', 1),
(4, 'Bancada', 2),
(5, 'Cadeira', 2);

-- --------------------------------------------------------

--
-- Estrutura da tabela `equipamentoslab`
--

CREATE TABLE `equipamentoslab` (
  `id` int(11) NOT NULL,
  `qtde` int(11) DEFAULT NULL,
  `equipamento_Id` int(11) DEFAULT NULL,
  `laboratorio_id` int(11) DEFAULT NULL,
  `lab_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `equipamentoslab`
--

INSERT INTO `equipamentoslab` (`id`, `qtde`, `equipamento_Id`, `laboratorio_id`, `lab_id`) VALUES
(1, 30, 5, NULL, 1),
(2, 10, 4, NULL, 1),
(3, 10, 1, NULL, 3),
(4, 10, 2, NULL, 3),
(5, 10, 3, NULL, 3),
(6, 4, 4, NULL, 3),
(7, 10, 5, NULL, 3);

-- --------------------------------------------------------

--
-- Estrutura da tabela `laboratorio`
--

CREATE TABLE `laboratorio` (
  `id` int(11) NOT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `numero` int(11) NOT NULL,
  `tipolab_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `laboratorio`
--

INSERT INTO `laboratorio` (`id`, `nome`, `numero`, `tipolab_id`) VALUES
(1, 'laboratório de estudos 1', 18, 2),
(3, 'Laboratório de Programação 1', 14, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `pessoa`
--

CREATE TABLE `pessoa` (
  `id` int(11) NOT NULL,
  `curso` varchar(255) DEFAULT NULL,
  `matricula` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `senha` varchar(255) DEFAULT NULL,
  `tipopessoa_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `pessoa`
--

INSERT INTO `pessoa` (`id`, `curso`, `matricula`, `nome`, `senha`, `tipopessoa_id`) VALUES
(1, 'ccomp', '1214100517', 'Diogo Evanio de Ávila', '123456', 1),
(2, 'CComp', '13181000123', 'Marcelo Filho', '12345', 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `reportar`
--

CREATE TABLE `reportar` (
  `id` int(11) NOT NULL,
  `problema` varchar(255) DEFAULT NULL,
  `laboratorio_id` int(11) DEFAULT NULL,
  `pessoa_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `reportar`
--

INSERT INTO `reportar` (`id`, `problema`, `laboratorio_id`, `pessoa_id`) VALUES
(4, 'Maquinas não Ligam', 3, 2);

-- --------------------------------------------------------

--
-- Estrutura da tabela `reserva`
--

CREATE TABLE `reserva` (
  `id` int(11) NOT NULL,
  `data` datetime DEFAULT NULL,
  `laboratorio_id` int(11) DEFAULT NULL,
  `usuario_id` int(11) DEFAULT NULL,
  `pessoa_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `reserva`
--

INSERT INTO `reserva` (`id`, `data`, `laboratorio_id`, `usuario_id`, `pessoa_id`) VALUES
(1, '2019-11-27 00:00:00', 1, NULL, 1),
(3, '2019-12-02 00:00:00', 1, NULL, 1),
(4, '2019-11-05 00:00:00', 3, NULL, 2),
(5, '2019-12-05 00:00:00', 3, NULL, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `tipoequipamento`
--

CREATE TABLE `tipoequipamento` (
  `Id` int(11) NOT NULL,
  `nome` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `tipoequipamento`
--

INSERT INTO `tipoequipamento` (`Id`, `nome`) VALUES
(1, 'periférico'),
(2, 'infraestrutura'),
(4, 'Apoio');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tipolab`
--

CREATE TABLE `tipolab` (
  `id` int(11) NOT NULL,
  `nome` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `tipolab`
--

INSERT INTO `tipolab` (`id`, `nome`) VALUES
(1, 'Programação'),
(2, 'Estudos'),
(3, 'Redes');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tipopessoa`
--

CREATE TABLE `tipopessoa` (
  `id` int(11) NOT NULL,
  `tipo` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `tipopessoa`
--

INSERT INTO `tipopessoa` (`id`, `tipo`) VALUES
(1, 'Aluno'),
(2, 'Professor');

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `avaliacaolab`
--
ALTER TABLE `avaliacaolab`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK959tbk6vqsnf9mhx8kfyihmxj` (`laboratorio_id`),
  ADD KEY `FKm9ytfh9eglo8d9lusm7gxvta0` (`pessoa_id`);

--
-- Índices para tabela `equipamento`
--
ALTER TABLE `equipamento`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `FK9mecuiesq7en7b5awlfid50r1` (`tipoequipamento_Id`);

--
-- Índices para tabela `equipamentoslab`
--
ALTER TABLE `equipamentoslab`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKiu4np9k01mdh8ey5qwf87fdnl` (`equipamento_Id`),
  ADD KEY `FKt6ux487buk483528qryaucdi8` (`laboratorio_id`),
  ADD KEY `FK94sl5wcwc07b06r7o9h2mb5j1` (`lab_id`);

--
-- Índices para tabela `laboratorio`
--
ALTER TABLE `laboratorio`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKmob2968ayf2n6thak937xmy73` (`tipolab_id`);

--
-- Índices para tabela `pessoa`
--
ALTER TABLE `pessoa`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKky2djs556dtyc1njoycdoofaw` (`tipopessoa_id`);

--
-- Índices para tabela `reportar`
--
ALTER TABLE `reportar`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK4dg6i60d5xpttk1ixplw5raat` (`laboratorio_id`),
  ADD KEY `FK8tbhrnh5onp8mcgfqt3kon0ry` (`pessoa_id`);

--
-- Índices para tabela `reserva`
--
ALTER TABLE `reserva`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK7blnk0lnpf81kemb7h6xnfm7n` (`laboratorio_id`),
  ADD KEY `FKkbhfmxjdrwpm4rguaukcrde5` (`usuario_id`),
  ADD KEY `FK3a8eavqu6ol8h7fqd7wqokpy3` (`pessoa_id`);

--
-- Índices para tabela `tipoequipamento`
--
ALTER TABLE `tipoequipamento`
  ADD PRIMARY KEY (`Id`);

--
-- Índices para tabela `tipolab`
--
ALTER TABLE `tipolab`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `tipopessoa`
--
ALTER TABLE `tipopessoa`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `avaliacaolab`
--
ALTER TABLE `avaliacaolab`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de tabela `equipamento`
--
ALTER TABLE `equipamento`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de tabela `equipamentoslab`
--
ALTER TABLE `equipamentoslab`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de tabela `laboratorio`
--
ALTER TABLE `laboratorio`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de tabela `pessoa`
--
ALTER TABLE `pessoa`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de tabela `reportar`
--
ALTER TABLE `reportar`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de tabela `reserva`
--
ALTER TABLE `reserva`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de tabela `tipoequipamento`
--
ALTER TABLE `tipoequipamento`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de tabela `tipolab`
--
ALTER TABLE `tipolab`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de tabela `tipopessoa`
--
ALTER TABLE `tipopessoa`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `avaliacaolab`
--
ALTER TABLE `avaliacaolab`
  ADD CONSTRAINT `FK959tbk6vqsnf9mhx8kfyihmxj` FOREIGN KEY (`laboratorio_id`) REFERENCES `laboratorio` (`id`),
  ADD CONSTRAINT `FKm9ytfh9eglo8d9lusm7gxvta0` FOREIGN KEY (`pessoa_id`) REFERENCES `pessoa` (`id`);

--
-- Limitadores para a tabela `equipamento`
--
ALTER TABLE `equipamento`
  ADD CONSTRAINT `FK9mecuiesq7en7b5awlfid50r1` FOREIGN KEY (`tipoequipamento_Id`) REFERENCES `tipoequipamento` (`Id`);

--
-- Limitadores para a tabela `equipamentoslab`
--
ALTER TABLE `equipamentoslab`
  ADD CONSTRAINT `FK94sl5wcwc07b06r7o9h2mb5j1` FOREIGN KEY (`lab_id`) REFERENCES `laboratorio` (`id`),
  ADD CONSTRAINT `FKiu4np9k01mdh8ey5qwf87fdnl` FOREIGN KEY (`equipamento_Id`) REFERENCES `equipamento` (`Id`),
  ADD CONSTRAINT `FKt6ux487buk483528qryaucdi8` FOREIGN KEY (`laboratorio_id`) REFERENCES `laboratorio` (`id`);

--
-- Limitadores para a tabela `laboratorio`
--
ALTER TABLE `laboratorio`
  ADD CONSTRAINT `FKmob2968ayf2n6thak937xmy73` FOREIGN KEY (`tipolab_id`) REFERENCES `tipolab` (`id`);

--
-- Limitadores para a tabela `pessoa`
--
ALTER TABLE `pessoa`
  ADD CONSTRAINT `FKky2djs556dtyc1njoycdoofaw` FOREIGN KEY (`tipopessoa_id`) REFERENCES `tipopessoa` (`id`);

--
-- Limitadores para a tabela `reportar`
--
ALTER TABLE `reportar`
  ADD CONSTRAINT `FK4dg6i60d5xpttk1ixplw5raat` FOREIGN KEY (`laboratorio_id`) REFERENCES `laboratorio` (`id`),
  ADD CONSTRAINT `FK8tbhrnh5onp8mcgfqt3kon0ry` FOREIGN KEY (`pessoa_id`) REFERENCES `pessoa` (`id`);

--
-- Limitadores para a tabela `reserva`
--
ALTER TABLE `reserva`
  ADD CONSTRAINT `FK3a8eavqu6ol8h7fqd7wqokpy3` FOREIGN KEY (`pessoa_id`) REFERENCES `pessoa` (`id`),
  ADD CONSTRAINT `FK7blnk0lnpf81kemb7h6xnfm7n` FOREIGN KEY (`laboratorio_id`) REFERENCES `laboratorio` (`id`),
  ADD CONSTRAINT `FKkbhfmxjdrwpm4rguaukcrde5` FOREIGN KEY (`usuario_id`) REFERENCES `pessoa` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
