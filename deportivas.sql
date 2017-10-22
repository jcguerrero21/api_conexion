-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 22-10-2017 a las 13:36:30
-- Versión del servidor: 10.1.19-MariaDB
-- Versión de PHP: 5.6.24

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `deportivas`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `descuentos`
--

CREATE TABLE `descuentos` (
  `id` int(11) NOT NULL,
  `tipo` varchar(30) NOT NULL,
  `codigo` varchar(6) NOT NULL,
  `id_usuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `fecha_alquiler_pista`
--

CREATE TABLE `fecha_alquiler_pista` (
  `usuario_id` int(11) NOT NULL,
  `pista_id` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `hora` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `horarios`
--

CREATE TABLE `horarios` (
  `id` int(2) NOT NULL,
  `hora` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `horarios`
--

INSERT INTO `horarios` (`id`, `hora`) VALUES
(1, '10:00:00'),
(2, '11:00:00'),
(3, '12:00:00'),
(4, '13:00:00'),
(5, '14:00:00'),
(6, '17:00:00'),
(7, '18:00:00'),
(8, '19:00:00'),
(9, '20:00:00'),
(10, '21:00:00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pistas`
--

CREATE TABLE `pistas` (
  `id` int(11) NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `tipo` varchar(20) NOT NULL,
  `ubicacion` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `pistas`
--

INSERT INTO `pistas` (`id`, `nombre`, `tipo`, `ubicacion`) VALUES
(1, 'futsal ''la suela''', 'futsal', 'el vivero'),
(2, 'futsal ''la elastica''', 'futsal', 'el faro'),
(3, 'futsal ''la elastica''', 'futsal', 'el faro');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `roles`
--

CREATE TABLE `roles` (
  `id` int(11) NOT NULL,
  `nombre` varchar(14) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `roles`
--

INSERT INTO `roles` (`id`, `nombre`) VALUES
(1, 'administrador'),
(2, 'usuario');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `apellidos` varchar(30) NOT NULL,
  `dni` varchar(9) NOT NULL,
  `fecha_alta` date NOT NULL,
  `localidad` varchar(30) DEFAULT NULL,
  `direccion` varchar(50) DEFAULT NULL,
  `id_rol` int(11) DEFAULT NULL,
  `nombre_usuario` varchar(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id`, `nombre`, `apellidos`, `dni`, `fecha_alta`, `localidad`, `direccion`, `id_rol`, `nombre_usuario`) VALUES
(5, 'juan carlos', 'guerrero moyano', '07272312J', '2017-10-22', 'Azuaga', 'estalajes 46', 2, 'jcguerrero21');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `descuentos`
--
ALTER TABLE `descuentos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_IdUsuario` (`id_usuario`);

--
-- Indices de la tabla `fecha_alquiler_pista`
--
ALTER TABLE `fecha_alquiler_pista`
  ADD PRIMARY KEY (`usuario_id`,`pista_id`),
  ADD KEY `fk_pisId` (`pista_id`),
  ADD KEY `fk_hora` (`hora`);

--
-- Indices de la tabla `horarios`
--
ALTER TABLE `horarios`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `pistas`
--
ALTER TABLE `pistas`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_IdRol` (`id_rol`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `descuentos`
--
ALTER TABLE `descuentos`
  ADD CONSTRAINT `fk_IdUsuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id`);

--
-- Filtros para la tabla `fecha_alquiler_pista`
--
ALTER TABLE `fecha_alquiler_pista`
  ADD CONSTRAINT `fk_hora` FOREIGN KEY (`hora`) REFERENCES `horarios` (`id`),
  ADD CONSTRAINT `fk_pisId` FOREIGN KEY (`pista_id`) REFERENCES `pistas` (`id`),
  ADD CONSTRAINT `fk_usId` FOREIGN KEY (`usuario_id`) REFERENCES `usuarios` (`id`);

--
-- Filtros para la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD CONSTRAINT `fk_IdRol` FOREIGN KEY (`id_rol`) REFERENCES `roles` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
