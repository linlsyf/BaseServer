package utils.excel;

import com.mw.utils.StringUtils;

import java.util.*;

public class NormTest {
//
//
//    public static  final  void main(String[] arg) throws Exception {
//
//
//            ReportData reportData = new ReportData();
//            String fileName="轨道交通执法大队执法文书印制计划表.xls";
//
//            reportData.setFileName(fileName);
//            String keysStr = "sortNum,docName,pVolumeNumber,startDocNum,endDocNum,price,sum";
//            String[] keys = keysStr.split(",");
//            reportData.setExportMetaKeys(Arrays.asList(keys));
//            String year = "2017";
//
//            List<Map> resultList=new ArrayList<>();
//
//
//            Date createDate=new  Date();
//
//            String createDateString=createDate+"";
//            String  timeString="2020-0103";
////            String  timeString=createDateString.substring(0,createDateString.indexOf("."));
//
//            String[] msgTitle ={"批次号","batchNumber","编制人","creator","","编制时间",timeString};
//            List<Map>  applyDetails = new ArrayList<>();
//
//            Double  sumPrice=new Double(0);
//            for (int i=0;i<applyDetails.size();i++){
//
//                Map itemMap=applyDetails.get(i);
//
//                int pVolumeNumber=(int)itemMap.get("pVolumeNumber");
//                if (pVolumeNumber==0){
//                    continue;
//                }
//                itemMap.put("sortNum",i+1);
//                itemMap.put("docName",itemMap.get("docName"));
//                itemMap.put("pVolumeNumber",itemMap.get("pVolumeNumber"));
//                itemMap.put("startDocNum",itemMap.get("startDocNum"));
//                itemMap.put("endDocNum",itemMap.get("endDocNum"));
//                itemMap.put("price","¥"+itemMap.get("unitPrice"));
//
//                Double  itemSumPrice=Double.parseDouble(itemMap.get("sumPrice")+"");
//                itemMap.put("sum","¥"+itemSumPrice);
//                resultList.add(itemMap);
//                sumPrice=sumPrice+itemSumPrice;
//            }
//
//            Map  testMap2=new HashMap();
//            testMap2.put("sortNum","");
//            testMap2.put("docName","");
//            testMap2.put("pVolumeNumber","");
//            testMap2.put("startDocNum","");
//            testMap2.put("endDocNum","");
//            testMap2.put("price","费用合计");
//            testMap2.put("sum","¥"+sumPrice);
//            resultList.add(testMap2);
//            reportData.setData(resultList);
//          PrintReportUtil.export(reportData,msgTitle);
//
//    }
}
