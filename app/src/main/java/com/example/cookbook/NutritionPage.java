package com.example.cookbook;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cookbook.databinding.FragmentNutritionApiBinding;
import com.example.cookbook.databinding.FragmentRecipePageBinding;
import com.example.cookbook.model.NutrientInfo;
import com.example.cookbook.model.NutritionModel;


public class NutritionPage extends Fragment {
    FragmentNutritionApiBinding binding;


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public NutritionPage() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
//    public static NutritionPage newInstance(String param1, String param2) {
//        NutritionPage fragment = new NutritionPage();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentNutritionApiBinding.inflate(inflater, container, false);
        View view = binding.getRoot();


        binding.nutritionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value = String.valueOf(binding.nutritionSearchTV.getText());
                LiveData<NutrientInfo> data = NutritionModel.instance.searchInfoByTitle("100 gram "+value);
                data.observe(getViewLifecycleOwner(),info->{
//                    Log.d("TAG","*****************************************************" + info.getEnergy().getQuantity()+" "+info.getEnergy().getUnit() +"**********************************************************");
                    binding.nutritionName.setText(value);
                    binding.nutritionEnergy.setText("Energy:  "+ info.getEnergy().getQuantity()+" "+info.getEnergy().getUnit());
                    binding.nutritionProtein.setText("Protein:  "+ info.getProtein().getQuantity()+" "+info.getProtein().getUnit());
                    binding.nutritionCarbs.setText("Carbs:  "+ info.getCarbohydrates().getQuantity()+" "+info.getCarbohydrates().getUnit());
                    binding.nutritionSuger.setText("Sugar:  "+ info.getSugar().getQuantity()+" "+info.getSugar().getUnit());
                    binding.nutritionFiber.setText("Fiber:  "+ info.getFiber().getQuantity()+" "+info.getFiber().getUnit());
                    binding.nutritionFat.setText("Fat:  "+ info.getFat().getQuantity()+" "+info.getFat().getUnit());
                    binding.nutritionColesterol.setText("Cholesterol:  "+ info.getCholesterol().getQuantity()+" "+info.getCholesterol().getUnit());
                });
            }
        });



        return view;
//        return inflater.inflate(R.layout.fragment_nutrition_api, container, false);
    }

}