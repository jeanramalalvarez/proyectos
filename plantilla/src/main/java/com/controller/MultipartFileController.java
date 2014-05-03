package com.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping( "api/file" )
public class MultipartFileController{
	
	private final Logger	logger			= LoggerFactory.getLogger( this.getClass() );

	@RequestMapping(value="/upload", method=RequestMethod.POST, produces="application/json", headers="Accept=application/json")
    public String handleFileUpload(@RequestParam("file") MultipartFile file){
		//@RequestParam("name") String name,
		String name = "name";
		logger.info( name );
        if (!file.isEmpty()) {
        	System.out.println("size: " + file.getSize());
        	System.out.println("ContentType: " + file.getContentType());
        	System.out.println("name: " + file.getName());
        	System.out.println("originalFileName: " + file.getOriginalFilename());
            try {
                byte[] bytes = file.getBytes();
                BufferedOutputStream stream =
                        new BufferedOutputStream(new FileOutputStream(new File(name + "-uploaded")));
                stream.write(bytes);
                stream.close();
                return "You successfully uploaded " + name + " into " + name + "-uploaded !";
            } catch (Exception e) {
                return "You failed to upload " + name + " => " + e.getMessage();
            }
        } else {
            return "You failed to upload " + name + " because the file was empty.";
        }
    }

}
