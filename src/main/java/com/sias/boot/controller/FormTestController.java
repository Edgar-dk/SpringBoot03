package com.sias.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author Edgar
 * @create 2022-03-03 20:03
 * @faction: 文件上传的测试
 */
@Controller
public class FormTestController {

    /*1.主页面跳转到子页面（就是把这个地址填写在主页面中，找到这个地址，最后在到子页面）*/
    @GetMapping("form_layouts")
    public String form_layouts(){
        /*跳转到具体的页面地址，前面是自己创建的文件夹*/
        return "form/form_layouts";
    }

    /*2.子页面接受数据的地址（post的方式）*/
    @PostMapping("/upload")
    public String  update(/*01.上传过来的数据，需要用参数接受,
    至于什么参数，就需要根据过来的类型来判断，提交过来的数据以post的方式，所以
    接受的也是一post的方式,后面两个是文件的形式，也应该文件的方式接受，只是在接受多个
    的时候，应该按照数组的方式，接受了，还没有放在一个位置*/
                                             @RequestParam("email") String email,
                                             @RequestParam("username") String username,
                                             @RequestPart("headerImg") MultipartFile headerImg,
                                             @RequestPart("photos") MultipartFile[] photos) throws IOException {
        if(!headerImg.isEmpty()){
            /*02.上传数据到服务器，下面的方式是获得，上传文件的名字*/
            String originalFilename = headerImg.getOriginalFilename();
            /*03.把文件传输的地方，后面的哪一个是获取文件的名字*/
            headerImg.transferTo(new File("D:\\WeGameApps\\"+originalFilename));
        }
        /*04.为什么不和上面的判断方式一样，原因：这个是多个文件
        *    不为空，不代表，上传的够了，需要先判断是否大于0，然后在一个
        *    一个的判断文件是否存在*/
        if(photos.length > 0){
            /*05.遍历的方式看看文件是不是都存在*/
            for (MultipartFile photo : photos) {
                if(!photo.isEmpty()){
                    String originalFilename = photo.getOriginalFilename();
                    photo.transferTo(new File("D:\\WeGameApps\\"+originalFilename));
                }
            }
        }
        return "main";
    }
}
