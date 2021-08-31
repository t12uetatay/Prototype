package id.t12uetatay.prototype.view.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseUser;

import id.t12uetatay.prototype.R;
import id.t12uetatay.prototype.view.activity.AuthActivity;
import id.t12uetatay.prototype.view.activity.MainActivity;
import id.t12uetatay.prototype.viewmodel.AuthViewModel;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LoginFragment} factory method to
 * create an instance of this fragment.
 */
public class LoginFragment extends Fragment {
    private AuthViewModel viewModel;
    private MaterialButton button;
    private TextInputEditText editText1;
    private TextInputEditText editText2;
    private TextInputLayout textInputLayout1;
    private TextInputLayout textInputLayout2;

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        init(view);
        return view;
    }

    private void init(View view){
        viewModel = new ViewModelProvider(this).get(AuthViewModel.class);
        button = view.findViewById(R.id.login);
        editText1 = view.findViewById(R.id.editext1);
        editText2 = view.findViewById(R.id.editext2);
        textInputLayout1 = view.findViewById(R.id.textInputLayout1);
        textInputLayout2 = view.findViewById(R.id.textInputLayout2);

        viewModel.getUserLiveData().observe(getActivity(), new Observer<FirebaseUser>() {
            @Override
            public void onChanged(FirebaseUser firebaseUser) {
                if (firebaseUser != null) {
                    startActivity(new Intent(getActivity(), MainActivity.class));
                }
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = editText1.getText().toString();
                String password = editText2.getText().toString();
                if (validate()){
                    viewModel.login(email, password);
                }
            }
        });

    }

    public boolean validate() {
        boolean valid = false;
        String Email = editText1.getText().toString();
        String Password = editText2.getText().toString();
        if (Email.isEmpty()) {
            valid = false;
            textInputLayout1.setError("Email Address Must Be Entered.");
        } else {
            valid = true;
            textInputLayout1.setError(null);
        }

        if (Password.isEmpty()) {
            valid = false;
            textInputLayout2.setError("Password Must Be Entered.");
        } else {
            valid = true;
            textInputLayout2.setError(null);
        }

        return valid;
    }
}