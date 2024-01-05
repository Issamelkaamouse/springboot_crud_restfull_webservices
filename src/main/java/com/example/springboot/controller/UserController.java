package com.example.springboot.controller;

import com.example.springboot.dto.UserDto;
import com.example.springboot.entity.User;
import com.example.springboot.exception.ErrorDetails;
import com.example.springboot.exception.ResourceNotFoundException;
import com.example.springboot.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.List;

@Tag(
        name = "CRUD REST API for User Resource",
        description = "CRUD REST APIs : Create User,Update User,Get User,Get All Users,Delete User"
)
@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {
    private UserService userService;
    @Operation(
            summary = "Crate User REST API",
            description = "Create user REST API is used to save a new user in the database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP status 201 Created"
    )

    @PostMapping()
    public ResponseEntity<UserDto> createUser(@RequestBody @Valid UserDto userDto){
        UserDto savedUserDto = userService.createUser(userDto);
        return new ResponseEntity<>(savedUserDto, HttpStatus.CREATED);
    }

    @Operation(
            summary = "Get User by id REST API",
            description = "Get user by id REST API is used to get a single  user from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP status 200 Success"
    )
    @GetMapping("{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long userId){
        UserDto userDto = userService.getUserById(userId);
        return  new ResponseEntity<>(userDto,HttpStatus.OK);
    }
    @Operation(
            summary = "Get all Users REST API",
            description = "Get all users REST API is used to get a all users from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP status 200 Success"
    )
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers(){
        List<UserDto> usersDto = userService.getAllUsers();
        return new ResponseEntity<>(usersDto,HttpStatus.OK);
    }

    @Operation(
            summary = "Update User REST API",
            description = "Update User by id REST API is used to update a particular user in the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP status 200 Success"
    )
    @PutMapping("{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("id") Long id,@RequestBody @Valid UserDto userDto){
         userDto.setId(id);
         UserDto updatedUserDto = userService.updateUser(userDto);
         return new ResponseEntity<>(updatedUserDto, HttpStatus.OK);
    }


    @Operation(
            summary = "Delete User REST API",
            description = "Delete user REST API is used to delete a particular user from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP status 200 Success"
    )
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long id){
        userService.deleteUser(id);
        return new ResponseEntity<>("User successfully deleted", HttpStatus.OK);
    }

//@ExceptionHandler(ResourceNotFoundException.class)
//    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(
//            ResourceNotFoundException exception,WebRequest webRequest)
//    {
//        ErrorDetails errorDetails = new ErrorDetails(
//                LocalDateTime.now(),
//                exception.getMessage(),
//                webRequest.getDescription(false),
//                "User_NOT_FOUND"
//        );
//        return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);
//    }
}
