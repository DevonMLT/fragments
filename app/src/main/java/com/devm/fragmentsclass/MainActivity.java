package com.devm.fragmentsclass;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    //we have created these variables to connect to the XML buttons
    Button firstFragmentBtn, secondFragmentBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //this will connect the variables to the XML button using their ID
        firstFragmentBtn = findViewById(R.id.fragment1btn);
        secondFragmentBtn = findViewById(R.id.fragment2btn);

        //setOnClickListener links a listener with certain attributes
        //since you can't instantiate setOnClickListener
        //you override with the onClick method
        firstFragmentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //this is a method name I have created with parameters
                //Fragment1 is the name of the new java file we created
                replaceFragment(new Fragment1());
            }
        });

        //when the button is clicked, the method replaceFragment will run
        secondFragmentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //this is a method name I have crated with parameters
                replaceFragment(new Fragment2());
            }
        });
    }

        //this is my private method for when thhe button is clicked
        //I have added a parameter for the fragments
        private void replaceFragment(Fragment fragment) {

            //accessing the fragmentManager class
            FragmentManager fragmentManager = getSupportFragmentManager();
            //we connect the fragmentManager to the fragmentTransaction and begin it
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            //since the fragmentTransaction is responsible for changes such as add/remove/replace..
            //.. we can use replace
            fragmentTransaction.replace(R.id.frameLayout,fragment);
            //the commit() call signals to the FragmentManager..
            //.. that all operations have been added to the transaction.
            fragmentTransaction.commit();

            //FragmentManager fragmentManager = getSupportFragmentManager();
            //FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            //fragmentTransaction.replace(R.id.frameLayout,fragment);
            //fragmentTransaction.commit();
        }
    }