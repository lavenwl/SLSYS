DROP TABLE "base_user";
DROP TABLE "base_role";
DROP TABLE "ws_user_info";
DROP TABLE "ws_company";
DROP TABLE "ws_order";
DROP TABLE "ws_item";
DROP TABLE "ws_goods";
DROP TABLE "ws_goods_type";
DROP TABLE "ws_sale_mode";

CREATE TABLE "base_user" (
"id" INTEGER NOT NULL,
"username" CHARACTER VARYING(100) NOT NULL,
"password" CHARACTER VARYING(255) NOT NULL,
"phone" CHARACTER VARYING(20) NULL,
"role_id" INTEGER NOT NULL 1,
"create_date" TIMESTAMP NULL DEFAULT NULL,
"update_date" TIMESTAMP NULL DEFAULT NULL,
"state" INTEGER NULL 1,
PRIMARY KEY ("id") 
);

CREATE TABLE "base_role" (
"id" INTEGER NOT NULL,
"name" CHARACTER VARYING(100) NOT NULL,
"create_date" TIMESTAMP NULL DEFAULT NULL,
"update_date" TIMESTAMP NULL DEFAULT NULL,
"state" INTEGER NULL 1,
PRIMARY KEY ("id") 
);

CREATE TABLE "ws_user_info" (
"id" INTEGER NOT NULL,
"user_id" INTEGER NOT NULL,
"company_id" INTEGER NOT NULL,
"phone" CHARACTER VARYING(20) NULL,
"create_date" TIMESTAMP NULL DEFAULT NULL,
"update_date" TIMESTAMP NULL DEFAULT NULL,
"state" INTEGER NULL 1,
PRIMARY KEY ("id") 
);

CREATE TABLE "ws_company" (
"id" INTEGER NOT NULL,
"company_name" CHARACTER VARYING(255) NULL,
"phone" CHARACTER VARYING(20) NULL,
"address" CHARACTER VARYING(255) NULL,
"create_date" TIMESTAMP NULL DEFAULT NULL,
"update_date" TIMESTAMP NULL DEFAULT NULL,
"state" INTEGER NULL 1,
PRIMARY KEY ("id") 
);

CREATE TABLE "ws_order" (
"id" INTEGER NOT NULL,
"sale" INTEGER NULL,
"purchase" INTEGER NULL,
"sum_money" DECIMAL(8,8) NULL 0,
"money" DECIMAL(8,8) NULL 0,
"create_date" TIMESTAMP NULL DEFAULT NULL,
"update_date" TIMESTAMP NULL DEFAULT NULL,
"state" INTEGER NULL 1,
PRIMARY KEY ("id") 
);

CREATE TABLE "ws_item" (
"id" INTEGER NOT NULL,
"order_id" INTEGER NULL,
"goods_id" INTEGER NULL,
"num" INTEGER NULL,
"sale_mode_id" INTEGER NULL,
"create_date" TIMESTAMP NULL DEFAULT NULL,
"update_date" TIMESTAMP NULL DEFAULT NULL,
"state" INTEGER NULL 1,
PRIMARY KEY ("id") 
);

CREATE TABLE "ws_goods" (
"id" INTEGER NOT NULL,
"name" CHARACTER VARYING(255) NULL,
"type_id" INTEGER NULL,
"spec" CHARACTER VARYING(255) NULL,
"brand" CHARACTER VARYING(255) NULL,
"provider" INTEGER NULL,
"create_date" TIMESTAMP NULL DEFAULT NULL,
"update_date" TIMESTAMP NULL DEFAULT NULL,
"state" INTEGER NULL 1,
PRIMARY KEY ("id") 
);

CREATE TABLE "ws_goods_type" (
"id" INTEGER NOT NULL,
"name" CHARACTER VARYING(255) NULL,
"create_date" TIMESTAMP NULL DEFAULT NULL,
"update_date" TIMESTAMP NULL DEFAULT NULL,
"state" INTEGER NULL 1,
PRIMARY KEY ("id") 
);

CREATE TABLE "ws_sale_mode" (
"id" INTEGER NOT NULL,
"name" CHARACTER VARYING(255) NULL,
"create_date" TIMESTAMP NULL DEFAULT NULL,
"update_date" TIMESTAMP NULL DEFAULT NULL,
"state" INTEGER NULL 1,
PRIMARY KEY ("id") 
);


ALTER TABLE "base_user" ADD CONSTRAINT "fk_user" FOREIGN KEY ("role_id") REFERENCES "base_role" ("id");
ALTER TABLE "ws_user_info" ADD CONSTRAINT "fk_user_info" FOREIGN KEY ("company_id") REFERENCES "ws_company" ("id");
ALTER TABLE "ws_user_info" ADD CONSTRAINT "fk_user_info_1" FOREIGN KEY ("user_id") REFERENCES "base_user" ("id");
ALTER TABLE "ws_order" ADD CONSTRAINT "fk_order" FOREIGN KEY ("sale") REFERENCES "ws_user_info" ("user_id");
ALTER TABLE "ws_order" ADD CONSTRAINT "fk_order_1" FOREIGN KEY ("purchase") REFERENCES "ws_user_info" ("user_id");
ALTER TABLE "ws_goods" ADD CONSTRAINT "fk_goods" FOREIGN KEY ("type_id") REFERENCES "ws_goods_type" ("id");
ALTER TABLE "ws_item" ADD CONSTRAINT "fk_item" FOREIGN KEY ("goods_id") REFERENCES "ws_goods" ("id");
ALTER TABLE "ws_item" ADD CONSTRAINT "fk_item_1" FOREIGN KEY ("sale_mode_id") REFERENCES "ws_sale_mode" ("id");
ALTER TABLE "ws_item" ADD CONSTRAINT "fk_item_2" FOREIGN KEY ("order_id") REFERENCES "ws_order" ("id");

