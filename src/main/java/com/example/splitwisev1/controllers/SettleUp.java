package com.example.splitwisev1.controllers;


import com.example.splitwisev1.dtos.RequestDTO;
import com.example.splitwisev1.dtos.ResponseDTO;
import com.example.splitwisev1.services.GroupSettleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/settle")
public class SettleUp {


    @Autowired
    private GroupSettleService groupSettleService;


    public SettleUp(GroupSettleService groupSettleService) {
        this.groupSettleService = groupSettleService;
    }

    //Settle the payments against a single user
   @PostMapping("/individual")
    public RequestEntity<ResponseDTO> settleIndividualUser(@RequestBody RequestDTO requestDTO){
       return null;
   }


   //Settle the payments of the entire group

   @PostMapping("/group")
    public RequestEntity<ResponseDTO> settleGroupUser(@RequestBody RequestDTO requestDTO){
       ResponseDTO responseDTO = groupSettleService.settle(requestDTO.getGroupId(),requestDTO.getRequesterUserId());

       return null;
   }

}
