CREATE TABLE netology.CUSTOMERS
( id BIGSERIAL PRIMARY KEY,
  name varchar(50),
  surname varchar(50),
  age int,
  phone_number varchar(50)
);
CREATE TABLE netology.orders
(
    id bigserial,
    date date,
    custamer_id bigint,
    product_name character varying(255) NOT NULL,
    amount bigint NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT customer_fkey FOREIGN KEY (custamer_id)
        REFERENCES netology.customers (id) MATCH SIMPLE
        ON UPDATE SET NULL
        ON DELETE SET NULL
        NOT VALID
);