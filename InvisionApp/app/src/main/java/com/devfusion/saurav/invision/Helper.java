package com.devfusion.saurav.invision;

import android.os.Environment;

import java.io.File;

/**
 * Created by saurav on 29/07/16.
 */
public class Helper {

    public static String getTempFile() {
        return Environment.getExternalStorageDirectory().getPath()    + "/Androidhub4you/";

    }

    public static File createFileInSDCard(String path,String fileName) {
        File dir = new File(path);
        try {
            if (!dir.exists() && dir.mkdirs()) {
                System.out.println("Directory created");
            } else {
                System.out.println("Directory is not created");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        File file = null;
        try {
            if (dir.exists()) {
                file = new File(dir, fileName);
                file.createNewFile();
            } else {

            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return file;

    }
}
