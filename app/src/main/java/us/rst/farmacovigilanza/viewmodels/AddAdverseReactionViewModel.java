package us.rst.farmacovigilanza.viewmodels;

import android.app.Application;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import us.rst.farmacovigilanza.FarmacoVigilanzaApp;
import us.rst.farmacovigilanza.database.entity.AdverseReactionEntity;
import us.rst.farmacovigilanza.repositories.AdverseReactionRepository;

public class AddAdverseReactionViewModel extends BaseViewModel {
    /**
     * Initializes a new instance of this class
     *
     * @param application
     */
    public AddAdverseReactionViewModel(@NonNull Application application, AdverseReactionRepository repository) {
        super(application);
        this.repository = repository;
    }

    public void add(AdverseReactionEntity adverseReactionEntity){
        repository.add(adverseReactionEntity);
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
            this.repository = ((FarmacoVigilanzaApp) application).getDataRepository().getAdverseReactionRepository();
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
            return (T) new AddAdverseReactionViewModel(application, repository);
        }

        @NonNull
        private final Application application;
        private final AdverseReactionRepository repository;
    }

    private final AdverseReactionRepository repository;
}
