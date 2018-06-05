package us.rst.farmacovigilanza.viewmodels;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import java.util.List;

import us.rst.farmacovigilanza.database.entity.ReportEntity;
import us.rst.farmacovigilanza.models.Report;
import us.rst.farmacovigilanza.repositories.ReportsRepository;

public class ReportsViewModel extends BaseViewModel{

    private ReportsRepository reportsRepository;

    public ReportsViewModel(@NonNull Application application, ReportsRepository reportsRepository) {
        super(application);
        this.reportsRepository = reportsRepository;
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
        public Factory(@NonNull Application application, ReportsRepository repository) {
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
            return (T) new ReportsViewModel(application, repository);
        }

        @NonNull
        private final Application application;
        private final ReportsRepository repository;
    }

    public LiveData<List<ReportEntity>> getReports() {
        return reportsRepository.getReports();
    }
}
