orders.getTaskList = SELECT * FROM (TASK.ls_compro_task_api.get_task_list (p_start_date => null, p_stop_date => null, p_order_num => null,
p_order_state_code_t => null, p_task_num => null, p_task_state_list => null, p_id_trade_net_t => null, p_responsible_code => null, p_client_reg_code => null, p_phone_from => null, p_em_code => null, p_page => 1, p_count => 10, p_order => 'create_date desc', p_user_code => null, p_locale => 'RU', p_sys_trace => 0))
client.findClientCont = SELECT * FROM (CLIENT.ls_client_api.find_client_contact (p_cp_code => null, p_client_phone => null,  p_client_email
=> null, p_client_card => null, p_client_reg_code => null, p_locale => 'RU', p_sys_trace => 0))
client.getClientCp = SELECT (CLIENT.ls_client_api.get_client_cp (p_client_reg_code => null, p_user_code => null)) FROM dual


-- create 2 tables 'dept' and 'emp'. Link tables by key 'dept_id'
CREATE TABLE ‘dept’ (‘dept_id’ INTEGER NOT NULL Primary Key, ‘dname’  VARCHAR(20) NOT NULL);
CREATE TABLE ‘emp’ (‘emp’_id INTEGER NOT NULL Primary Key, ‘dept-id’ INTEGER NOT NULL,  ‘ename’ VARCHAR(15) NOT NULL, ‘salary’ NUMERIC(6, 2) NOT NULL, Foreign Key (‘emp’_id) References ‘dept’ (‘dept_id’));

-- fill tables
INSERT into ‘dept’ values (1, 'Marketing');
INSERT into ‘emp’ values (1, 1, 'Smith', 2000);

-- you have tables 'dept_arch' with same structure as 'dept'. Insert data from from one to another
INSERT into ‘dept_arch’ SELECT ‘dept_id’, ‘dname’  FROM ‘dept’;

-- change data within cell (rise salary)
UPDATE ‘emp’ SET ‘salary’ = ‘salary’ * 1.15 WHERE ‘ename’ = ‘Smith’;

-- delete specified record
DELETE FROM ‘emp’ WHERE ‘epm_id’ = 1;

-- delete all records
TRUNCATE TABLE ‘emp’;

-- delete table as a whole
DROP TABLE ‘emp’;

-- show all records from table
SELECT * FROM ‘purchase’;

-- show records in specified order
SELECT ‘product_name’, ‘quantity’ FROM ‘purchase’;

-- show column and give them alias
SELECT ‘hiredate’ AS ‘Started Work’ FROM ‘person’;

-- show column from one table with specified conditions
SELECT ‘product_name’ FROM ‘product’ WHERE ‘product_price’ IS NULL;
SELECT ‘product_name’ FROM ‘purchase’ WHERE ‘quantity’ BETWEEN 3 AND 23;
SELECT ‘last_name’ FROM ‘person’ WHERE ‘hiredate’ IN (‘2010-02-01’, ‘2010-02-15’);

-- show column from several tables with specified conditions (tables 'salesperson' and 'person_code' are linked)
SELECT ‘product_name’ FROM ‘purchase’ WHERE ‘salesperson’ = (SELECT ‘person_code’ FROM ‘person’ WHERE ‘last_name’ LIKE ‘B%’);
SELECT product_name FROM ‘purchase’ WHERE ‘salesperson’ = (SELECT ‘person_code’ FROM ‘person’ WHERE ‘last_name’ NOT LIKE ‘B%’);
SELECT ‘purchase.product_name’, ‘product.laststock_date’, ‘person.last_name’ FROM ‘purschase’, ‘product’, ‘person’ WHERE ‘product
.product_name’ = ‘purchase.product_name’ AND ‘person.person_code’ = ‘purchase.salesperson’;

-- show column with conditions and sort
SELECT ‘product_name’ FROM ‘product’ WHERE ‘product name’ LIKE ‘%Small Widget%’ OR ‘%Medium Widget%’ ORDER BY ‘laststock_date’ DESC;

-- show column from union tables with alias
SELECT ‘pur.product_name’, ‘per.first_name’, ‘per.last_name’ FROM ‘purchase’ AS ‘pur’, ‘person’ AS ‘per’ WHERE ‘pur.salesperson’ = ‘per.person_code’;

-- show only unique 'salesperson' records from table
SELECT DISTINCT ‘salesperson’ FROM ‘purchase’;

-- show column after changing value
SELECT ‘product_price’ * 1.15 FROM ‘product’ WHERE ‘product_name’ = ‘X’;

-- show several records from table
SELECT COUNT (*) FROM ‘product’;

-- show max and min value from table with alias
SELECT MIN(‘product_price’) AS ‘lowPrice’, MAX(‘product_price’) AS ‘HighPrice’ FROM ‘product’;

--show count records selected by conditions
SELECT COUNT (‘product_price’) FROM ‘product’ WHERE ‘product_price’ IS NULL;

-- show records with conditions from several tables
SELECT ‘product.product_name’, SUM(‘product.product_price’ * ‘purchase.quantity’)
    FROM ‘product’ INNER JOIN ‘purchase’ ON ‘product.product_name’ = ‘purchase.product_name’ WHERE SUM(‘product.product_price’ * ‘purchase.quantity’)>125

-- show records selected by math conditions
SELECT ‘product_name’ FROM ‘product’ WHERE ‘product_price’ < AVG(‘product_price’);

-- show records selected by logical conditions
SELECT ‘product_name’ FROM ‘purchase’ WHERE ‘quantity’ > 1;
SELECT ‘first_name’ FROM ‘person’ WHERE EXISTS (SELECT ‘salesperson’ FROM ‘purchase’ WHERE ‘quantity’ > 1);

-- show difference between date
SELECT DATEDIFF (year, ‘1990-05-02’,’2020-11-23’);

-- show record Upper or Lower case
SELECT UPPER/LOWER ('привет');

-- show only first 3 digits
SELECT SUBSTRING (purchase.product_name, 1, 3) FROM purchase;

-- show digits from 4 to the end of records
SELECT SUBSTRING (purchase.product_name, 3, LEN(purchase.product_name)) FROM purchase;