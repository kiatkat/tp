package profplan.storage;

import static java.util.Objects.requireNonNull;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;
import java.util.logging.Logger;

import profplan.commons.core.LogsCenter;
import profplan.commons.exceptions.DataLoadingException;
import profplan.commons.exceptions.IllegalValueException;
import profplan.commons.util.FileUtil;
import profplan.commons.util.JsonUtil;
import profplan.model.ReadOnlyProfPlan;

/**
 * A class to access AddressBook data stored as a json file on the hard disk.
 */
public class JsonProfPlanStorage implements ProfPlanStorage {

    private static final Logger logger = LogsCenter.getLogger(JsonProfPlanStorage.class);

    private Path filePath;

    public JsonProfPlanStorage(Path filePath) {
        this.filePath = filePath;
    }

    public Path getProfPlanFilePath() {
        return filePath;
    }

    @Override
    public Optional<ReadOnlyProfPlan> readProfPlan() throws DataLoadingException {
        return readProfPlan(filePath);
    }

    /**
     * Similar to {@link #readProfPlan()}.
     *
     * @param filePath location of the data. Cannot be null.
     * @throws DataLoadingException if loading the data from storage failed.
     */
    public Optional<ReadOnlyProfPlan> readProfPlan(Path filePath) throws DataLoadingException {
        requireNonNull(filePath);

        Optional<JsonSerializableProfPlan> jsonAddressBook = JsonUtil.readJsonFile(
                filePath, JsonSerializableProfPlan.class);
        if (!jsonAddressBook.isPresent()) {
            return Optional.empty();
        }

        try {
            return Optional.of(jsonAddressBook.get().toModelType());
        } catch (IllegalValueException ive) {
            logger.info("Illegal values found in " + filePath + ": " + ive.getMessage());
            throw new DataLoadingException(ive);
        }
    }

    @Override
    public void saveProfPlan(ReadOnlyProfPlan addressBook) throws IOException {
        saveProfPlan(addressBook, filePath);
    }

    /**
     * Similar to {@link #saveProfPlan(ReadOnlyProfPlan)}.
     *
     * @param filePath location of the data. Cannot be null.
     */
    public void saveProfPlan(ReadOnlyProfPlan addressBook, Path filePath) throws IOException {
        requireNonNull(addressBook);
        requireNonNull(filePath);

        FileUtil.createIfMissing(filePath);
        JsonUtil.saveJsonFile(new JsonSerializableProfPlan(addressBook), filePath);
    }

}