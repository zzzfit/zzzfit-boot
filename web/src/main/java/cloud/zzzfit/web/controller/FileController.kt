package cloud.zzzfit.web.controller

import lombok.extern.slf4j.Slf4j
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile


@Slf4j
@RestController
@RequestMapping("/file")
class FileController {

    @PostMapping(path = ["/upload"])
    fun uploadFile(@RequestParam("file") file: MultipartFile): ResponseEntity<String> {
        return if (file.isEmpty) ResponseEntity(HttpStatus.NOT_FOUND) else ResponseEntity(HttpStatus.OK)
    }
}