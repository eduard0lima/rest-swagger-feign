CREATE TABLE public.cotacao (
    id int PRIMARY KEY not null,
    data_requisicao timestamp not null,
    data_cotacao date not null,
    cotacao_compra varchar(10) not null,
    cotacao_venda varchar(10) not null
);

CREATE SEQUENCE public.seq_cotacao START 1;

