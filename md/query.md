```
CREATE DATABASE coffee_space;
ADD DATAFILE '/var/lib/mysql/coffee_space.ibd'
ENGINE = InnoDB
FILE_BLOCK_SIZE = 8192;

CREATE TABLE PRODUCT_MENU (
    MENU_ID varchar(20) not null
    MENU_NAME varchar(200)
    MENU_NAME_EN varchar(200)
    MENU_FILTER varchar(200)
    MENU_FILTER_EN varchar(200)
    COFFEE_BRAND_DIV_CD(4)
    ICE_HOT_DIV_CD varchar(10)
    ENABLE_SIZE varchar(20)
    PRICE number(10)
    IMAGE CLOB
    constraint product_pk primary key(MENU_ID)
);

insert into PRODUCT_MENU( MENU_ID,MENU_NAME,MENU_NAME_EN,MENU_FILTER,MENU_FILTER_EN,COFFEE_BRAND_DIV_CD,ICE_HOT_DIV_CD,ENABLE_SIZE,PRICE) values (

)

```

