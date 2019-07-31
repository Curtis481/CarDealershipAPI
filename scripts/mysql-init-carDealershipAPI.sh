#! /bin/zsh

echo "Checking if Homebrew is installed..."
if [[ $(command -v brew) == "" ]]; then
  echo "Homebrew is not installed.  Installing now..."
  /usr/bin/ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"
else
     echo "Homebrew is already installed."
fi


echo "Checking if mysql is installed..."
if brew ls --versions mysql > /dev/null; then
  echo "mysql is installed"
else
  echo "mysql is not installed. Installing mysql..."
  brew install mysql
  brew postinstall mysql
fi


echo "Starting MySql..."
string="$(mysql.server status)"
if [[ $string == *"SUCCESS"* ]]; then
  echo "MySql is already running!"
else
  mysql.server start
fi



echo "Populating database..."
mysql -u root -e "CREATE DATABASE IF NOT EXISTS CarDealership;"
mysql -u root -e "USE CarDealership;

DROP TABLE IF EXISTS Cars;


CREATE TABLE Cars (
   id int PRIMARY KEY auto_increment,
   color varchar (200) NOT NULL,
   make varchar (200) NOT NULL,
   model varchar (200) NOT NULL,
   year int NOT NULL,
   price int NOT NULL

);


insert into Cars (id, color, make, model, year, price) values (1, 'White', 'Nissan', 'Altima', 2005, 5000);
insert into Cars (id, color, make, model, year, price) values (2, 'Red', 'Nissan', 'Maxima', 2019, 45000);
insert into Cars (id, color, make, model, year, price) values (3, 'Grey', 'Honda', 'Pilot', 2002, 2500);
insert into Cars (id, color, make, model, year, price) values (4, 'Teal', 'Kia', 'Rio', 2003, 3200);
insert into Cars (id, color, make, model, year, price) values (5, 'Red', 'Dodge', 'Journey', 2015, 18000);
insert into Cars (id, color, make, model, year, price) values (6, 'Grey', 'BMW', 'Z4', 2010, 29000);
insert into Cars (id, color, make, model, year, price) values (7, 'Black', 'Acura', 'MDX', 2004, 4150);
insert into Cars (id, color, make, model, year, price) values (8, 'Blue', 'Cadillac', 'ATS', 2013, 1900);
insert into Cars (id, color, make, model, year, price) values (9, 'Pink', 'Tesla', 'Model 3', 2017, 35000);
insert into Cars (id, color, make, model, year, price) values (10, 'White', 'Fiat', '500', 2014, 1200);
insert into Cars (id, color, make, model, year, price) values (11, 'Orange', 'Mitsubishi', 'Galant', 2006, 2600);
insert into Cars (id, color, make, model, year, price) values (12, 'Green', 'Isuzu', 'FTR', 2005, 1700);
insert into Cars (id, color, make, model, year, price) values (13, 'Black', 'Chevrolet', 'Equinox', 2015, 22000);
insert into Cars (id, color, make, model, year, price) values (14, 'Grey', 'Land Rover', 'Freelander', 2002, 6500);
insert into Cars (id, color, make, model, year, price) values (15, 'White', 'Volkswagen', 'Bora', 2006, 8200);




DROP TABLE IF EXISTS Customers;

CREATE TABLE Customers (
   id int PRIMARY KEY auto_increment,
   name varchar (200) NOT NULL,
   address varchar (200) NOT NULL,
   purchase_number int
);


insert into Customers (id, name, address, purchase_number) values (1, 'Joe Matthews', '4850 Hardman Road', 2);
insert into Customers (id, name, address, purchase_number) values (2, 'Rikki Denholm ', '1396 Bubby Drive', 1);
insert into Customers (id, name, address, purchase_number) values (3, 'Lorri Carver ', '3828 Ottis Street', 1);
insert into Customers (id, name, address, purchase_number) values (4, 'Rikki Denholm ', '795 Barrington Court', 1);
insert into Customers (id, name, address, purchase_number) values (5, 'Charis Darryl ', '157 Still Pastures Drive', 1);
insert into Customers (id, name, address, purchase_number) values (6, 'Deacon Nichole ', '941 Virgil Street', 2);




DROP TABLE IF EXISTS Employees;

CREATE TABLE Employees (
   id int PRIMARY KEY auto_increment,
   name varchar (200) NOT NULL,
   address varchar (200) NOT NULL,
   sold_number int
);


insert into Employees (id, name, address, sold_number) values (1, 'Christina Alberta', '194 Bingamon Road', 3);
insert into Employees (id, name, address, sold_number) values (2, 'Isabelle Cece', '4738 Owen Lane', 1);
insert into Employees (id, name, address, sold_number) values (3, 'Burton Jerold', '85 Seth Street', 2);
insert into Employees (id, name, address, sold_number) values (4, 'Milo Dylan', '2950 Valley Drive', 1);
insert into Employees (id, name, address, sold_number) values (5, 'Valentine Albin', '591 Gladwell Street', 1);

DROP TABLE IF EXISTS Sales;

CREATE TABLE Sales (
   id int PRIMARY KEY auto_increment,
   car_id int,
   employee_id int,
   customer_id int,
   sell_price int,
   sell_date date

);


insert into Sales (id, car_id, employee_id, customer_id, sell_price, sell_date) values (1, 1, 1, 1, 5500, '2019-07-13');
insert into Sales (id, car_id, employee_id, customer_id, sell_price, sell_date) values (2, 2, 1, 1, 43000, '2019-07-11');
insert into Sales (id, car_id, employee_id, customer_id, sell_price, sell_date) values (3, 3, 1, 2, 2500, '2019-07-19');
insert into Sales (id, car_id, employee_id, customer_id, sell_price, sell_date) values (4, 4, 5, 4, 3000, '2019-07-03');
insert into Sales (id, car_id, employee_id, customer_id, sell_price, sell_date) values (5, 5, 4, 3, 19750, '2019-06-13');
insert into Sales (id, car_id, employee_id, customer_id, sell_price, sell_date) values (6, 6, 3, 6, 30000, '2019-06-29');
insert into Sales (id, car_id, employee_id, customer_id, sell_price, sell_date) values (7, 7, 2, 5, 4250, '2019-07-22');
insert into Sales (id, car_id, employee_id, customer_id, sell_price, sell_date) values (8, 8, 3, 6, 1300, '2019-07-28');


"

echo "Done"