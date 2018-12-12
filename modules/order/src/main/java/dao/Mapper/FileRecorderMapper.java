package dao.Mapper;


import dao.bean.FileRecorder;

import java.util.List;

public interface FileRecorderMapper {
        List<FileRecorder> findAllOrders();
        FileRecorder findOrderById(String id);

        int  add(FileRecorder Order);
        int  delete(String id);
        int update(FileRecorder Order);
        }