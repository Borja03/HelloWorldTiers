/**
 * Author:  2dam
 * Created: 16-sep-2024
 */

Create database DBUser;

use DBUser;

Create table user (
    dni varchar (9) primary key,
    username varchar (20),
    password varchar (20),
    fullName varchar (50)
)

insert into user (dni,username,password,fullname) 
values (20202020A,godofredo1,GodoFredo777,Gonzalo Alfredo Rodriguez)



