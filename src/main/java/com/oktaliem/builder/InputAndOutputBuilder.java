package com.oktaliem.builder;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;

import java.io.File;
import java.util.List;

public class InputAndOutputBuilder {

    public List<File> getAllFolderNameListed(String path){
        File dir = new File(path);
        List<File> files = (List<File>) FileUtils.listFiles(dir, TrueFileFilter.INSTANCE, TrueFileFilter.INSTANCE);
        for (File file : files) {
            System.out.println("file Name: " + file.getName());
        }
        return files;
    }
}
