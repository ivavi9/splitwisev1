package com.example.splitwisev1.controllers;


import com.example.splitwisev1.dtos.RequestDTO;
import com.example.splitwisev1.dtos.ResponseDTO;
import com.example.splitwisev1.services.GroupSettleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/settle")
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
    @GetMapping("/group2")
    public void settleGroupUser2(){
        System.out.println("Came here group2");
        RequestDTO requestDTO = new RequestDTO();
        requestDTO.setGroupId(1);
        requestDTO.setRequesterUserId(1);
        ResponseDTO responseDTO = groupSettleService.settle(requestDTO.getGroupId(),requestDTO.getRequesterUserId());

    }

}
