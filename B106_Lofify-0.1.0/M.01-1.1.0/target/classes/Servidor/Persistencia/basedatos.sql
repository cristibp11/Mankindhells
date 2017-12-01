CREATE TABLE `albumes` (
  `idAlbum` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `precio` double NOT NULL,
  `artista` varchar(45) NOT NULL,
  PRIMARY KEY (`idAlbum`),
  UNIQUE KEY `idAlbum_UNIQUE` (`idAlbum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ;

CREATE TABLE `artistas` (
  `id_artista` int(11) NOT NULL,
  `Nombre` varchar(45) NOT NULL,
  `Descripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_artista`),
  UNIQUE KEY `id_artista_UNIQUE` (`id_artista`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `canciones` (
  `idCanciones` int(11) NOT NULL,
  `titulo` varchar(45) NOT NULL,
  `album` varchar(45) NOT NULL,
  `precio` double NOT NULL,
  `metadatos` varchar(45) NOT NULL,
  PRIMARY KEY (`idCanciones`),
  UNIQUE KEY `idCanciones_UNIQUE` (`idCanciones`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
