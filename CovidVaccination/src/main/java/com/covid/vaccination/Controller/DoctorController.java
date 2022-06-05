//package com.covid.vaccination.Controller;
//
//import com.covid.vaccination.Entity.Doctor;
//import com.covid.vaccination.Service.DoctorServicesImp;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//


//// this Controller class is not able to controlled by me
//@RestController
//public class DoctorController {
//
//    @Autowired
//    public final DoctorServicesImp dsi;
//
//        public DoctorController(DoctorServicesImp dsi) {
//            this.dsi = dsi;
//        }
//
//
//        //    Create User
//        @PostMapping("/addDoctor")
//        public String createUser(@RequestBody Doctor doctor){
//            dsi.addDoctor(doctor);
//            return "Doctor Has Been Added Successfully.";
//        }
//
//    //    get User Using User_id
//    @GetMapping("/Doctor/{did}")
//    public Doctor getUserById(@PathVariable("did") Integer id) {
//
//        return dsi.getDoctor(id);
//
//    }
//////    Get All Users
////
////    @GetMapping("/Users")
////    public List<User> getAllUserFromDB(){
////        return usi.getAllUsers();
////    }
////    // Delete User By Id
////    @DeleteMapping("/deleteUser/{id}")
////    public User deleteUserUsingId(@PathVariable("id") Integer id){
////        return usi.deleteUserById(id);
////    }
////    // Update User Using Key.
////    @PutMapping("/updateUser")
////    public User updateUserByUsingId(@RequestBody User user,@RequestParam String key) {
////        return usi.updateUser(user, key);
////
////    }
//
//    }
//
//
//}
