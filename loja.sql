-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 17-Jan-2021 às 22:36
-- Versão do servidor: 10.4.13-MariaDB
-- versão do PHP: 7.2.32

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `loja`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `cliente`
--

CREATE TABLE `cliente` (
  `nome` varchar(90) NOT NULL,
  `usuario` varchar(90) NOT NULL,
  `CPF` varchar(90) NOT NULL,
  `contato` varchar(90) NOT NULL,
  `endereco` varchar(90) NOT NULL,
  `estado` char(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `cliente`
--

INSERT INTO `cliente` (`nome`, `usuario`, `CPF`, `contato`, `endereco`, `estado`) VALUES
('kaique nakao', 'func', '12345678911', '222231232', 'rua babababa', 'SP');

-- --------------------------------------------------------

--
-- Estrutura da tabela `funcionario`
--

CREATE TABLE `funcionario` (
  `nome` varchar(90) NOT NULL,
  `usuario` varchar(90) NOT NULL,
  `CPF` varchar(90) NOT NULL,
  `contato` varchar(90) NOT NULL,
  `endereco` varchar(90) NOT NULL,
  `estado` char(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `funcionario`
--

INSERT INTO `funcionario` (`nome`, `usuario`, `CPF`, `contato`, `endereco`, `estado`) VALUES
('kaique', 'teste@123', '12345678911', '12314123', '12312412767', 'AM'),
('testeteste', 'oliveira', '12345678917', '22334242', '123124125', 'DF');

--
-- Acionadores `funcionario`
--
DELIMITER $$
CREATE TRIGGER `Tg_Funcionario_Delete` AFTER DELETE ON `funcionario` FOR EACH ROW BEGIN
	delete from login where login.usuario = old.usuario;
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `Tg_Funcionario_Update` BEFORE UPDATE ON `funcionario` FOR EACH ROW BEGIN
	update login set login.usuario = new.usuario
    where login.usuario = old.usuario;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `login`
--

CREATE TABLE `login` (
  `usuario` varchar(100) NOT NULL,
  `senha` varchar(90) NOT NULL,
  `nivel` enum('Funcionario','Gerente') DEFAULT NULL CHECK (`nivel` <> '')
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `login`
--

INSERT INTO `login` (`usuario`, `senha`, `nivel`) VALUES
('oliveira', '12345678', 'Funcionario'),
('teste@123', '12345678', 'Gerente');

-- --------------------------------------------------------

--
-- Estrutura da tabela `produto`
--

CREATE TABLE `produto` (
  `codigo` int(11) NOT NULL,
  `nome` varchar(90) NOT NULL,
  `preco` float(10,2) NOT NULL,
  `tipo` varchar(90) NOT NULL,
  `quantidade` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `produto`
--

INSERT INTO `produto` (`codigo`, `nome`, `preco`, `tipo`, `quantidade`) VALUES
(4, 'Switch', 300.00, 'Rede', 5),
(5, 'Placa mãe', 6000.00, 'Hardware', 5),
(6, 'Memoria ram', 200.00, 'Hardware', 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `venda`
--

CREATE TABLE `venda` (
  `codnota` int(11) NOT NULL,
  `datavenda` datetime DEFAULT current_timestamp(),
  `codfunc` varchar(12) DEFAULT NULL,
  `codcli` varchar(12) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `venda`
--

INSERT INTO `venda` (`codnota`, `datavenda`, `codfunc`, `codcli`) VALUES
(8, '2021-01-15 19:23:26', '12345678911', '12345678911'),
(9, '2021-01-15 19:25:09', '12345678911', '12345678911'),
(10, '2021-01-15 19:26:07', '12345678911', '12345678911'),
(11, '2021-01-15 19:26:35', '12345678911', '12345678911'),
(12, '2021-01-15 19:46:38', '12345678911', '12345678911'),
(14, '2021-01-15 19:53:49', '12345678911', '12345678911'),
(15, '2021-01-15 19:54:06', '12345678911', '12345678911'),
(16, '2021-01-17 17:51:54', '12345678911', '12345678911');

-- --------------------------------------------------------

--
-- Estrutura da tabela `venda_produto`
--

CREATE TABLE `venda_produto` (
  `codvenda` int(11) NOT NULL,
  `codpro` int(11) NOT NULL,
  `preco` float(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `venda_produto`
--

INSERT INTO `venda_produto` (`codvenda`, `codpro`, `preco`) VALUES
(8, 4, 300.00),
(8, 5, 6000.00),
(8, 6, 200.00),
(9, 4, 300.00),
(9, 5, 6000.00),
(9, 6, 200.00),
(10, 5, 6000.00),
(10, 5, 6000.00),
(10, 6, 200.00),
(10, 6, 200.00),
(10, 4, 300.00),
(11, 4, 300.00),
(11, 5, 6000.00),
(11, 4, 300.00),
(11, 4, 300.00),
(11, 4, 300.00),
(12, 4, 300.00),
(12, 5, 6000.00),
(12, 6, 200.00),
(14, 4, 300.00),
(14, 5, 6000.00),
(14, 6, 200.00),
(14, 6, 200.00),
(15, 4, 300.00),
(15, 6, 200.00),
(16, 4, 300.00),
(16, 4, 300.00);

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`CPF`);

--
-- Índices para tabela `funcionario`
--
ALTER TABLE `funcionario`
  ADD PRIMARY KEY (`CPF`),
  ADD UNIQUE KEY `usuario` (`usuario`),
  ADD UNIQUE KEY `usuario_2` (`usuario`);

--
-- Índices para tabela `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`usuario`);

--
-- Índices para tabela `produto`
--
ALTER TABLE `produto`
  ADD PRIMARY KEY (`codigo`);

--
-- Índices para tabela `venda`
--
ALTER TABLE `venda`
  ADD PRIMARY KEY (`codnota`),
  ADD KEY `codfunc` (`codfunc`),
  ADD KEY `codcli` (`codcli`);

--
-- Índices para tabela `venda_produto`
--
ALTER TABLE `venda_produto`
  ADD KEY `codvenda` (`codvenda`),
  ADD KEY `codpro` (`codpro`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `produto`
--
ALTER TABLE `produto`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de tabela `venda`
--
ALTER TABLE `venda`
  MODIFY `codnota` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `funcionario`
--
ALTER TABLE `funcionario`
  ADD CONSTRAINT `FK_funclogin` FOREIGN KEY (`usuario`) REFERENCES `login` (`usuario`);

--
-- Limitadores para a tabela `venda`
--
ALTER TABLE `venda`
  ADD CONSTRAINT `venda_ibfk_1` FOREIGN KEY (`codfunc`) REFERENCES `funcionario` (`CPF`),
  ADD CONSTRAINT `venda_ibfk_2` FOREIGN KEY (`codcli`) REFERENCES `cliente` (`CPF`);

--
-- Limitadores para a tabela `venda_produto`
--
ALTER TABLE `venda_produto`
  ADD CONSTRAINT `venda_produto_ibfk_1` FOREIGN KEY (`codvenda`) REFERENCES `venda` (`codnota`),
  ADD CONSTRAINT `venda_produto_ibfk_2` FOREIGN KEY (`codpro`) REFERENCES `produto` (`codigo`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
