
UPDATE sys_components SET  status ='0'

  WHERE ID in (${$in(ids)});