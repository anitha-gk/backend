package com.whatyourdoing.whatyourdoing.controllers;

import com.whatyourdoing.whatyourdoing.DTO.UserInfoDTO;
import com.whatyourdoing.whatyourdoing.data.UserInfoRepository;
import com.whatyourdoing.whatyourdoing.models.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Iterator;

@Controller
public class UserRegistrationController {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @CrossOrigin
    @RequestMapping(method= {RequestMethod.GET}, value= "ValidateUser",
            produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public HashMap<String,String> validateUser(@RequestParam String userID, String password) {
        System.out.println(" in validateUser, validating " + userID + " with password " + password);
        HashMap<String,String> returnSet = new HashMap<>();
        returnSet.put("STATUS","Failure");
        if (userID == null || userID.isEmpty()) {
            returnSet.put("STATUS","Failure");
        } else {

            Iterable<UserInfo> userInfos = userInfoRepository.findAll();
            Iterator<UserInfo> userInfoIterator = userInfos.iterator();
            UserInfo userInfo = null;
            while (userInfoIterator.hasNext()) {
                userInfo = (UserInfo) userInfoIterator.next();
                if (userInfo.getUSER_ID().equals(userID) &&
                        (userInfo.getPASSWORD().equals(password))
                ) {
                    returnSet.put("STATUS", "Success");
                    break;
                }
            }
        }
        return returnSet;
    }

    @CrossOrigin
    @RequestMapping(method= {RequestMethod.POST, RequestMethod.GET}, value= "RegisterUser",
            produces= MediaType.APPLICATION_JSON_VALUE, consumes ="application/json")
    @ResponseBody
    public HashMap<String,String> registerUser(@RequestBody UserInfoDTO userInfoDTO) {
        System.out.println(" In Register User " + userInfoDTO.toString());
        HashMap<String,String> returnSet = new HashMap<>();

        UserInfo userInfo = new UserInfo();
        userInfo.setFIRST_NAME(userInfoDTO.getFname());
        userInfo.setLAST_NAME(userInfoDTO.getLname());
        userInfo.setEMAIL(userInfoDTO.getEmail());
        userInfo.setUSER_ID(userInfoDTO.getUserID());
        userInfo.setPASSWORD(userInfoDTO.getPassword());

        userInfoRepository.save(userInfo);



        returnSet.put("STATUS","Success");
        return returnSet;
    }


}
