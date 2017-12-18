package com.websystique.springsecurity.controller;
 
import java.io.File;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import com.websystique.springsecurity.model.FileBucket;
import com.websystique.springmvc.util.FileValidator;
import com.websystique.springsecurity.dao.FileUploadDAO;
import com.websystique.springsecurity.model.ImageSujet;
import com.websystique.springsecurity.service.ImageSujetService;
import com.websystique.springsecurity.service.SujetService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
 
/**
 * Handles requests for the file upload page.
 */
@Controller
@RequestMapping("/image")
public class ImageSujetControler {
	
	 private static String UPLOAD_LOCATION="C:/Users/youpi/git/ProjetAchatCollectif1/src/main/webapp/static/images/";
	 
    @Autowired
    private FileUploadDAO fileUploadDao;
    
    @Autowired
    private ImageSujetService imageSujetService;
    
//    @Autowired
//    FileValidator fileValidator;
//    
//       @InitBinder("fileBucket")
//     protected void initBinder(WebDataBinder binder) {
//       binder.addValidators(fileValidator);
//      }
    
    @Autowired
    SujetService  sujetService;
 
    @RequestMapping(value = "/doUploadshow", method = RequestMethod.GET)
    public String showUploadForm( ModelMap model,HttpServletResponse response,HttpServletRequest request) {
    	

       FileBucket fileModel = new FileBucket();
        model.addAttribute("fileBucket", fileModel);
        return "managedocuments";
    }
     
    @RequestMapping(value = "/doUpload", method = RequestMethod.POST)
    public String handleFileUpload(	@RequestParam MultipartFile fileUpload, ModelMap model) throws Exception {
          
//    	 if (fileUpload != null && fileUpload.length > 0) {
//             for (CommonsMultipartFile aFile : fileUpload){
                  
                System.out.println("Saving file: " + ((MultipartFile) fileUpload).getOriginalFilename());
             
                ImageSujet uploadFile = new ImageSujet();
                uploadFile.setName( fileUpload.getOriginalFilename());
               uploadFile.setContent( fileUpload.getBytes());
                uploadFile.setType( fileUpload.getContentType());
                //uploadFile.setSujet(sujetService.findById(sujet_id));
                fileUploadDao.save(uploadFile);     
                
                
                FileCopyUtils.copy(fileUpload.getBytes(), new File(UPLOAD_LOCATION + fileUpload.getOriginalFilename()));
              String filename = fileUpload.getOriginalFilename();
              model.addAttribute("fileName", filename);
          //  }
              
          	
              return "redirect:/";
        // }
    	
    	
    	
//    	System.out.println("Saving file: " + ((MultipartFile) fileUpload).getOriginalFilename());
//        
//        ImageSujet uploadFile = new ImageSujet();
//        uploadFile.setName(((MultipartFile) fileUpload).getOriginalFilename());
//        uploadFile.setContent(((MultipartFile) fileUpload).getBytes());
//        uploadFile.setType(((MultipartFile) fileUpload).getContentType());
//        fileUploadDao.save(uploadFile);   
    	
    	
    	
    	
    	
//        System.out.println("Fetching file");
//        
//
//        ImageSujet document = new ImageSujet();
//        
//        MultipartFile multipartFile = fileBucket.getFile();
//         
//        document.setName(multipartFile.getOriginalFilename());
//        document.setType(multipartFile.getContentType());
//        document.setContent(multipartFile.getBytes());
//        imageSujetService.saveImage(document);
////        ------------Savetofile---------------
//      
//        FileCopyUtils.copy(fileBucket.getFile().getBytes(), new File(UPLOAD_LOCATION + fileBucket.getFile().getOriginalFilename()));
//        String filename = fileBucket.getFile().getOriginalFilename();
//        model.addAttribute("fileName", filename);
    	//FileBucket fileBucket, BindingResult result,
    
    }  
}