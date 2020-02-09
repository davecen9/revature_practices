Create Table accounts(
accountid SERIAL PRIMARY KEY not null,
accountownershiptype varchar(15) NOT NULL,
accounttype varchar(15) not null,
balance numeric not null,
creditlimit numeric not null,
CHECK(accountownershiptype in ('SINGLE','JOINT')),
CHECK(accounttype in ('CHECKING','CREDIT','SAVING'))
)


Create table transactions(
trx_id serial primary key not null,
initaccount int references accounts(accountid),
endaccount int references accounts(accountid),
trxtype varchar(15),
trxamount numeric not null,
check(trxtype in('transfer','deposit','withdraw'))
)

create table users_accounts(
uaid serial primary key not null,
userid varchar(10) references users(userid),
accountid int references accounts (accountid)
)
