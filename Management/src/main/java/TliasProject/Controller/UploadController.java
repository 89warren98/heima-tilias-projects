package TliasProject.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import TliasProject.POJO.Result;
import TliasProject.Utils.AliOSSUtils;

import java.io.IOException;

/*
 * author: Warren
 */
@Slf4j
@RestController
public class UploadController {

    //    @PostMapping("/upload")
//    public Result upload(String username,Integer age,MultipartFile image) throws Exception {
//        log.info("文件上传:{},{},{}",username,age,image);
//        String originalFilename = image.getOriginalFilename();
//
//        //防止文件名重复造成文件的覆盖
//        int index = originalFilename.lastIndexOf(".");
//        String extendName = originalFilename.substring(index);
//        String newFileName = UUID.randomUUID().toString()+extendName;
//
//        log.info("新的文件名字:{}",newFileName);
//        image.transferTo(new File("D:\\Test\\"+newFileName));
//        return Result.success();
//    }
    @Autowired
    private AliOSSUtils aliOSSUtils;

    @PostMapping("/upload")
    public Result upload(MultipartFile image) throws IOException {

        log.info("Upload File:{}", image.getOriginalFilename());
        String url = aliOSSUtils.upload(image);

        log.info("url:{}", url);
        return Result.success(url);
    }
}
//D:\Test
