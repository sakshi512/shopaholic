CREATE TABLE PRODUCT
(p_id  serial PRIMARY key,
 p_catid INT NOT NULL references PRODUCT_CATEGORY(pc_catid),
p_name Varchar(50) NOT null,
p_description Varchar(50) NOT null,
p_price FLOAT NOT null,
p_discount INT NOT null,
p_image VARCHAR(300) NOT null,
p_color Varchar(30) NOT null,
p_creationdate DATE NOT NULL
);
