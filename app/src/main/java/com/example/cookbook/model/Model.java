package com.example.cookbook.model;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import androidx.core.os.HandlerCompat;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Model {
    private static final Model _instance = new Model();

    private Executor executor = Executors.newSingleThreadExecutor();
    private Handler mainHandler = HandlerCompat.createAsync(Looper.getMainLooper());
//    private FirebaseModel firebaseModel = new FirebaseModel();
    AppLocalDbRepository localDb = AppLocalDb.getAppDb();

    public static Model instance(){
        return _instance;
    }
    private Model(){
    }

    public interface Listener<T>{
        void onComplete(T data);
    }


    public enum LoadingState{
        LOADING,
        NOT_LOADING
    }
    final public MutableLiveData<LoadingState> EventStudentsListLoadingState = new MutableLiveData<LoadingState>(LoadingState.NOT_LOADING);


    private LiveData<List<Recipe>> recipeList;
    public LiveData<List<Recipe>> getAllStudents() {
        if(recipeList == null){
            recipeList = localDb.recipeDao().getAll();
            refreshAllRecipes();
        }
        return recipeList;
    }

    public void refreshAllRecipes(){
//        EventStudentsListLoadingState.setValue(LoadingState.LOADING);
//        // get local last update
//        Long localLastUpdate = Recipe.getLocalLastUpdate();
//        // get all updated recorde from firebase since local last update
//        firebaseModel.getAllStudentsSince(localLastUpdate,list->{
//            executor.execute(()->{
//                Log.d("TAG", " firebase return : " + list.size());
//                Long time = localLastUpdate;
//                for(Student st:list){
//                    // insert new records into ROOM
//                    localDb.studentDao().insertAll(st);
//                    if (time < st.getLastUpdated()){
//                        time = st.getLastUpdated();
//                    }
//                }
//                try {
//                    Thread.sleep(3000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                // update local last update
//                Student.setLocalLastUpdate(time);
//                EventStudentsListLoadingState.postValue(LoadingState.NOT_LOADING);
//            });
//        });
    }

    public void addStudent(Recipe st, Listener<Void> listener){
//        firebaseModel.addStudent(st,(Void)->{
//            refreshAllRecipes();
//            listener.onComplete(null);
//        });
    }

    public void uploadImage(String name, Bitmap bitmap, Listener<String> listener) {
//        firebaseModel.uploadImage(name,bitmap,listener);
    }
}