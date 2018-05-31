package us.rst.farmacovigilanza.viewmodels;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;
import us.rst.farmacovigilanza.database.entity.DoctorEntity;
import us.rst.farmacovigilanza.models.Doctor;
import us.rst.farmacovigilanza.repositories.DoctorsRepository;

public class LoginViewModel extends BaseViewModel {
    /**
     * Initializes a new instance of this class
     *
     * @param application
     */
    public LoginViewModel(@NonNull Application application, DoctorsRepository repository) {
        super(application);
        this.repository = repository;
    }

    /**
     * Gets the doctor
     * @param id doctor id
     * @param password doctor password
     * @return an instance of {@link Doctor} if doctor exists; otherwise null
     */
    public LiveData<DoctorEntity> getDoctor(String id, String password) {
        return repository.getDoctor(id, password);
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
        public Factory(@NonNull Application application, DoctorsRepository repository) {
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
        private final DoctorsRepository repository;
    }

    private final DoctorsRepository repository;
}
