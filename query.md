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
    constraint product_pk primary key(MENU_ID)
);

insert into PRODUCT_MENU( MENU_ID,MENU_NAME,MENU_NAME_EN,MENU_FILTER,MENU_FILTER_EN,COFFEE_BRAND_DIV_CD,ICE_HOT_DIV_CD,ENABLE_SIZE,PRICE) values (

)

```

### 구분 값에 대한 설명
- 메뉴id(커피브랜드 2 + 메뉴뷴류3 + 숫자 3자리)
- 커피브랜드코드(커피 브랜드의 고유값 4자리 ex) STBS = 스타벅스, MGCF = 메가커피)
- 핫 아이스 구분 (H : only hot, I : only Ice, H/I 둘다)
- 가능 사이즈
  - S : Short
  - T : Tall
  - G : Grande
  - V : Venti
  - R : Trenta
  - 7 : 7oz
  - O : Solo
  - D : Doppio