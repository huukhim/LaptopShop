package vn.hoidanit.laptopshop.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.ServletContext;

@Service
public class UploadService {

    private final ServletContext servletContext;

    public UploadService(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    public String handleSaveUploadFile(MultipartFile file, String targetFolder) {
        // noi luu tru file
        String rootPath = this.servletContext.getRealPath("/resources/images");
        String finalName = "";
        try {
            // lấy hình ảnh dưới dạng byte
            byte[] bytes = file.getBytes();

            // webapp/resources/images/avatar
            File dir = new File(rootPath + File.separator + targetFolder);
            if (!dir.exists()) // kiem tra ton tai cua thu muc avatar
                dir.mkdirs();
            // Create the file on server
            finalName = System.currentTimeMillis() + "-" + file.getOriginalFilename();
            File serverFile = new File(dir.getAbsolutePath() + File.separator + finalName); // = new File(Nơi lưu ảnh)

            BufferedOutputStream stream = new BufferedOutputStream(
                    new FileOutputStream(serverFile)); // truyen vao file muon luu
            stream.write(bytes); // ghi file
            stream.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return finalName;
    }

    public String handleDisplayUploadedFile(String fileName, String targetFolder) {
        String rootPath = this.servletContext.getRealPath("/resources/images");
        return rootPath + File.separator + targetFolder + File.separator + fileName;
    }
}
