package zhonger.cancer.bbs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import zhonger.cancer.bbs.dto.FileDTO;

import java.io.File;
import java.io.IOException;

@Controller
public class FileController {
    @RequestMapping("/file/upload")
    @ResponseBody
    public FileDTO upload(@RequestParam(value = "editormd-image-file", required = false)MultipartFile image) {
        String imageName = image.getOriginalFilename();
        String imagePath = "C:/code/bbs/src/main/resources/static/images/";
        File destination = new File(imagePath+imageName);
        try {
            image.transferTo(destination);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String presentCatalog = "http://localhost:8887/images/"+imageName;
        FileDTO fileDTO = new FileDTO();
        fileDTO.setSuccess(1);
        fileDTO.setUrl(presentCatalog);
        return fileDTO;
    }
}
