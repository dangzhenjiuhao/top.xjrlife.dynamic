package top.xjrlife.dynamic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import top.xjrlife.dynamic.dto.Result;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * 创建人：xjz
 * 创建时间：2018/7/19
 */
@RequestMapping("image")
@Controller
public class ImageController {
    @RequestMapping(value = "upload",method = RequestMethod.POST)
    @ResponseBody
    public Result upload(HttpServletRequest request, @RequestParam("file") MultipartFile file){
        Result result = new Result();
        //如果文件不为空，写入上传路径
        if(!file.isEmpty()) {
            //上传文件路径
            String path = request.getServletContext().getRealPath("/images/");
            //获取后缀
            String ext = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")+1);
            //上传文件名
            String filename = UUID.randomUUID().toString().replace("-", "").toLowerCase() + "." + ext;
            File filepath = new File(path,filename);
            //判断路径是否存在，如果不存在就创建一个
            if (!filepath.getParentFile().exists()) {
                filepath.getParentFile().mkdirs();
            }
            //将上传文件保存到一个目标文件当中
            try {
                file.transferTo(new File(path + File.separator + filename));
                result.setCode(200);
                result.setMsg("success");
                result.setData("/images/" + filename);
            } catch (IOException e) {
                result.setCode(500);
                result.setMsg(e.getMessage());
            }

        } else {
            result.setCode(500);
            result.setMsg("上传异常");
        }
        return result;
    }
}
