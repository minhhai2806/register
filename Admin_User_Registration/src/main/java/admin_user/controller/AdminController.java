package admin_user.controller;

import admin_user.model.User;
import admin_user.repositories.UserRepository;
import admin_user.service.PdfService;
import admin_user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {


    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PdfService pdfService;

    @GetMapping(value = "/users/report", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> usersReport() {

        List<User> users = userRepository.findAll();

        ByteArrayInputStream bis = pdfService.usersReport(users);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=usersreport.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }


}
