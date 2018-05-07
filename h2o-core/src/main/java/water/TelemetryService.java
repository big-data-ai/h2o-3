package water;

/**
 * Service used to write to registered H2O listeners
 */
public class TelemetryService {

    private static TelemetryService service = new TelemetryService();
    private TelemetryService(){
    }

    public static TelemetryService getInstance(){
        return service;
    }

    public void report(HeartBeat heartBeat){
        for (H2OTelemetryExtension ext : ExtensionManager.getInstance().getTelemetryExtensions()) {
            ext.report(heartBeat);
        }
    }
}
