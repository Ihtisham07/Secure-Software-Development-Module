CREATE TABLE CUSTOMER (
    CUST_ID int,
    NAME varchar(255),
    STATUS varchar(1),
    ORDER_LIMIT int,
    HINT varchar(255) 
);

INSERT INTO CUSTOMER (CUST_ID, NAME, STATUS, ORDER_LIMIT, HINT) VALUES (1001, 'Arthur', 'A', 10000, '');
INSERT INTO CUSTOMER (CUST_ID, NAME, STATUS, ORDER_LIMIT, HINT) VALUES (1002, 'Ford', 'B', 5000, '');
INSERT INTO CUSTOMER (CUST_ID, NAME, STATUS, ORDER_LIMIT, HINT) VALUES (1003, 'John', 'C', 1000, '');
INSERT INTO CUSTOMER (CUST_ID, NAME, STATUS, ORDER_LIMIT, HINT) VALUES (1006, 'Christina', 'D', 100, '42');
