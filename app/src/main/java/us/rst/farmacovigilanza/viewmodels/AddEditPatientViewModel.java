package us.rst.farmacovigilanza.viewmodels;

import android.app.Application;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import us.rst.farmacovigilanza.FarmacoVigilanzaApp;
import us.rst.farmacovigilanza.database.entity.PatientEntity;
import us.rst.farmacovigilanza.repositories.PatientRepository;

public class AddEditPatientViewModel extends BaseViewModel {
    /**
     * Initializes a new instance of this class
     *
     * @param application
     */
    public AddEditPatientViewModel(@NonNull Application application, PatientRepository repository) {
        super(application);
        this.repository = repository;
    }

    public void add(PatientEntity patientEntity){
        repository.add(patientEntity);
    }

    /**
     * This class Factory
     */
    public static class Factory extends ViewModelProvider.NewInstanceFactory {
        /**
         * Initializes a Factory for this viewmodel
         * @param application
         */
        public Factory(@NonNull Application application) {
            this.application = application;
            this.repository = ((FarmacoVigilanzaApp) application).getDataRepository().getPatientRepository();
        }

        /**
         * Gets the actual viewmodel
         * @param modelClass model of the... Viewmodel
         * @param <T> type of the viewmodel
         * @return the viewmodel
         */
        @Override
        public <T extends ViewModel> T create(Class<T> modelClass) {
            //noinspection unchecked
            return (T) new AddEditPatientViewModel(application, repository);
        }

        @NonNull
        private final Application application;
        private final PatientRepository repository;
    }

    private final PatientRepository repository;
}
