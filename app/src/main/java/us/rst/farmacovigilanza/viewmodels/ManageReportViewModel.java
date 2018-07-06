package us.rst.farmacovigilanza.viewmodels;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import us.rst.farmacovigilanza.database.entity.PatientEntity;
import us.rst.farmacovigilanza.models.FiscalCode;
import us.rst.farmacovigilanza.repositories.ReportsRepository;

public class ManageReportViewModel extends BaseViewModel {

    private final ReportsRepository reportsRepository;

    /**
     * Initializes a new instance of this class
     *
     * @param application
     */
    public ManageReportViewModel(@NonNull Application application, ReportsRepository reportsRepository) {
        super(application);
        this.reportsRepository = reportsRepository;
    }

    /**
     * This class Factory
     */
    public static class Factory extends ViewModelProvider.NewInstanceFactory {
        @NonNull
        private final Application application;
        private final ReportsRepository reportsRepository;

        /**
         * Initializes a Factory for this viewmodel
         * @param application
         */
        public Factory(@NonNull Application application, ReportsRepository reportsRepository) {
            this.application = application;
            this.reportsRepository = reportsRepository;
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
            return (T) new ManageReportViewModel(application, reportsRepository);
        }
    }

    public LiveData<PatientEntity> getPatient(FiscalCode fiscalCode) {
        return reportsRepository.getPatient(fiscalCode);
    }
}
