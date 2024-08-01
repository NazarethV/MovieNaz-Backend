package com.movieflix.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileServiceImpl implements FileService{


    @Override
    public String uploadFile(String path, MultipartFile file) throws IOException {

        //get name (necesitamos el nombre del archivo, porque necesitamos devlver eso)
        String fileName = file.getOriginalFilename()

        //to get the file path
        String filePath = path + File.separator + fileName;

        //create file object
        File f = new File(path);
        if(!f.exists()){
            f.mkdir();
        }

        //copy the file or upload file to the path
        Files.copy(file.getInputStream(), Paths.get(filePath), StandardCopyOption.REPLACE_EXISTING);

        return fileName;
    }


    @Override
    public InputStream getResourceFile(String path, String name) throws FileNotFoundException {
        return null;
    }
}
