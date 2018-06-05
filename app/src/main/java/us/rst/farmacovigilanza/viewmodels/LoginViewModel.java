package us.rst.farmacovigilanza.viewmodels;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;
import us.rst.farmacovigilanza.database.entity.CredentialsEntity;
import us.rst.farmacovigilanza.repositories.CredentialsRepository;

public class LoginViewModel extends BaseViewModel {
    /**
     * Initializes a new instance of this class
     *
     * @param application
     */
    public LoginViewModel(@NonNull Application application, CredentialsRepository repository) {
        super(application);
        this.repository = repository;
    }

    /**
     * Effettua il login dati id e password
     * @param id id utente
     * @param password password utente
     * @return oggetto osservabile che invierà i dati delle credenziali a utente connesso
     */
    public LiveData<CredentialsEntity> getUser(String id, String password) {
        return repository.getCredentials(id, password);
    }

    /**
     * This class Factory
     */
    public static class Factory extends ViewModelProvider.NewInstanceFactory {
        /**
         * Initializes a Factory for this viewmodel
         *
         * @param application
         */
        public Factory(@NonNull Application application, CredentialsRepository repository) {
            this.application = application;
            this.repository = repository;
        }

        /**
         * Gets the actual viewmodel
         *
         * @param modelClass model of the... Viewmodel
         * @param <T>        type of the viewmodel
         * @return the viewmodel
         */
        @Override
        public <T extends ViewModel> T create(Class<T> modelClass) {
            //noinspection unchecked
            return (T) new LoginViewModel(application, repository);
        }

        @NonNull
        private final Application application;
        private final CredentialsRepository repository;
    }

    private final CredentialsRepository repository;
}
