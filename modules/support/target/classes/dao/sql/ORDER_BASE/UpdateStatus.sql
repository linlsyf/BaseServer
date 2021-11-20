
UPDATE ShopOrder SET  status ='0'

  WHERE ID in (${$in(ids)});