package id.t12uetatay.prototype.viewmodel;

import android.annotation.SuppressLint;
import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.google.firebase.auth.FirebaseUser;

import id.t12uetatay.prototype.repository.AuthAppRepository;

public class AuthViewModel extends AndroidViewModel {

    private AuthAppRepository authAppRepository;
    private MutableLiveData<FirebaseUser> userLiveData;
    private MutableLiveData<Boolean> loggedOutLiveData;

    public AuthViewModel(@NonNull Application application) {
        super(application);

        authAppRepository = new AuthAppRepository(application);
        userLiveData = authAppRepository.getUserLiveData();
        loggedOutLiveData = authAppRepository.getLoggedOutLiveData();
    }

    public MutableLiveData<FirebaseUser> getUserLiveData() {
        return userLiveData;
    }

    public MutableLiveData<Boolean> getLoggedOutLiveData() {
        return loggedOutLiveData;
    }

    public void login(String email, String password) {
        authAppRepository.login(email, password);
    }

    @SuppressLint("NewApi")
    public void register(String email, String password) {
        authAppRepository.register(email, password);
    }

    public void logOut() {
        authAppRepository.logOut();
    }
}
