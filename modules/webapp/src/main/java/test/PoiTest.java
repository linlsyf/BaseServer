package test;


import com.mw.utils.FileUtils;
import com.mysql.jdbc.TimeUtil;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

public class PoiTest {
//
//    public static  final  void main(String[] arg ) throws Exception {
//
//
//
//        XSSFFont font;
//        List<Map>  dataList=new ArrayList<>();
//        List<String>  keyList=new ArrayList<>();
//
//        HSSFHyperlink link = new HSSFHyperlink(HSSFHyperlink.LINK_URL);
//
//        link.setAddress("https://www.baidu.com/");
//
//        keyList.add("sn");
//        keyList.add("dh");
//        keyList.add("wh");
//        keyList.add("zrz");
//        keyList.add("tm");
//        keyList.add("rq");
//        keyList.add("mj");
//        keyList.add("ys");
//        keyList.add("bz");
//        keyList.add("qx");
//        keyList.add("hh");
//
////        keyList.put("qx","qx");
////        keyList.put("hh","hh");
//        for (int i = 0; i <10 ; i++) {
//            Map dataMap=new HashMap<>();
//            dataMap.put("sn","sn"+i);
//            dataMap.put("dh","dh"+i);
//            dataMap.put("wh","wh"+i);
//            dataMap.put("zrz","zrz"+i);
//            dataMap.put("tm","tm"+i);
//            dataMap.put("rq","rq"+i);
//            dataMap.put("mj","mj"+i);
//            dataMap.put("ys","ys"+i);
//            dataMap.put("bz","bz"+i);
//
//            dataList.add(dataMap);
//        }
//
//         Map  paramsMap=new HashMap();
//        paramsMap.put("qx","qx");
//        paramsMap.put("hh","hh");
//
//
//
//         String  filePath="E:\\Solr\\测试数据-old.xls";
//
//
//
//
//         String  copyFilePath="E:\\Solr\\测试数据new.xls";
//
//        File oldFile=new  File(filePath);
//
//
//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
//        String  time=df.format(new Date());// new Date()为获取当前系统时间
//
//
//
//        File fileCopy=new  File(copyFilePath);
//
//
//        FileUtils.copy( oldFile, fileCopy );
//
//        Workbook hssfWorkbook = null;
//
//        hssfWorkbook = new HSSFWorkbook(new FileInputStream(filePath));
//
//
////        try {
////            hssfWorkbook = new XSSFWorkbook(new FileInputStream(filePath));
////        } catch (Exception ex) {
////            try {
////                hssfWorkbook = new HSSFWorkbook(new FileInputStream(filePath));
////            } catch (IOException e) {
////                e.printStackTrace();
////            }
////        }
//
//          int startRowIndex=0;
//        Sheet s=null;
//
//        Map  keyColnumMap=new HashMap();
//        int nameNumbers=   hssfWorkbook.getNumberOfNames();
//        for (int i = 0; i <nameNumbers ; i++) {
//            Name  aNamedCell=         hssfWorkbook.getNameAt(i);
//
////            int t=0;
////        }
//////
////        for (String  key : keyList) {//先改变cell内容以及获取 递归每列字段列的位置
////            int namedCellIdx = hssfWorkbook.getNameIndex(key);
////            Name aNamedCell = hssfWorkbook.getNameAt(namedCellIdx);
//
//            AreaReference[] arefs  = AreaReference.generateContiguous(aNamedCell.getRefersToFormula());
//            org.apache.poi.ss.util.CellReference crefs = arefs[0].getFirstCell();
//
//             if (null==s){
//                 s = hssfWorkbook.getSheet(crefs.getSheetName());
//             }
//
//
////            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
////           String  time=df.format(new Date());// new Date()为获取当前系统时间
//
//
//             String  key=    aNamedCell.getNameName();
//
//             String value="";
//              if (paramsMap.containsKey(key)){
//                  value=(String)paramsMap.get(key);
//              }
//            boolean ischange=changeParams(crefs,s,value);
//
//            if (!ischange){
//                 if (startRowIndex==0){
//                     int rowIndex=crefs.getRow();
//                     startRowIndex=rowIndex+1;
//                 }
//             int  colIndex=crefs.getCol();
//
//                keyColnumMap.put(key,colIndex);//储存字段的列位置
//
//            }
//        }
//
//
//         List<String> appendingList=new ArrayList(keyColnumMap.keySet());
//        for (Map itemMap : dataList) {
//
//            Row row = s.createRow((short) startRowIndex);
//
//
//            CellStyle cellStyle = hssfWorkbook.createCellStyle();
//            // 水平方向上居中对齐
//            cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
//
//            for (String colKey : appendingList) {
//             int colIndex=(int)keyColnumMap.get(colKey);
//
//
//                Cell cell = row.createCell((short) colIndex);
//
//                // 定义单元格为字符类型，也可以指定为日期类型、数字类型
//                cell.setCellType(HSSFCell.CELL_TYPE_STRING);
//                // 定义编码方式，为了支持中文，这里使用了ENCODING_UTF_16
////                cell.set(HSSFCell.ENCODING_UTF_16);
//                // 为单元格设置格式
//                cell.setCellStyle(cellStyle);
//
//                // 添加内容至单元格
//                cell.setCellValue((String) itemMap.get(colKey));
//
//
//            }
//            startRowIndex=startRowIndex+1;
//        }
//
//
//        FileOutputStream  out= new  FileOutputStream(fileCopy.getAbsoluteFile());
//
//        hssfWorkbook.write(out);
//
//        out.close();
//
//
//    }
//
//    private static boolean  changeParams(org.apache.poi.ss.util.CellReference crefs, Sheet s,String   changeValue) {
//        Row r = s.getRow(crefs.getRow());
//        Cell c = r.getCell(crefs.getCol());
//        boolean isChangeCell=false;
//       String  cellValue= c.getStringCellValue();
//        if (null!=c&(cellValue.indexOf(":")>-1||cellValue.indexOf("：")>-1)){//只改变当前框的内容
//            c.setCellValue(cellValue+changeValue);
//            isChangeCell=true;
//        }
//        return  isChangeCell;
//    }
}
