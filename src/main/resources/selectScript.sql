SELECT DISTINCT product_name
FROM netology.orders
INNER JOIN netology.customers on netology.customers.id = netology.orders.custamer_id
where LOWER(netology.customers.name) = LOWER(:name)