CREATE TYPE order_status AS ENUM ('In-Cart', 'Completed');

CREATE TABLE ORDERS
(o_id  serial PRIMARY key,
o_p_id  INT NOT NULL REFERENCES PRODUCT(p_id),
 o_su_id INT NOT NULL REFERENCES SHOPAHOLIC_USER(su_id),
o_date DATE,
o_qty INT NOT null,
o_totalprice FLOAT NOT NULL,
o_status order_status
);
