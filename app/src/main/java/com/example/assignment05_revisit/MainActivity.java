package com.example.assignment05_revisit;

import androidx.appcompat.app.AppCompatActivity; // Import the base class for activities
import android.os.Bundle; // Import the class for saving and restoring state

public class MainActivity extends AppCompatActivity { // MainActivity is an Activity, the main entry point

    @Override
    protected void onCreate(Bundle savedInstanceState) { // onCreate is called when the Activity is created
        super.onCreate(savedInstanceState); // Call the superclass's onCreate method
        setContentView(R.layout.activity_main); // Set the layout for this Activity

        // Check if this is the first time the Activity is created
        if (savedInstanceState == null) {
            // If it's the first time, start a fragment transaction
            getSupportFragmentManager().beginTransaction() // Get the FragmentManager and start a transaction
                    .replace(R.id.fragment_container, new WelcomeFragment()) // Replace the content of the container with WelcomeFragment
                    .commit(); // Commit the transaction (execute it)
        }
    }

    // Method to load the CreateUserFragment
    public void loadCreateUserFragment() {
        getSupportFragmentManager().beginTransaction() // Start a new fragment transaction
                .replace(R.id.fragment_container, new CreateUserFragment()) // Replace the current fragment with CreateUserFragment
                .addToBackStack(null) // Add the transaction to the back stack (so the user can go back)
                .commit(); // Commit the transaction
    }

    // Method to load the ProfileFragment and pass the user data
    public void loadProfileFragment(User user) {
        ProfileFragment profileFragment = ProfileFragment.newInstance(); // Create a new instance of ProfileFragment
        Bundle bundle = new Bundle(); // Create a new Bundle to pass data
        bundle.putSerializable("user", user); // Put the User object into the Bundle
        profileFragment.setArguments(bundle); // Set the Bundle as arguments for the ProfileFragment

        getSupportFragmentManager().beginTransaction() // Start a new fragment transaction
                .replace(R.id.fragment_container, profileFragment) // Replace the current fragment with ProfileFragment
                .addToBackStack(null) // Add the transaction to the back stack
                .commit(); // Commit the transaction
    }
}