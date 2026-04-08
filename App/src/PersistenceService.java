import java.io.*;

class PersistenceService {

    private static final String FILE_NAME = "system_state.dat";

    // SAVE STATE
    public static void saveState(SystemState state) {
        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {

            oos.writeObject(state);
            System.out.println("✅ State saved successfully.");

        } catch (IOException e) {
            System.out.println("❌ Error saving state: " + e.getMessage());
        }
    }

    // LOAD STATE
    public static SystemState loadState() {
        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream(FILE_NAME))) {

            SystemState state = (SystemState) ois.readObject();
            System.out.println("✅ State loaded successfully.");
            return state;

        } catch (FileNotFoundException e) {
            System.out.println("⚠ No previous state found. Starting fresh.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("❌ Corrupted state. Starting fresh.");
        }
        return null;
    }
}