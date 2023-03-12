package com.example.cookbook;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.cookbook.model.Model;
import com.example.cookbook.model.User;

import java.util.List;

public class EditUserViewModel extends ViewModel {
    private LiveData<User> user = Model.instance().getExsitUser();


    LiveData<User> getUser(){
        return user;
    }

}
