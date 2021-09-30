package test;


import com.mw.utils.FileUtils;
import com.mysql.jdbc.TimeUtil;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MangerTest {
//
//    public static  final  void main(String[] arg ) throws Exception {
//
//
//
//        List<Map>  dataList=new ArrayList<>();
//        List<String>  keyList=new ArrayList<>();
//
//
//        keyList.add("archivesitemnumber");
//        keyList.add("archivalcode");
//        keyList.add("documentnumber");
//        keyList.add("author");
//        keyList.add("title");
//        keyList.add("filedate");
//        keyList.add("securityclassification");
//        keyList.add("amountofpages");
//        keyList.add("annotation");
//        keyList.add("retentionperiod");
//        keyList.add("copies");
//
//        for (int i = 0; i <30 ; i++) {
//            Map dataMap=new HashMap<>();
//
//               if(i<8){
//                   dataMap.put("copies","1");
//               }
//               if(i>=8&i<15){
//                   dataMap.put("copies","12");
//               }
//               if(i>=15&&i<20){
//                   dataMap.put("copies","1");
//               }
//               if(i>=20){
//                   dataMap.put("copies","2");
//               }
//
//
//            dataMap.put("archivesitemnumber","00201"+i);//testsn
//            dataMap.put("archivalcode","G051-WS·2019-D30-BGH-1174");
//            dataMap.put("documentnumber","署X发字〔2019〕2号");
//            dataMap.put("author","李抚原"+i);
//            dataMap.put("title","就是很长的意思测试题目很长就是很长的意思就是很长的意1234567890就"+i);
//           // dataMap.put("title","就是很长的意思测试题目很长就是很长的意思就是很长的意1234567890就是很长的意思测试题目很长就是很长的意思就是很长的意1234567890"+i);
//            dataMap.put("filedate","2019-01-01");
//            dataMap.put("securityclassification","securityclassification"+i);
//            dataMap.put("amountofpages","amountofpages"+i);
//            dataMap.put("annotation","annotation"+i);
//            dataMap.put("retentionperiod",i+"年");
//
////            dataMap.put("fondscode","fondscode"+i);
//            dataMap.put("fondsname","fondsname"+i);
//            dataMap.put("archivingyear","archivingyear"+i);
//           // dataMap.put("retentionperiod","retentionperiod"+i);
//            dataMap.put("deptabbname","deptabbname"+i);
//
//            dataList.add(dataMap);
//        }
//
//        int  itemPageCount=8;//先按盒号分组   分组后每份8条数据   不够8条补够8条
//         Map copiesMap=new HashMap();
//       for (int i=0;i<dataList.size();i++){
//           Map dataMap=dataList.get(i);
//        String key=(String)dataMap.get("copies");
//         if (null==key){
//             key="";
//         }
//
//           List<Map>  dataCopiesList=  (List<Map>) copiesMap.get(key);
//         if (null==dataCopiesList){
//             dataCopiesList=new ArrayList<>();
//         }
//           dataCopiesList.add(dataMap);
//           copiesMap.put(key,dataCopiesList);
//       }
//
//
//        // 将 set 集合转为 List 集合，为什么，为了使用工具类的排序方法
//        List<String> copiesKeyList = new ArrayList<String>(copiesMap.keySet());
//        // 使用 Collections 集合工具类对 list 进行排序，排序规则使用匿名内部类来实现
//        Collections.sort(copiesKeyList, new Comparator<String>() {
//            @Override
//            public int compare(String key1, String key2) {
//                //按照要求根据 User 的 age 的倒序进行排
//
//                int keyIntOne=0;
//                int keyIntTwo=0;
//                 try {
//                     keyIntOne=Integer.parseInt(key1);
//                     keyIntTwo=Integer.parseInt(key2);
//                 }catch ( Exception e){
//
//                 }
//
//                return keyIntOne-keyIntTwo ;
//            }
//        });
//
//            if (copiesKeyList.size()>0){
//                dataList=new ArrayList<>();        //盒号分组后补全8的倍数
//            }
//        for (String  key:copiesKeyList  ) {
//            List<Map>  dataCopiesList=  (List<Map>) copiesMap.get(key);
//
//                int  isOver=dataCopiesList.size()%itemPageCount;
//              if (isOver>0){
//                     int size=itemPageCount-isOver;
//                   for (int i=0;i<size;i++){
//
//                    Map  itemMap=   new HashMap();
//                       dataCopiesList.add(itemMap);
//                   }
//              }
//
//            dataList.addAll(dataCopiesList);
//
//        }////先按盒号分组 end
//
//
//
//         Map  paramsMap=new HashMap();
//        paramsMap.put("retentionperiod","retentionperiod");
//        paramsMap.put("copies","copies");
//
//
//
//         String  filePath="E:\\Solr\\测试数据.xls";
//
//
//
//
//         String  copyFilePath="E:\\Solr\\测试数据new"+TimeUtil.getCurrentTimeNanosOrMillis()+".xls";
//
//        File oldFile=new  File(filePath);
//
//
//        File fileCopy=new  File(copyFilePath);
//
//
//        FileUtils.copy( oldFile, fileCopy );
//
//        Workbook hssfWorkbook = null;
//
//
//        try{
//            hssfWorkbook = new HSSFWorkbook(new FileInputStream(filePath));
//
//        }catch ( Exception e){
//            hssfWorkbook = new XSSFWorkbook(new FileInputStream(filePath));
//
//        }
//
//
//          int startRowIndex=0;
//        Sheet s=null;
//        int nameNumbers=   hssfWorkbook.getNumberOfNames();
//
//        Map  keyColnumMap=new HashMap();
//
//        for (int i = 0; i <nameNumbers ; i++) {
//            Name aNamedCell = hssfWorkbook.getNameAt(i);
//            AreaReference[] arefs  = AreaReference.generateContiguous(aNamedCell.getRefersToFormula());
//            org.apache.poi.ss.util.CellReference crefs = arefs[0].getFirstCell();
//
//            String  key=    aNamedCell.getNameName();
//            keyColnumMap.put(key,crefs);//储存字段的列位置
//        }
//        List<String> appendingList=new ArrayList(keyColnumMap.keySet());
//
//        Sheet pagesSheet= hssfWorkbook.getSheet("封面");
//
//        CellStyle pagesStyle = hssfWorkbook.createCellStyle();//创建格式
//        Font fontPages = hssfWorkbook.createFont();
//        fontPages.setColor(Font.COLOR_NORMAL);
//        fontPages.setFontName("宋体");
//        fontPages.setFontHeightInPoints((short) 23);
//          pagesStyle.setFont(fontPages);
//        for (String colKey : appendingList) {
//
//            org.apache.poi.ss.util.CellReference aref=(org.apache.poi.ss.util.CellReference)keyColnumMap.get(colKey);
//
//            Row row =pagesSheet.getRow(aref.getRow());
//            Cell cell =row.createCell(aref.getCol()) ;
//            cell.setCellType(HSSFCell.CELL_TYPE_STRING);
//          cell.setCellStyle(pagesStyle);
//             if (dataList.size()>0){//ldh0428
//                 String value=(String) dataList.get(0).get(colKey);
//                  if (null==value){
//                      value="";
//                  }
//                 cell.setCellValue(value);
//
//             }
//
//
//
//        }
//        //=========pages end==============
//
//
//        s = hssfWorkbook.getSheet("归档文件目录");
//
//         String title="归  档  文  件  目  录";
//        List<String>  columnNameList=new ArrayList<>();
////        List<String>  paramNameList=new ArrayList<>();
//
//
//        columnNameList.add("序\r\n号");
//        columnNameList.add("档       号");
//        columnNameList.add("文   号");
//        columnNameList.add("责任者");
//        columnNameList.add("题           名");
//        columnNameList.add("日\r\n期");
//        columnNameList.add("密\r\n级");
//        columnNameList.add("页\r\n数");
//        columnNameList.add("备\r\n注");
//
//        CellStyle titleStyle = hssfWorkbook.createCellStyle();//创建格式
//        Font fontTitle = hssfWorkbook.createFont();
//        fontTitle.setColor(Font.COLOR_NORMAL);
//        fontTitle.setFontHeightInPoints((short) 23);
//       // fontTitle.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
//
//        titleStyle.setFont(fontTitle);
//        titleStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
//        titleStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
//
//
//        CellStyle columnStyle = hssfWorkbook.createCellStyle();//创建格式
//          columnStyle.setWrapText(true);
//        Font columnFont = hssfWorkbook.createFont();
//        columnFont.setColor(Font.COLOR_NORMAL);
//        columnFont.setFontHeightInPoints((short) 15);
//        // fontTitle.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
//
//        columnStyle.setFont(columnFont);
//        columnStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
//        columnStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
//        columnStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
//        columnStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
//        columnStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
//        columnStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
//        Font font2 = hssfWorkbook.createFont();
//        //font2.setFontName("仿宋_GB2312");
//        font2.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
//        font2.setFontHeightInPoints((short) 14);//设置字体大小
//        columnStyle.setFont(font2);
//
//        CellStyle  paramsStyle=hssfWorkbook.createCellStyle();
//
//        paramsStyle.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
//        paramsStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
//
//        for ( int i=0; i<dataList.size();i++) {
//
//            if (i==0||i%itemPageCount==0){
////            s.createRow((short) startRowIndex+1);
////            s.createRow((short) startRowIndex+2);
//                Row  titleRow=      s.createRow((short) startRowIndex+1);
//
//                  for ( int t=0; t<columnNameList.size()-1;t++) {
//                       titleRow.createCell(t);
//                  }
//                    s.addMergedRegion(new CellRangeAddress(startRowIndex+1,startRowIndex+1,0,8));
//                Cell        cell = titleRow.createCell(0);
//                  cell.setCellType(HSSFCell.CELL_TYPE_STRING);
//                  cell.setCellStyle(titleStyle);
//                  cell.setCellValue(title);
//                s.createRow((short) startRowIndex+2);
//                startRowIndex=startRowIndex+3;
//            }
//            if (i==0||(i!=1&&i%itemPageCount==0)){
//
//                Row  colNameRow=      s.createRow((short) startRowIndex);
//                for ( int t=0; t<columnNameList.size();t++) {
//                    //String colKey =columnNameList.get(t);
//
//                     if (t==columnNameList.size()-2){
//                         s.addMergedRegion(new CellRangeAddress(startRowIndex,startRowIndex,columnNameList.size()-4,columnNameList.size()-3));
//                         Cell  cell = colNameRow.createCell(columnNameList.size()-4);
//                         cell.setCellStyle(paramsStyle);
//
//                         String value="  ";
//                          if (null!= dataList.get(i).get("retentionperiod")){
//                              value=(String) dataList.get(i).get("retentionperiod");
//                          }
//
//                         cell.setCellValue("期限:"+value);
//
//                     }
//                     if (t==columnNameList.size()-1){
//
//                         s.addMergedRegion(new CellRangeAddress(startRowIndex,startRowIndex,columnNameList.size()-2,columnNameList.size()-1));
//
//                         Cell  cell = colNameRow.createCell(columnNameList.size()-2);
//                         cell.setCellStyle(paramsStyle);
//
//                         String value="  ";
//                         if (null!= dataList.get(i).get("copies")){
//                             value=(String) dataList.get(i).get("copies");
//                         }
//
//                        cell.setCellValue("盒号:"+value);
//                     }
//
//                }
//
//
//                startRowIndex=startRowIndex+1;
//            }
//
//
//            if (i==0||(i!=1&&i%itemPageCount==0)){
//                Row  colNameRow=      s.createRow((short) startRowIndex);
//
//                    for ( int t=0; t<columnNameList.size();t++) {
//                        String colKey =columnNameList.get(t);
//                    Cell  cell = colNameRow.createCell(t);
//                    cell.setCellStyle(columnStyle);
//
//                    cell.setCellValue(colKey);
//                }
//              startRowIndex=startRowIndex+1;
//            }
//
//            Map itemMap=dataList.get(i);
//            Row row = s.createRow((short) startRowIndex);
//
//            row.setHeightInPoints(55);
//            CellStyle cellStyle = hssfWorkbook.createCellStyle();
//            // 水平方向上居中对齐
//            cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
//            cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
//
//            cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
//            cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
//            cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
//            cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
//
//
//
//            cellStyle.setLeftBorderColor(HSSFColor.BLACK.index);
//            cellStyle.setRightBorderColor(HSSFColor.BLACK.index);
//            cellStyle.setTopBorderColor(HSSFColor.BLACK.index);
//            cellStyle.setBottomBorderColor(HSSFColor.BLACK.index);
//
//            cellStyle.setWrapText(true);
//
//
//            CellStyle titleCellStyle = hssfWorkbook.createCellStyle();
//            titleCellStyle.setAlignment(HSSFCellStyle.ALIGN_LEFT);
//            // 水平方向上居中对齐
//            titleCellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
//
//
//            titleCellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
//            titleCellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
//            titleCellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
//            titleCellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
//
//
//            titleCellStyle.setLeftBorderColor(HSSFColor.BLACK.index);
//            titleCellStyle.setRightBorderColor(HSSFColor.BLACK.index);
//            titleCellStyle.setTopBorderColor(HSSFColor.BLACK.index);
//            titleCellStyle.setBottomBorderColor(HSSFColor.BLACK.index);
//
//
//
//            titleCellStyle.setWrapText(true);
//
//
//
//
//            CellStyle minColumnStyle = hssfWorkbook.createCellStyle();
//            // 水平方向上居中对齐
//            minColumnStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
//            minColumnStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
//
//
//            minColumnStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
//            minColumnStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
//            minColumnStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
//            minColumnStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
//
//            minColumnStyle .setLeftBorderColor(HSSFColor.BLACK.index);
//            minColumnStyle.setRightBorderColor(HSSFColor.BLACK.index);
//            minColumnStyle.setTopBorderColor(HSSFColor.BLACK.index);
//            minColumnStyle.setBottomBorderColor(HSSFColor.BLACK.index);
//
//
//
//            minColumnStyle.setWrapText(true);
//            // List<String>  KeyList= new   ArrayList(itemMap.keySet());
//
//            for (int t=0;t<columnNameList.size();t++) {
//
//                String colKey= keyList.get(t) ;
//                String value=(String) itemMap.get(colKey) ;
//                Cell cell = row.createCell((short) t);
//                if(null==value){
//                    value="";
//                }
//
//                // 定义单元格为字符类型，也可以指定为日期类型、数字类型
//                cell.setCellType(HSSFCell.CELL_TYPE_STRING);
//                  if ("archivesitemnumber".equals(colKey)){
//                       if (""!=value){
//                           Pattern p = Pattern.compile("[^0]{1}");
//                           Matcher m = p.matcher(value);
//                           if(m.find()){
//                            int start=  m.start();
//                               if(start>0){
//                                   value=value.substring(start,value.length());
//                               }
//                           }
//                       }
//
//                  }
//                if ("archivesitemnumber".equals(colKey)||"securityclassification".equals(colKey)||"amountofpages".equals(colKey)||"annotation".equals(colKey)){
//                    cell.setCellStyle(minColumnStyle);
//                   s.setColumnWidth(t, 6*256);
//                }else{
//                    if ("documentnumber".equals(colKey)) {
//                        s.setColumnWidth(t,13*256);
//                            if (value.contains("〔") && value.contains("〕")) {
//                                value = value.substring(0, value.indexOf("〔")) + "\r\n" + value.substring(value.indexOf("〔"), value.length());
//                            }
//                    }
//                    else if ("author".equals(colKey)) {
//                        s.setColumnWidth(t, 10*256);
//                    }
//                    else if ("filedate".equals(colKey)) {
//                        s.setColumnWidth(t, 6*256);
//                        if(value.length()>4){
//                         value=value.replace("-","");
//                            value=value.substring(0,4)+"\n"+value.substring(4,value.length());
//                        }
//                        if(value.length()>8){
//                            value=value.substring(0,9);
//                        }
//
//                    }
//                    else if ("archivalcode".equals(colKey)) {
//                        s.setColumnWidth(t, 32*256);
//                    }
//
//                     if ("title".equals(colKey)) {
//                        s.setColumnWidth(t, 39*256);
//                         cell.setCellStyle(titleCellStyle);
//
//                    }else{
//                         cell.setCellStyle(cellStyle);
//                     }
//                }
//
//                cell.setCellValue(value);
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
//    }
//
//     public void execPages(){
//
//     }


}
