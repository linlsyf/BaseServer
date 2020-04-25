//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package utils.excel;

import java.util.List;
import java.util.Map;

public class ReportData {
    private String fileName;
    private List<Map> data;
    private Map metas;
    private List<String> exportMetaKeys;

    public ReportData() {
    }

    public String getFileName() {
        return this.fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public List<Map> getData() {
        return this.data;
    }

    public void setData(List<Map> data) {
        this.data = data;
    }

    public Map getMetas() {
        return this.metas;
    }

    public void setMetas(Map metas) {
        this.metas = metas;
    }

    public List<String> getExportMetaKeys() {
        return this.exportMetaKeys;
    }

    public void setExportMetaKeys(List<String> exportMetaKeys) {
        this.exportMetaKeys = exportMetaKeys;
    }
}
