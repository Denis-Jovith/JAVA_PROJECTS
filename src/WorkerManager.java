
import java.util.ArrayList;
import java.util.List;

public class WorkerManager {
    private List<Worker> workers;

    public WorkerManager() {
        workers = new ArrayList<>();
    }

    public void addWorker(Worker worker) {
        workers.add(worker);
    }

    public void removeWorker(String name) {
        workers.removeIf(worker -> worker.getName().equals(name));
    }

    public List<Worker> getWorkers() {
        return workers;
    }
}
