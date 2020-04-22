package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;

public class FileUtils {
    private static final int MB = 1048576;
    private static final int KB = 1024;
    private static DecimalFormat df = new DecimalFormat("0");
    private static final File TEMP_DIR = new File(System.getProperty("java.io.tmpdir"));

    public FileUtils() {
    }

    public static String getNewFileName(String fileName, String newName) {
        return newName + fileName.substring(fileName.lastIndexOf("."), fileName.length());
    }

    public static File getTempDirectory() {
        return TEMP_DIR;
    }

    public static File createDirecttory(File baseDir, String dirPartPath) {
        if (!baseDir.exists()) {
            baseDir.mkdirs();
        }

        File newDir = new File(baseDir, dirPartPath);
        if (!newDir.exists()) {
            newDir.mkdirs();
        }

        return newDir;
    }

    public static File createFile(File baseDir, String fileName) {
        if (!baseDir.exists()) {
            baseDir.mkdirs();
        }

        File newFile = new File(baseDir, fileName);

        try {
            if (!newFile.exists()) {
                newFile.createNewFile();
            }
        } catch (IOException var4) {
            var4.printStackTrace();
        }

        return newFile;
    }

    public static synchronized void delete(File file) {
        if (file.exists()) {
            if (file.isDirectory()) {
                File[] arr$ = file.listFiles();
                int len$ = arr$.length;

                for(int i$ = 0; i$ < len$; ++i$) {
                    File f = arr$[i$];
                    if (f.isDirectory()) {
                        delete(file);
                    } else {
                        f.delete();
                    }
                }
            }

            file.delete();
        }

    }

    public static String getFileSuffixName(String fileName) {
        return fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length()).toLowerCase();
    }

    public static String getFileSize(long size) {
        return size / 1024L >= 1024L ? isDivisible(size, 1048576, "MB") : isDivisible(size, 1024, "KB");
    }

    public static String isDivisible(long l1, int l2, String sizeType) {
        if (l1 <= 1024L) {
            return "1KB";
        } else {
            return l1 % (long)l2 == 0L ? df.format(l1 / (long)l2) + sizeType : df.format(l1 / (long)l2 + 1L) + sizeType;
        }
    }

    public static void removeFile(File file) {
        if (file.exists()) {
            file.delete();
        }

    }
//
//    public static String getFileMd5(File file) throws NoSuchAlgorithmException, IOException {
//        FileInputStream is = null;
//        String md5 = null;
//
//        try {
//            is = new FileInputStream(file);
//            md5 = MD5Util.getMd5(is);
//        } finally {
//            if (is != null) {
//                try {
//                    is.close();
//                } catch (Exception var9) {
//                    ;
//                }
//            }
//
//        }
//
//        return md5;
//    }

    public static boolean isImage(File file) {
        if (file.isDirectory()) {
            return false;
        } else {
            String fileName = file.getName();
            return isImage(fileName);
        }
    }

    public static boolean isImage(String fileName) {
        int len = fileName.indexOf(".");
        String imagesPattern = fileName.substring(len + 1, fileName.length()).toLowerCase();
        if ("jpg".equals(imagesPattern)) {
            return true;
        } else if ("bmp".equals(imagesPattern)) {
            return true;
        } else if ("gif".equals(imagesPattern)) {
            return true;
        } else if ("psd".equals(imagesPattern)) {
            return true;
        } else if ("pcx".equals(imagesPattern)) {
            return true;
        } else if ("png".equals(imagesPattern)) {
            return true;
        } else if ("dxf".equals(imagesPattern)) {
            return true;
        } else if ("cdr".equals(imagesPattern)) {
            return true;
        } else if ("ico".equals(imagesPattern)) {
            return true;
        } else if ("bmp".equals(imagesPattern)) {
            return true;
        } else if ("jpeg".equals(imagesPattern)) {
            return true;
        } else if ("svg".equals(imagesPattern)) {
            return true;
        } else if ("wmf".equals(imagesPattern)) {
            return true;
        } else if ("emf".equals(imagesPattern)) {
            return true;
        } else if ("eps".equals(imagesPattern)) {
            return true;
        } else if ("tga".equals(imagesPattern)) {
            return true;
        } else if ("nef".equals(imagesPattern)) {
            return true;
        } else if ("tif".equals(imagesPattern)) {
            return true;
        } else {
            return "tiff".equals(imagesPattern);
        }
    }

    public static void main(String[] arg0) {
        System.out.println(getFileSize(1048576L));
    }
}
