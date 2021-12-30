package com.uashuke.livefeed.usernotes.controller;

import com.uashuke.livefeed.usernotes.dao.UserNotesDao;
import com.uashuke.livefeed.usernotes.model.ApiRequest;
import com.uashuke.livefeed.usernotes.model.ApiResponse;
import com.uashuke.livefeed.usernotes.service.UserNotesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/usernotes")
public class UserNotesController {
    private static final Logger logger = LoggerFactory.getLogger(UserNotesController.class);

    @Autowired
    UserNotesService userNotesService;

    @RequestMapping(value = "/getAllUserNotes", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public ApiResponse getAllNotes(@RequestParam ApiRequest apiRequest) {
        logger.info("ApiRequest: " + apiRequest.toString());
        ApiResponse apiResponse = new ApiResponse("array");
        List<UserNotesDao> data = new ArrayList<>();
        int count = 0;
        long startTime = System.currentTimeMillis();
        String userName = "";
        try {
            userName = apiRequest.userNotes.getUsername();
            data = userNotesService.getAllNotes();
            count = data.size();
            apiResponse.setData(data);
        } catch (Exception e) {
            logger.error("Error! Details: ", e);
            apiResponse.setResponseCode(500);
            apiResponse.setResponseMessage("Failed! Unable to get user notes.");
        }
        long endTime = System.currentTimeMillis();
        logger.info("Usernotes end [user:" + userName + " | result: " + count + " | time: " + (endTime - startTime) + " ms]");
        return apiResponse;
    }

    @RequestMapping(value = "/saveUserNotes", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public ApiResponse setUserNotes(@RequestParam ApiRequest apiRequest) {
        logger.info("ApiRequest: " + apiRequest.toString());
        ApiResponse apiResponse = new ApiResponse();
        long startTime = System.currentTimeMillis();
        String userName = "";
        try {
            userName = apiRequest.userNotes.getUsername();
            userNotesService.saveUserNotes(apiRequest);
        } catch (Exception e) {
            logger.error("Error! Unable to save user notes. Details: ", e);
            apiResponse.setResponseCode(500);
            apiResponse.setResponseMessage("Failed! Unable to save user notes.");
        }
        long endTime = System.currentTimeMillis();
        logger.info("Usernotes save end [user:" + userName + " | time:" + (endTime - startTime) + " ms]");
        return apiResponse;
    }

    @RequestMapping(value = "/deleteUserNotes", method = RequestMethod.DELETE, consumes = "application/json")
    @ResponseBody
    public ApiResponse deleteUserNotes(@RequestParam ApiRequest apiRequest) {
        logger.info("ApiRequest: " + apiRequest.toString());
        ApiResponse apiResponse = new ApiResponse();
        long startTime = System.currentTimeMillis();
        String userName = "";
        try {
            userNotesService.deleteUserNotes(apiRequest);
        } catch (Exception e) {
            logger.error("Error! Unable to delete user notes. Details: ", e);
            apiResponse.setResponseCode(500);
            apiResponse.setResponseMessage("Failed! Unable to delete user notes.");
        }
        long endTime = System.currentTimeMillis();
        logger.info("Usernotes delete end [user:" + userName + " | time:" + (endTime - startTime) + " ms]");
        return apiResponse;
    }

    @RequestMapping(value = "/searchUserNotes", method = RequestMethod.GET)
    @ResponseBody
    public ApiResponse searchUserNotes(@RequestParam Map<String, String> aUserNotes) {
        logger.info("ApiRequest: " + aUserNotes.keySet().stream().map(key -> key + "=" + aUserNotes.get(key)).collect(Collectors.joining("\n")));
        String request = aUserNotes.get("request");
        ApiResponse apiResponse = new ApiResponse("array");
        long startTime = System.currentTimeMillis();
        String userName = "";
        int count = 0;
        boolean unidentifiedRequest = false;
        try{
            userName = aUserNotes.get("user_name");

            if(request!=null) {
                if(request.equals("search")) {
                    List<UserNotesDao> data = userNotesService.getAllNotesWs(aUserNotes);
                    apiResponse.setData(data);
                } else if(request.equals("insert") || request.equals("update")) {
                    userNotesService.saveUserNotesWs(aUserNotes);
                } else if(request.equals("delete")) {
                    userNotesService.deleteUserNotesWs(aUserNotes);
                } else{
                    unidentifiedRequest = true;
                }
            }

            if(request == null || unidentifiedRequest) {
                logger.error("Error! Unable to search user notes. Invalid request: " + request);
                apiResponse.setResponseCode(500);
                apiResponse.setResponseMessage("Failed! Unable to search user notes.");
            }
        }catch(Exception e){
            logger.error("Error! Unable to search user notes. Details: ", e);
            apiResponse.setResponseCode(500);
            apiResponse.setResponseMessage("Failed! Unable to search user notes.");
        }
        long endTime = System.currentTimeMillis();
        logger.info("Usernotes search end [user:"+userName+" | result: "+ count+ "| time: "+(endTime-startTime)+"ms]");
        return apiResponse;
    }

}
