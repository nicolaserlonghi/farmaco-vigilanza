package us.rst.farmacovigilanza.viewmodels;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import us.rst.farmacovigilanza.FarmacoVigilanzaApp;
import us.rst.farmacovigilanza.database.entity.FactorEntity;
import us.rst.farmacovigilanza.database.entity.PatientEntity;
import us.rst.farmacovigilanza.database.entity.PatientFactorEntity;
import us.rst.farmacovigilanza.database.entity.TherapyEntity;
import us.rst.farmacovigilanza.models.FiscalCode;
import us.rst.farmacovigilanza.repositories.PatientRepository;

public class PatientViewModel extends BaseViewModel {
    /**
     * Initializes a new instance of this class
     *
     * @param application
     */
    public PatientViewModel(@NonNull Application application, PatientRepository repository) {
        super(application);
        this.repository = repository;
        this.patientFactors = new MutableLiveData<>();
        this.patientTherapies = new MutableLiveData<>();
        this.patientFactors.setValue(new ArrayList<>());
        this.patientTherapies.setValue(new ArrayList<>());
    }

    /**
     * Aggiunge il paziente
     * @param patientEntity paziente
     */
    public void add(PatientEntity patientEntity) {
        if (isEditMode) {
            // TODO: implement edit
            return;
        }

        repository.add(patientEntity, patientFactors.getValue(), patientTherapies.getValue());
    }

    /**
     * Aggiunge un fattore di rischio legato al paziente
     * @param name nome fattore di rischio
     * @param level livello di rischio
     */
    public void addFactor(String name, int level) {
        PatientFactorEntity entity = new PatientFactorEntity();
        entity.setFactorName(name);
        entity.setLevelOfRisk(level);

        if (isEditMode) {
            entity.setPatientCf(FiscalCode.parse(cf));
            repository.addFactor(entity);
            return;
        }

        patientFactors.getValue().add(entity);
        patientFactors.setValue(patientFactors.getValue());
    }

    /**
     * Aggiunge una terapia legata al paziente
     * @param entity terapia legata al paziente
     */
    public void addTherapy(TherapyEntity entity) {
        if (isEditMode) {
            entity.setPatient(FiscalCode.parse(cf));
            repository.addTherapy(entity);
            return;
        }

        patientTherapies.getValue().add(entity);
        patientTherapies.setValue(patientTherapies.getValue());
    }

    /**
     * Restituisce una lista osservabile di tutti i {@link FactorEntity}
     * @return lista di {@link FactorEntity} osservabile
     */
    public LiveData<List<FactorEntity>> getFactors() {
        return repository.getFactors();
    }

    /**
     * Restituisce una lista osservabile di {@link PatientFactorEntity} collegati al paziente
     * @return lista osservabile di {@link PatientFactorEntity} collegati al paziente
     */
    public LiveData<List<PatientFactorEntity>> getPatientFactors() {
        if (isEditMode) {
            return repository.getPatientFactors(cf);
        }

        return patientFactors;
    }

    /**
     * Restituisce un oggetto osservabile di {@link PatientEntity}
     * @return un oggetto osservabile di {@link PatientEntity}
     */
    public LiveData<PatientEntity> getPatient() {
        return repository.getPatient(cf);
    }

    /**
     * Imposta il codice fiscale del paziente da modificare
     * @param cf codice fiscale del paziente
     */
    public void setPatient(String cf) {
        this.cf = cf;
        isEditMode = true;
    }

    /**
     * Restituisce una lista osservabile di {@link TherapyEntity} collegati al paziente
     * @return lista osservabile di {@link TherapyEntity} collegati al paziente
     */
    public LiveData<List<TherapyEntity>> getPatientTherapies() {
        if (isEditMode) {
            return repository.getPatientTherapies(cf);
        }

        return patientTherapies;
    }

    /**
     * Rimuove un fattore di rischio legato al paziente
     * @param name nome fattore di rischio
     */
    public void deleteFactor(String name) {
        if (isEditMode) {
            repository.deleteFactor(cf, name);
            return;
        }

        List<PatientFactorEntity> currentFactors = getPatientFactors().getValue();
        currentFactors.removeIf(patientFactorEntity -> patientFactorEntity.getFactorName() == name);
        patientFactors.setValue(currentFactors);
    }

    /**
     * Rimuove una terapia legata al paziente
     * @param medicineName nome del farmaco
     */
    public void deleteTherapy(String medicineName) {
        if (isEditMode) {
            repository.deleteTherapy(cf, medicineName);
            return;
        }

        List<TherapyEntity> currentFactors = getPatientTherapies().getValue();
        currentFactors.removeIf(patientFactorEntity -> patientFactorEntity.getMedicine() == medicineName);
        patientTherapies.setValue(currentFactors);
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
            return (T) new PatientViewModel(application, repository);
        }

        @NonNull
        private final Application application;
        private final PatientRepository repository;
    }

    private final PatientRepository repository;
    private MutableLiveData<List<PatientFactorEntity>> patientFactors;
    private MutableLiveData<List<TherapyEntity>> patientTherapies;
    private String cf;
    private boolean isEditMode;
}
