CREATE TABLE public.products
(
    id          int not null,
    name        varchar,
    description varchar,
    price       int,
    quantity    int
);

CREATE SEQUENCE public.products_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE CACHE 1;

ALTER SEQUENCE public.products_id_seq OWNED BY public.products.id;

ALTER TABLE ONLY public.products ADD CONSTRAINT products_pkey PRIMARY KEY (id);

CREATE TABLE public.events
(
    id              varchar not null,
    subject         varchar,
    start_date_time date,
    event_length    int,
    description     varchar
);
ALTER TABLE ONLY public.events ADD CONSTRAINT events_pkey PRIMARY KEY (id);

CREATE TABLE public.users
(
    id        int not null,
    login     varchar,
    password  varchar,
    privilege varchar
);

CREATE SEQUENCE public.users_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE CACHE 1;

ALTER SEQUENCE public.users_id_seq OWNED BY public.users.id;
ALTER TABLE ONLY public.users ADD CONSTRAINT users_pkey PRIMARY KEY (id);
ALTER TABLE ONLY public.users ADD CONSTRAINT uc_users_login UNIQUE (login);