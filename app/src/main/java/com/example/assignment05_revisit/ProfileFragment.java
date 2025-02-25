package com.example.assignment05_revisit;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class ProfileFragment extends Fragment {
    private Button updateButton;
    private User user;
    private RadioGroup roleRadioGroup;

    public ProfileFragment() {
        // Required empty public constructor
    }

    public static ProfileFragment newInstance() {
        ProfileFragment fragment = new ProfileFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Get the User object from the arguments
        user = (User) getArguments().getSerializable("user");

        // Display the User object in the UI
        TextView nameTextView = view.findViewById(R.id.nameEdit);
        TextView emailTextView = view.findViewById(R.id.editTextText2);

        // Role is a radiogroup so we need to get the selected radio button
        roleRadioGroup = view.findViewById(R.id.roleEditText1);
        // Set the text of the TextViews to show the user's information
        nameTextView.setText(user.getName());
        emailTextView.setText(user.getEmail());
        // Find the TextView for the role
        // Set the text of the TextView to show the user's role
        // Find the selected radio button using the ID
        if (user.role.equals("Admin")) {
            roleRadioGroup.check(R.id.radioAdmin);
        } else if (user.role.equals("User")) {
            roleRadioGroup.check(R.id.radioUser);
        }

        updateButton= view.findViewById(R.id.updateButton);

        // Handle Update button click (navigate to EditUserFragment)
        updateButton.setOnClickListener(v -> {
            EditUserFragment editUserFragment = EditUserFragment.newInstance(user);
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.editUserFragment, editUserFragment)
                    .addToBackStack(null)
                    .commit();
        });
    }
}