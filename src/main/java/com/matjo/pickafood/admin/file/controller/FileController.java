package com.matjo.pickafood.admin.file.controller;

import com.matjo.pickafood.admin.file.dto.FileDTO;
import com.matjo.pickafood.admin.file.service.FileService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.coobird.thumbnailator.Thumbnails;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@Log4j2
@RequiredArgsConstructor
public class FileController {

    private final FileService fileService;

    //이미지 보이기
    @GetMapping("/view")  //  /{fileName:.+}
    public ResponseEntity<byte[]> viewFile(String fileName){  //@PathVariable("fileName")
        //log.info("--------------------: "+fileName);

        File targetFile = new File("D:\\upload\\"+fileName);

        try {
            String mimeType = Files.probeContentType(targetFile.toPath());

            byte[] data = FileCopyUtils.copyToByteArray(targetFile);

            return ResponseEntity.ok().header("Content-Type",mimeType)
                    .body(data);

        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(404).build();
        }

    }


    //이미지 업로드
    @ResponseBody
    @PostMapping("/upload")
    public List<FileDTO> upload(MultipartFile[] files){
//        log.info("----------file---------");
//        log.info(files);
//        log.info("-----------------------");

        List<FileDTO> list = new ArrayList<>();
        
        for(MultipartFile file:files){
            // 업로드 되는 파일 이름
            String originalFileName = file.getOriginalFilename();

            boolean img = file.getContentType().startsWith("image"); //이미지 여부
            String uuid = UUID.randomUUID().toString();
            String saveName = uuid+"_"+originalFileName;
            //최종적으로 저장되는 파일 이름, 중복을 방지하기 위해서 사용된다.

            //log.info("---------upload file---------: "+file.getResource());

            String saveFolder = makeFolders();
            //날짜별로 첨부파일 정리하기

            File saveFile = new File("D:\\upload\\"+saveFolder+"\\"+saveName);

            // 서버까지 파일 업로드가 된 상태... 이제 저장을 해야하는데!
            try (InputStream in = file.getInputStream();
                 FileOutputStream fos = new FileOutputStream(saveFile);
            ){
                FileCopyUtils.copy(in, fos);
            } catch (IOException e) {
                e.printStackTrace();
            }


            if(img){
                //saveName == UUID + "_" + fileName
                String thumbFileName = saveFolder+"\\s_"+saveName;
                File thumbFile = new File("D:\\upload\\"+thumbFileName);

                try {
                    Thumbnails.of(saveFile)
                            .size(150, 150)
                            .toFile(thumbFile);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }//end if(boolean img)

            FileDTO fileDTO = FileDTO.builder()
                    .fileName(originalFileName)
                    .uuid(uuid)
                    .img(img)
                    .savePath(saveFolder)
                    .build();
            //독립적인 DB 등록시
            fileService.register(fileDTO); //파일매퍼 테이블에 upload 파일 정보 보내기

            log.info("fileDTO :  {}", fileDTO);
            list.add(fileDTO);
        }//end for

        return list;
    }//end upload1


    //폴더의 경로 만들어주기 // 폴더가 있었으면 안만들어진다 기본에 있던 폴더로 들어감
    private String makeFolders(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        String str = sdf.format(new java.util.Date()); //new Date 나는 java.util 에 있는 것으로 사용한다.

        File folderPath = new File("D:\\upload\\"+str);

        //이 경로가 존재하지 않는다면?
        if(!folderPath.exists()){
            folderPath.mkdirs();
        }

        return str;
    }//end makeFolders

    
    //파일 삭제하기
    @PostMapping("/delete")
    @ResponseBody //이거 안주면 응답이 안나간다.
    public String  deleteFile(String fileName){
        int idx = fileName.lastIndexOf("/");
        String path = fileName.substring(0, idx); //경로
        String name = fileName.substring(idx+1); //삭제할 파일 이름
        //name -> uuid_fileName 상태 _ 앞에 uuid만 가져오기
        String uuid = name.substring(0,name.indexOf("_"));

        // log.info("path: "+path);
        // log.info("name: "+name);

        File targetFile = new File("D:\\upload\\"+fileName);
        boolean result = targetFile.delete();

        //원본 파일 삭제 후 삭제 성공하면 섬네일 삭제하기
        if(result){
            File thumbFile = new File("D:\\upload\\"+path+"\\s_"+name);
            thumbFile.delete();
        }

        //독립적인 DB 등록 방법
        fileService.remove(uuid);

        return "success";

    }

}
