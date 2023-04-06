package com.example.splitwisev1.controllers;


import com.example.splitwisev1.dtos.ControllerRequestDTO;
import com.example.splitwisev1.dtos.ControllerResponseDTO;
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
    public RequestEntity<ControllerResponseDTO> settleIndividualUser(@RequestBody ControllerRequestDTO controllerRequestDTO){
       return null;
   }


   //Settle the payments of the entire group

   @PostMapping("/group")
    public RequestEntity<ControllerResponseDTO> settleGroupUser(@RequestBody ControllerRequestDTO controllerRequestDTO){
       ControllerResponseDTO controllerResponseDTO = groupSettleService.settle(controllerRequestDTO.getGroupId(), controllerRequestDTO.getRequesterUserId());

       return null;
   }
    @GetMapping("/group2")
    public void settleGroupUser2(){
        System.out.println("Came here group2");
        ControllerRequestDTO controllerRequestDTO = new ControllerRequestDTO();
        controllerRequestDTO.setGroupId(1);
        controllerRequestDTO.setRequesterUserId(1);
        ControllerResponseDTO controllerResponseDTO = groupSettleService.settle(controllerRequestDTO.getGroupId(), controllerRequestDTO.getRequesterUserId());

    }

}
