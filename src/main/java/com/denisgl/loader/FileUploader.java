package com.denisgl.loader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public class FileUploader {

    private static final Logger LOG = LoggerFactory.getLogger(FileUploader.class);

    public static final String ABS_PATH = "/home/dennis/IdeaProjects/denisgl-shop/src/main/webapp/assets/images/";

    public static boolean uploadFile(String realPath, MultipartFile file, String code) {
        LOG.info(realPath);

        new File(realPath).mkdirs();
        new File(ABS_PATH).mkdirs();

        try {
            //transfer the file to both the location
            file.transferTo(new File(realPath + code + ".jpg"));
            file.transferTo(new File(ABS_PATH + code + ".jpg"));
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }
        return true;
    }
}
