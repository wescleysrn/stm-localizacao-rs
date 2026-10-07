CREATE TABLE tb_regiao (
  sigla VARCHAR(2) NOT NULL,
  nome VARCHAR(50),
  CONSTRAINT tb_regiao_pkey PRIMARY KEY (sigla)
);

CREATE TABLE tb_uf (
  codigo_ibge VARCHAR(2) NOT NULL,
  nome VARCHAR(40),
  sigla VARCHAR(2),
  regiao_fk VARCHAR(2),
  id_sei BIGINT,
  CONSTRAINT tb_uf_pkey PRIMARY KEY (codigo_ibge),
  CONSTRAINT regiao_fkc FOREIGN KEY (regiao_fk) REFERENCES tb_regiao (sigla)
);

CREATE TABLE tb_meso_regiao (
  codigo_ibge_completo VARCHAR(4) NOT NULL,
  codigo_ibge VARCHAR(2),
  nome VARCHAR(100),
  uf_fk VARCHAR(2),
  CONSTRAINT tb_meso_regiao_pkey PRIMARY KEY (codigo_ibge_completo),
  CONSTRAINT uf_fkc FOREIGN KEY (uf_fk) REFERENCES tb_uf (codigo_ibge)
);

CREATE TABLE tb_micro_regiao (
  codigo_ibge_completo VARCHAR(5) NOT NULL,
  codigo_ibge VARCHAR(3),
  nome VARCHAR(100),
  meso_regiao_fk VARCHAR(4),
  CONSTRAINT tb_micro_regiao_pkey PRIMARY KEY (codigo_ibge_completo),
  CONSTRAINT meso_regiao_fkc FOREIGN KEY (meso_regiao_fk) REFERENCES tb_meso_regiao (codigo_ibge_completo)
);

CREATE TABLE tb_municipio (
  codigo_ibge_completo VARCHAR(7) NOT NULL,
  codigo_ibge VARCHAR(5),
  nome VARCHAR(200),
  micro_regiao_fk VARCHAR(5),
  uf_fk VARCHAR(2),
  id_sei BIGINT,
  CONSTRAINT tb_municipio_pkey PRIMARY KEY (codigo_ibge_completo),
  CONSTRAINT micro_regiao_fkc FOREIGN KEY (micro_regiao_fk) REFERENCES tb_micro_regiao (codigo_ibge_completo),
  CONSTRAINT uf_fkc_mun FOREIGN KEY (uf_fk) REFERENCES tb_uf (codigo_ibge)
);

CREATE TABLE tb_distrito (
  codigo_ibge_completo VARCHAR(9) NOT NULL,
  codigo_ibge VARCHAR(2),
  nome VARCHAR(150),
  municipio_fk VARCHAR(7),
  CONSTRAINT tb_distrito_pkey PRIMARY KEY (codigo_ibge_completo),
  CONSTRAINT municipio_fkc FOREIGN KEY (municipio_fk) REFERENCES tb_municipio (codigo_ibge_completo)
);

CREATE TABLE tb_sub_distrito (
  codigo_ibge_completo VARCHAR(11) NOT NULL,
  codigo_ibge VARCHAR(2),
  nome VARCHAR(150),
  distrito_fk VARCHAR(9),
  CONSTRAINT tb_sub_distrito_pkey PRIMARY KEY (codigo_ibge_completo),
  CONSTRAINT distrito_fkc FOREIGN KEY (distrito_fk) REFERENCES tb_distrito (codigo_ibge_completo)
);
