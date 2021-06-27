package service;

import com.alibaba.fastjson.JSON;

import file.dao.FileListDao;
import dao.GoodsDao;
import file.dao.bean.FileRecorder;
import dao.bean.Goods;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.UUID;

@Service
public class GoodsService {

//    public String add( String  msg) throws Exception  {
//
//          Goods goods=  JSON.parseObject(msg, Goods.class);
//        String goodsId= UUID.randomUUID().toString();
//        goods.setId(goodsId);
//        GoodsDao.add(goods);
//         FileRecorder fileRecorder= FileListDao.getFileRecorderById(goods.getImageId());
//           fileRecorder.setRefId(goods.getId());
//           FileListDao.update(fileRecorder);
//        return goods.getId();
//    }
    public  String list()throws Exception  {
       String data= GoodsDao.list();
        return data;
    }
    public  String getOrderedList()throws Exception  {
       String data= GoodsDao.listByStatus(3);
        return data;
    }

    public Goods get(String id) throws IOException {
        GoodsDao  dao=new GoodsDao();
        return  dao.get(id);
    }
}
