CREATE USER auth_user WITH PASSWORD 'auth_password';
CREATE USER user_user WITH PASSWORD 'user_password';
CREATE USER inventory_user WITH PASSWORD 'inventory_password';
CREATE USER order_user WITH PASSWORD 'order_password';

CREATE DATABASE "auth-service" OWNER auth_user;
CREATE DATABASE "user-service" OWNER user_user;
CREATE DATABASE "inventory-service" OWNER inventory_user;
CREATE DATABASE "order-service" OWNER order_user;
