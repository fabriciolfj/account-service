create table account(
id bigserial primary key not null,
uuid varchar(255) not null,
customer varchar(255) not null,
overdraft numeric(15,4) not null,
create_date timestamp not null
);

create table extract(
id bigserial primary key not null,
uuid varchar(255) not null,
account_id bigserial not null,
credit numeric(15,4) not null,
debit numeric(15,4) not null,
balance numeric(15,4) not null,
description varchar(255) not null,
moviment_date timestamp not null,
constraint fk_account foreign key (account_id) references account (id)
);