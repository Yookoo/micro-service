INSERT INTO product (name, category, detail, buyPrice, sellPrice, provider) VALUES ('wahaha', '饮料', '乳酸菌饮料', 20 ,50, '哇哈哈');
INSERT INTO product (name, category, detail, buyPrice, sellPrice, provider) VALUES ('kangshifu', '食品', '康师傅方便面', 10 ,20, '康师傅');

update product set name='wahahaAD钙奶',  buyPrice = 10, sellPrice=20 where id = 1；

delete from product where id = 2；