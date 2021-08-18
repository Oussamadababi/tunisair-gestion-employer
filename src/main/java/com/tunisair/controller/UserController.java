package com.tunisair.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.tunisair.dao.userEntityRepository;
import com.tunisair.entities.UserEntity;
import com.tunisair.message.MessageResponse;
import com.tunisair.service.AppConstants;
import com.tunisair.service.FileStorageService;
import com.tunisair.service.UserEntityService;




@CrossOrigin(origins = "http://localhost:4201")
@RestController
@RequestMapping("/User")
public class UserController {
	
	@Autowired 
	UserEntityService Us;
	@Autowired
	userEntityRepository UER;
	
	@Autowired
	FileStorageService fileStorageServiceImpl;
	
	// Ajout User

	
	/* liste de Users */
	@GetMapping(value="/findallusers")
	public List <UserEntity> findall(){	
		return  Us.findall();
		}
	
	/*Liste des  personnels*/
	@GetMapping(value="/findallPerso")
	public List <UserEntity> findallPerso(){	
		return  Us.findallPerso();
		}
	
	/*Liste des  Role*/
	@GetMapping(value="/FindRole")
	public List <String> FindRole(){	
		return  Us.findRole();
		}
	
	/*Liste des  Role by Iduser*/
	@GetMapping(value="/FindRoleByIdUser/{Iduser}")
	public List <Object> FindRoleByidU(@PathVariable(name="Iduser") String Iduser){	
		return  Us.findRoleByIdUser(Iduser);
		}
	//test push git
	@Transactional
	@DeleteMapping(value="/delete/{idr}/{idUser}")
	public void delete(@PathVariable(name="idr") String idr,@PathVariable(name="idUser") String idUser){
		Us.deleteRoleUser(idr, idUser);
		
	}
	
	@PutMapping(value = "/image/{id}")
	public void createImageProfil(@PathVariable(value = "id") String id,@RequestParam(required = true, value = AppConstants.EMPLOYEE_FILE_PARAM) List<MultipartFile> file)
			throws JsonParseException, JsonMappingException, IOException {
		for (MultipartFile i : file) {
			String fileName = fileStorageServiceImpl.storeFile(i);
			String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
					.path(AppConstants.DOWNLOAD_PATH).path(fileName).toUriString();
			int num=fileDownloadUri.indexOf("/downloadFile");
			String partie1 =fileDownloadUri.substring(0,num);
			String partie2 =fileDownloadUri.substring(num,fileDownloadUri.length());
			String Complete = partie1+"/User/"+partie2;
			UER.UpdateProfilPic(Complete, id);
			
		}


	}
	@GetMapping(value = "/downloadFile/{fileName:.+}")
	public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
		Resource resource = fileStorageServiceImpl.loadFileAsResource(fileName);
		String contentType = null;
		try {
			contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		if (contentType == null) {
			contentType = AppConstants.DEFAULT_CONTENT_TYPE;
		}
		return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType))
				.header(HttpHeaders.CONTENT_DISPOSITION,
						String.format(AppConstants.FILE_DOWNLOAD_HTTP_HEADER, resource.getFilename()))
				.body(resource);
	}
	
	@GetMapping(value = "/imageProfil/{id}")
	public Object GetprofilPic(@PathVariable(value = "id") String id){
	 return	UER.GetProfilPic(id);
		
	}
	
	@GetMapping(value = "/getuser/{username}")
	public UserEntity getUserbyUsername(@PathVariable(value = "username") String username){
	 return	UER.GetUserbyUsername(username);
		
	}
	
	@PutMapping(value = "/updateDetailsU/{value}/{id}/{attribute}")
	public ResponseEntity<MessageResponse> updateUserDetail(@PathVariable(value = "value") String value,@PathVariable(value = "id") String id,@PathVariable(value = "attribute") String attribute){
		
		Us.ChangeDetailUser(value, id, attribute);
		return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse("Details user modifié"));
	}
	
}
	

