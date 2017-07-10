package com.jb.bjho6.myapplication11;

import android.view.View;

import java.util.Random;

/**
 * Created by bjho6 on 2017-07-05.
 */

public class FileInfo {
    int iDrawableResId;
    String strFileName;
    long lFileSize;

    public FileInfo(int iDrawableResId, String strFileName, long lFileSize) {
        this.iDrawableResId = iDrawableResId;
        this.strFileName = strFileName;
        this.lFileSize = lFileSize;

        if(iDrawableResId == View.NO_ID){
            this.iDrawableResId = getiDrawableResId(this.strFileName);
        }
        if(this.lFileSize == 0){
            Random ran = new Random();
            this.lFileSize = ran.nextInt(10000);
        }

    }

    public int getiDrawableResId(String strFileName){
        int iDrawableResId = R.drawable.fileicon_bin;
        if(strFileName.contains(".apk")){
            iDrawableResId = R.drawable.fileicon_apk;
        }else if (strFileName.contains(".doc")) {
            iDrawableResId = R.drawable.fileicon_doc;
        } else if (strFileName.contains(".gif")) {
            iDrawableResId = R.drawable.fileicon_gif;
        } else if (strFileName.contains(".jpg")) {
            iDrawableResId = R.drawable.fileicon_jpg;
        } else if (strFileName.contains(".json")) {
            iDrawableResId = R.drawable.fileicon_json;
        } else if (strFileName.contains(".pdf")) {
            iDrawableResId = R.drawable.fileicon_pdf;
        } else if (strFileName.contains(".png")) {
            iDrawableResId = R.drawable.fileicon_png;
        } else if (strFileName.contains(".ppt")) {
            iDrawableResId = R.drawable.fileicon_ppt;
        } else if (strFileName.contains(".txt")) {
            iDrawableResId = R.drawable.fileicon_txt;
        } else if (strFileName.contains(".word")) {
            iDrawableResId = R.drawable.fileicon_word;
        }

        return iDrawableResId;
    }

}
