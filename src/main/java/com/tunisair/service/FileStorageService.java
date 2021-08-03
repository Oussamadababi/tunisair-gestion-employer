package com.tunisair.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.tunisair.exception.FileStorageException;
import com.tunisair.exception.FileStorageProperties;
import com.tunisair.exception.MyFileNotFoundException;

@Service
public class FileStorageService {
	  private final Path fileStorageLocation;

	    @Autowired
	    public FileStorageService(FileStorageProperties fileStorageProperties) {
	        this.fileStorageLocation =Paths.get(fileStorageProperties.getUploadDir())
	                .toAbsolutePath().normalize();

	        try {
	            Files.createDirectories(this.fileStorageLocation);
	        } catch (Exception ex) {
	            throw new FileStorageException("Could not create the directory where the uploaded files will be stored.", ex);
	        }
	    }

	    public String storeFile(MultipartFile file) throws IOException {
	        // Normalize file name
	        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

	        // Check if the file's name contains invalid characters
			if(fileName.contains("..")) {
			    throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
			}         
	       
			String newFileName = System.currentTimeMillis() + "_" + fileName;
			//Path targetLocation = this.fileStorageLocation.resolve(newFileName);
			/*Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);*/
			//return newFileName;
			   // Copy file to the target location (Replacing existing file with the same name)

			Path targetLocation = this.fileStorageLocation.resolve(newFileName);
			Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
			return newFileName;
	    }

	    public Resource loadFileAsResource(String fileName) {
	    	try {
				Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
				Resource resource = new UrlResource(filePath.toUri());
				if (resource.exists()) {
					return resource;
				} else {
					throw new MyFileNotFoundException("File not found " + fileName);
				}
			} catch (MalformedURLException ex) {
				throw new MyFileNotFoundException("File not found " + fileName, ex);
			}
		}

}
