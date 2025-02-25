package com.example.assignment05_revisit;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;
import java.io.Serializable;




import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class CreateUserFragment extends Fragment {
    private EditText nameEditText, emailEditText;
    private RadioGroup roleRadioGroup;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_create_user, container, false);

        nameEditText = view.findViewById(R.id.nameEditText);
        emailEditText = view.findViewById(R.id.emailEditText);
        roleRadioGroup = view.findViewById(R.id.roleEditText);
        Button createUserButton = view.findViewById(R.id.nextButton);

        createUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEditText.getText().toString();
                String email = emailEditText.getText().toString();
                int selectedId = roleRadioGroup.getCheckedRadioButtonId();
                RadioButton selectedRadioButton = view.findViewById(selectedId);
                String role = selectedRadioButton.getText().toString();

                User user = new User(name, email, role);
                // Get the MainActivity and call the method to load the ProfileFragment
                if (getActivity() instanceof MainActivity) {
                    ((MainActivity) getActivity()).loadProfileFragment(user);
                }
            }
        });

        return view;
    }
}











