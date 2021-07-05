CREATE TABLE public.products(
    id int not null,
    name varchar,
    description varchar,
    price int,
    quantity int
);

CREATE SEQUENCE public.products_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE public.products_id_seq OWNED BY public.products.id;