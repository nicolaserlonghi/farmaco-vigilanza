package us.rst.farmacovigilanza.viewmodels;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import java.util.List;

import us.rst.farmacovigilanza.database.entity.DrugEntity;
import us.rst.farmacovigilanza.repositories.DrugsRepository;

public class DrugsViewModel extends BaseViewModel{

    private DrugsRepository drugsRepository;

    public DrugsViewModel(@NonNull Application application, DrugsRepository drugsRepository) {
        super(application);
        this.drugsRepository = drugsRepository;
    }

    /**
     * Restituisce una lista osservabile di farmaci
     * @return lista osservabile di farmaci
     */
    public LiveData<List<String>> getDrugs() {
        return drugsRepository.getDrugs();
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
        public Factory(@NonNull Application application, DrugsRepository repository) {
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
            return (T) new DrugsViewModel(application, repository);
        }

        @NonNull
        private final Application application;
        private final DrugsRepository repository;
    }
}