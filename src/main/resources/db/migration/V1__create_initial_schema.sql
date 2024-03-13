CREATE TABLE BRANDS(
	ID INT PRIMARY KEY NOT NULL,
	NAME VARCHAR(50) not null
);

CREATE TABLE PRICES
(
	ID INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
	BRAND_ID INT NOT NULL,
	START_DATE TIMESTAMP NOT NULL,
	END_DATE TIMESTAMP NOT NULL,
	PRICE_LIST INT NOT NULL,
	PRODUCT_ID INT NOT NULL,
	PRIORITY INT NOT NULL,
	PRICE NUMERIC(5, 2) NOT NULL,
	CURR VARCHAR(5) NOT NULL,
	FOREIGN KEY (BRAND_ID) REFERENCES BRANDS(ID)
);