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
    owner_id        int     not null,
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

/*CREATE TABLE public.events_users
(
    event_id varchar NOT NULL,
    users_id  bigint  NOT NULL
);

ALTER TABLE ONLY public.events_users
    ADD CONSTRAINT events_users_pkey PRIMARY KEY (event_id, users_id);

ALTER TABLE ONLY public.events_users
    ADD CONSTRAINT fk_eu_events FOREIGN KEY (event_id) REFERENCES public.events (id);

ALTER TABLE ONLY public.events_users
    ADD CONSTRAINT fk_eu_users FOREIGN KEY (users_id) REFERENCES public.users (id);*/